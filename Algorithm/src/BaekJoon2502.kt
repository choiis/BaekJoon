import java.util.*

fun main(args:Array<String>) {

    val sc: Scanner = Scanner(System.`in`);
    val D:Int = sc.nextInt();
    val K:Int = sc.nextInt();
    val d:Array<IntArray> = Array(31) {IntArray(2)};
    d[1][0] = 1;
    d[2][1] = 1;
    for (i in 3 .. D) {
        d[i][0] = d[i - 1][0] + d[i - 2][0];
        d[i][1] = d[i - 1][1] + d[i - 2][1];
    }

    var A:Int = -1;
    var B:Int = -1;
    for (i in 2 .. K / d[D][0]) {
        if ((K - i * d[D][0]) % d[D][1] == 0) {
            A = i;
            B = (K - i * d[D][0]) / d[D][1];
            break;
        }
    }
    println(A);
    println(B);
}