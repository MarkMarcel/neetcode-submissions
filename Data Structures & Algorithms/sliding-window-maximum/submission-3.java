class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        final int[] result = new int[nums.length - (k - 1)];
        final ArrayDeque<Integer> c = new ArrayDeque();
        for(int i = 0; i <= nums.length - 1; i++){
            boolean l = (c.peekLast() == null)? false: (nums[c.peekLast()] <= nums[i]);
            while(l){
                c.removeLast();
                l = (c.peekLast() == null)? false: (nums[c.peekLast()] <= nums[i]);
            }
            boolean f = (c.peekLast() == null)? false: (c.peekFirst() < (i - k + 1));
            while(f){
                c.removeFirst();
                f = (c.peekLast() == null)? false: (c.peekFirst() < (i - k + 1));
            }
            c.add(i);
            if(i >= (k - 1)){
                result[i - k + 1] = nums[c.getFirst()];
            }
        }
        return result;
    }
}
