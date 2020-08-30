import java.util.*

fun main(args: Array<String>) {
	val sc: Scanner = Scanner(System.`in`);
	val K: Int = sc.nextInt();
	val d1: Int = sc.nextInt();
	val d2: Int = sc.nextInt();
	val res: Double = K * K - (d1 - d2) * (d1 - d2) / 4.00;
	println(res);
}