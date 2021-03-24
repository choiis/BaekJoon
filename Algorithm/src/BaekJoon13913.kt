import java.util.*
import kotlin.collections.ArrayList

fun main(args:Array<String>) {

    val sc:Scanner = Scanner(System.`in`);
    val start:Int = sc.nextInt();
    val end:Int = sc.nextInt();

    var queue:Queue<HideSeek> = LinkedList();
    var intqueue:Queue<HideSeek> = LinkedList();
    queue.add(HideSeek(start,0));
    var visited:IntArray = IntArray(100001);
    for (i in 0 until visited.size) {
        visited[i] = -1;
    }
    visited[start] = start;
    while(!queue.isEmpty()) {
        val nowHideSeek:HideSeek = queue.poll();
        val now:Int = nowHideSeek.now;
        val cnt:Int = nowHideSeek.cnt;
        if (now == end) {
            println(cnt);
            break;
        }
        var next:Int = 0;
        for (i in 0 .. 2) {
            if (i == 0) {
                next = now - 1
            } else if (i == 1) {
                next = now + 1;
            } else {
                next = 2 * now;
            }

            if (next >= 0 && next < 100001) {
                if(visited[next] == -1) {
                    visited[next] = now;
                    queue.add(HideSeek(next,cnt + 1));
                }
            }
        }
    }

    val array:ArrayList<Int> = ArrayList();
    array.add(end);
    var nextStep = visited[end];
    array.add(nextStep);
    while(start != nextStep) {
        nextStep = visited[nextStep];
        array.add(nextStep);
    }

    for (i in array.size - 1 downTo 0 step 1) {
        print("" + array.elementAt(i) + " ");
    }
}

class HideSeek {
    var now:Int;
    var cnt:Int;

    constructor(now:Int,cnt:Int) {
        this.now = now;
        this.cnt = cnt;
    }
}