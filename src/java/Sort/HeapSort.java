package Sort;

import java.util.ArrayList;

public class HeapSort {
    /**
     * 小根堆
     */
    // 向下调整，顶端的大值往下调，主要用于删除和建堆,i表示要调整的节点索引
    // 删除时候，i是0，建堆时候i从最后一个节点的父节点依次往前调整
    private void fixMinHeapDown(ArrayList<Integer> data, int i) {
        int lastIndex = data.size()-1; //lastIndex表示堆的最后一个元素索引
        int num = data.get(i);
        int son = i * 2 + 1;
        while (son <= lastIndex) {
            if (son + 1 <= lastIndex && data.get(son + 1) < data.get(son))
                son++;
            if (num < data.get(son))
                break;
            data.set(i, data.get(son));
            i = son;
            son = i * 2 + 1;
        }
        data.set(i, num);
    }

    // 向上调整，小值往上走,用于增加,往上调整不需要制定最上面的索引，肯定是0
    private void fixMinHeapUp(ArrayList<Integer> data, int index) {
        int num = data.get(index);
        int father = (index - 1) / 2;
        // data[father] > num是进入循环的基本条件,father减到0就不会减少了
        // 当index等于0时，father=0；进入死循环，所以当index==0时，需要跳出循环
        while (data.get(father) > num && index != 0) {
            data.set(index, data.get(father));
            index = father;
            father = (index - 1) / 2;
        }
        data.set(index, num);
    }

    // 取出最小值
    public int getMin(ArrayList<Integer> data){
        int min = data.get(0);
        deleteMinHeap(data);
        return min;
    }

    // 删除根节点,lastIndex表示堆的最后一个元素的索引
    public void deleteMinHeap(ArrayList<Integer> data) {
        int lastIndex = data.size() - 1;
        data.set(0, data.get(lastIndex));
        data.remove(lastIndex);
        fixMinHeapDown(data, 0);
    }

    // 在末尾处增加,num表示要增加的数字，lastIndex表示堆的最后一个元素的索引
    public void insertMinHeap(ArrayList<Integer> data, int num) {
        data.add(num);
        int lastIndex = data.size() - 1;
        fixMinHeapUp(data, lastIndex);
    }

    // 建堆,lastIndex表示要建堆的最后一个元素的索引
    public void createMinHeap(ArrayList<Integer> data) {
        int lastIndex = data.size() - 1;
        for (int i = (lastIndex - 1) / 2; i >= 0; i--)
            fixMinHeapDown(data, i);
    }


    /**
     * 大根堆
     */
    // 向下调整，顶端的小值往下调，主要用于删除和建堆,i表示要调整的节点索引
    // 删除时候，i是0，建堆时候i从最后一个节点的父节点依次往前调整
    private void fixMaxHeapDown(ArrayList<Integer> data, int i) {
        int lastIndex = data.size()-1; //lastIndex表示堆的最后一个元素索引
        int num = data.get(i);
        int son = i * 2 + 1;
        while (son <= lastIndex) {
            if (son + 1 <= lastIndex && data.get(son + 1) > data.get(son))
                son++;
            if (num < data.get(son))
                break;
            data.set(i, data.get(son));
            i = son;
            son = i * 2 + 1;
        }
        data.set(i, num);
    }

    // 向上调整，大值往上走,用于增加,往上调整不需要制定最上面的索引，肯定是0
    private void fixMaxHeapUp(ArrayList<Integer> data, int index) {
        int num = data.get(index);
        int father = (index - 1) / 2;
        // data[father] > num是进入循环的基本条件,father减到0就不会减少了
        // 当index等于0时，father=0；进入死循环，所以当index==0时，需要跳出循环
        while (data.get(father) < num && index != 0) {
            data.set(index, data.get(father));
            index = father;
            father = (index - 1) / 2;
        }
        data.set(index, num);
    }

    // 取出最小值
    public int getMax(ArrayList<Integer> data){
        int max = data.get(0);
        deleteMaxHeap(data);
        return max;
    }

    // 删除根节点,lastIndex表示堆的最后一个元素的索引
    public void deleteMaxHeap(ArrayList<Integer> data) {
        int lastIndex = data.size() - 1;
        data.set(0, data.get(lastIndex));
        data.remove(lastIndex);
        fixMaxHeapDown(data, 0);
    }

    // 在末尾处增加,num表示要增加的数字，lastIndex表示堆的最后一个元素的索引
    public void insertMaxHeap(ArrayList<Integer> data, int num) {
        data.add(num);
        int lastIndex = data.size() - 1;
        fixMaxHeapUp(data, lastIndex);
    }

    // 建堆,lastIndex表示要建堆的最后一个元素的索引
    public void createMaxHeap(ArrayList<Integer> data) {
        int lastIndex = data.size() - 1;
        for (int i = (lastIndex - 1) / 2; i >= 0; i--)
            fixMaxHeapDown(data, i);
    }

}
