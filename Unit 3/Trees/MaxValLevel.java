package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxValLevel {
    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
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


    public static void main(String[] args) {
        Integer[] arr = new Integer[]{};

        TreeNode root = buildTree(arr);

        List<Integer> avg = maxValLevel(root);
        System.out.println(avg);
    }


    public static List<Integer> maxValLevel(TreeNode root){
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int lev = q.size();

            int max = Integer.MIN_VALUE;

            for(int i=0;i<lev;i++){
                TreeNode curr = q.poll();

                max = Math.max(max, curr.val);

                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            res.add(max);
        }

        return res;
    }


}
