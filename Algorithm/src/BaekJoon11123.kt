import java.util.*

val direction = arrayOf(
        intArrayOf(0, -1), intArrayOf(0, 1),
        intArrayOf(1, 0), intArrayOf(-1, 0)
);

lateinit var grid:Array<CharArray>;
lateinit var visit:Array<BooleanArray>;

fun dfssheep(grid:Array<CharArray> , x:Int, y:Int) {
    visit[x][y] = true;
    for (i in 0 until direction.size) {
        val nextX:Int = direction[i][0] + x;
        val nextY:Int = direction[i][1] + y;
        if (nextX >= 0 && nextY >= 0 && nextX < grid.size && nextY < grid[0].size) {
            if(grid[nextX][nextY] == '#' && !visit[nextX][nextY]) {
                dfssheep(grid, nextX, nextY);
            }
        }
    }
}

fun main(args:Array<String>) {

    val sc: Scanner = Scanner(System.`in`);
    val T:Int = sc.nextInt();
    for (t in 0 until T) {
        val H:Int = sc.nextInt();
        val W:Int = sc.nextInt();
        grid = Array(H) { CharArray(W) };
        visit = Array(H) { kotlin.BooleanArray(W) };
        for (i in 0 until H) {
            grid[i] = sc.next().toCharArray();
        }
        var cnt:Int = 0;

        for (i in 0 until H) {
            for (j in 0 until W) {
                if (!visit[i][j] && grid[i][j] == '#') {
                    cnt++;
                    dfssheep(grid,i,j);
                }
            }
        }

        println(cnt);
    }
}