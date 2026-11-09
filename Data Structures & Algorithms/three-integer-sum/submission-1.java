class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        final HashMap<Integer,List<Set<Integer>>> k = new HashMap();
        final List<List<Integer>> s = new ArrayList();
        final Set<Set<Integer>> ek = new HashSet();
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                final int d = nums[i] + nums[j];
                final HashSet<Integer> c = new HashSet();
                c.add(i);
                c.add(j);
                final List<Set<Integer>> e = k.getOrDefault(d, new ArrayList<Set<Integer>>());
                e.add(c);
                k.put(d,e); 
            }
        }
        for(int i = 0; i < nums.length; i++){
           final int d = -(nums[i]);
           final List<Set<Integer>> e = k.getOrDefault(d, new ArrayList<Set<Integer>>());
           for(Set<Integer> c: e){
                if(!c.contains(i)){
                   final List<Integer> cs = new ArrayList();
                   final HashSet<Integer> t = new HashSet();
                   t.add(nums[i]);
                   cs.add(nums[i]);
                   for(int n: c){
                    t.add(nums[n]);
                    cs.add(nums[n]);
                   }  
                   if(!ek.contains(t)){
                    s.add(cs);
                    ek.add(t);
                   }   
                }
           } 
        }
        return s;
    }
}
