import java.util.*


var a:Int = 0;
var b:Int = 0;

lateinit var warBoard:Array<CharArray>;
lateinit var warVisited:Array<BooleanArray>;

val wardirects:Array<IntArray> = arrayOf(
        intArrayOf(0, -1), intArrayOf(0, 1),
        intArrayOf(1, 0), intArrayOf(-1, 0)
);

var sumB:Int = 0;
var sumW:Int = 0;

var tempCnt:Int = 0;
fun warDfs(x:Int,y:Int,char:Char) {
    warVisited[x][y] = true;

    wardirects.forEach { i ->
        run {
            val nextX: Int = x + i[0];
            val nextY: Int = y + i[1];

            if (nextX >= 0 && nextY >= 0 && nextX < b && nextY < a) {
                if (!warVisited[nextX][nextY] && warBoard[nextX][nextY] == char) {
                    tempCnt++;
                    warDfs(nextX,nextY,warBoard[nextX][nextY]);
                }
            }
        }
    };
}

fun main(args:Array<String>) {
    val sc: Scanner = Scanner(System.`in`);
    a = sc.nextInt();
    b = sc.nextInt();
    warBoard = Array(b,{CharArray(a)});
    warVisited = Array(b,{BooleanArray(a)});
    for (i in 0 until b) {
        warBoard[i] = sc.next().toCharArray();
    }

    for (i in 0 until b) {
        for (j in 0 until a) {
            if (!warVisited[i][j]) {
                tempCnt = 1;
                warDfs(i,j,warBoard[i][j]);
                if (warBoard[i][j] == 'B') {
                    sumB += tempCnt * tempCnt;
                } else if (warBoard[i][j] == 'W') {
                    sumW += tempCnt * tempCnt;
                }
            }
        }
    }

    println("$sumW $sumB");
}