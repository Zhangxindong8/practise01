import java.util.Scanner;

public class Test4Tree {
    static class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    //二叉树的构建及遍历
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //多组输入
        while (sc.hasNext()) {
            String line = sc.next();
            TreeNode root = createTreePreOrder(line);
            inOrder(root);
            System.out.println();
        }
    }

    private static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.val + " ");
        inOrder(root.right);
    }
    private static TreeNode createTreePreOrder(String line) {
        int index = 0;
        char cur = line.charAt(index);
        if (cur == '#') {
            return null;
        }
        TreeNode root = new TreeNode(cur);
        index++;
        root.left = createTreePreOrder(line);
        index++;
        root.right = createTreePreOrder(line);
        return root;
    }
}
