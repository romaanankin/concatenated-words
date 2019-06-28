package com;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("/home/roman/Documents/concatenatedwords/src/main/resources/words.txt"));
        List<String> allConcatenatedWordsInADict = new ConcatenetedWords()
                .findAllConcatenatedWordsInADict(strings.toArray(new String[0]));
        System.out.println(allConcatenatedWordsInADict.size());
    }
}
