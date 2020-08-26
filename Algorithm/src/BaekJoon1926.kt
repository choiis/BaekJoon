import java.util.*

val paperdirect = arrayOf(
    intArrayOf(0, -1), intArrayOf(0, 1),
    intArrayOf(1, 0), intArrayOf(-1, 0)
)


lateinit var paper:Array<IntArray>;
lateinit var papervisited:Array<BooleanArray>;

fun dfsPaper(x:Int, y:Int, N:Int, M:Int):Int {
    var cnt:Int = 1;
    papervisited[x][y] = true;
    for(i in 0 until paperdirect.size) {
        val nextX = x + paperdirect[i][0];
        val nextY = y + paperdirect[i][1];
        if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
            if(!papervisited[nextX][nextY] && paper[nextX][nextY] == 1) {
                cnt += dfsPaper(nextX , nextY ,N , M);
            }
        }
    }

    return cnt;
};

fun main(args:Array<String>) {

    val sc: Scanner = Scanner(System.`in`);
    val N:Int = sc.nextInt();
    val M:Int = sc.nextInt();
    paper = Array(N){ IntArray(M) };
    papervisited = Array(N){ BooleanArray(M) };
    for (i in 0 until N) {
        for (j in 0 until M) {
            paper[i][j] = sc.nextInt();
        }
    }

    var cnt:Int = 0;
    var max:Int = 0;
    for (i in 0 until N) {
        for (j in 0 until M) {
            if(!papervisited[i][j] && paper[i][j] == 1) {
                cnt++;
                max = Math.max(max , dfsPaper(i,j,N,M));
            }
        }
    }
    println(cnt);
    println(max);
}