class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
          int t = nums1.length + nums2.length;
          int mc = (t + 1) / 2, l = (nums1.length > 0)? 0 : -1;
          int r = (l == 0)? (nums1.length - 1) : -1;
          while(l <= r){
             int m = (l + r) / 2; // index
             int mr = (m > -1)? mc - (m + 1) : mc; // count

             int nums1L = (m >= 0)? nums1[m] : Integer.MIN_VALUE;
             int nums1R = ((m + 1) < nums1.length)? nums1[m + 1] : Integer.MAX_VALUE;
             int nums2L = (mr > 0)? nums2[mr - 1] : Integer.MIN_VALUE;
             int nums2R = ((mr >= 0) && (mr - 1 < nums2.length - 1))? nums2[mr] : Integer.MAX_VALUE;

             if((nums1L <= nums2R) && (nums2L <= nums1R)){
                if((t % 2) == 0){
                    return (Math.max(nums1L, nums2L) + Math.min(nums1R, nums2R)) / 2.0;
                }else{
                    return Math.max(nums1L, nums2L);
                }
             }else{
                if(nums1L > nums2R){
                    r = m - 1;
                }else{
                    l = m + 1;
                }
             } 
          }
          return -1;
    }
}
