class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        int[] result = new int[2];
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                result = new int[]{l+1, r+1};
                break;
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }

        return result;
    }
}
