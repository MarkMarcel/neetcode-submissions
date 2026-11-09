class Solution {
    public int largestRectangleArea(int[] heights) {
        final ArrayDeque<Integer> stack = new ArrayDeque();
        int mr = 0;
        for(int i = 0; i < heights.length; i++){
            int p = (stack.isEmpty())? 0 : heights[stack.getLast()];
            while(p >= heights[i] && !stack.isEmpty()){
                int j = stack.removeLast();
                mr = Math.max(mr, (heights[i] * (i - j + 1)));
                mr = Math.max(mr, (heights[j] * (i - j)));
                p = (stack.isEmpty())? 0 : heights[stack.getLast()];
            }
            stack.add(i);
        }
        while(!stack.isEmpty()){
            int j = stack.removeLast();
            int p = (stack.isEmpty())? heights.length : (heights.length - stack.getLast() - 1);
            mr = Math.max(mr, (heights[j] * p));
        }
        return mr;
    }
}
