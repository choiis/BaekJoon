import java.util.*

fun main(args: Array<String>) {

	val sc: Scanner = Scanner(System.`in`);
	val T: Int = sc.nextInt();
	for (t in 0 until T) {
		val V: Int = sc.nextInt();
		val E: Int = sc.nextInt();
		println(E - V + 2);
	}
}