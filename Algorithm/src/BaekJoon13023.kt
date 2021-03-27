import java.util.*

var vector:Vector<Vector<Int>> = Vector();

fun dfsfriend(idx:Int, cnt:Int, visited:BooleanArray):Boolean {
    if(cnt == 4) {
        return true;
    }

    visited[idx] = true;
    for (i in 0 until vector.elementAt(idx).size) {
        val next:Int = vector.elementAt(idx).elementAt(i);
        if (!visited[next]) {
            if(dfsfriend(next, cnt + 1, visited)) {
                return true;
            }
        }
    }
    visited[idx] = false;
    return false;
}

fun main(args:Array<String>) {

    val sc:Scanner = Scanner(System.`in`);
    val N:Int = sc.nextInt();
    val M:Int = sc.nextInt();
    for (i in 0 until N) {
        vector.add(Vector());
    }
    for (i in 0 until M) {
        val a:Int = sc.nextInt();
        val b:Int = sc.nextInt();
        vector.elementAt(a).add(b);
        vector.elementAt(b).add(a);
    }

    for(i in 0 until N) {
        var visited:BooleanArray = BooleanArray(N);
        if(dfsfriend(i,0,visited)) {
            println(1);
            System.exit(0);
        }
    }
    println(0);
}