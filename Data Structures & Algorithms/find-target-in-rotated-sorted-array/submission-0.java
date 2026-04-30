class Solution {
    public int search(int[] nums, int target) {
        int l = rotation(nums);
        if (l == 0) return search (nums, target, l, nums.length - 1);
        
        int index = search (nums, target, l, nums.length - 1);
        return (index == -1) ? search (nums, target, 0, l - 1) : index;
    }

    private int search(int[] nums, int target, int l, int r) {
        if (l > r) return -1;
        int m = (l+r)/2;
        if (nums[m] == target) return m;
        else if (target < nums[m]) {
            r = m-1;
        } else {
            l = m + 1;
        }
        return search(nums, target, l, r);
    }

    // Rotation Point, the smallest item's index
    private int rotation(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] < nums[r]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

}
