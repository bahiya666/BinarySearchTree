Overview
The Binary Search Tree (BST) project is an implementation of a binary search tree in Java. The project includes a variety of operations such as insertion, deletion, searching for a node, finding the maximum and minimum elements, checking for balance, and more. The tree supports recursion for many of these operations.

This project also includes the ability to extract the biggest "superficially balanced" subtree and provides a detailed string representation of the tree using a toString() method.

Classes
BinaryNode<T>
Represents a node in the binary tree.

Fields:

data: The value stored in the node.
left, right: Child nodes (left and right).
Constructor:

BinaryNode(T data): Creates a node with the specified data.
toString(): Returns a string representation of the node, showing its left and right children.

BST<T>
Represents the Binary Search Tree.

Fields:
root: The root of the tree.
Methods:
insert(T data): Inserts a value into the tree.
delete(T data): Deletes a node with the specified value.
contains(T data): Checks if a value exists in the tree.
findMin(), findMax(): Returns the minimum or maximum value node.
getHeight(): Returns the height of the tree.
getNumLeaves(): Counts the number of leaf nodes
printSearchPath(T data): Prints the path from the root to a node containing the specified data.
isSuperficiallyBalanced(): Checks if the tree is superficially balanced (left and right subtrees have equal nodes).
toString(): Returns a string representation of the entire tree structure.

Main
Demonstrates the usage of the BST class with examples:

Insert nodes and print the tree.
Find max/min values and check if the tree is balanced.
Perform search operations and print search paths.
Delete nodes and show tree after deletion.

Compilation 
javac *.java
java Main
