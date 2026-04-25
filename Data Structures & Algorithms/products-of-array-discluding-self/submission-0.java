class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] pref = new int[len];
        int[] suff = new int[len];
        int[] product = new int[len];

        pref[0] = 1;
        suff[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            pref[i] = pref[i-1]*nums[i-1];
            int ri = len - 1 - i;
            suff[ri] = suff[ri+1] * nums[ri+1];
        }

        for (int i = 0; i < len; i++) {
            product[i] = pref[i] * suff[i];
        }

        return product;
    }
}  
