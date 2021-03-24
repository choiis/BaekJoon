import java.util.*


fun main(args:Array<String>) {

    val sc: Scanner = Scanner(System.`in`);
    while(true) {
        val str:String = sc.nextLine();
        if("0".equals(str)) {
            break;
        }
        val length:Int = str.length / 2;
        var p:Boolean = true;
        for(i in 0 until length) {
            if (str.get(i) != str.get(str.length - 1 - i)) {
                p = false;
                break;
            }
        }

        if (p) {
            println("yes");
        } else {
            println("no");
        }
    }
}