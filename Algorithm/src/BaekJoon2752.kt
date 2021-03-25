import java.util.*

fun main(args: Array<String>) {

	val sc: Scanner = Scanner(System.`in`);

	var arr: IntArray = IntArray(3);
	arr[0] = sc.nextInt();
	arr[1] = sc.nextInt();
	arr[2] = sc.nextInt();
	Arrays.sort(arr);
	for (i in 0 until 3) {
		print("" + arr[i] + " ");
	}
}