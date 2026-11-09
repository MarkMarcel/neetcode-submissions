class Solution {
    public int trap(int[] height) {
      int c = -1, l = 0, max = 0;
      final int[] ls = new int[height.length + 1];
      int i = 1;
      while( i < height.length){
        // going up or down, if up then we calc
        //change how r is defined
        // Calculation when rising
        if(height[i] > height[i - 1]){
            c = i;
        }
        // hit same height
        if(height[i] >= height[l]){
            max += ls[i];
            ls[i + 1] = 0;
            l = i;
            c = -1;
        }else{
            ls[i + 1] = ls[i] + (height[l] - height[i]);
        }
        i++;
      }
      if(c != -1){
        int nl = l;
        int r = height[c];
        while((height[nl+1] <= height[nl]) && (height[nl+1] >= r)){
            nl = l + 1;
        }
        int k = (c - 1 - nl);
        int kl = (c - 1 - l);
        int gc = ls[c];
        max += (gc - (k * (height[nl] - height[c])) - (kl * (height[l] - height[nl])));
      }
      return max;
    }
}