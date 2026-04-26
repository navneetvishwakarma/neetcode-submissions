class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        List<Integer> starters = new ArrayList<>();

        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            if (!set.contains(num-1)) {
                starters.add(num);
            }
        }

        int maxLen = 1;
        for (int starter: starters) {
            int len = 1;
            int num = starter;
            while (set.contains(num+1)) {
                len++;
                num++;
                set.remove(num);
                maxLen = Math.max(len, maxLen);
            }
        }

        return maxLen;
    }
}
