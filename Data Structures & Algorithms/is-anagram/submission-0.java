class Solution {
    public boolean isAnagram(String s, String t) {
        final int base = (int) 'a';
        int[] sT = new int[26];
        for(char c: s.toCharArray()){
            sT[((int) c) - base] += 1;
        }
        for(char c: t.toCharArray()){
            sT[((int) c) - base] -= 1;
        }
        for(int n: sT){
            if(n != 0)
                return false;
        }
        return true;
    }
}
