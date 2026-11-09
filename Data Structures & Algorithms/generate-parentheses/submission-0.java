class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        backtrack(n, 0, 0, stack, res);
        return res;
    }

    private void backtrack(int n, int openN, int closedN, Stack<Character> stack, List<String> res) {
        if (openN == closedN && openN == n) {
            StringBuilder sb = new StringBuilder();
            for (char c : stack) {
                sb.append(c);
            }
            res.add(sb.toString());
            return;
        }

        if (openN < n) {
            stack.push('(');
            backtrack(n, openN + 1, closedN, stack, res);
            stack.pop();
        }
        if (closedN < openN) {
            stack.push(')');
            backtrack(n, openN, closedN + 1, stack, res);
            stack.pop();
        }
    }

}
