class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int m = (l + r) / 2;
            int next = nums[(m + 1) % nums.length];
            if(next < nums[m]){
                return next;
            }
            if(nums[m] >= nums[l]){
                l = m + 1;
            }else {
                r = m;
            }
        }
        return nums[0];   
    }
}
