class WordDictionary {
    Map<Integer, Set<String>> d;

    public WordDictionary() {
        d = new HashMap<>();
    }
    
    public void addWord(String word) {
        int m = word.length();
        if(!d.containsKey(m)) {
            d.put(m, new HashSet<>());
        }
        d.get(m).add(word);
        
    }
    
    public boolean search(String word) {
        int m = word.length();
        if (d.containsKey(m)) {
            for (String w : d.get(m)) {
                int i = 0;
                while ((i < m) && (w.charAt(i) == word.charAt(i) || word.charAt(i) == '.')) {
                    i++;
                }
                if (i == m) return true;
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */