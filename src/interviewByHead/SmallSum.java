package interviewByHead;

/**
 * 小和问题
 * 一个数组中,每个数的左边比当前数小  累加起来
 *  1   3   4   2   5
 *  1的左边 比1小的  没有
 *  3的左边 比3小的  1
 *  4的左边 比4小的  1+3
 *  2的左边 比2小的  1
 *  5的左边 比5小的  1+3+4+2
 * 总和 1+1+3+1+1+3+4+2
 *
 */
public class SmallSum {

    public static void main(String[] args) {

    }

    public static int process(int[] arr, int l, int r){
        if(l == r) return 0;
        int mid = l + ((r-l) >> 1);
        return process(arr,l,mid) + process(arr,mid+1,r) + merge(arr,l,mid,r);
    }
    public static int merge(int[] arr,int l,int m,int r){
        int[] help = new int[r - l + 1];
        int helpIndex = 0,p1 = l,p2 = m+1;
        int sum = 0;
        while(p1 <= m && p2 <= r){
            // 左组小于有组的时候 产生多少个arr[p1]
            sum += arr[p1] < arr[p2] ? (r - p2 +1) * arr[p1] : 0;
            help[helpIndex++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) help[helpIndex++] = arr[p1++];
        while (p2 <= r) help[helpIndex++] = arr[p2++];
        for(helpIndex = 0; helpIndex < help.length; helpIndex++) arr[l + helpIndex] = help[helpIndex];
        return sum;
    }


}
