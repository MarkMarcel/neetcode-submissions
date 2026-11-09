class Solution {
    public int findDuplicate(int[] nums) {
        var fast = nums[0];
        var slow = nums[0];
        var start = true;
        while((fast != slow) || start){
            start = false;
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        fast = nums[0];
        while(fast != slow){
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;   
    }
}
