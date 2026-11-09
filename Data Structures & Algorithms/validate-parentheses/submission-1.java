class Solution {
    public boolean isValid(String s) {
        final HashSet<Character> op = new HashSet(Arrays.asList('(','{','['));
        final ArrayDeque<Character> stack = new ArrayDeque();
        for(char c: s.toCharArray()){
            if(op.contains(c)){
                stack.add(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                if((c == ')' && stack.peekLast() != '(')
                || (c == '}' && stack.peekLast() != '{')
                || (c == ']' && stack.peekLast() != '[')){
                    return false;
                }
                stack.removeLast();
            }
        }
        return stack.isEmpty();
    }
}
