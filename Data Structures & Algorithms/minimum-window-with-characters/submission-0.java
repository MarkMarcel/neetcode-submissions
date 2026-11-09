class Solution {
    public String minWindow(String s, String t) {
        String result = "";
        boolean found = true;
        final HashMap<Character,Integer> n = new HashMap();
        final int[][] pr = new int[52][s.length() + 1];
        for(int i = 0; i < s.length(); i++){
            int k = getIndex(s.charAt(i));
            for(int j = 0; j < pr.length; j++){
                int p = pr[j][i];
                if(j == k){
                    p += 1;
                }
                pr[j][i + 1] = p;
            }
        }
        for(char c: t.toCharArray()){
            int nc = n.getOrDefault(c,0);
            n.put(c, ++nc);
            int i = getIndex(c);
            if(pr[i][s.length()] < nc){
                found = false;
            } 
        }
        if(found){
            boolean kg = true;
            int l = 0, r = s.length() - 1;
            while(kg){
                kg = false;
                // if reduce left
                char lc = s.charAt(l); // boundary
                int il = getIndex(lc);
                int count = pr[il][r + 1] - pr[il][l + 1];
                if(n.getOrDefault(lc, 0) <= count){
                    kg = true;
                    l++;
                } else {
                    char rc = s.charAt(r); // boundary
                    int ir = getIndex(rc);
                    count = pr[ir][r] - pr[ir][l];
                    if(n.getOrDefault(rc, 0) <= count){
                        kg = true;
                        r--;
                    }
                }
            }
            if(r == s.length() - 1){
                result = s.substring(l);
            }else{
                result = s.substring(l, (r + 1));
            }
        }
        return result;
    }

    private int getIndex(char c){
        int i = (int) c;
        int d = 0;
        if((65 <= i) && (i <= 90)){
            d = i - 65;
        } else{
            d = i - 72;
        }
        return d;
    }
}
