class LRUCache {
    class Value{
        int key;
        Value next;
        Value prev;
        int value;
        public Value(int key, Value next, Value prev, int value){
            this.key = key;
            this.next = next;
            this.prev = prev;
            this.value = value;
        }
    }

    private final int capacity;
    private Value head;
    private HashMap<Integer,Value> store = new HashMap();
    private Value tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        final var val = store.get(key);
        if(val != null){
            if((tail != null) && (tail != val)){
                update(val);
            }
            return val.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        //eviction
        Value val = store.get(key);
        if(val == null) {
            if(store.size() == capacity){
                if(head != null){
                    store.remove(head.key);
                }
                if(head.next != null){
                    head.next.prev = null;
                    head = head.next;
                } else {
                    head = null;
                }
            }
            val = new Value(key, null, null, value);
            store.put(key,val);
        } else {
            val.value = value;
        }
        if(head == null) {
            head = val;
        } else if(tail == null) {
            head.next = val;
            val.prev = head;
            tail = val;
        } else {
            update(val);
        }
    }
    
    private void update(Value val){
        //If not tail
        if(val.prev != null) {
            val.prev.next = val.next;
        }
        if(val.next != null) {
            val.next.prev = val.prev;
        }
        if(val == head) {
            head = val.next;
        }
        tail.next = val;
        val.prev = tail;
        tail = val;
        val.next = null;
    }
}
