class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> st = new ArrayDeque<>();
        Set<String> ops = Set.of("+", "-", "*", "/");
        for (String token: tokens) {
            if (ops.contains(token)) {
                int i2 = Integer.parseInt(st.pop());
                int i1 = Integer.parseInt(st.pop());
                int val = execute(i1, i2, token);
                st.push(val + "");
            } else {
                st.push(token);
            }
        }

        return Integer.parseInt(st.pop());
    }

    private int execute(int i1, int i2, String op) {
        int val = switch (op) {
            case "+" -> i1 + i2;
            case "-" -> i1 - i2;
            case "*" -> i1 * i2;
            case "/" -> i1 / i2;
            default -> 0;
        };
        return val;
    }
}
