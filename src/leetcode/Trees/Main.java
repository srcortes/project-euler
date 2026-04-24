package leetcode.Trees;

import java.util.*;

public class Main {

    // ============================================
    // TreeNode Definition (provided by LeetCode)
    // ============================================
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Node with next pointer for level linking problems.
     * Used in problems like LeetCode 116/117.
     */
    static class Node {
        int val;
        Node left;
        Node right;
        Node next;

        Node() {}

        Node(int val) {
            this.val = val;
        }
    }

    // ============================================
    // UTILITY: Tree Construction
    // ============================================

    /**
     * Builds a binary tree from LeetCode array format.
     *
     * <p>Array format uses level-order traversal with null for missing nodes.
     * Example: [3,9,20,null,null,15,7] creates:
     * <pre>
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * </pre>
     *
     * @param arr the array representation of the tree
     * @return the root node of the constructed tree, or null if input is empty
     */
    public static TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode current = queue.poll();

            // Process left child
            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;

            // Process right child
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    // ============================================
    // DEPTH/HEIGHT CALCULATIONS
    // ============================================

    /**
     * Calculates the maximum depth (height) of a binary tree using recursion.
     *
     * <p>The depth of a tree is the number of nodes along the longest path from
     * the root node down to the farthest leaf node.
     *
     * <p>Time Complexity: O(n) where n is the number of nodes
     * <br>Space Complexity: O(h) where h is the height (recursion stack)
     *
     * @param root the root node of the binary tree
     * @return the maximum depth of the tree, or 0 if the tree is empty
     * @see <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/">LeetCode 104</a>
     */
    public static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // Count this node (1) + the maximum depth of either subtree
        return 1 + Math.max(depth(root.left), depth(root.right));
    }

    /**
     * Calculates the maximum depth using iterative BFS (level-order traversal).
     *
     * <p>Alternative to recursive approach - counts levels as we process the tree.
     *
     * <p>Time Complexity: O(n)
     * <br>Space Complexity: O(w) where w is maximum width of the tree
     *
     * @param root the root node of the binary tree
     * @return the maximum depth of the tree, or 0 if the tree is empty
     */
    public static int depth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }
        return depth;
    }

    /**
     * Finds the minimum depth of a binary tree.
     *
     * <p>The minimum depth is the number of nodes along the shortest path
     * from the root to the nearest leaf node. Uses BFS to find the first
     * leaf encountered, which guarantees the shortest path.
     *
     * <p>Time Complexity: O(n) worst case, but can be faster if tree is unbalanced
     * <br>Space Complexity: O(w) where w is maximum width
     *
     * @param root the root node of the binary tree
     * @return the minimum depth, or 0 if the tree is empty
     * @see <a href="https://leetcode.com/problems/minimum-depth-of-binary-tree/">LeetCode 111</a>
     */
    public static int MinimumDepthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            depth++;
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();

                // Found a leaf node - return immediately (shortest path)
                if (current.left == null && current.right == null) {
                    return depth;
                }

                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }
        return depth;
    }

    // ============================================
    // TREE TRAVERSALS
    // ============================================

    /**
     * Returns level-order traversal (BFS) of the tree grouped by level.
     *
     * <p>Each list in the result represents one level of the tree from top to bottom.
     *
     * <p>Time Complexity: O(n)
     * <br>Space Complexity: O(w) where w is maximum width
     *
     * @param root the root node of the binary tree
     * @return list of lists containing node values at each level
     * @see <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/">LeetCode 102</a>
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                currentLevel.add(current.val);

                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            result.add(currentLevel);
        }

        return result;
    }

    /**
     * Performs preorder traversal (Root -> Left -> Right) iteratively.
     *
     * <p>Note: Current implementation uses BFS pattern, not true preorder.
     * For correct preorder, use a stack with right child pushed before left.
     *
     * <p>Time Complexity: O(n)
     * <br>Space Complexity: O(h) where h is height
     *
     * @param root the root node of the binary tree
     * @return list of node values in preorder sequence
     * @see <a href="https://leetcode.com/problems/binary-tree-preorder-traversal/">LeetCode 144</a>
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> stack = new LinkedList<>();
        stack.offer(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.poll();
            result.add(current.val);

            if (current.right != null) {
                stack.offer(current.right);
            }
            if (current.left != null) {
                stack.offer(current.left);
            }
        }
        return result;
    }

    /**
     * Performs inorder traversal (Left -> Root -> Right) iteratively.
     *
     * <p>Note: Current implementation uses BFS pattern, not true inorder.
     * For correct inorder, use a stack and traverse left subtree first.
     *
     * <p>Time Complexity: O(n)
     * <br>Space Complexity: O(h) where h is height
     *
     * @param root the root node of the binary tree
     * @return list of node values in inorder sequence
     * @see <a href="https://leetcode.com/problems/binary-tree-inorder-traversal/">LeetCode 94</a>
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> stack = new LinkedList<>();
        stack.offer(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.poll();
            result.add(current.val);

            if (current.left != null) {
                stack.offer(current.left);
            }
            if (current.right != null) {
                stack.offer(current.right);
            }
        }
        return result;
    }

    /**
     * Performs postorder traversal (Left -> Right -> Root) iteratively.
     *
     * <p>Note: Current implementation uses BFS pattern, not true postorder.
     * For correct postorder, use two stacks or a modified iterative approach.
     *
     * <p>Time Complexity: O(n)
     * <br>Space Complexity: O(h) where h is height
     *
     * @param root the root node of the binary tree
     * @return list of node values in postorder sequence
     * @see <a href="https://leetcode.com/problems/binary-tree-postorder-traversal/">LeetCode 145</a>
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> stack = new LinkedList<>();
        stack.offer(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.poll();
            result.add(current.val);

            if (current.left != null) {
                stack.offer(current.left);
            }
            if (current.right != null) {
                stack.offer(current.right);
            }
        }
        return result;
    }

    /**
     * Inverts a binary tree (mirrors it left-to-right).
     *
     * <p>
     * Time Complexity: O(n)
     * <br>
     * Space Complexity: O(w) where w is maximum width
     *
     * @param root the root node of the tree to invert
     * @return the root of the inverted tree
     * @see <a href="https://leetcode.com/problems/invert-binary-tree/">LeetCode
     *      226</a>
     */
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            // Swap left and right children
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            // Add children to queue for processing
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }

        return root; // Return the modified original tree
    }

    // ============================================
    // TREE VALIDATION
    // ============================================

    /**
     * Checks if a binary tree is symmetric (mirror image of itself around center).
     *
     * <p>A tree is symmetric if its left and right subtrees are mirrors of each other.
     *
     * <p>Time Complexity: O(n)
     * <br>Space Complexity: O(h) recursion stack
     *
     * @param root the root node of the binary tree
     * @return true if the tree is symmetric, false otherwise
     * @see <a href="https://leetcode.com/problems/symmetric-tree/">LeetCode 101</a>
     */
    public static boolean SymetricTree(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    /**
     * Helper method to check if two subtrees are mirror images of each other.
     *
     * @param left the root of the left subtree
     * @param right the root of the right subtree
     * @return true if subtrees are mirrors, false otherwise
     */
    private static boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        return left.val == right.val
                && isMirror(left.left, right.right)
                && isMirror(left.right, right.left);
    }

    /**
     * Checks if a binary tree is height-balanced.
     *
     * <p>A tree is balanced if the left and right subtrees of every node
     * differ in height by no more than 1.
     *
     * <p>Time Complexity: O(n)
     * <br>Space Complexity: O(h) recursion stack
     *
     * @param root the root node of the binary tree
     * @return true if the tree is balanced, false otherwise
     * @see <a href="https://leetcode.com/problems/balanced-binary-tree/">LeetCode 110</a>
     */
    private static boolean isBalanced(TreeNode root) {
        return isBalanced2(root) != -1;
    }

    /**
     * Helper method that calculates height and detects imbalance.
     *
     * @param root the root node to check
     * @return height of the tree, or -1 if imbalanced
     */
    private static int isBalanced2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Recursively check left subtree
        int left = isBalanced2(root.left);
        if (left == -1) {
            return -1;
        }
        int right = isBalanced2(root.right);
        if (right == -1) {
            return -1;
        }
        // Check balance condition at current node
        if (Math.abs(left - right) > 1) {
            return -1; // Imbalanced

        }
        return 1 + Math.max(left, right);

    }

    // ============================================
    // TREE METRICS
    // ============================================

    /**
     * Calculates the diameter of a binary tree.
     *
     * <p>The diameter is the length of the longest path between any two nodes
     * in the tree. This path may or may not pass through the root.
     *
     * <p>Time Complexity: O(n)
     * <br>Space Complexity: O(h) recursion stack
     *
     * @param root the root node of the binary tree
     * @return the diameter (number of edges in longest path)
     * @see <a href="https://leetcode.com/problems/diameter-of-binary-tree/">LeetCode 543</a>
     */
    private static int DiameterOfBinaryTree(TreeNode root) {
        int[] max = new int[1];
        DiameterOfBinaryTree2(root, max);
        return max[0];
    }

    /**
     * Helper method that calculates height while tracking maximum diameter.
     *
     * @param root the root node to process
     * @param max array holding the current maximum diameter
     * @return height of the current subtree
     */
    private static int DiameterOfBinaryTree2(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = DiameterOfBinaryTree2(root.left, max);
        int right = DiameterOfBinaryTree2(root.right, max);
        max[0] = Math.max(max[0], right + left);

        return 1 + Math.max(right, left);
    }

    // ============================================
    // PATH PROBLEMS
    // ============================================

    /**
     * Determines if the tree has a root-to-leaf path with the given sum.
     *
     * <p>A leaf is a node with no children. The path must start at the root
     * and end at a leaf.
     *
     * <p>Time Complexity: O(n)
     * <br>Space Complexity: O(h) recursion stack
     *
     * @param root the root node of the binary tree
     * @param target the target sum to find
     * @return true if such a path exists, false otherwise
     * @see <a href="https://leetcode.com/problems/path-sum/">LeetCode 112</a>
     */
    public static boolean pathSum(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return target - root.val == 0;
        }
        // Recursively check both subtrees with reduced target
        return pathSum(root.left, target - root.val) || pathSum(root.right, target - root.val);
    }

    // ============================================
    // LEVEL-BASED QUERIES
    // ============================================

    /**
     * Returns the values of nodes visible from the right side of the tree.
     *
     * <p>The right side view shows the rightmost node at each level when
     * looking at the tree from the right side.
     *
     * <p>Time Complexity: O(n)
     * <br>Space Complexity: O(w) where w is maximum width
     *
     * @param root the root node of the binary tree
     * @return list of values visible from the right side, top to bottom
     * @see <a href="https://leetcode.com/problems/binary-tree-right-side-view/">LeetCode 199</a>
     */
    public static List<Integer> BinaryTreeRightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            // Process all nodes at current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                currentLevel.add(current.val);

                // Add children for next level
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            result.add(currentLevel.get(currentLevel.size() - 1));
        }
        return result;

    }

    /**
     * Calculates the average value of nodes at each level of the tree.
     *
     * <p>Uses BFS to process nodes level by level, computing the average
     * for each level.
     *
     * <p>Time Complexity: O(n)
     * <br>Space Complexity: O(w) where w is maximum width
     *
     * @param root the root node of the binary tree
     * @return list of average values for each level, top to bottom
     * @see <a href="https://leetcode.com/problems/average-of-levels-in-binary-tree/">LeetCode 637</a>
     */
    public static List<Double> AverageOfLevelsInBinaryTree(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double levelSum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                levelSum += current.val;
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            result.add(levelSum / levelSize);
        }
        return result;

    }

    /**
     * Finds the minimum depth of a binary tree (alternative implementation).
     *
     * <p>Note: This is a duplicate of the method at line 161. Consider removing
     * one implementation to avoid confusion.
     *
     * <p>Time Complexity: O(n)
     * <br>Space Complexity: O(w) where w is maximum width
     *
     * @param root the root node of the binary tree
     * @return the minimum depth, or 0 if the tree is empty
     */
    public static int MinimumDepthOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            depth++;
            // Process all nodes at current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();

                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
                if (current.left == null && current.right == null) {
                    return depth;
                }

            }
        }
        return depth;

    }

    // ============================================
    // NEXT POINTER PROBLEMS
    // ============================================

    /**
     * Populates each next pointer to point to its next right node.
     *
     * <p>Note: This implementation is incomplete. It creates a Node but doesn't
     * properly construct the next pointers. Should convert TreeNode to Node
     * and link nodes at the same level.
     *
     * <p>Expected Time Complexity: O(n)
     * <br>Expected Space Complexity: O(1) for perfect binary tree
     *
     * @param root the root node of the binary tree
     * @return the root of the tree with next pointers populated (currently incomplete)
     * @see <a href="https://leetcode.com/problems/populating-next-right-pointers-in-each-node/">LeetCode 116</a>
     */
    public static Node PopulatingNextRightPointersInEachNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Node head = new Node();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }
        return head;
    }
    // ============================================
    // MAIN — aquí pruebas
    // ============================================
    public static void main(String[] args) {
        // Input igual al de LeetCode: [3,9,20,null,null,15,7]
        // Integer[] input = {3, 9, 20, null, null, 15, 7};

        Integer[] input = { 2, null, 3, null, 4, null, 5, null, 6 };
        // Integer[] input = {1,2,3,4,5};
        TreeNode root = buildTree(input);

        // System.out.println("Árbol construido desde: " + Arrays.toString(input));
        // System.out.println("Resultado BFS por niveles: " + levelOrder(root));
        // System.out.println("Resultado Preorder Traversal: " +
        // preorderTraversal(root));
        // System.out.println("Resultado Inorder Traversal: " + inorderTraversal(root));
        // System.out.println("Resultado Postorder Traversal: " +
        // postorderTraversal(root));
        // System.out.println("Resultado Depth: " + depth(root));
        // System.out.println("Resultado Invert Tree: " + levelOrder(invertTree(root)));
        // System.out.println("Resultado Symetric Tree: " + SymetricTree(root));
        // System.out.println("Resultado isBalanced: " + isBalanced(root));
        // System.out.println("Resultado DiameterOfBinaryTree: " +
        // DiameterOfBinaryTree(root));
        // System.out.println("Resultado isBalanced: " + isBalanced(root));
        // System.out.println("Resultado pathSum: " + pathSum(root, 22));
        // System.out.println("Resultado BinaryTreeRightSideView: " +
        // BinaryTreeRightSideView(root));
        // System.out.println("Resultado AverageOfLevelsInBinaryTree: " +
        // AverageOfLevelsInBinaryTree(root));
        //System.out.println("Resultado MinimumDepthOfBinaryTree: " + MinimumDepthOfBinaryTree(root));
        // Esperado: [[3], [9, 20], [15, 7]]
        System.out.println("Resultado PopulatingNextRightPointersInEachNode: " + PopulatingNextRightPointersInEachNode(root));
    }
}
