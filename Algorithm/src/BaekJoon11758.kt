import java.util.*

fun main(args: Array<String>) {

	val sc: Scanner = Scanner(System.`in`);

	val x1: Int = sc.nextInt();
	val y1: Int = sc.nextInt();
	val x2: Int = sc.nextInt();
	val y2: Int = sc.nextInt();
	val x3: Int = sc.nextInt();
	val y3: Int = sc.nextInt();

	val result: Int = (x1 * y2 + x2 * y3 + x3 * y1) - (y1 * x2 + y2 * x3 + y3 * x1);

	if (result > 0) {
		println(1);
	} else if (result < 0) {
		println(-1);
	} else {
		println(0);
	}
}