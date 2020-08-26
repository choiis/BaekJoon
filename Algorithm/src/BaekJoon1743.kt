import java.util.*

val garbagedirect = arrayOf(
    intArrayOf(0, -1), intArrayOf(0, 1),
    intArrayOf(1, 0), intArrayOf(-1, 0)
)

lateinit var garbage:Array<BooleanArray>;
lateinit var visited:Array<BooleanArray>;

fun dfsGarbage(x:Int, y:Int, N:Int, M:Int):Int {

    var cnt:Int = 1;
    visited[x][y] = true;
    for(i in 0 until garbagedirect.size) {
        val nextX = x + garbagedirect[i][0];
        val nextY = y + garbagedirect[i][1];
        if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
            if(!visited[nextX][nextY] && garbage[nextX][nextY]) {
                cnt += dfsGarbage(nextX , nextY ,N , M);
            }
        }
    }

    return cnt;
};

fun main(args:Array<String>) {
    val sc: Scanner = Scanner(System.`in`);
    val N:Int = sc.nextInt();
    val M:Int = sc.nextInt();
    val K:Int = sc.nextInt();

    garbage = Array(N){ BooleanArray(M) };
    visited = Array(N){ BooleanArray(M) };
    for (i in 0 until K) {
        val x:Int = sc.nextInt();
        val y:Int = sc.nextInt();
        garbage[x - 1][y - 1] = true;
    }

    var cnt:Int = 0;
    for (i in 0 until N) {
        for (j in 0 until M) {
            if(!visited[i][j] && garbage[i][j]) {
                cnt = Math.max(dfsGarbage(i, j, N , M), cnt);
            }
        }
    }
    println(cnt);
}