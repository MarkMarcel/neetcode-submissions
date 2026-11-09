class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
          if((nums1.length != 0) && (nums2.length != 0)){
            int tl = nums1.length + nums2.length;
            double m1 = nums1[nums1.length / 2];
            double m2 = nums2[nums2.length / 2];
            int cp = (m2 > m1)? nums2.length / 2 : nums1.length / 2, il = -1;
            int acp = (m2 > m1)? 1 : 0;
            boolean found = false;
            while(!found){
                int l = 0, r = ((acp == 0)? nums2 : nums1).length - 1, p = -1;
                while(l <= r){
                    int m = (l + r)/2;
                    if(((acp == 0)? nums2 : nums1)[m] >= ((acp == 0)? nums1 : nums2)[cp]){
                        r = m - 1;
                    }else{
                        l = m + 1;
                        p = m;
                    }
                }
                if(((cp + 1) + p) <= (tl / 2)){
                    il = p;
                    found = true;
                }else{
                    cp = p;
                    acp = (acp == 0)? 1 : 0;
                }
            }
            if(((cp + 1) + il) == (tl / 2)){
                if(tl % 2 == 0){
                    int v1 = ((acp == 0)? nums1 : nums2)[cp];
                    int v2 = 0;
                    if(il > -1){
                        v2 = ((acp == 0)? nums2 : nums1)[il];
                    }
                    if((cp - 1) > 0){
                        v2 = Math.max(v2, ((acp == 0)? nums1 : nums2)[cp - 1]);
                    }
                    return (v1 + v2) / 2.0; // using wrong v1 & v2
                }
                return ((acp == 0)? nums1 : nums2)[cp];
            }else{
                int p = (tl / 2) - (cp + 1);
                if(tl % 2 == 0){
                    int v1 = (((acp == 0)? nums2 : nums1)[p]);
                    int v2 = 0;
                    if((p - 1) > -1){
                        v2 = (((acp == 0)? nums2 : nums1)[p - 1]);
                    } else{
                        v2 = (((acp == 0)? nums1 : nums2)[cp]);
                    }
                    return (v1 + v2) / 2.0;
                }
                return (((acp == 0)? nums2 : nums1)[p]);
            }
        }
        if(nums1.length == 0){
            return ((nums2.length % 2) == 0)? ((nums2[nums2.length / 2] + nums2[nums2.length / 2 - 1])/2.0)
            : nums2[nums2.length / 2];
        }
            return ((nums1.length % 2) == 0)? ((nums1[nums1.length / 2] + nums1[nums1.length / 2 - 1])/2.0)
            : nums1[nums1.length / 2];
    }
}
