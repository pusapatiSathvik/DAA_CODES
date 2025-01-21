package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class Balanced {
    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{};

        TreeNode root = buildTree(arr);

        int ans = isBalanced(root);

        if (ans == -1) {
            System.out.println("false");
        }else{
            System.out.println("true");
        }

        
    }

    public static int isBalanced(TreeNode node){
        if (node == null) {
            return 0;
        }

        /////  get height of the left subtree
        int leftHeight = isBalanced(node.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = isBalanced(node.right);

        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    
    }

    public static TreeNode buildTree(Integer[] arr){

        if (arr.length == 0) return null;
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i=1;

        while (!q.isEmpty() && i<arr.length) {
            TreeNode curr = q.poll();

            /// add leftchild
            if (arr[i]!=null) {
                curr.left = new TreeNode(arr[i]);
                q.add(curr.left);
            }
            i++;

            //add right child

            if (arr[i]!=null) {
                curr.right = new TreeNode(arr[i]);
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
}
