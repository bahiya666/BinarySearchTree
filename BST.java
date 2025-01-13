public class BST<T extends Comparable<T>> {

    public BinaryNode<T> root;

    public BST() 
    {
        this.root = null;
    }

    public void delete(T data) 
    {
        root = deleteRecursive(root, data);
    }

    private BinaryNode<T> deleteRecursive(BinaryNode<T> root, T data) {
        if (root == null) 
        {
            return null; // Data not found in the tree
        }
    
        // Search for the node to delete
        int cmp = data.compareTo(root.data);
        if (cmp < 0) 
        {
            root.left = deleteRecursive(root.left, data); // Delete in left subtree
        } 
        else if (cmp > 0) 
        {
            root.right = deleteRecursive(root.right, data); // Delete in right subtree
        } 
        else 
        {
            if (root.left == null) 
            {
                return root.right;
            } 
            else if (root.right == null) 
            {
                return root.left;
            }
    
            // Find the minimum value node in the right subtree
            BinaryNode<T> minNode = findMinRecursive(root.right);
            root.data = minNode.data;
            root.right = deleteMinRecursive(root.right);
        }
    
        return root;
    }
    
    private BinaryNode<T> deleteMinRecursive(BinaryNode<T> node) 
    {
        if (node.left == null) 
        {
            return node.right;
        }
        node.left = deleteMinRecursive(node.left);
        return node;
    }
    
    public boolean contains(T data) 
    {
        return containsRecursive(root, data);
    }

    private boolean containsRecursive(BinaryNode<T> node, T data) 
    {
        if (node == null) 
        {
            return false; 
        }

        int cmp = data.compareTo(node.data);

        if (cmp < 0) 
        {
            return containsRecursive(node.left, data); // Search in the left subtree
        } 
        else if (cmp > 0) 
        {
            return containsRecursive(node.right, data); // Search in the right subtree
        } 
        else 
        {
            return true; // Node found
        }
    }
    
    public void insert(T data) 
    {
        root = insertRecursive(root, data);
    }

    private BinaryNode<T> insertRecursive(BinaryNode<T> root, T data) {
        if (root == null) 
        {
            return new BinaryNode<>(data);
        }

        if (data.compareTo(root.data) == 0) 
        {
            return root;
        }

        if (data.compareTo(root.data) < 0) 
        {
            root.left = insertRecursive(root.left, data);
        }
        else 
        {
            root.right = insertRecursive(root.right, data);
        }

        return root;
    }


    public int getHeight() 
    {
        return calculateHeight(root);
    }

    private int calculateHeight(BinaryNode<T> node) 
    {
        if (node == null) 
        {
            return 0; // Base case: empty tree or leaf node
        }
        
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    public String printSearchPath(T data) {
        if (root == null) {
            return "Empty tree";
        }
    
        StringBuilder path = new StringBuilder();
    
        // Check if the root node itself matches the target data
        if (root.data.equals(data)) {
            path.append(root.data);
            return path.toString();
        }
    
        // If not, call the recursive function starting from the root's children
        if (root.left != null && printSearchPathRecursive(root.left, data, path)) {
            path.insert(0, root.data + " -> "); // Insert the root data at the beginning
            return path.toString();
        }
        path.setLength(0); // Clear the path StringBuilder for the right subtree
    
        if (root.right != null && printSearchPathRecursive(root.right, data, path)) {
            path.insert(0, root.data + " -> "); // Insert the root data at the beginning
            return path.toString();
        }
    
        return "Data not found";
    }

    private boolean printSearchPathRecursive(BinaryNode<T> node, T data, StringBuilder path) {
        if (node == null) {
            return false;
        }
    
        // Remember the current length of the path
        int lengthBeforeAppend = path.length();
    
        // Append the arrow separator if needed
        if (lengthBeforeAppend > 0) {
            path.append(" -> ");
        }
    
        // Append the current node's data to the path
        path.append(node.data);
    
        // If the current node's data matches the target data, return true
        if (node.data.equals(data)) {
            return true;
        }
    
        // Search in the left subtree
        if (printSearchPathRecursive(node.left, data, path)) {
            return true;
        }
    
        // If not found in the left subtree, backtrack
        if (path.length() > lengthBeforeAppend) {
            int separatorIndex = path.lastIndexOf(" -> ");
            if (separatorIndex != -1) {
                path.delete(separatorIndex, path.length());
            }
        }
    
        // Search in the right subtree
        if (printSearchPathRecursive(node.right, data, path)) {
            return true;
        }
    
        // If not found in the right subtree, backtrack
        if (path.length() > lengthBeforeAppend) {
            int separatorIndex = path.lastIndexOf(" -> ");
            if (separatorIndex != -1) {
                path.delete(separatorIndex, path.length());
            }
        }
    
        return false;
    }
    
    public int getNumLeaves() 
    {
        return countLeaves(root);
    }

    private int countLeaves(BinaryNode<T> node) 
    {
        if (node == null) 
        {
            return 0; // Base case: empty tree or leaf node
        }
        if (node.left == null && node.right == null) 
        {
            return 1; // Leaf node found
        }
        return countLeaves(node.left) + countLeaves(node.right);
    }

    public BST<T> extractBiggestSuperficiallyBalancedSubTree() {
        BinaryNode<T> subtreeRoot = findBiggestSuperficiallyBalancedSubTree(root);
        BST<T> subtreeBST = new BST<>();
        subtreeBST.root = subtreeRoot;
        return subtreeBST;
    }

    private BinaryNode<T> findBiggestSuperficiallyBalancedSubTree(BinaryNode<T> node) {
        if (node == null) {
            return null;
        }

        int leftCount = countNodes(node.left);
        int rightCount = countNodes(node.right);

        if (leftCount == rightCount) {
            return node; // Current node is superficially balanced
        } else {
            // Recursively search for the biggest superficially balanced subtree
            BinaryNode<T> leftSubTree = findBiggestSuperficiallyBalancedSubTree(node.left);
            BinaryNode<T> rightSubTree = findBiggestSuperficiallyBalancedSubTree(node.right);

            // Return the larger of the two subtrees
            if (countNodes(leftSubTree) >= countNodes(rightSubTree)) {
                return leftSubTree;
            } else {
                return rightSubTree;
            }
        }
    }

    public BinaryNode<T> getNode(T data) 
    {
        return getNodeRecursive(root, data);
    }

    private BinaryNode<T> getNodeRecursive(BinaryNode<T> node, T data) 
    {
        if (node == null) 
        {
            return null; 
        }

        int cmp = data.compareTo(node.data);

        if (cmp < 0) 
        {
            return getNodeRecursive(node.left, data); // Search in the left subtree
        } 
        else if (cmp > 0) 
        {
            return getNodeRecursive(node.right, data); // Search in the right subtree
        } 
        else 
        {
            return node; // Node containing the data found
        }
    }

    
    public boolean isSuperficiallyBalanced() 
    {
        return isSuperficiallyBalanced(root);
    }

    private boolean isSuperficiallyBalanced(BinaryNode<T> node) 
    {
        if (node == null) 
        {
            // If the node is null, it is superficially balanced
            return true;
        }

        int leftNodes = countNodes(node.left);
        int rightNodes = countNodes(node.right);

        if (leftNodes == rightNodes) 
        {
            return isSuperficiallyBalanced(node.left) && isSuperficiallyBalanced(node.right);
        }

        return false;
    }

    private int countNodes(BinaryNode<T> node) 
    {
        if (node == null) 
        {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public BinaryNode<T> findMax() 
    {
        return findMaxRecursive(root);
    }

    private BinaryNode<T> findMaxRecursive(BinaryNode<T> node) {
        if (node == null) 
        {
            return null; 
        } 
        else if (node.right == null) 
        {
            return node; // Rightmost node found
        } 
        else 
        {
            return findMaxRecursive(node.right); // Recursively search in the right subtree
        }
    }

    public BinaryNode<T> findMin() 
    {
        return findMinRecursive(root);
    }

    private BinaryNode<T> findMinRecursive(BinaryNode<T> node) 
    {
        if (node == null) 
        {
            return null; // Tree is empty
        } 
        else if (node.left == null) 
        {
            return node; // Leftmost node found
        } 
        else 
        {
            return findMinRecursive(node.left); // Recursively search in the left subtree
        }
    }

    ///////////////

    private StringBuilder toString(BinaryNode<T> node, StringBuilder prefix, boolean isTail, StringBuilder sb) {
        if (node.right != null) {
            toString(node.right, new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
        }
        sb.append(prefix).append(isTail ? "└── " : "┌── ").append(node.data.toString()).append("\n");
        if (node.left != null) {
            toString(node.left, new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
        }
        return sb;
    }

    @Override
    public String toString() {
        return root == null ? "Empty tree" : toString(root, new StringBuilder(), true, new StringBuilder()).toString();
    }

}


    
    
    
    

   

    

    


    
    
    

    


    

    


