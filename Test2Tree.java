class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Test2Tree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q ==null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        boolean ret = false;
        if (s.val == t.val) {
            ret = isSameTree(s, t);
        }
        if (!ret) {
            ret = isSubtree(s.left, t);
        }
        if (!ret) {
            ret = isSubtree(s.right, t);
        }
        return ret;
    }
}
