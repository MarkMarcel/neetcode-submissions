class Solution {
    private int idx;
    public int evalRPN(String[] tokens) {
        idx = tokens.length - 1;
        return eval(tokens);
    }

    private int eval (String[] tokens) {
        int num = 0, i = 0;
        String e = tokens[idx--];
        char c = e.charAt(0);
        if (e.length() == 1) {
            if (c == '+') {
                num = eval(tokens);
                return eval(tokens) + num;
            } else if (c == '-') {
                num = eval(tokens);
                return eval(tokens) - num;
            } else if (c == '*') {
                num = eval(tokens);
                return eval(tokens) * num;
            } else if (c == '/') {
                num = eval(tokens);
                return eval(tokens) / num;
            }
            return c - '0';
        } else {
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = e.charAt(++i);
            }
            num = c - '0';
            i++;
            while (i < e.length()) {
                c = e.charAt(i++);
                num = num*10 + (c - '0');
            }
            return sign*num;
        }
    }

}
