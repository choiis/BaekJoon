import java.util.*

fun main(args:Array<String>) {

    val sc: Scanner = Scanner(System.`in`);
    var N:Int = sc.nextInt();

    var cnt:IntArray = IntArray(3  );

    if (N >= 300) {
        cnt[0] = N / 300;
        N -= 300 * cnt[0];
    }
    if (N >= 60) {
        cnt[1] = N / 60;
        N -= 60 * cnt[1];
    }
    if (N >= 10) {
        cnt[2] = N / 10;
        N -= 10 * cnt[2];
    }

    if (N == 0) {
        for (i in 0 until cnt.size) {
            print("" + cnt[i] + " ");
        }
    } else {
        println(-1);
    }

}