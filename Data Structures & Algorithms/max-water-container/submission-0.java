class Solution {
    public int maxArea(int[] heights) {
        int len = heights.length;
        int l = 0, r = len - 1;
        int maxWater = 0;
        while (l < r) {
            int water = (r - l) * Math.min(heights[l], heights[r]);
            maxWater = Math.max(maxWater, water);
            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxWater;
    }
}
