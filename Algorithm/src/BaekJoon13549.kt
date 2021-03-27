import java.util.*
import kotlin.collections.ArrayList

fun main(args:Array<String>) {

    val sc:Scanner = Scanner(System.`in`);
    val start:Int = sc.nextInt();
    val end:Int = sc.nextInt();

    var deque:Deque<HideAndSeek> = LinkedList();
    var visited:BooleanArray = BooleanArray(100001);
    deque.addFirst(HideAndSeek(start,0));
    visited[start] = true;

    while(!deque.isEmpty()) {
        val nowHideSeek:HideAndSeek = deque.pollFirst();
        val now:Int = nowHideSeek.now;
        var cnt:Int = nowHideSeek.cnt;
        visited[now] = true;
        if (now == end) {
            println(cnt);
            break;
        }
        val left = now - 1;
        val right = now + 1;
        val jump = 2 * now;

        if (jump < 100001 && !visited[jump]) {
            deque.addFirst(HideAndSeek(jump, cnt));
        }

        if (left >= 0 && !visited[left]) {
            deque.addLast(HideAndSeek(left, cnt + 1));
        }

        if (right < 100001 && !visited[right]) {
            deque.addLast(HideAndSeek(right, cnt + 1));
        }

    }

}

class HideAndSeek {
    var now:Int;
    var cnt:Int;

    constructor(now:Int,cnt:Int) {
        this.now = now;
        this.cnt = cnt;
    }
}