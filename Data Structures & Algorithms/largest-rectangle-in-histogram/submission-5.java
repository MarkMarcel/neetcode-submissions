class Solution {
    public int largestRectangleArea(int[] heights) {
        int li = -1, mr = 0;
        final int[] stack = new int[heights.length];
        for(int i = 0; i < heights.length; i++){
            int p = (li == -1)? 0 : heights[li];
            while(p >= heights[i] && (li != -1)){
                int j = li;
                li = stack[li];
                mr = Math.max(mr, (heights[i] * (i - j + 1)));
                mr = Math.max(mr, (heights[j] * (i - j)));
                p = (li == -1)? 0 : heights[li];
            }
            stack[i] = li;
            li = i;
        }
        while(li != -1){
            int p = (stack[li] == -1)? heights.length : (heights.length - stack[li] - 1);
            mr = Math.max(mr, (heights[li] * p));
            li = stack[li];
        }
        return mr;
    }
}
