class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        int maxTemp=0;
        for(int i=len-1;i>=0;i--){
            if(temperatures[i]>=maxTemp){
                maxTemp = temperatures[i];
                continue;
            }
            int day=1;
            while(temperatures[i+day]<=temperatures[i])day+=res[i+day];
            res[i]=day;
        }
        return res;
    }
}
