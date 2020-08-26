import java.util.*

fun main(args:Array<String>) {

    val sc: Scanner = Scanner(System.`in`);
    val N :Int = sc.nextInt();
    val M:Int = sc.nextInt();

    var dp:Array<IntArray> = Array(N + 1){ IntArray(N + 1) };
    for(i in 0 until N) {
        for(j in 0 until N) {
            val matrix:Int = sc.nextInt();
            dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j + 1] - dp[i][j] + matrix;
        }
    }

    for(i in 0 until M) {
        val x1:Int = sc.nextInt();
        val y1:Int = sc.nextInt();
        val x2:Int = sc.nextInt();
        val y2:Int = sc.nextInt();

        println(dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1]);
    }
}