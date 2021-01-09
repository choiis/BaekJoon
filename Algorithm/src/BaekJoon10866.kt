import java.util.*

fun main(args:Array<String>) {

    val sc: Scanner = Scanner(System.`in`);
    var deque:BaekJoon10866.Deques<Int> = BaekJoon10866.Deques();
    val N:Int = sc.nextInt();
    for(i in 0 until N) {
        val str:String = sc.next();
        if ("push_back".equals(str)) {
            val num:Int = sc.nextInt();
            deque.pushback(num);
        } else if("push_front".equals(str)) {
            val num:Int = sc.nextInt();
            deque.pushfront(num);
        } else if ("front".equals(str)) {
            val res: Int? = if (deque.getfront() === null) -1 else deque.getfront();
            println(res);
        } else if ("back".equals(str)) {
            val res: Int? = if (deque.getback() === null) -1 else deque.getback();
            println(res);
        } else if ("size".equals(str)) {
            println(deque.length());
        } else if ("empty".equals(str)) {
            val res:Int? = if (deque.isEmpty()) 1 else 0;
            println(res);
        } else if ("pop_front".equals(str)) {
            val res: Int? =  deque.popfront();
            if(res == null) {
                println(-1);
            } else {
                println(res);
            }
        } else { // pop_back
            val res: Int? =  deque.popback();
            if(res == null) {
                println(-1);
            } else {
                println(res);
            }
        }
    }
}

class BaekJoon10866 {

    class Deques<T> : LinkdedLists<T> {

        constructor() {

        }

        fun pushback(t:T) {
            super.pushBack(t);
        }

        fun popfront(): T? {
            return super.popFront();
        }

        fun pushfront(t:T) {
            super.pushFront(t);
        }

        fun popback() : T? {
            return super.popBack();
        }

        fun getfront() : T? {
            return super.front();
        }

        fun getback() : T? {
            return super.back();
        }
    }

    open class LinkdedLists<T> {
        var size:Int;
        var head:Data<T>?;
        var tail:Data<T>?;

        protected constructor() {
            this.size = 0;
            this.head = null;
            this.tail = null;
        }

        fun length() : Int {
            return this.size;
        }

        fun isEmpty() : Boolean {
            return this.size == 0
        }

        protected fun pushBack(t:T) {
            if(isEmpty()) {
                this.head = Data<T>(t);
                this.tail = this.head;
                this.size++;
            } else {
                val data:Data<T> = Data<T>(t, this.tail ,null);
                this.tail!!.back = data;
                this.tail = this.tail!!.back;
                this.size++;
            }
        }

        protected fun pushFront(t:T) {
            if(isEmpty()) {
                this.head = Data<T>(t);
                this.tail = this.head;
                this.size++;
            } else {
                val data:Data<T> = Data<T>(t, null ,this.head);
                this.head!!.front = data;
                this.head = this.head!!.front;
                this.size++;
            }
        }
        protected fun popBack() : T? {
            if(isEmpty()) {
                return null;
            } else {
                size--;
                val result:T = this.tail!!.element;
                this.tail!!.front?.back = null;
                this.tail = this.tail!!.front;
                return result;
            }
        }

        protected fun popFront() : T? {
            if (isEmpty()) {
                return null;
            } else {
                size--;
                val result: T = this.head!!.element;
                this.head!!.back?.front = null;
                this.head = this.head!!.back;
                return result;
            }
        }

        protected fun front() : T? {
            if(isEmpty()) {
                return null;
            } else {
                return this.head!!.element;
            }
        }

        protected fun back() : T? {
            if(isEmpty()) {
                return null;
            } else {
                return this.tail!!.element;
            }
        }

    }

    class Data<T> {
        var element:T
        var front:Data<T>?;
        var back:Data<T>?;

        constructor(element:T) {
            this.element = element;
            this.front = null;
            this.back = null;
        }

        constructor(element:T, front:Data<T>?, back: Data<T>?) {
            this.element = element;
            this.front = front;
            this.back = back;
        }
    }
}