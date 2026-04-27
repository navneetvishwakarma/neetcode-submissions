class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] result = new int[len];
        if (len <= 1) return result;

        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int coldDayIndex = stack.pop();
                result[coldDayIndex] = i - coldDayIndex;
            }
            stack.push(i);
        }
        return result;
    }
}
