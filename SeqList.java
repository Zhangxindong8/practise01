import java.util.Arrays;

public class SeqList {
    // 创建一个类, 一般先考虑这个类要支持哪些操作(分析需求)
    // 结合这些操作来考虑要保存什么样的数据

    // 这个数组的最大容量是 10. 初始情况下
    // 这 10 个元素并不都是有效元素
    // 执行插入操作之后, 被插入的元素才是有效元素
    private int[] data = new int[10];
    // size 表示当前数组中有多少个有效元素
    private int size = 0;

    public void display() {
        // System.out.println(Arrays.toString(data));
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i]);
            if (i != size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // pos 把元素放到哪个下标上. elem 表示插入的元素是啥
    // 时间复杂度 O(N) (最坏)
    public void add(int pos, int elem) {
        // TODO
        if(pos>data.length||pos<0){
            return;
        }
        if (size >= data.length) {
            realloc();
        }
        if(pos==size){
            data[pos]=elem;
            size++;
        }
        else{
            for (int i = size; i>pos; i--) {
                data[i]=data[i-1];
            }
            data[pos]=elem;
            size++;
        }

    }

    private void realloc() {
        // 扩容的策略很灵活. 根据实际问题场景的特点
        // 来决定具体是线性增长还是指数增长还是其他啥方式
        // 原则是扩容是比较大的开销. 尽量应该根据实际场景
        // 让扩容的次数尽量少
        int[] newData = new int[this.data.length * 2];
        for (int i = 0; i < this.data.length; i++) {
            newData[i] = this.data[i];
        }
        this.data = newData;
    }

    public boolean contains(int toFind) {
        return this.search(toFind) != -1;
    }

    public int search(int toFind) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    public int getPos(int pos) {
        return this.data[pos];
    }

    public void setPos(int pos, int elem) {
        this.data[pos] = elem;
    }

    // 按值删除. 删除第一次出现的值
    public void remove(int toRemove) {
        // TODO
        int pos = search(toRemove);
        if(pos == -1){
            return;
        }

        if(pos == this.size - 1){
            this.size--;
            return;
        }

        for(int i = pos; i < this.size - 1; i++){
            this.data[i] = this.data[i + 1];
        }
        this.size--;
    }

    public int size() {
        return this.size;
    }

    public void clear() {
        this.size = 0;
        this.data = new int[10];
    }
}
