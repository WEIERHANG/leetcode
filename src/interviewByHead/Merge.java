package interviewByHead;

/**
 * 递归排序
 */
public class Merge {

    public static void main(String[] args) {

    }


    // 左右排序 然后调用merge
    public static void process(int[] arr,int L,int R){
        if (L == R) return;
        int mid = L +((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge_Sort(arr,L,mid,R);

    }

    public static void merge_Sort(int[] arr,int L,int M,int R){
        int[] help = new int[R-L+1];
        int helpIndex = 0;
        int p1 = L,p2 = M + 1;
        while (p1 <= M && p2 <= R){
            help[helpIndex++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        //要么p1越界或者p2越界,只会运行一个
        while(p1 <= M){
            help[helpIndex++] = arr[p1++];
        }
        while (p2 <= R){
            help[helpIndex++] = arr[p2++];
        }
        //
        for(helpIndex = 0;helpIndex < help.length; helpIndex++){
            arr[L + helpIndex] = help[helpIndex];
        }

    }
}
