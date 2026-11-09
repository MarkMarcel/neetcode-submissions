class Solution {
    public boolean checkInclusion(String s1, String s2) {
        final HashMap<Character,Integer> n = new HashMap();
        int[] cn = new int[26];
        int l = 0, r = 0, a = 0;
        for(char c: s1.toCharArray()){
            int count = n.getOrDefault(c, 0);
            count++;
            n.put(c, count);
        }
        a = n.size();
        while(r < s2.length()){
            if(!n.containsKey(s2.charAt(r))){
                r++;
                l = r;
                a = n.size();
                cn = new int[26];
            } else {
                cn[s2.charAt(r) - 97]++;
                if((cn[s2.charAt(r) - 97]) == n.getOrDefault(s2.charAt(r), 0)){
                    a--;
                }
                while(cn[s2.charAt(r) - 97] > (n.getOrDefault(s2.charAt(r), 0))){
                    if(cn[s2.charAt(l) - 97] == (n.getOrDefault(s2.charAt(l), 0))){
                        a++;
                    }
                    cn[s2.charAt(l) - 97]--;
                    l++;
                }
                if(a == 0){
                    return true;
                }
                r++;
            }
            
        }
        return false;
    }
}
