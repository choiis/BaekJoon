import java.util.*

fun main(args:Array<String>) {

    val sc: Scanner = Scanner(System.`in`);

    val x1:Int = sc.nextInt();
    val y1:Int = sc.nextInt();
    val x2:Int = sc.nextInt();
    val y2:Int = sc.nextInt();
    val x3:Int = sc.nextInt();
    val y3:Int = sc.nextInt();

    if (x1 == x2) {
        print("$x3 ");
    } else if (x1 == x3) {
        print("$x2 ");
    } else {
        print("$x1 ");
    }

    if (y1 == y2) {
        println(y3);
    } else if (y1 == y3) {
        println(y2);
    } else {
        println(y1);
    }
}