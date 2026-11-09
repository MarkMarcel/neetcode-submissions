class Solution {
    public int[] productExceptSelf(int[] nums) {
       final int l = nums.length; 
       final int[] pP = new int[l + 1];
       final int[] s = new int[l];
       pP[0] = 1;
       int r = 1;
       for(int i = 0; i < l; i++){
        pP[i + 1] = pP[i] * nums[i];
       }
       for(int i = l - 1; i >= 0; i--){
         s[i] = pP[i] * r;
         r *= nums[i];
       } 
       return s;
    }
}  
