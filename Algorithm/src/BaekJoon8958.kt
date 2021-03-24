import java.util.*

fun main(args:Array<String>) {

    val sc: Scanner = Scanner(System.`in`);
    val T:Int = sc.nextInt();

    for(t in 1 .. T) {
        val str:String = sc.next();
        var sum:Int = 0;
        var cnt:Int = 0;
        for (i in str.indices) {
            if (str[i] == 'X') {
                cnt = 0;
            } else {
                cnt++;
                sum+=cnt;
            }
        }
        println(sum);
    }
}