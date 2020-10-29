import java.util.Arrays;
import java.util.Stack;

public class TestSort {
    public static void insertSort(int[] array) {
        for (int bound = 1; bound < array.length; bound++) {
            int v = array[bound];
            int cur = bound - 1;
            for (; cur >= 0 ; cur--) {
                if (array[cur] > v) {     //  >=不能保证稳定性
                    array[cur + 1] = array[cur];
                } else {
                    break;
                }
            }
            array[cur + 1] = v;
        }
    }
    public static void shellSort(int[] array) {
        int gap = array.length / 2;
        while (gap > 0) {
            insertSortGap(array, gap);
            gap = gap / 2;
        }
        insertSortGap(array, 1);
    }
    private static void insertSortGap(int[] array, int gap) {
        for (int bound = gap; bound < array.length; bound++) {
            int v = array[bound];
            int cur = bound - gap;
            for (; cur >= 0; cur -= gap) {
                if (array[cur] > v) {
                    array[cur + gap] = array[cur];
                } else {
                    break;
                }
            }
            array[cur + gap] = v;
        }
    }
    public static void selectSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            //找出最小的交换
            for (int cur = bound + 1; cur < array.length; cur++) {
                if (array[cur] < array[bound]) {
                    int tmp = array[cur];
                    array[cur] = array[bound];
                    array[bound] = tmp;
                }
            }
        }
    }
    public static void heapSort(int[] array) {
        createHeap(array);
        //将堆顶元素交换到最后，交换完后将最后一个元素从堆中删除掉
        for (int i = 0; i < array.length - 1; i++) {
            swap(array, 0, array.length - 1 - i);
            shiftDown(array, array.length - i, 0);
        }
    }
    private static void createHeap(int[] array) {
        for (int i = (array.length - 1 - 1) / 2; i >= 0 ; i--) {
            shiftDown(array, array.length, i);
        }
    }
    private static void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
    //建大堆
    private static void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while (child < size) {
            if (child + 1 < size && array[child + 1] > array[child]) {
                child = child + 1;//child为比较大元素的下标
            }
            if (array[child] > array[parent]) {
                swap(array, child, parent);
            } else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }
    //升序[0,bound)有序
    public static void bubbleSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = array.length - 1; cur > bound ; cur--) {//如果cur>=,bound = 0时，cur--数组下标越界
                if (array[cur - 1] > array[cur]) {//如果取cur+1的元素，也就越界了
                    swap(array, cur - 1, cur);
                }
            }
        }
    }
    public static void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
    }
    private static void quickSortHelper(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int par = partition(array, left, right);
        quickSortHelper(array, left, par - 1);
        quickSortHelper(array, par + 1, right);
    }
    private static int partition(int[] array, int low, int high) {
        int tmp = array[low];
        while (low < high) {
            while (low < high && array[high] >= tmp) {
                high--;
            }
            array[low] = array[high];
            while (low < high && array[low] <= tmp) {
                low++;
            }
            array[high] = array[low];
        }
        array[low] = tmp;
        return low;
    }
    //非递归
    public static void quickSortByLoop(int[] array) {
        Stack<Integer> stack = new Stack<>();

        stack.push(array.length - 1);
        stack.push(0);

        while (!stack.empty()) {
            int left = stack.pop();
            int right = stack.pop();
            if (left >= right) {
                continue;
            }
            int par = partition(array, left, right);
            if (par > left + 1) {
                stack.push(par - 1);
                stack.push(left);
            }
            if (par < right - 1) {
                stack.push(right);
                stack.push(par + 1);
            }
        }
    }
    public static void mergeSort(int[] array) {
        mergeSortHelper(array, 0,array.length);
    }
    private static void mergeSortHelper(int[] array, int left, int right) {
        if (left >= right || right - left == 1) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSortHelper(array, left, mid);
        mergeSortHelper(array, mid, right);

        merge(array, left, mid, right);
    }
    private static void merge(int[] array, int left, int mid, int right) {
        int i = left;
        int j = mid;
        int length = right - left;
        int[] ret = new int[length];
        int index = 0;//ret数组的下标
        while (i < mid && j < right) {
            if (array[i] <= array[j]) {//<=保证稳定性
                ret[index++] = array[i++];
            } else {
                ret[index++] = array[j++];
            }
        }
        while (i < mid) {
            ret[index++] = array[i++];
        }
        while (j < right) {
            ret[index++] = array[j++];
        }
        //ret中的元素拷贝到原来区间
        for (int k = 0; k < ret.length; k++) {
            array[left + k] = ret[k];
        }
    }
    public static void mergeSortByLoop(int[] array) {
        for (int gap = 0; gap < array.length; gap *= 2) {
            for (int i = 0; i < array.length; i += 2 * gap) {
                int beg = i;
                int mid = i + gap;
                int end = i + 2 * gap;
                if (mid > array.length) {
                    mid = array.length;
                }
                if (end > array.length) {
                    end = array.length;
                }
                merge(array, beg, mid, end);
            }
        }
    }
    public static void main(String[] args) {
        int[] array = {6, 5, 1, 2, 9, 3, 10, 8, 4};
        mergeSortByLoop(array);
        System.out.println(Arrays.toString(array));
    }

}
