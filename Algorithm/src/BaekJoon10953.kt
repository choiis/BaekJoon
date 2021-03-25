import java.util.*

fun main(args: Array<String>) {

	val sc: Scanner = Scanner(System.`in`);
	val T: Int = sc.nextInt();
	for (t in 0 until T) {
		val str: List<String> = sc.next().split(",");
		val A: Int = Integer.parseInt(str[0]);
		val B: Int = Integer.parseInt(str[1]);
		println(A + B);
	}
}