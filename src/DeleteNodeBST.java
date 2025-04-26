import Entity.TreeNode;

public class DeleteNodeBST {
    /*
    Intuition
In a Binary Search Tree (BST), every node to the left of a node is smaller, and every node to the right is larger. To delete a node while preserving this structure:

If the node has no children, simply remove it.

If it has one child, replace it with its child.

If it has two children, find the inorder successor (the smallest value in the right subtree), copy its value to the node, and delete the successor recursively.

Approach
Search the node:

Recursively traverse left or right based on the key compared to the current node's value.
Delete the node:

Case 1: Leaf node – return null.

Case 2: One child – return the non-null child.

Case 3: Two children – find the inorder successor, copy its value, and delete the successor node from the right subtree.

Inorder Successor:

It is the leftmost node of the right subtree.
⏱️ Time Complexity

Complexity
Time complexity:
Average Case: O(log n) — For balanced BSTs.

Worst Case: O(n) — For skewed trees (like linked lists).
Space complexity:
O(log n) for balanced trees.

O(n) for skewed trees.
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(root.val < key){
            root.right = deleteNode(root.right,key);
        }else if(root.val > key){
            root.left = deleteNode(root.left,key);
        }else{
            if(root.left == null && root.right == null){
                return null;
            }

            if(root.left == null){
                return root.right;
            }

            else if(root.right == null) return root.left;

            TreeNode successor = findSuccessor(root.right);
            root.val = successor.val;
            root.right = deleteNode(root.right,successor.val);
        }

        return root;
    }
    private static TreeNode findSuccessor(TreeNode root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
}
