import java.util.*

fun main(args:Array<String>) {

    val sc: Scanner = Scanner(System.`in`);
    val N: Int = sc.nextInt();

    var arr: IntArray = IntArray(N);
    var dp: IntArray = IntArray(N);
    dp[0] = 1;

    for (i in 0 until N) {
        arr[i] = sc.nextInt();
    }

    for (i in 1 until N) {
        for (j in i - 1 downTo 0) {
            if (arr[i] > arr[j]) {
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
    }

    var max:Int = 0;
    for (i in 0 until N) {
        max = Math.max(max , dp[i]);
    }
    println(max);
}