import java.util.*

fun main(args:Array<String>) {

    val sc: Scanner = Scanner(System.`in`);
    var stack:Stack<Char> = Stack();
    val str:String = sc.next();
    var cnt:Int = 0;
    for(i in 0 until str.length) {
        if(str.get(i) == '(') {
            stack.add(str.get(i));
        } else {
            stack.pop();
            if(str.get(i - 1) == '(') {
                cnt += stack.size;
            } else {
                cnt += 1;
            }
        }
    }
    println(cnt);
}