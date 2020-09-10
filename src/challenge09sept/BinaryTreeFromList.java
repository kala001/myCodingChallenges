package challenge09sept;

import java.util.ArrayList;
import java.util.List;


public class BinaryTreeFromList {
	
	
class BinaryTreeNode {
		
		int data;
		BinaryTreeNode leftNode;
		BinaryTreeNode rightNode;
		
		BinaryTreeNode(int data) {
			this.data = data;
			this.leftNode = null;
			this.rightNode = null;
		}
	}




private BinaryTreeNode constructTreeFromArray(List<Integer> list, int size) {
	
	BinaryTreeNode rootNode = new BinaryTreeNode(list.get(0));
	
	for (int i=1; i<size; i++) {
		
		int element = list.get(i);
		findRootNode(rootNode, element);
	}
	
	return rootNode;
}


private void findRootNode (BinaryTreeNode rootNode, int element) {
	if(element < rootNode.data) {
		if (rootNode.leftNode != null) {
		findRootNode(rootNode.leftNode, element);
	} else {
		BinaryTreeNode leftNode = new BinaryTreeNode(element);
		rootNode.leftNode = leftNode;
	}
	}
	else {
		if(rootNode.rightNode != null) {
		findRootNode(rootNode.rightNode, element);
	} else {
		BinaryTreeNode rightNode = new BinaryTreeNode(element);
		rootNode.rightNode = rightNode;
	}
	}
}

private static void inorderTraversal(BinaryTreeNode node)  
{ 
    if (node != null)  
    { 
        inorderTraversal(node.leftNode); 
        System.out.print(node.data + " "); 
        inorderTraversal(node.rightNode); 
    } 
} 

private int findNodeTraversalInBinaryTree (BinaryTreeNode node, int data1, int data2, List<Integer> list) {
	if (list.contains(data1) && list.contains(data2)) {
		return findNodeTraversalInBinaryTree(node, data1, data2);
		} else {
			return -1;
		}
	}

private int findNodeTraversalInBinaryTree (BinaryTreeNode node, int data1, int data2) {
	int distance = -1;
	if (data1 == node.data) {
		return findDistanceToroot(node, data2);
		
		} else if (data2 == node.data) {
			return findDistanceToroot(node, data1);
		}
	BinaryTreeNode rootnode = node;
	if (data1 < rootnode.data &&  data2 < rootnode.data) {
		return findNodeTraversalInBinaryTree(rootnode.leftNode, data1, data2);
	} else if (data1 > rootnode.data &&  data2 > rootnode.data) {
		return findNodeTraversalInBinaryTree(rootnode.rightNode, data1, data2);
	} else {
		BinaryTreeNode currentRootNode = rootnode;
		int data1distance = findDistanceToroot(rootnode, data1);
		if (data1distance != -1) {
			int data2distance = findDistanceToroot(currentRootNode, data2);
			if (data2distance != -1) {
				distance = data1distance + data2distance;
			}
		}
			 
		return distance;
	}
	
}

private int findDistanceToroot (BinaryTreeNode node, int data) {
	if (data == node.data) {
		return 0;
	} else if (data < node.data ) {
		if (node.leftNode == null) {
		return -1;
		} else {
			return 1+ findDistanceToroot(node.leftNode, data);
		}
	} else {
		if (node.rightNode == null) {
			return -1;
			} else {
				return 1+ findDistanceToroot(node.rightNode, data);
			}
	}
}



public static void main(String args[]) {
	List<Integer> list = new ArrayList();
	list.add(5);
	list.add(6);
	list.add(3);
	list.add(1);
	list.add(2);
	list.add(4);

	BinaryTreeNode node =new BinaryTreeFromList().constructTreeFromArray(list, list.size());
	inorderTraversal(node);
	System.out.println();
	
	System.out.println(new BinaryTreeFromList().findNodeTraversalInBinaryTree(node, 2, 4, list));

	System.out.println(new BinaryTreeFromList().findNodeTraversalInBinaryTree(node, 3, 9, list));
	
	System.out.println(new BinaryTreeFromList().findNodeTraversalInBinaryTree(node, 5, 4, list));

}

}