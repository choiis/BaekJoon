import java.util.*

fun main(args:Array<String>) {

    val sc: Scanner = Scanner(System.`in`);
    var N:Int = sc.nextInt();
    var div:Int = 2;
    while(N != 1) {
        if(N % div == 0) {
            N /= div;
            println(div);
        } else {
            div++;
        }
    }
}