package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class Symmetric {
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

        System.out.println(isSymmetric(root));

        System.out.println(iterative(root));
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

    public static boolean isSymmetric(TreeNode root){

        if(root == null) return true;

        return mirror_recursive(root.left,root.right);
    }


    public static boolean mirror_recursive(TreeNode left,TreeNode right){

        ///// bc 
        if (left == null && right == null) return true;

        if (left==null || right==null || left.val!=right.val) return false;

        // Check if:
        // 1. Left child of left subtree is a mirror of right child of right subtree
        // 2. Right child of left subtree is a mirror of left child of right subtree
        return mirror_recursive(left.left, right.right) && mirror_recursive(left.right, right.left);
    }




    public static boolean iterative(TreeNode root){
        if (root == null) {
            return true;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);

        while (!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();

            if (left==null & right == null) {
                continue;
            }
            if (left == null || right == null || left.val != right.val) {
                return false;
            }

            //
            q.add(left.left);
            q.add(right.right);

            //

            q.add(left.right);
            q.add(right.left);

        }

        return true;
    }
}
