import java.util.*

fun main(args: Array<String>) {

	val sc: Scanner = Scanner(System.`in`);
	val T: Int = sc.nextInt();
	for (t in 1..T) {
		println("Class " + t);
		val K: Int = sc.nextInt();
		var arr: IntArray = IntArray(K);
		for (i in 0 until K) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		var max: Int = 0;
		for (i in 1 until K) {
			max = Math.max(max, arr[i] - arr[i - 1]);
		}
		println("Max " + arr[K - 1] + ", Min " + arr[0] + ", Largest gap " + max);
	}
}