package com.company;
public class Main {
    public static void main (String[] args) {
        Node root = CreateTree();
        PrintPreorder(root);
    }

    private static Node CreateTree(){
        Node root =
                new Node("Times",
                    new Node("Plus",
                        new Node("Var",
                                new Node("a", null, null),
                                null),
                        new Node("Var",
                            new Node("n", null, null),
                                null)),
                    new Node("int",
                        new Node("1", null, null),
                         null));
        return root;
    }

    private static void PrintPreorder(Node x){
        if(x != null){
            System.out.println(x.toString());
            PrintPreorder(x.left);
            PrintPreorder(x.right);
        }
    }
}
