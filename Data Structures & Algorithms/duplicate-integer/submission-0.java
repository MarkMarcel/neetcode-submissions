class Solution {
    public boolean hasDuplicate(int[] nums) {
       HashSet<Integer> tracker = new HashSet<Integer>();
       for(int num: nums){
         boolean isSuccess = tracker.add(num);
         if(!isSuccess)
            return true;
       } 
       return false;
    }
}
