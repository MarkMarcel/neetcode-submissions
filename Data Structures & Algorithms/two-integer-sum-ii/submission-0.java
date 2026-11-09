class Solution {
    public int[] twoSum(int[] numbers, int target) {
        final HashMap<Integer,Integer> indices = new HashMap();
        final int[] s = new int[2];
        for(int i = 0; i < numbers.length; i++){
            final int rem = target - numbers[i];
            if(indices.containsKey(rem) && rem != numbers[i]){
                s[0] = indices.getOrDefault(rem,1);
                s[1] = i + 1;
                break;
            }
            if(!indices.containsKey(numbers[i])){
                indices.put(numbers[i], i + 1);
            }
        }
        return s;
    }
}
