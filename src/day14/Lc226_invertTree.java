package day14;

/**
 * lc226-- 翻转二叉树
 */
public class Lc226_invertTree {

    /**
     * 翻转二叉树
     * @param root
     * @return
     */
    public Node invertTree(Node root) {
        if(root == null) return null;
        swapChildren(root);
        invertTree(root.l);
        invertTree(root.r);
        return root;
    }

    private void swapChildren(Node root) {
        Node temp = root.l;
        root.l = root.r;
        root.r = temp;
    }


    // 先序遍历打印树
    private void printTree(Node root) {
        if (root == null) return;
        System.out.print(root.v + " ");
        printTree(root.l);
        printTree(root.r);
    }

    public static void main(String[] args) {
        Lc226_invertTree tree = new Lc226_invertTree();

        // 创建测试二叉树
        Node root = new Node(1);
        root.l = new Node(2);
        root.r = new Node(3);
        root.l.l = new Node(4);
        root.l.r = new Node(5);
        root.r.l = new Node(6);
        root.r.r = new Node(7);

        System.out.println("翻转前的二叉树先序遍历:");
        tree.printTree(root);

        // 翻转二叉树
        tree.invertTree(root);

        System.out.println("\n翻转后的二叉树先序遍历:");
        tree.printTree(root);
    }
}