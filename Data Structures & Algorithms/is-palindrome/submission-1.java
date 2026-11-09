class Solution {
    public boolean isPalindrome(String s) {
        final String ls = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(char c: ls.toCharArray()){
            final int code = (int) c;
            if((code >= 97 && code <= 122) || code >= 48 && code <= 57)
                sb.append(c);
        }
        final String sbStr = sb.toString();
        final int length = sbStr.length();
        for(int i = 0; i < (length / 2); i++){
            final int j = length - 1 - i;
            if(sbStr.charAt(i) != sbStr.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
