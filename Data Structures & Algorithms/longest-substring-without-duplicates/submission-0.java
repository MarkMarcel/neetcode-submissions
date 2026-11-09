class Solution {
    public int lengthOfLongestSubstring(String s) {
     int l = 0, r = 0, ml = 0;
        HashMap<Character,Integer> h = new HashMap();
        while(r < s.length()){
            char c = s.charAt(r);
            int f = h.getOrDefault(c, -1);
            if(f >= l){
                l = h.getOrDefault(c, 0) + 1;
            }
            ml = Math.max(ml, (r + 1 - l));
            h.put(c, r);
            r++;
        }
        return ml;   
    }
}
