import java.util.*

fun main(args: Array<String>) {

	val sc: Scanner = Scanner(System.`in`);
	var t: Int = sc.nextInt();
	val res: Double = t.toDouble() * t.toDouble() / 4.0;
	println(Math.round(res));
}