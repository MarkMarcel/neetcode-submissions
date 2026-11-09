class Solution {
    public int longestConsecutive(int[] nums) {
        final HashSet<Integer> nS = new HashSet();
        for(int n: nums){
          nS.add(n);
        }
        int max = 0;
        int c = 0;
        while(!nS.isEmpty()){
          final int a = nS.iterator().next();
          int h = a + 1;
          int l = a - 1;
          nS.remove(a);
          c++;
          while(nS.remove(h)){
            c++;
            h++;
          }
          while(nS.remove(l)){
            c++;
            l--;
          }
          max = Math.max(c,max);
          c = 0;
        }
        return max;
    }
}
