package com.company;

/**
 * Created by peter on 2017-01-29.
 */
public class Node<T> {
   public Node(Node leftChild, Node rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
    private Node leftChild;

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node(T value) {
        this.value = value;
    }

    private Node rightChild;

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
    public static void inOrderDFS(Node node){
        if(node == null)
            return;
       inOrderDFS(node.getLeftChild());
        System.out.println(node.value);
       inOrderDFS(node.getRightChild());
    }
    public static void preOrderDFS(Node node){
        if(node == null)
            return;
        preOrderDFS(node.getLeftChild());
        preOrderDFS(node.getRightChild());
        System.out.println(node.value);
    }
    public static void postOrderDFS(Node node){
        if(node == null)
            return;
        System.out.println(node.value);
        postOrderDFS(node.getLeftChild());
        postOrderDFS(node.getRightChild());
    }
}
