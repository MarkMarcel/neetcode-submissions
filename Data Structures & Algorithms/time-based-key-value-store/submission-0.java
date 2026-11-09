class TimeMap {
    private HashMap<String, ArrayList<Pair<Integer,String>>> store;
    
    public TimeMap() {
        store = new HashMap<String, ArrayList<Pair<Integer,String>>>();    
    }
    
    public void set(String key, String value, int timestamp) {
        var a = new ArrayList<Pair<Integer,String>>();
        a.add(new Pair(timestamp,value));
        store.merge(key, a,(e,n) -> {
            e.addAll(n);
            return e;
        });
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer,String>> l = store.getOrDefault(key, new ArrayList<Pair<Integer,String>>());
        var r = "";
        var t = 0; 
        int a = 0, b = l.size() - 1;
        while(a <= b){
            int m = (b + a) / 2;
            Pair<Integer,String> mv = l.get(m);
            if(mv.getKey() == timestamp){
                return mv.getValue();
            }
            if(timestamp < mv.getKey()){
                b = m - 1;
            }else{
                a = m + 1;
                if(mv.getKey() > t){
                    r = mv.getValue();
                }
            }
        }
        return r;
    }
}
