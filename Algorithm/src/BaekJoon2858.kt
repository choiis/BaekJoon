import java.util.*

fun main(args:Array<String>) {
    var sc:Scanner = Scanner(System.`in`);

    val R: Int = sc.nextInt();
    val B: Int = sc.nextInt();
    val area:Int = R + B;
    val sqrt:Int = Math.sqrt(area.toDouble()).toInt();
    var L:Int = 0;
    var W:Int = 0;
    for (i in 3..sqrt) {
        val j:Int = area / i;
        if (i * j != area || j <= 2) {
            continue;
        }
        if ((i - 2) * (j - 2) == B) {
            L = i;
            W = j;
            break;
        }
    }
    if (L > W) {
        println("$L $W");
    } else {
        println("$W $L");
    }
}