class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        final ArrayList<List<String>> s = new ArrayList();
        final ArrayList<HashMap<Character,Integer>> t = new ArrayList();
        for(String str: strs){
            final HashMap<Character,Integer> sT = new HashMap();
            for(char c: str.toCharArray()){
                int count = 0;
                if(sT.containsKey(c)){
                    count = sT.get(c);
                }
                sT.put(c,count + 1);
            }
            boolean exists = false;
            for(int i = 0; i < t.size(); i++){
                final HashMap<Character,Integer> existing = t.get(i);
                if(existing.equals(sT)){
                    exists = true;
                    s.get(i).add(str);
                    break;
                }
            }
            if(!exists){
                t.add(sT);
                final ArrayList<String> g = new ArrayList();
                g.add(str);
                s.add(g);
            }
        }
        return s;
    }
}
