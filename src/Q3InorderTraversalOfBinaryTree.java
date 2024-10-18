public class Q3InorderTraversalOfBinaryTree {
    public void call() {
        // Creating a simple binary tree
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);

        System.out.println("Inorder Traversal:");
        inorderTraversal(tree);
    }

    static void inorderTraversal(TreeNode node) {
        if (node == null) return;

        inorderTraversal(node.left);  // Visit left subtree
        System.out.print(node.value + " ");  // Visit node
        inorderTraversal(node.right); // Visit right subtree

    }
}

class TreeNode {
    int value;
    TreeNode left, right;

    TreeNode(int item) {
        value = item;
        left = right = null;
    }
}
