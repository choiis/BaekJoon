import java.util.*

fun main(args:Array<String>) {
    val sc:Scanner = Scanner(System.`in`);
    val N:Int = sc.nextInt();

    var dp:IntArray = IntArray(1010);

    dp[1] = 0;
    dp[2] = 1;
    dp[3] = 0;

    for(i in 4 .. N) {
         if (dp[i - 1] == 0 || dp[i - 3] == 0) {
            dp[i] = 1;
        } else {
            dp[i] = 0;
        }
    }

    if (dp[N] == 1) {
        println("SK");
    } else {
        println("CY");
    }

}