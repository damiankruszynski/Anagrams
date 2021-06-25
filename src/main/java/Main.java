import java.util.*;

public class Main {

    public static void main(String[] args) {

        Set<String> anagramsList = new HashSet<>();
        anagramsList = generateAnagramsList();

        Anagrams anagrams = new AnagramsWithMap(anagramsList);
        System.out.println("List size: " + anagrams.getAnagramsList().size());
        System.out.println(anagrams.findAllAnagramsForWord("GRZEBALE"));
        System.out.println(anagrams.findAllAnagramsForWord("BADI"));
        System.out.println(anagrams.findAllAnagramsForWord("dOM"));
    }

    public static Set<String> generateAnagramsList() {
        Set<String> anagramsList = new HashSet<>();
        anagramsList.add("ablegrze");
        anagramsList.add("algebrze");
        anagramsList.add("grzebale");
        anagramsList.add("abituryn");
        anagramsList.add("braunity");
        anagramsList.add("braunity");
        anagramsList.add("braunity");
        Arrays.stream(generateRandomWords(999999)).forEach(s -> anagramsList.add(s));
        return anagramsList;
    }

    public static String[] generateRandomWords(int numberOfWords) {
        String[] randomStrings = new String[numberOfWords];
        Random random = new Random();
        for (int i = 0; i < numberOfWords; i++) {
            char[] word = new char[random.nextInt(8) + 3];
            for (int j = 0; j < word.length; j++) {
                word[j] = (char) ('a' + random.nextInt(26));
            }
            randomStrings[i] = new String(word);
        }
        return randomStrings;
    }

}
