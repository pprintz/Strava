
public class program {
	
	Node root;
	
	public void addNode(int key , String name) {
		
		Node newNode = new Node(key, name);
		
		if(root == null){
			root = newNode;
		}
		else{
			Node focusNode = root;
			
			Node parent;
			
			while(true){
				parent = focusNode;
				if(key < focusNode.key){
					focusNode = focusNode.leftChild;
					
					if (focusNode == null){
						parent.leftChild = newNode;
						return;
						
					}
				}
				else{
					focusNode = focusNode.rightChild;
					
					if(focusNode == null){
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}
	
	public void inOrderTraverse(Node focusNode){
		if(focusNode != null){
			inOrderTraverse(focusNode.leftChild);
			System.out.print(focusNode);
			inOrderTraverse(focusNode.rightChild);
		}
	}
	
	public static void main(String[] args) {
			
		program binaryTree = new program();
		
		binaryTree.addNode(1, "Times");
		binaryTree.addNode(2, "Plus");
		binaryTree.addNode(3, "int");
		binaryTree.addNode(4, "Var");
		binaryTree.addNode(5, "1");
		binaryTree.addNode(6, "a");
		
		binaryTree.inOrderTraverse(binaryTree.root);
		
	}

}

class Node {
	
	int key;
	String name;
	
	Node leftChild;
	Node rightChild;
	
	Node(int key , String name){
		this.key = key;
		this.name = name;
	}
	
	public String toString(){
		return name + " " + key;
	}
	
}

