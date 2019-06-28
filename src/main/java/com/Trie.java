package com;

public class Trie {
    private boolean end;
    private int level;
    private Trie[] next;
    private Trie root;

    Trie() {
        this(null, 0);
    }

    private Trie(Trie root, int level) {
        end = false;
        next = new Trie[26];
        this.root = root;
        this.level = level;
    }

    void add(String s, int idx) {
        if (idx == s.length()) end = true;
        else {
            int i = s.charAt(idx) - 'a';
            if (next[i] == null) next[i] = new Trie(root == null ? this : root, level + 1);
            next[i].add(s, idx + 1);
        }
    }

    boolean match(String s, int idx) {
        if (idx == s.length()) return end && idx != level;
        int i = s.charAt(idx) - 'a';
        if (next[i] != null && next[i].match(s, idx + 1)) return true;
        return end && root.match(s, idx);
    }
}
