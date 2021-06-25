import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class AnagramsWithMap implements Anagrams {
    private Set<String> anagramsList;

    public AnagramsWithMap(Set<String> anagramsList) {
        this.anagramsList = anagramsList;
    }

    public Set<String> getAnagramsList() {
        return anagramsList;
    }

    @Override
    public Set<String> findAllAnagramsForWord(String word) {
        return anagramsList.stream()
                .filter(s -> s.length() == word.length())
                .filter(s -> compareMaps(mapForWord(s), mapForWord(word)))
                .collect(Collectors.toSet());
    }

    private boolean compareMaps(Map<Character, Integer> mapOne, Map<Character, Integer> mapTwo) {
        if (mapOne.keySet().equals(mapTwo.keySet())) {
            return mapOne.entrySet().stream().allMatch(s -> s.getValue().equals(mapTwo.get(s.getKey())));
        } else {
            return false;
        }
    }

    private Map<Character, Integer> mapForWord(String word) {
        Map<Character, Integer> wordMap = new HashMap<>();
        word = word.toUpperCase();
        for (int i = 0; i < word.length(); i++) {
            char key = word.charAt(i);
            if (wordMap.containsKey(key)) {
                wordMap.replace(key, wordMap.get(key) + 1);
            } else {
                wordMap.put(key, 1);
            }
        }
        return wordMap;
    }


}
