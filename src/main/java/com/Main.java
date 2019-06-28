package com;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> strings = Files
                .readAllLines(Paths.get("src/main/resources/words.txt"));
        List<String> allConcatenatedWordsInADict = findAllConcatenatedWordsInADict(strings.toArray(new String[0]));

        final int size = allConcatenatedWordsInADict.size();

        allConcatenatedWordsInADict.sort((Comparator.comparingInt(String::length)));
        String longest = allConcatenatedWordsInADict.get(allConcatenatedWordsInADict.size() - 1);
        String secondLongest = allConcatenatedWordsInADict.get(allConcatenatedWordsInADict.size() - 2);
        System.out.println("The number of concatenated words is " + size +
                " and the longest word is " +
                longest + "and " + secondLongest + " goes after");
    }

    private static List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length < 2) return res;
        Trie root = new Trie();
        for (String word : words) {
            if (!word.isEmpty()) root.add(word, 0);
        }
        for (String word : words) {
            if (root.match(word, 0)) res.add(word);
        }
        return res;
    }
}
