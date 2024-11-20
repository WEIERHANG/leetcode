package day17;


/**
 * lc617_合并二叉树
 *
 */
public class Lc617_mergeTrees {


    public Node mergeTrees(Node r1, Node r2){
        if(r1 == null) return r2;
        if(r2 == null) return r1;

        r1.v += r2.v;

        r1.l = mergeTrees(r1.l, r2.l);
        r1.r = mergeTrees(r1.r, r2.r);

        return r1;
    }


}
