package interviewByHead;


/**
 * 荷兰国旗  不要用辅助数组bigOn
 * 一个数组arr=[      ]
 * 1. 一个数x,小于等于x的放左边 大于x的放右边  [小于等于x   大于x]
 * 2. 小于x的放左边  等于x放中间  大于x放右边  [小于x   x   大于x]
 * eg  arr = [2, 1, 5, 4, 2, 3, 7, 0]    x = 4
 * 一. <=4 |  >4
 *  设计一个小于等于的区域 一开始下标在负一位置 R 便利下去 会遇到2中情况
 *      1. 当前数小于等于目标
 *          把当前数和小于等于区
 *          域的下一个数交换 然后小于等于区域向右扩 当前数跳下一个
 *
 *      2. 当前 > 目标 当前数直接跳下一个
 *
 * 二 <x | =x | >x    停止:当前数和右边届撞上时候
 *  设计一个小于区域 放在数组左边  一个大于区 放在数组右边 三种情况
 *   1. 当前 < 目标
 *       ~ 当前数和小于区的下一个数交换
 *       ~ 小于区向右扩一位
 *       ~ 当前数跳下一个
 *   2. 当前 = 目标
 *       ~ 当前直接跳下一个
 *   3. 当前 > 目标
 *       ~ 当前数和大于区 前一个交换
 *       ~ 大于区 向左 扩一位
 *       ~ 当前停留在原地
 *
 */
public class NetherlandsFlag {

    public static void main(String[] args) {
        testNetherlandsFlag();
    }

    public static void testNetherlandsFlag() {
        // 测试案例1: 基本情况，数组中有不同的值
        int[] arr1 = {3, 1, 4, 2, 5, 2, 3, 2};
        int[] result1 = netherlandsFlag(arr1, 0, arr1.length - 1);
        System.out.println("Test 1:");
        System.out.println("Array after partition: " + arrayToString(arr1));
        System.out.println("Indexes: " + result1[0] + ", " + result1[1]);
        System.out.println();

        // 测试案例2: 所有元素相同
        int[] arr2 = {5, 5, 5, 5, 5};
        int[] result2 = netherlandsFlag(arr2, 0, arr2.length - 1);
        System.out.println("Test 2:");
        System.out.println("Array after partition: " + arrayToString(arr2));
        System.out.println("Indexes: " + result2[0] + ", " + result2[1]);
        System.out.println();

        // 测试案例3: 数组中有一个元素
        int[] arr3 = {10};
        int[] result3 = netherlandsFlag(arr3, 0, arr3.length - 1);
        System.out.println("Test 3:");
        System.out.println("Array after partition: " + arrayToString(arr3));
        System.out.println("Indexes: " + result3[0] + ", " + result3[1]);
        System.out.println();

        // 测试案例4: 数组中所有元素都小于基准值
        int[] arr4 = {1, 2, 1, 2, 1};
        int[] result4 = netherlandsFlag(arr4, 0, arr4.length - 1);
        System.out.println("Test 4:");
        System.out.println("Array after partition: " + arrayToString(arr4));
        System.out.println("Indexes: " + result4[0] + ", " + result4[1]);
        System.out.println();

        // 测试案例5: 数组中所有元素都大于基准值
        int[] arr5 = {7, 8, 9, 10, 11};
        int[] result5 = netherlandsFlag(arr5, 0, arr5.length - 1);
        System.out.println("Test 5:");
        System.out.println("Array after partition: " + arrayToString(arr5));
        System.out.println("Indexes: " + result5[0] + ", " + result5[1]);
        System.out.println();
    }

    // 辅助方法：数组转换为字符串以便打印输出
    private static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void swap(int[] arr, int i ,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    /**
     * 荷兰国旗问题
     * 返回的是
     * @param arr
     * @param l
     * @param r
     * @return
     */
    public static int[] netherlandsFlag(int[] arr,int l, int r){
        if(l > r) return new int[]{-1,-1};
        if(l == r) return new int[]{l,r};
        int less = l - 1; // <区域的右边界  小于区域的最后一个位置  那么等于区域的第一个位置就是less+1
        int index = l;   // 当前数
        int more = r;   // > 区域的左边界
        //当前数不能喝大于区域的左边界撞上
        while(index < more){
            if(arr[index] == arr[r]) index++;     //1. 当前数等于划分值 直接跳下一个
            else if(arr[index] < arr[r]) swap(arr, index++, ++less);   // 2.当前小于目标
            else swap(arr, index, --more); // 当前大于目标  1. 当前原地 2. 大于扩左边
        }
        swap(arr, more, r);
        return new int[] {less + 1, more};
    }





}
