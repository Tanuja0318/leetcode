class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactSet = new HashSet<>();
        Map<String, String> caseMap = new HashMap<>();
        Map<String, String> vowelMap = new HashMap<>();
        for (String word : wordlist) {
            exactSet.add(word);
            String lower = word.toLowerCase();
            caseMap.putIfAbsent(lower, word);
            String devoweled = devowel(lower);
            vowelMap.putIfAbsent(devoweled, word);
        }
        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            if (exactSet.contains(q)) {
                result[i] = q;
            } else {
                String lower = q.toLowerCase();
                if (caseMap.containsKey(lower)) {
                    result[i] = caseMap.get(lower);
                } else {
                    String devoweled = devowel(lower);
                    result[i] = vowelMap.getOrDefault(devoweled, "");
                }
            }
        }
        return result;
    }
    private String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (isVowel(c)) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) >= 0;
    }
}