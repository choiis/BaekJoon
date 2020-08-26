import java.util.*

var fiboDp:IntArray = IntArray(21);

fun fibo(n:Int) : Int {

    if(n == 0) {
        fiboDp[n] = 0;
    } else if (n == 1) {
        fiboDp[n] = 1;
    } else {
        fiboDp[n] = fibo(n - 1) + fibo(n - 2);
    }
    return fiboDp[n];
};

fun main(args:Array<String>) {

    val sc: Scanner = Scanner(System.`in`);
    val N:Int = sc.nextInt();
    println(fibo(N));
}