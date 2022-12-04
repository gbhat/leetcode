//https://leetcode.com/problems/sort-characters-by-frequency/

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortCharactersByFrequency2 {
    public String frequencySort(String s) {
        Map<Character, Long> map = s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return s.chars().mapToObj(value -> (char) value)
                .sorted((a, b) -> Objects.equals(map.get(a), map.get(b)) ? a - b : (int) (map.get(b) - map.get(a))).map(t -> String.valueOf(t)).collect(Collectors.joining());
    }
}
