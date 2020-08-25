import java.util.*

val dir = arrayOf(
    intArrayOf(0, -1), intArrayOf(0, 1),
    intArrayOf(1, 0), intArrayOf(-1, 0),
    intArrayOf(1, -1), intArrayOf(1, 1),
    intArrayOf(-1, 1), intArrayOf(-1, -1)
)

fun main(args:Array<String>) {

    val sc:Scanner = Scanner(System.`in`);
    val N:Int = sc.nextInt();
    val M:Int = sc.nextInt();

    val banners:Array<IntArray> = Array(N){ IntArray(M) };
    for(i in 0 until N) {
        for (j in 0 until M) {
            banners[i][j] = sc.nextInt();
        }
    }
    val visited = Array(N) { BooleanArray(M) };

    var ch:Int = 0;

    for(i in 0 until N) {
        for(j in 0 until M) {

            if(banners[i][j] == 1 && !visited[i][j]) {
                ch++;
                val queue:Queue<Banner> = LinkedList<Banner>();
                visited[i][j] = true;
                queue.add(Banner(i, j));
                while(!queue.isEmpty()) {
                    val now:Banner = queue.poll();
                    val nowX:Int = now.x;
                    val nowY:Int = now.y;
                    for(k in 0 until dir.size) {
                        val nextX:Int = nowX + dir[k][0];
                        val nextY:Int = nowY + dir[k][1];
                        if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
                            if(!visited[nextX][nextY] && banners[nextX][nextY] == 1) {
                                visited[nextX][nextY] = true;
                                queue.add(Banner(nextX,nextY));
                            }
                        }
                    }
                }
            }

        }
    }

    println(ch);
}

class Banner {
    val x:Int;
    val y:Int;

    constructor(x:Int,y:Int) {
        this.x = x;
        this.y = y;
    }
}