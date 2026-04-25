class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            String key = getKey(strs[i]);
            List<String> anagrams = map.getOrDefault(key, new ArrayList<>());
            anagrams.add(str);
            map.put(key, anagrams);
        }
        
        for (List<String> set: map.values()) {
            result.add(set);
        }

        return result;
    }

    private String getKey(String str) {
        int[] freq = new int[26];
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0)
            sb.append((char)('a' + i)).append(freq[i]);
        }
        return sb.toString();
    }
}
