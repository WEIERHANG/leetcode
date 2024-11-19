package interviewByHead;

/**
 * ------ 题目------
 *  请把一段纸条竖着放在桌子上,然后从纸条下往上对折一次,压出的折痕是凹下去的向里,
 *  给定一个输入参数N,代表纸条都是从下边向上方连续对折n次,请你从上到下打印所有折痕的方向
 *
 *  二叉树折纸 规律
 *  1. 头结点都是凹
 *  2. 所有左子树的头都是凹的
 *  3. 所有右子树的头都是凸的
 */
public class PaperFold {

    public static void printfAllFolds(int n){
        printProcess(1, n, true);
    }

    /**
     *  当你来到了第一个节点(假象)  节点就是折痕
     *  这个节点在第i层, 一共N层, N固定不变
     * 如果这个节点是凹 down = T
     * 如果节点是凸的 down = F
     * 函数的功能: 中序打印以你想象节点为头的整棵树
     *
     *
     * @param i
     * @param n
     * @param down
     */
    public static void printProcess(int i, int n, boolean down){
        if(i > n) return;   // 如果想象的节点大于n  直接返回
        printProcess(i + 1, n, true);  //
        System.out.print((down ? "凹" : "凸")+ " ");
        printProcess(i + 1, n, false);
    }

    public static void main(String[] args) {
        int n = 3;
        printfAllFolds(n);
    }


}
