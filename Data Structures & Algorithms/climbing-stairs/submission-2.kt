class Solution {
    fun climbStairs(n: Int): Int {

        if (n <= 2) return n

        var p1 = 1
        var p2 = 2
        var sum = p1 + p2

        for (i in 3 until n + 1) {
            sum = p1 + p2
            p1 = p2
            p2 = sum
        }

        return sum
    }
}
