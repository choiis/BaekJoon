import java.util.*

fun main(args:Array<String>) {

    val sc: Scanner = Scanner(System.`in`);
    val N:Int = sc.nextInt();
    for(i in 1 .. N) {
        for (j in 1 .. i){
            print("*")
        }
        println();
    }
}