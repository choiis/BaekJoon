import java.util.*

fun main(args:Array<String>) {

    val sc:Scanner = Scanner(System.`in`);
    val V:Int = sc.nextInt();
    val E:Int = sc.nextInt();
    var graph:Array<IntArray> = Array(V,{IntArray(V)}); //
    for (i in 0 until V) {
        for (j in 0 until V) {
            graph[i][j] = -1;
        }
    }

    for(i in 0 until E) {
        val x:Int = sc.nextInt();
        val y:Int = sc.nextInt();
        val z:Int = sc.nextInt();
        graph[x - 1][y - 1]= z;
    }

    for (i in 0 until V) {
        for (j in 0 until V) {
            for (k in 0 until V) {
                if (graph[i][k] != -1 && graph[k][j] != -1 && graph[i][j] == -1) {
                    graph[i][j] = graph[i][k] + graph[k][j];
                } else if (graph[i][k] != -1 && graph[k][j] != -1 && graph[i][j] != -1) {
                    graph[i][j] = Math.min(graph[i][k] + graph[k][j], graph[i][j]) ;
                }
            }
        }
    }

    var cnt:Int = 40000;
    for (i in 0 until V) {
        if (graph[i][i] != -1) {
            cnt = Math.min(cnt,graph[i][i]);
        }
    }
    if (cnt == 40000) {
        println(-1);
    } else {
        println(cnt);
    }
}