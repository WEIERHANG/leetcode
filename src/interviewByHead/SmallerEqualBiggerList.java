package interviewByHead;

/**
 *  将链表按照某个值划分成 左边小 中间相等  右边大的形式
 *
 */
public class SmallerEqualBiggerList {

    public static void main(String[] args) {

    }
    // node节点
    public static class NodeBetter{
        int value;
        NodeBetter next;
        public NodeBetter(int data){
            this.value = data;
        }
    }

    /**
     * 方法1 :
     * l
     * @param head
     * @param target
     * @return
     */
    public static NodeBetter listPartition1(NodeBetter head, int target){

        if(head == null) return head;
        // 计算链表的长度
        NodeBetter cur = head;
        int i = 0;
        while(cur != null){
            i++;
            cur = cur.next;
        }
        // 将链表的节点存入数组中
        NodeBetter[] nodeArr = new NodeBetter[i];
        i = 0;
        cur = head;
        for(i = 0;i != nodeArr.length; i++){
            nodeArr[i] = cur;
            cur = cur.next;
        }
        // 对数组进行分区操作
        arrPartition(nodeArr,target);
        // 将数组重新连成链表
        for(i = 1; i != nodeArr.length; i++) nodeArr[i - 1].next = nodeArr[i];
        nodeArr[i - 1].next = null;
        // 返回新链表的头结点
        return nodeArr[0];
    }

    /**
     * 数组的分区操作
     * @param nodeArr
     * @param target
     */
    public static void arrPartition(NodeBetter[] nodeArr, int target){

        int small = -1, big = nodeArr.length, index = 0;
        while(index != big){
            if(nodeArr[index].value < target){
                swap(nodeArr, ++small, index++);
            }else if(nodeArr[index].value == target){
                index++;
            }else {
                swap(nodeArr, --big, index);
            }
        }
    }
    public static void swap(NodeBetter[] nodeArr, int a, int b){
        NodeBetter tmp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = tmp;
    }
//    ---------------------------------------------------

    /**
     * 方法2  面试有=用
     * 划分成小 中 大三个区域,再把各个区域连接起来
     * @param head
     * @param target
     * @return
     */
    public static NodeBetter listPartition2(NodeBetter head, int target){
        // 1. 设定6个变量和 一个next
        NodeBetter sH = null, sW = null;
        NodeBetter eH = null, eW = null;
        NodeBetter bH = null, bW = null;
        NodeBetter next = null;

        /**   2. 遍历原链表并分区
         * 1. 首先保存head.next到next 因为爆吧当前节点从链表中取出,并且于原链表断开
         * 2. 然后根据节点的值 于目标划分值进行比较 开始分区
         * 如果链表的头部为空,则初始化头尾,否则,将节点添加到当前尾节点的后面,并且更新尾巴节点
         * 3. 三个区域链接起来
         *  首先检查小于区域是否为空,如果不为空,将小尾sW与等头eH进行链接
         *  如果等于区域为空,那么eW设置为sW 确保小尾直接链接到大于区域
         *
         *  然后检查等于区域是否为空,如果不为空,将等尾eW与大头bH进行链接
         * 最后返回新链表的头结点
         * 1. 如果小于区域不为空,返回小头sH
         * 2. 否则 如果等于区域不为空, 返回等头eH
         * 3, 否则 返回大于区域的头节点bH
         *
         *
         *
         */
        while(head != null){
            next = head.next;
            head.next = null;
            if(head.value < target){
                if(sH == null){
                    sH = head;
                    sW = head;
                }else {
                    sW.next = head;
                    sW = head;
                }
            }else if(head.value == target){
                if(eH == null){
                    eH = head;
                    eW = head;
                }else {
                    eW.next = head;
                    eW = head;
                }
            }else{
                if(bH == null){
                    bH = head;
                    bW = head;
                }else {
                    bW.next = head;
                    bW = head;
                }
            }
            head = next;
        }
        // 3. 串起来 小尾连 等头, 等尾连大头

        if(sW != null){
            sW.next = eH;
            //下一步,谁去链接大于区域的头,谁就变成eW
            eW = eW == null ? sW : eW;
        }
        if(eW != null){
            eW.next = bH;
        }
        return sH != null ? sH : (eH != null ? eH : bH);

    }

    public static void printfLinkedList(NodeBetter node){
        System.out.println("链表数据: ");
        while (node != null){
            System.out.println(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

}
