import java.util.*

lateinit var depth:IntArray;
lateinit var treeParents:IntArray;
lateinit var graph:Vector<Vector<Int>>;

fun treedfs(from:Int, deep:Int) {
    depth[from] = deep;
    for(i in 0 until graph.elementAt(from).size) {
        if(depth[graph.elementAt(from).get(i)] == 0) {
            treeParents[graph.elementAt(from).get(i)] = from;
            treedfs(graph.elementAt(from).get(i) , deep + 1);
        }
    }
}

fun main(args:Array<String>) {

    val sc: Scanner = Scanner(System.`in`);
    val N:Int = sc.nextInt();
    graph = Vector();
    depth = IntArray(N + 1);
    treeParents = IntArray(N + 1);
    for(i in 0 .. N){
        graph.add(Vector<Int>());
    }

    for(i in 0 until N - 1) {
        val x:Int = sc.nextInt();
        val y:Int = sc.nextInt();
        graph.elementAt(x).add(y);
        graph.elementAt(y).add(x);
    }

    treedfs(1,1);
    val M:Int = sc.nextInt();
    for(i in 0 until M) {
        var nowX:Int = sc.nextInt();
        var nowY:Int = sc.nextInt();
        var depthX:Int = depth[nowX];
        var depthY:Int = depth[nowY];

        while(nowX != nowY) {
            if (depthX < depthY) {
                nowY = treeParents[nowY];
                depthY = depth[nowY];
            } else if (depthX > depthY) {
                nowX = treeParents[nowX];
                depthX = depth[nowX];
            } else {
                nowY = treeParents[nowY];
                depthY = depth[nowY];

                nowX = treeParents[nowX];
                depthX = depth[nowX];
            }
        }
        println(nowX);
    }
}