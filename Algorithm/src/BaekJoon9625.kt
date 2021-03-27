import java.util.*

fun main(args:Array<String>) {

    val sc: Scanner = Scanner(System.`in`);
    val K:Int = sc.nextInt();
    val A:IntArray = IntArray(K + 1);
    val B:IntArray = IntArray(K + 1);

    A[1] = 0;
    B[1] = 1;
    for (i in 2 .. K) {
        A[i] = B[i - 1];
        B[i] = B[i - 1] + A[i - 1];
    }
    print("" + A[K] + " " + B[K]);
}