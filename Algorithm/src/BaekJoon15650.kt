import java.util.*

fun combination(arr: IntArray, visited: BooleanArray, start: Int, n: Int, r: Int) {
    if (r == 0) {
        print(arr, visited, n);
        return;
    }
    for (i in start until n) {
        visited[i] = true;
        combination(arr, visited, i + 1, n, r - 1);
        visited[i] = false;
    }
}

fun print(arr: IntArray, visited: BooleanArray, n: Int) {
    for (i in 0 until n) {
        if (visited[i]) {
            print("" + arr[i] + " ");
        }
    }
    println()
}

fun main(args:Array<String>) {

    val sc: Scanner = Scanner(System.`in`);
    val N:Int = sc.nextInt();
    val M:Int = sc.nextInt();

    var arr:IntArray = IntArray(N);
    for(i in 0 until arr.size) {
        arr[i] = i + 1;
    }
    var visited:BooleanArray = BooleanArray(N);
    combination(arr, visited,0 ,N , M);
}