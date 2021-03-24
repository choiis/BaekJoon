import java.util.*

fun main(args:Array<String>) {

    val sc: Scanner = Scanner(System.`in`);
    val A:Int = sc.nextInt();
    val B:Int = sc.nextInt();
    var arrA:IntArray = IntArray(A);
    var arrB:IntArray = IntArray(B);
    for (i in 0 until A) {
        arrA[i] = sc.nextInt();
    }

    for (i in 0 until B) {
        arrB[i] = sc.nextInt();
    }

    var idxA = 0;
    var idxB = 0;
    while (idxA < A && idxB < B) {

        if (arrB[idxB] > arrA[idxA]) {
            print("" + arrA[idxA++] + " ");
        } else {
            print("" + arrB[idxB++] + " ");
        }
    }
    while (idxA < A) {
        print("" + arrA[idxA++] + " ");
    }
    while (idxB < B) {
        print("" + arrB[idxB++] + " ");
    }

}