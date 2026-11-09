class LinkedList {
    class Node{
        Node next;
        int val;

        Node(int val){
            this.val = val;
        }
    }

    private Node head;
    private int size = 0;
    private Node tail;

    public int get(int index) {
        if(index >= size || index < 0)
            return -1;
        int i = 0;
        Node node = head;
        while(i < index){
            node = node.next;
            i++;
        }
        return node.val;
    }

    public void insertHead(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        if(tail == null){
             tail = node;
        }
        size += 1;
    }

    public void insertTail(int val) {
        if(size == 0)
            insertHead(val);
        else{
           Node node = new Node(val);
           tail.next = node;
           tail = node;
           size += 1; 
        }  
    }

    public boolean remove(int index) {
        if(index >= size || index < 0)
            return false; 
        if(index == 0){
            if(head.next == null){
                head = null;
            }else{
                head = head.next;
            }
            size--;
            return true;
        }
        Node node = head;
        int i = 1;
        while(i < index){
            node = node.next;
            i++;
        }    
        if(node.next != null){
             node.next = node.next.next;
        size--;
        if(size == index){
            tail = node;
        }
        }
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<Integer>();
        Node node = head;
        while(node != null){
            values.add(node.val);
            node = node.next;
        }
        return values;
    }
}
