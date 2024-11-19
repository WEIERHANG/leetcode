package interviewByHead;

/**
 * java  逆序对
 * 数组（3，1，4，5，2）的逆序对有(3,1),(3,2),(4,2),(5,2)，共4个
 * 本质求解 一个数x  求这个数左边比x小
 *
 */
public class ReverseCount {


    public static int reverPairCount(int[] arr){
        if(arr == null || arr.length <2) return 0;
        return process(arr, 0, arr.length -1);
    }

    public static int process(int[] arr,int l,int r){
        if(l == r) return 0;
        int mid = l + ((r-l) >> 1);
        return process(arr,l,mid) +process(arr,mid+1,r) + merge(arr,l,mid,r);
    }
    // 右往左和
    public static int merge(int[] arr,int l,int m,int r){
        int[] help = new int[r - l + 1];
        int i = help.length - 1;
        int p1 = m,p2 = r,res = 0;
        while(p1 >= l && p2 > m){
            res += arr[p1] > arr[p2] ? (p2 - m) : 0;
            help[i--] = arr[p1] > arr[p2] ? arr[p1--] : arr[p2--];
        }
        while (p1 >= l) help[i--] = arr[p1--];
        while (p2 > m)  help[i--] = arr[p2--];
        for(i = 0; i < help.length; i++) arr[l + i] = help[i];
        return res;
    }



}
