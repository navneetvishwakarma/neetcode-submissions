class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexes = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (indexes.containsKey(target - curr)) {
                result[0] = indexes.get(target - curr);
                result[1] = i;
                break;
            } else {
                indexes.put(curr, i);
            }
        }

        return result;
    }
}
