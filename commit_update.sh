#!/bin/bash

if ! command -v jq &> /dev/null
then
    echo "jq not be found. Install jq"
    exit
fi

files=$(git diff --name-only --cached)

if [[ $files == "" ]]; then
	echo "No files staged for commit. Exiting..."
	exit 1
fi

url=
for file in $files
do
	if [[ $file != *java ]]; then
		echo "Non java files staged for commit. Exiting..."
		exit 1
	fi
	head=$(cat $file | head -1)
	if [[ $url == "" ]]; then
		url=$head
	elif [[ $url != $head ]]; then
		echo "Different solutions are staged for commit. URLs found: "
		echo "$url"
		echo "$head"
		echo "Exiting.."
		exit 1
	fi
done

if [[ $url == "" ]]; then
	echo "Leetcode URL not found in the 1st line of Java files. Exiting..."
	exit 1
fi

url=$(echo "https${url#*https}")
echo "$url"

echo "Updating README.md"
response=$(curl -i -sS $url)
cookie=$(echo $response | grep set-cookie | cut -f2 -d':' | xargs | cut -f1 -d';')
csrftoken=$(echo $cookie | cut -f2 -d'=')
slug=""
if [[ $url == */ ]]
then
	slug=$(echo $url | rev | cut -f2 -d'/' | rev)
else
	slug=$(echo $url | rev | cut -f1 -d'/' | rev)
fi

content=$(curl -sS -X post -H "Content-Type: application/json" -H "referer: $url" -H "cookie: $cookie" -H "x-csrftoken: $csrftoken" --request POST --data '{"operationName":"getQuestionDetail","variables":{"titleSlug":"'$slug'"},"query":"query getQuestionDetail($titleSlug: String!) {\n  isCurrentUserAuthenticated\n  question(titleSlug: $titleSlug) {\n    questionId\n    questionFrontendId\n    questionTitle\n    translatedTitle\n    questionTitleSlug\n    content\n    translatedContent\n    difficulty\n    stats\n    allowDiscuss\n    contributors {\n      username\n      profileUrl\n      __typename\n    }\n    similarQuestions\n    mysqlSchemas\n    randomQuestionUrl\n    sessionId\n    categoryTitle\n    submitUrl\n    interpretUrl\n    codeDefinition\n    sampleTestCase\n    enableTestMode\n    metaData\n    enableRunCode\n    enableSubmit\n    judgerAvailable\n    infoVerified\n    envInfo\n    urlManager\n    article\n    questionDetailUrl\n    libraryUrl\n    adminUrl\n    companyTags {\n      name\n      slug\n      translatedName\n      __typename\n    }\n    companyTagStats\n    topicTags {\n      name\n      slug\n      translatedName\n      __typename\n    }\n    __typename\n  }\n  interviewed {\n    interviewedUrl\n    companies {\n      id\n      name\n      slug\n      __typename\n    }\n    timeOptions {\n      id\n      name\n      __typename\n    }\n    stageOptions {\n      id\n      name\n      __typename\n    }\n    __typename\n  }\n  subscribeUrl\n  isPremium\n  loginUrl\n}\n"}' https://leetcode.com/graphql/)
id=$(echo $content | jq .data.question.questionFrontendId | tr -d '"')
title=$(echo $content | jq .data.question.questionTitle | tr -d '"')
difficulty=$(echo $content | jq .data.question.difficulty | tr -d '"')

echo "Question details found:"
echo "id: $id"
echo "title: $title"
echo "difficulty: $difficulty"

if [[ $id == "null" || $title == "null" || $difficulty == "null" ]]; then
	echo "Could not get some details for the question. Exiting..."
	exit 1
fi

if [[ $difficulty == "Medium" ]]; then
	difficulty="\$\${\\color{orange}Medium}\$\$"
elif [[ $difficulty == "Hard" ]]; then
	difficulty="\$\${\\color{red}Hard}\$\$"
else
	difficulty="\$\${\\color{green}Easy}\$\$"
fi

read -p "Add star to this question (y/n)?" choice
if [[ $choice == 'y' || $choise == 'Y' ]]; then
	echo -n  "| :star2: " >> README.md
else
	echo -n  " | " >> README.md
fi

echo -n "[$title]($url) | " >> README.md

is_second='N'
for file in $files
do
	file=$(echo $file | rev | cut -f1 -d'/' | rev)
	if [[ $is_second == 'Y'  ]]; then
		echo -n " <br>" >> README.md
	fi
	echo -n " [$file](https://github.com/gbhat/leetcode/blob/main/src/$file)" >> README.md
	is_second='Y'
done

echo " | $difficulty |" >> README.md

echo "Commiting to git"
git add README.md
git commit -as -m "$url"
