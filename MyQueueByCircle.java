public class MyQueueByCircle {
    private int[] array = new int[100];
    //[head,tail)为有效元素范围
    private int head = 0;
    private int tail = 0;
    private int size = 0;

    public void offer(int val) {
        if (size == array.length) {
            //队满，无法继续插入
            return;
        }
        array[tail] = val;
        tail++;
        if (tail >= array.length) {//超出范围，从头开始
            tail = 0;
        }
        size++;
    }
    public Integer poll() {
        if (size == 0) {
            return null;
        }
        Integer ret = array[head];
        head++;
        if (head >= array.length) {
            head = 0;
        }
        size--;
        return ret;
    }
    //取队首元素
    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return array[head];
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
}

