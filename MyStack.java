public class MyStack {
    private int[] array = new int[100];
    private int size = 0;

    public void push(int v) {
        array[size] = v;
        size++;
    }
    public int pop() {
        if (size == 0) {
            return 0;
        }
        int ret = array[size -1];
        size--;
        return ret;
    }
    public int peek() {
        if (size == 0) {
            return 0;
        }
        return array[size - 1];
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
}
