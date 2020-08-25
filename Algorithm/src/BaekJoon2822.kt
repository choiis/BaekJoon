import java.util.Scanner
import java.lang.Override

fun main(args: Array<String>) {
	val sc: Scanner = Scanner(System.`in`);

	var arr: Array<ScoreClass?> = arrayOfNulls<ScoreClass>(8);
	for (i in 1..8) {
		val num = sc.nextInt();
		arr[i - 1] = ScoreClass(i, num);
	}
	arr.sort();
	var sum: Int = 0;
	var intarr: IntArray = IntArray(5);
	for (i in 3 until 8) {
		sum += arr[i]!!.score;
		intarr[i - 3] = arr[i]!!.index;
	}
	println(sum);
	intarr.sort();
	for (i in 0 until 5) {
		print(intarr[i]);
		print(" ");
	}
}

internal class ScoreClass : Comparable<ScoreClass> {

	var index: Int;
	var score: Int;

	constructor(index: Int, score: Int) {
		this.index = index;
		this.score = score;
	}

	override fun compareTo(o: ScoreClass): Int {
		return this.score - o.score;
	}

}