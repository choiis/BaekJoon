import java.util.*

fun main(args:Array<String>) {

    val sc: Scanner = Scanner(System.`in`);
    var S:Long = sc.nextLong();
    var sum:Long = 0;
    var cnt:Long = 1;

    while(true) {
        sum+=cnt;
        if(sum > S) {
            cnt--;
            break;
        }
        cnt++;
    }
    println(cnt);
}