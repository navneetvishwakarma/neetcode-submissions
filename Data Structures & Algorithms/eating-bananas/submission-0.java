class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int low = 1, high = getMax(piles);
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canFinish(piles, h, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canFinish(int[] piles, int h, int k) {
        long totalHours = 0;

        for (int pile: piles) {
            totalHours += (pile + k - 1) / k;
        }
        return totalHours <= h;
    }

    private int getMax(int[] piles) {
        int max = 0;
        for(int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }

        return max;
    }
}
