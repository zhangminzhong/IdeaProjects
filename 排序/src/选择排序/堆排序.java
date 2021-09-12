package 选择排序;

public class 堆排序 {

    public static void main(String[] args) {
        int arr[]={8,6,12,5,14,7,21,2,9,3};
        heapSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void heapSort(int[] a){
        //循环建堆
        for(int i=0;i<a.length-1;i++){
            //建堆
            buildMaxHeap(a, a.length-1-i);
            //交换堆顶和最后一个元素
            swap(a,0,a.length-1-i);
        }
    }

    //对数组从0到lastIndex建大顶堆
    public static void buildMaxHeap(int[] a,int lastIndex){
        //从lastIndex处节点的父节点开始
        for(int i=(lastIndex-1)/2;i>=0;i--){
            //k保存正在判断的节点
            int k = i;
            //如果当前k节点的子节点存在
            while(k*2+1<=lastIndex){
                //k节点的左子结点的索引
                int biggerIndex=2*k+1;
                //如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                if(biggerIndex<lastIndex){
                    //如果右子节点的值较大
                    if(a[biggerIndex]<a[biggerIndex+1])
                        biggerIndex++;
                }

                //如果k节点的值小于其较大的子节点的值
                if(a[k]<a[biggerIndex]){
                    //交换他们
                    swap(a, k, biggerIndex);
                    //将biggerIndex赋值给k，开始while循环下一次循环，重新保证k节点的值大于其左右子节点的值
                    k=biggerIndex;
                }else
                    break;
            }
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
