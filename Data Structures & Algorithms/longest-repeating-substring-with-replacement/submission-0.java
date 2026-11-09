class Solution {
    public int characterReplacement(String s, int k) {
        final int b = 65;
        final int[][] p = new int[26][s.length() + 1];
        int max = 1;
        for(int i = 0; i < s.length(); i++){
            final int index = ((int)s.charAt(i)) - b;
            for(int j = 0; j < 26; j++){
                if(index == j){
                    p[j][i + 1] = p[j][i];
                }else{
                    p[j][i + 1] = p[j][i] + 1;
                }
            }
        }
        for(int i = 0; i < 26; i++){
            int l = 0, r = 1;
            while(r <= s.length()){
                int nc = p[i][r] - p[i][l];
                if(nc > k){
                    max = Math.max((r - 1 - l), max);
                    do{
                        l++;
                    }while((p[i][r] - p[i][l]) > k);
                } else{
                    r++;
                } 
            }
            max = Math.max((r - 1 - l), max);
        }
        return max;
    }
}
