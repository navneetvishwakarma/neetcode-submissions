class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();
        for (String token: tokens) {
            if (token.equals("+")) {
                st.push(st.pop() + st.pop());
            } else if (token.equals("-")){
                int b = st.pop();
                int a = st.pop();
                st.push(a-b);
            } else if (token.equals("*")) {
                st.push(st.pop() * st.pop());
            } else if (token.equals("/")){
                int b = st.pop();
                int a = st.pop();
                st.push(a/b);
            } else {
                st.push(Integer.parseInt(token));
            }
        }

        return st.pop();
    }
}
