class DynamicArray {
    private int[] arr;
    private int size = 0;
    private int capacity = 1;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i] = n;
    }

    public void pushback(int n) {
        if(size == capacity)
            resize();
        arr[size] = n;
        size += 1;    
    }

    public int popback() {
        size -= 1;
        return arr[size];
    }

    private void resize() {
        capacity *= 2;
        int[] nArr = new int[capacity * 2];
        for(int i = 0; i < size; i++){
            nArr[i] = arr[i];
        }
        arr = nArr;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
