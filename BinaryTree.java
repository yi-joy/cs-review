/* Tree: a data structure to represent a system of hierarchical structure by a set of nodes and edges
 [1] Terms
 1. Posistion of node
	ROOT ------ INTERNAL NODES ------ LEAVES (TERMINALS)
2. Relation of nodes
	Ancestors* - Parent - Child (Siblings*) - Decendants*; Ancestors include Parent & Decendants include Child
3. Attributes of node
	Level: distance from the root node (the level of ROOT is 0 or 1)
	Height:
	Degree: # of child nodes

[2] Trees
1. Binary Tree (General)
	-Only 0~2 child nodes (Degree of all nodes: 0, 1, 2)
	-(# of edges in a tree) = (# of nodes in the tree -1)

2. Full Binary Tree
	-# of nodes in a tree: n = 2^(height) -1
3.  Complete Binary Tree
	-At the highest level of a tree, nodes are filled from leftside.
4. Skewed Binary Tree
	-Minimum number of nodes
	-All nodes have only leftchild, or only rightchild.

[3] Implementation
1. Array -> Heap, good to search
2. Pointer -> Good to memory use
*/

import java.util.*;

class BinaryTree {
	private BinNode root;

	public static void main (String[] args) {
		BinaryTree tree = create(1);
		BinNode test = tree.getRoot().createChild(2);
		System.out.println("TEST: " + test.getData());
	}

	public static BinaryTree create(int rootValue) {
		BinaryTree tree = new BinaryTree();
		tree.root = new BinNode(rootValue);
		return tree;
	}
	public BinNode getRoot() { return root; }
}

class BinNode {
	private BinNode parent;
	private BinNode leftchild, rightchild;
	private int data;

	public int getData() { return data; }
	public void setData(int data) { this.data = data; }
	public BinNode getParent() { return parent; }
	public BinNode getLeftchild() { return leftchild; }
	public BinNode getRightchild() { return rightchild; }
	public void setParent (BinNode parent) { this.parent = parent; }
	public void insertLeftchild(int data) { this.leftchild = createChild(data); }
	public void insertRightchild(int data) { this.rightchild = createChild(data); }
	public void deleteLeftchild() { this.leftchild = null; }
	public void deleteRightchild() { this.rightchild = null; }
	public BinNode createChild (int data) {
		BinNode node = new BinNode(data);
		node.setParent(this);
		return node;
	}

	// delete node
	// traversal: preorder, inorder, postorder, level

	public BinNode(int data) { setData(data); }
	public BinNode() { }
}