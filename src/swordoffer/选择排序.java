package swordoffer;

//堆:http://blog.51cto.com/shangdc/2073589
//TopK问题是指从大量数据（源数据）中获取最大（或最小）的K个数据。
public class 选择排序
{

    public static void main(String[] args)
    {
        //int[] arr = {7, 23, 45, 9, 40, 73, 12, 49};  //0下标放的是数组长度，
        int[] arr = {19, 38, 7, 36, 5, 5, 3, 2, 1, 0, 56};
        printArr(arr);
        //简单选择 有序区和无序区
        //simpleChoiceSort(arr);

        //堆排序
        heapSort(arr);

        printArr(arr);
    }

    private static void heapSort(int[] arr)
    {
        //1 6 7 2 3 4 5
        /**
         *         1
         *     6       7
         *  2     3  4    5
         */
        if (arr == null || arr.length <= 1)
            return;
        // 第一次排序，构建最大堆，只保证了堆顶元素是数组里最大的
        buildMaxHeap(arr);
        for (int i = arr.length - 1; i >= 1; i--)
        {
            // 这个是什么意思呢？，经过上面的一些列操作，目前array[0]是当前数组里最大的元素，
            // 需要和末尾的元素交换，然后，拿出最大的元素
            //接下来不断建堆，然后让数组最后一位与当前堆顶(数组第一位)进行交换即可排序：
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            //交换完后，下次遍历的时候，就应该跳过最后一个元素，也就是最大的那个值，然后开始重新构建最大堆
            //堆的大小就减去1，然后从0的位置开始最大堆
            maxHeap(arr, 0, i);
            //minHeap(arr, 0, i);


        }
    }

    // 构建堆
    private static void buildMaxHeap(int[] arr)
    {
        // 堆的公式就是 int root = 2*i, int left = 2*i+1, int right = 2*i+2;
        int currentRootNode = arr.length / 2;
        for (int i = currentRootNode; i >= 0; i--)// 这样for循环下，就可以第一次排序完成
        {
            //最大堆
            maxHeap(arr, i, arr.length);

            //最小堆
            //minHeap(arr, i, arr.length);
        }
    }

    private static void maxHeap(int[] arr, int currentRootNode, int heapSize)
    {
        int left = 2 * currentRootNode + 1;// 左子节点
        int right = 2 * currentRootNode + 2;// 右子节点
        int maxValue = currentRootNode;// 暂时定在currentRootNode的位置就是最大值

        // 如果左子节点的值，比当前最大的值大，就把最大值的位置换成左子节点的位置
        if (left < heapSize && arr[left] > arr[maxValue])
            maxValue = left;//记录位置
        //如果右子节点的值，比当前最大的值大，就把最大值的位置换成右子节点的位置
        if (right < heapSize && arr[right] > arr[maxValue])
            maxValue = right;
        // 如果不相等，说明啊，这个子节点的值有比自己大的，位置发生了交换了位置
        if (maxValue != currentRootNode)
        {
            // 就要交换位置元素，上面的只是记录位置
            int temp = arr[maxValue];
            arr[maxValue] = arr[currentRootNode];
            arr[currentRootNode] = temp;

            // 交换完位置后还需要判断子节点是否打破了最大堆的性质。最大堆性质：两个子节点都比父节点小。
            maxHeap(arr, maxValue, heapSize);

        }
    }

    private static void minHeap(int[] arr, int currentRootNode, int heapSize)
    {
        int left = 2 * currentRootNode + 1;// 左子节点
        int right = 2 * currentRootNode + 2;// 右子节点
        int minValue = currentRootNode;// 暂时定在currentRootNode的位置就是最大值

        // 如果左子节点的值，比当前最小的值小，就把最小值的位置换成左子节点的位置
        if (left < heapSize && arr[left] < arr[minValue])
            minValue = left;//记录位置
        // 如果不相等，说明啊，这个子节点的值有比自己小的，位置发生了交换了位置
        if (right < heapSize && arr[right] < arr[minValue])
            minValue = right;
        // 如果不相等，说明啊，这个子节点的值有比自己大的，位置发生了交换了位置
        if (minValue != currentRootNode)
        {
            // 就要交换位置元素，上面的只是记录位置
            int temp = arr[minValue];
            arr[minValue] = arr[currentRootNode];
            arr[currentRootNode] = temp;
            // 交换完位置后还需要判断子节点是否打破了最小堆的性质。最小性质：两个子节点都比父节点大。
            minHeap(arr, minValue, heapSize);

        }
    }

    // 数组元素交换
    public static void swap(int[] array, int index1, int index2)
    {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    //*******************************简单选择*****************************************

    private static void simpleChoiceSort(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            //用K记录最小的元素的下标
            int k = i;
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[j] < arr[k])
                    k = j;
            }
            int temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
        }
    }

    private static void printArr(int[] arr)
    {
        for (int val : arr)
        {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
