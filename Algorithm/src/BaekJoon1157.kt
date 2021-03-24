import java.util.*

fun main(args:Array<String>) {

    val sc: Scanner = Scanner(System.`in`);
    var voca: String = sc.nextLine().toUpperCase();
    var cnt: IntArray = IntArray(26);
    var alpha:CharArray = charArrayOf('A','B','C','D','E','F',
    'G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z');
    for (i in 0 until voca.length) {
        cnt[(voca[i] - 'A')]++;
    }
    var idx: Int = -1;
    var maxCnt: Int = -1;
    for (i in 0 until cnt.size) {
        if (maxCnt < cnt[i]) {
            maxCnt = cnt[i];
            idx = i;
        }
    }

    for (i in 0 until cnt.size) {
        if (maxCnt == cnt[i] && i != idx) {
            println("?");
            System.exit(0);
        }
    }
    println(alpha[idx]);
}