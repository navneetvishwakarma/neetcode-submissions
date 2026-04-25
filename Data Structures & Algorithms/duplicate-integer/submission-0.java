class Solution {
    public boolean hasDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) return false;
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (seen.contains(curr)) return true;
            else seen.add(curr);
        }

        return false;
    }
}