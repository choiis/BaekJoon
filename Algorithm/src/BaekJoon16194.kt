import java.util.*

fun main(args:Array<String>) {
    val sc:Scanner = Scanner(System.`in`);

    val N:Int = sc.nextInt();
    var P:IntArray = IntArray(N + 1);
    var dp:IntArray = IntArray(N + 1);
    for (i in 1 until N + 1) {
        P[i] = sc.nextInt();
    }
    dp[1] = P[1];
    for (i in 2 until N + 1) {
        dp[i] = P[i];
        for (j in 1 .. i) {
            dp[i] = Math.min(dp[i] , P[j] + dp[i - j]);
        }
    }

    print(dp[N]);
}