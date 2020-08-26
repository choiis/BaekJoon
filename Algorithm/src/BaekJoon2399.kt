
import java.util.*


fun main(args:Array<String>) {
    var sc:Scanner = Scanner(System.`in`);

    val n: Int = sc.nextInt();
    val arr = LongArray(n);
    for (i in 0 until n) {
        arr[i] = sc.nextLong();
    }
    Arrays.sort(arr);
    var sum: Long = 0;
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            sum += arr[j] - arr[i];
        }
    }
    println(2 * sum);
}