class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> counts = new HashMap();
        HashMap<Integer,HashSet<Integer>> f = new HashMap();
        ArrayList<Integer> q = new ArrayList();
        int[] s = new int[k];
        int cH = 1000;
        int cL = -1000;
        for(int num: nums){
            int count = counts.getOrDefault(num,0);
            if(count != 0){
                f.get(count).remove(num);
            }
            count++;
            counts.put(num,(count));
            HashSet<Integer> fS = f.getOrDefault(count, new HashSet<Integer>());
            fS.add(num);
            f.put(count,fS);
            cH = Math.max(count,cH);
            cL = Math.min(count,cL);
        }
        while((q.size() < k) && (cH >= cL)){
            q.addAll(f.getOrDefault(cH,new HashSet<Integer>()));
            cH--;
        }
        for(int i = 0; i < s.length; i++){
            s[i] = q.get(i);
        }
        return s;
    }
}
