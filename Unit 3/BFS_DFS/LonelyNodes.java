import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LonelyNodes {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> lonelyNodes = new ArrayList<>();
        if (root == null) return lonelyNodes; // Edge case: Empty tree

        // Queue for BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();

            // Check for lonely left child
            if (currentNode.left != null && currentNode.right == null) {
                lonelyNodes.add(currentNode.left.val);
            }
            // Check for lonely right child
            if (currentNode.right != null && currentNode.left == null) {
                lonelyNodes.add(currentNode.right.val);
            }

            // Add left and right children to the queue
            if (currentNode.left != null) queue.offer(currentNode.left);
            if (currentNode.right != null) queue.offer(currentNode.right);
        }

        return lonelyNodes;
    }


    
    public static TreeNode buildTree(Integer[] array) {
        if (array == null || array.length == 0) return null;

        // Create the root node from the first element
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1; // Start from the second element in the array
        while (!queue.isEmpty() && i < array.length) {
            TreeNode current = queue.poll();

            // Add the left child
            if (array[i] != null) {
                current.left = new TreeNode(array[i]);
                queue.add(current.left);
            }
            i++;

            // Add the right child if there's a next element
            if (i < array.length && array[i] != null) {
                current.right = new TreeNode(array[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }
    public static void main(String[] args) {
        // Example 1
        Integer[] array1 = {1, 2, 3, null, 4};
        Integer[] array2 = {7, 1, 4, 6, null, 5, 3, null, null, null, null, null, 2};

        TreeNode root1 = buildTree(array2);
        List<Integer> ans = getLonelyNodes(root1);
        System.out.println(ans);
    }
} 

// 1
// / \
// 2   3
// \
//  4

// 7
// / \
// 1   4
// /   / \
// 6   5   3
//     \
//      2
