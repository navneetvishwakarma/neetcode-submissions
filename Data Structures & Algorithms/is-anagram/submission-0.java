class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null
        || s.isBlank() || t.isBlank() 
        || s.length() != t.length()) return false;

        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            freq[sChar - 'a']++;

            char tChar = t.charAt(i);
            freq[tChar - 'a']--;
        }

        for(int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) return false;
        }

        return true;
    }
}
