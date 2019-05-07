package Sort;

/**
 * 直接插入排序（Straight Insertion Sorting）的基本思想：
 * 在要排序的一组数中，假设前面(n-1) [n>=2] 个数已经是排好顺序的，
 * 现在要把第n个数插到前面的有序数中，使得这n个数也是排好顺序的。
 * 如此反复循环，直到全部排好顺序。
 */
public class InsertSort {
    //插入排序
    public void insertSort(int [] a){
        int len=a.length;//单独把数组长度拿出来，提高效率
        int insertNum;//要插入的数
        for(int i=1;i<len;i++){//因为第一次不用，所以从1开始
            insertNum=a[i];
            int j=i-1;//序列元素个数
            while(j>=0&&a[j]>insertNum){//从后往前循环，将大于insertNum的数向后移动
                a[j+1]=a[j];//元素向后移动
                j--;
            }
            a[j+1]=insertNum;//找到位置，插入当前元素
        }
    }
}
