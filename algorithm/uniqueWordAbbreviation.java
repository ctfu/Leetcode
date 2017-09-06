class ValidWordAbbr {
    private Map<String, String> hm;
    public ValidWordAbbr(String[] dictionary) {
        hm = new HashMap<>();
        for (String word : dictionary) {
            if (word.length() != 0) {
                String key = getKey(word);
                // if the key in the dictionary is not unique, set the store value to ""
                // otherwise set it to store its word
                if (hm.containsKey(key) && !hm.get(key).equals(word)) {
                    hm.put(key, "");
                } else {
                    hm.put(key, word);
                }
            }
        }
    }

    public boolean isUnique(String word) {
        if (word.length() != 0) {
            String key = getKey(word);
            // if containsKey, check if the word is unique in the dictionary
            return !hm.containsKey(key) || hm.get(key).equals(word);
        }
        return true;
    }

    public String getKey(String word) {
        return word.charAt(0) + String.valueOf(word.length() - 2) + word.charAt(word.length() - 1);
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
