class Solution {
    fun climbStairs(n: Int): Int {
        if(n == 1) return 1
        var prev = 1 
        var curr = 2
        for(i in 3..n){
            val temp = curr
            curr = curr + prev
            prev = temp
        }
        return curr
    }
}
