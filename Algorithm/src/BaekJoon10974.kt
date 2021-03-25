import java.util.*

fun permutaion(arr: IntArray, output: IntArray, visited: BooleanArray, depth: Int, n: Int, r: Int) {
	if (depth == r) {
		printing(output, r);
		return;
	}
	for (i in 0 until n) {
		if (!visited[i]) {
			visited[i] = true;
			output[depth] = arr[i];
			permutaion(arr, output, visited, depth + 1, n, r);
			visited[i] = false;
		}
	}
}

fun printing(arr: IntArray, r: Int) {
	for (i in 0 until r) {
		print("" + arr[i] + " ");
	}
	println();
}

fun main(args: Array<String>) {

	val sc: Scanner = Scanner(System.`in`);
	val N: Int = sc.nextInt();

	var arr: IntArray = IntArray(N);
	for (i in 0 until arr.size) {
		arr[i] = i + 1;
	}
	var out: IntArray = IntArray(N);
	var visited: BooleanArray = BooleanArray(N);
	permutaion(arr, out, visited, 0, N, N);
}