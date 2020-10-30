public class Test5Tree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    //最近公共祖先
    private TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        findNode(root, p, q);
        return lca;
    }

    private boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        int left = findNode(root.left, p, q) ? 1 : 0;
        int right = findNode(root.right, p, q )? 1 : 0;
        int mid = (root == p || root == q) ? 1 : 0;
        if (left + right + mid == 2) {
            lca = root;
        }
        //三个结果之和为零，没找到，只要能找到1个或以上，返回true
        return (left + right + mid) > 0;
    }
    //二叉树转双向链表
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            return pRootOfTree;
        }
        TreeNode left = Convert(pRootOfTree.left);
        //左子树链表的尾结点,循环结束之后，leftTail就指向了左侧链表的尾部
        TreeNode leftTail = left;
        while (leftTail != null && leftTail.right != null) {
            leftTail = leftTail.right;
        }
        if (left != null) {
            leftTail.right = pRootOfTree;
            pRootOfTree = leftTail;
        }
        //转换右子树
        TreeNode right = Convert(pRootOfTree.right);
        if (right != null) {
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        return left == null ? pRootOfTree : left;
    }
    //前序，中序构建二叉树
    private int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index = 0;
        return buildTreeHelper(preorder, inorder, 0, inorder.length);
    }
    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int left, int right) {
        if (left >= right) {//中序遍历结果为空，这个数就是空数
            return null;
        }
        if (index >= preorder.length) {//遍历元素结束
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        index++;
        int pos = find(inorder, left, right, root.val);
        //[left,pos)表示当前root左子树中序遍历结果[pos+1，right）
        root.left = buildTreeHelper(preorder, inorder, left, pos);
        root.right = buildTreeHelper(preorder, inorder, pos + 1, right);
        return root;
    }
    private int find(int[] inorder, int left, int right, int toFind) {
        for (int i = left; i < right; i++) {
            if (inorder[i] == toFind) {
                return i;
            }
        }
        return -1;
    }
    //二叉树创建字符串
    private StringBuilder sb = new StringBuilder();
    public String treeStr(TreeNode t) {
        if (t == null) {
            return "";
        }
        helper(t);
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void helper(TreeNode t) {
        sb.append("(");
        sb.append(t.val);
        helper(t.left);
        if (t.left == null && t.right != null) {
            sb.append("()");
        }
        helper(t.right);
        sb.append(")");
    }

}
