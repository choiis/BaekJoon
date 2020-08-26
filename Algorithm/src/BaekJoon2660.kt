import java.util.*

fun main(args:Array<String>) {

    val sc: Scanner = Scanner(System.`in`);
    val N:Int = sc.nextInt();
    var friend:Array<IntArray> = Array(N + 1){ IntArray(N + 1) };
    var score:IntArray = IntArray(N + 1);
    for(i in 0 until N + 1) {
        for(j in 0 until N + 1) {
            friend[i][j] = -1;
        }
    }

    while(true) {
        var x:Int = sc.nextInt();
        var y:Int = sc.nextInt();
        if(x == -1 && y == -1){
            break;
        }
        friend[x][y] = 1;
        friend[y][x] = 1;
    }

    for (k in 1 until N + 1) {
        for (i in 1 until N + 1) {
            for (j in 1 until N + 1) {
                if(friend[i][j] == -1) {
                    friend[i][j] = friend[i][k] + friend[k][j];
                } else if (friend[i][j] > friend[i][k] + friend[k][j]) {
                    friend[i][j] = friend[i][k] + friend[k][j];
                }
            }
        }
    }
    var pick:Int = -1
    for (i in 1 .. N) {
        var max:Int = 0;
        for (j in 1 .. N) {
            if (friend[i][j]  > max) {
                max = friend[i][j];
            }
        }
        score[i] = max
        if (pick > max || pick == -1) {
            pick = max
        }
    }
    var cnt:Int = 0
    for (i in 1 .. N) {
        if (score[i] === pick) {
            cnt++
        }
    }
    println(""+ pick+" " + cnt);
    for (i in 1 .. N) {
        if (score[i] === pick) {
           print("" + i + " ");
        }
    }
}