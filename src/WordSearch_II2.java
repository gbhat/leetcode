//https://leetcode.com/problems/word-search-ii/

import java.util.*;

public class WordSearch_II2 {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        buildTrie(root, words);
        // printTrie(root);

        Set<String> result = new HashSet<>();

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                findWords(board, root, i, j, "", result);
            }
        }

        return new LinkedList<>(result);
    }

    private void findWords(char[][] board, TrieNode root, int x, int y, String word, Set<String> result) {
        if (root.endOfWord)
            result.add(word);

        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] == '*' || !root.map.containsKey(board[x][y]))
            return;

        char backup = board[x][y];
        board[x][y] = '*';

        word = word + backup;
        root = root.map.get(backup);

        findWords(board, root, x + 1, y, word, result);
        findWords(board, root, x - 1, y, word, result);
        findWords(board, root, x, y + 1, word, result);
        findWords(board, root, x, y - 1, word, result);
        board[x][y] = backup;
    }

    private void printTrie(TrieNode root) {
        if (root.endOfWord) {
            System.out.println(root.word);
            return;
        }
        for (TrieNode node : root.map.values()) {
            printTrie(node);
        }
    }

    private void buildTrie(TrieNode root, String[] words) {
        for (String word : words) {
            if (word == null || word.isEmpty())
                continue;

            TrieNode prev = root;
            for (int i = 0; i < word.length(); i++) {
                prev.map.putIfAbsent(word.charAt(i), new TrieNode());
                prev = prev.map.get(word.charAt(i));
            }

            prev.endOfWord = true;
            prev.word = word;
        }
    }
}

class TrieNode {
    public String word;
    public boolean endOfWord;
    public Map<Character, TrieNode> map;

    public TrieNode() {
        this.endOfWord = false;
        this.map = new HashMap<>();
    }
}
