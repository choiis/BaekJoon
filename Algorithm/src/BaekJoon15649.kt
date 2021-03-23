import java.util.*

fun perm(arr: IntArray, output: IntArray, visited: BooleanArray, depth: Int, n: Int, r: Int) {
    if (depth == r) {
        print(output, r);
        return;
    }
    for (i in 0 until n) {
        if (!visited[i]) {
            visited[i] = true;
            output[depth] = arr[i];
            perm(arr, output, visited, depth + 1, n, r);
            visited[i] = false;
        }
    }
}
fun print(arr: IntArray, r: Int) {
    for (i in 0 until r) {
        print("" + arr[i] + " ");
    }
    println();
}
fun main(args:Array<String>) {

    val sc: Scanner = Scanner(System.`in`);
    val N:Int = sc.nextInt();
    val M:Int = sc.nextInt();

    var arr:IntArray = IntArray(N);
    for(i in 0 until arr.size) {
        arr[i] = i + 1;
    }
    var out:IntArray = IntArray(N);
    var visited:BooleanArray = BooleanArray(N);
    perm(arr,out,visited,0,N,M);
}