package interviewByHead;

public class KMTime {


    public static void main(String[] args) {

    }

    /**
     * 只有一种数出现k次，其余m次
     * @param arr
     * @param k
     * @param m
     * @return
     */
    public static int onlyKTimes(int[] arr,int k,int m){
        int[] t = new int[32];
        // t[0]位置代表 0位置的1出现了几次
        // t[i] 代表 i位置的1出现了几次
        for(int num : arr){
            for(int i = 0; i <=31; i++){
                // num 向右移动i之后&一 不等于0 就代表 num在第i的位置上是1
                if(((num >> i) & 1) != 0) t[i]++;
//                t[i] += (num >> 1) & 1; 向右移动i之后&一 不等于0 就等于啥也不加，

            }

        }
        return 0;
    }
}
