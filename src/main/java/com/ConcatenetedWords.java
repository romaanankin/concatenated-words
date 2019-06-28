package com;

import java.util.ArrayList;
import java.util.List;

public class ConcatenetedWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
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
