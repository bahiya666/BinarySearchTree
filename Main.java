
public class Main 
{
    public static void main(String[] args) 
    {
        BST<Integer> tree = new BST<>();

        // Insert
        tree.root = new BinaryNode<>(50);
        tree.root.left = new BinaryNode<>(30);
        tree.root.left.left = new BinaryNode<>(20);
        tree.root.left.right = new BinaryNode<>(40);
        tree.root.right = new BinaryNode<>(70);
        tree.root.right.left = new BinaryNode<>(60);
        tree.root.right.right = new BinaryNode<>(80);

        System.out.println("Binary Search Tree:");
        System.out.println(tree);

        BinaryNode<Integer> maxNode = tree.findMax();
        BinaryNode<Integer> minNode = tree.findMin();
        int numLeaves = tree.getNumLeaves();
        int height = tree.getHeight();

        System.out.println("Maximum value in the tree: " + (maxNode != null ? maxNode.data : "Tree is empty"));
        System.out.println("Minimum value in the tree: " + (minNode != null ? minNode.data : "Tree is empty"));
        System.out.println("Number of leaf nodes: " + numLeaves);
        System.out.println("Height of the tree: " + height);
        System.out.println("Is the tree superficially balanced? " + tree.isSuperficiallyBalanced());
        System.out.println();

        System.out.println("Search path for data 60: " + tree.printSearchPath(60));
        System.out.println("Search path for data 30: " + tree.printSearchPath(30));
        System.out.println("Search path for data 80: " + tree.printSearchPath(80));
        System.out.println("Search path for data 2: " + tree.printSearchPath(2));

        // Test extractBiggestSuperficiallyBalancedSubTree method
        BST<Integer> largestSubtree = tree.extractBiggestSuperficiallyBalancedSubTree();
        System.out.println("Extracted Biggest Superficially Balanced Subtree:");
        System.out.println(largestSubtree);
        
        //delete
        tree.delete(20); // Delete a leaf node
        tree.delete(70); // Delete a node with one child
        tree.delete(50); // Delete the root node with two children
        tree.delete(30);
        tree.delete(40);
        tree.delete(60);
        tree.delete(80);

        System.out.println("Search path for data 60: " + tree.printSearchPath(60));


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();


        BST<Integer> tree2 = new BST<>();

        // Insert 
        tree2.root = new BinaryNode<>(20);
        tree2.root.left = new BinaryNode<>(10);
        tree2.root.right = new BinaryNode<>(45);
        tree2.root.left.left = new BinaryNode<>(5);
        tree2.root.left.right = new BinaryNode<>(15);
        tree2.root.right.left = new BinaryNode<>(35);
        tree2.root.right.right = new BinaryNode<>(70);

        // toString method
        System.out.println("Binary Search Tree:");
        System.out.println(tree2);

        //contains method
        int testData1 = 25;
        int testData2 = 70;
        int testData3 = 10;
        int testData4 = 35;
        int testData5 = 20;

        System.out.println("Tree contains " + testData1 + ": " + tree2.contains(testData1));
        System.out.println("Tree contains " + testData2 + ": " + tree2.contains(testData2));
        System.out.println("Tree contains " + testData3 + ": " + tree2.contains(testData3));
        System.out.println("Tree contains " + testData4 + ": " + tree2.contains(testData4));
        System.out.println("Tree contains " + testData5 + ": " + tree2.contains(testData5));

        //max/min 
        BinaryNode<Integer> maxNode2 = tree2.findMax();
        BinaryNode<Integer> minNode2 = tree2.findMin();

        System.out.println("Maximum value in the tree: " + (maxNode2 != null ? maxNode2.data : "Tree is empty"));
        System.out.println("Minimum value in the tree: " + (minNode2 != null ? minNode2.data : "Tree is empty"));

        int nodeData1 = 35;
        int nodeData2 = 10;
        int nodeData3 = 20;
        int nodeData4 = 70;
        int nodeData5 = 2;

        BinaryNode<Integer> node1 = tree2.getNode(nodeData1);
        BinaryNode<Integer> node2 = tree2.getNode(nodeData2);
        BinaryNode<Integer> node3 = tree2.getNode(nodeData3);
        BinaryNode<Integer> node4 = tree2.getNode(nodeData4);
        BinaryNode<Integer> node5 = tree2.getNode(nodeData5);

        System.out.println("Node with data " + nodeData1 + ": " + (node1 != null ? node1.data : "Not found"));
        System.out.println("Node with data " + nodeData2 + ": " + (node2 != null ? node2.data : "Not found"));
        System.out.println("Node with data " + nodeData3 + ": " + (node3 != null ? node3.data : "Not found"));
        System.out.println("Node with data " + nodeData4 + ": " + (node4 != null ? node4.data : "Not found"));
        System.out.println("Node with data " + nodeData5 + ": " + (node5 != null ? node5.data : "Not found"));
        
        int numLeaves3 = tree2.getNumLeaves();
        System.out.println("Number of leaf nodes: " + numLeaves3);

        int height3 = tree2.getHeight();
        System.out.println("Height of the tree: " + height3);
        System.out.println("Is the tree superficially balanced? " + tree2.isSuperficiallyBalanced());

        System.out.println();
        BST<Integer> largestSubtreetree2 = tree2.extractBiggestSuperficiallyBalancedSubTree();
        System.out.println("Extracted Biggest Superficially Balanced Subtree from Tree2:");
        System.out.println(largestSubtreetree2);

        System.out.println("Search path for data 35: " + tree2.printSearchPath(35));
        System.out.println("Search path for data 10: " + tree2.printSearchPath(10));
        System.out.println("Search path for data 45: " + tree2.printSearchPath(45));

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        BST<Integer> unbalancedTree = new BST<>();
        unbalancedTree.root = new BinaryNode<>(50);
        unbalancedTree.root.left = new BinaryNode<>(30);
        unbalancedTree.root.left.left = new BinaryNode<>(20);
        unbalancedTree.root.left.left.left = new BinaryNode<>(10);
        unbalancedTree.root.left.left.left.left = new BinaryNode<>(5);

        // Display unbalanced tree
        System.out.println("Unbalanced Binary Search Tree:");
        System.out.println(unbalancedTree);

        // Testing methods on the unbalanced tree
        System.out.println("Height of the unbalanced tree: " + unbalancedTree.getHeight());
        System.out.println("Number of leaf nodes in the unbalanced tree: " + unbalancedTree.getNumLeaves());
        System.out.println("Is the unbalanced tree superficially balanced? " + unbalancedTree.isSuperficiallyBalanced());
        System.out.println();
        BST<Integer> largestSubtreeUnbalanced = unbalancedTree.extractBiggestSuperficiallyBalancedSubTree();
        System.out.println("Extracted Biggest Superficially Balanced Subtree from Unbalanced Tree:");
        System.out.println(largestSubtreeUnbalanced);

    }





    
}
