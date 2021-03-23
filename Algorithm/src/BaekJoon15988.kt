import java.util.*

var plus:LongArray = LongArray(1000001);
val mod:Long = 1000000009;
fun dpplus(idx:Int) : Long {
    if (plus[idx] != 0L){
        return plus[idx];
    } else {
        plus[idx] = (dpplus(idx - 1) + dpplus(idx - 2) + dpplus(idx - 3)) % mod;
    }
    return plus[idx];
}

fun main(args:Array<String>) {

    val sc: Scanner = Scanner(System.`in`);
    val t:Int = sc.nextInt();
    plus[1] = 1;
    plus[2] = 2;
    plus[3] = 4;

    for(i in 0 until t) {
        var n:Int = sc.nextInt();
        println(dpplus(n));
    }
}