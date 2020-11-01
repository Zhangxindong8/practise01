import java.util.Stack;

public class Test6Tree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public static void preOrderByLoop(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            System.out.println(top.val + " ");
            if (top.right != null) {
                stack.push(top.right);
            }
            if (top.left != null) {
                stack.push(top.left);
            }
        }
    }
    public static void inOrderByLoop(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (true) {
            while (cur != null) {
                cur = cur.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            TreeNode top = stack.pop();
            System.out.println(top.val + " ");
            //从当前节点的右子树出发，继续刚才的过程
            cur = top.right;
        }
    }
    public static void postOrderByLoop(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;//当前访问过节点的最后一个
        while (true) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            TreeNode top = stack.peek();
            if (top.right == null || prev == top.right) {
                System.out.println(top.val + " ");
                stack.pop();
                prev = top;
            } else {
                cur = top.right;
            }
        }
    }
}
