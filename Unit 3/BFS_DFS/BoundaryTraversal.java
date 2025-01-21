import java.util.*;
class TreeNode{
    TreeNode left,right;
    int val;

    TreeNode(int x){
        this.val=x;
    }
}

public class BoundaryTraversal {

     public static void main(String[] args) {
        // Example 1
        Integer[] array1 = {1, 2, 3, null, 4};
        Integer[] array2 = {7, 1, 4, 6, null, 5, 3, null, null, null, null, null, 2};

        TreeNode root1 = buildTree(array2);
        List<Integer> ans = boundary(root1);
        // System.out.println(ans);
    }

    public static TreeNode buildTree(Integer[] arr){
        if (arr == null || arr.length == 0 ) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i=1;
        while (!q.isEmpty() && i<arr.length) {
            TreeNode curr = q.poll();

            if (arr[i] != null || arr[i]!=-1) {
                curr.left = new TreeNode(arr[i]);
                q.add(curr.left);
            }
            i++;


            // add right
            if (i < arr.length && arr[i] != null) {
                curr.right = new TreeNode(arr[i]);
                q.add(curr.right);
            }
            i++;

        }


        return root;
            
    }
    public static List<Integer> boundary(TreeNode root){
        List<Integer> ans = new LinkedList<>();
        if (root == null) return ans;

        // add root node.....
        ans.add(root.val);

        // left boundary
        left(root.left,ans);

        // leafnodes...

        leaf(root,ans);

        // Collect right boundary (excluding root and leaves, in reverse order)
        List<Integer> rightans = new ArrayList<>();

        right(root.right,rightans);


        Collections.reverse(rightans);

        ans.addAll(rightans);

        return ans;
    }


    private static void left(TreeNode node,List<Integer> ans){
        while (node!=null) {
            if (node.left!=null && node.right!=null) {
                ans.add(node.val);
            }

            if (node.left!=null) {
                node = node.left;
            }
            else{
                node = node.right;
            }
        }
    }

    private static void leaf(TreeNode node,List<Integer>ans){
        if (node==null) return;

        if (node.left==null && node.right==null) {
            ans.add(node.val);
        }


        leaf(node.left, ans);
        leaf(node.right, ans);
    }

    private static void right(TreeNode node,List<Integer> ans){
        while (node!=null) {
            if (node.left!=null && node.right!=null) {
                ans.add(node.val);
            }
            // move right or left..
            if (node.right!=null) {
                node = node.right;
            }else{
                node = node.left;
            }

        }
    }
}
