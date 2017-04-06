package DepthFirst;

public class Main {

    public static void main(String[] args) {
        /*
                            times
                        plus        int
                    Var     Var     "1"
                    "a"     "n"
         */

        // Assignment 2+3
        BinaryNode head =
                new BinaryNode("Times",
                        new BinaryNode("Plus",
                                new BinaryNode("Var",
                                        new BinaryNode("a", null, null),
                                        null),
                                new BinaryNode("Var",
                                        new BinaryNode("n", null, null),
                                        null)
                        ),
                        new BinaryNode("Int",
                                new BinaryNode("1", null, null),
                                null
                        )
                );

        System.out.print("Pre:\t");
        PrintPreOrder(head);
        System.out.println();

        System.out.print("In:\t\t");
        PrintInOrder(head);
        System.out.println();

        System.out.print("Post:\t");
        PrintPostOrder(head);
        System.out.println();


        // Assignment 4
        String operators = "a + n = 1";
        Object[] objects = operators.split(" ");

        System.out.println("String objects:");
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }

    }

    public static void PrintPreOrder(BinaryNode node){
        if(node == null) return;

        System.out.print(node.value + " ");
        PrintPreOrder(node.leftChild);
        PrintPreOrder(node.rightChild);
    }

    public static void PrintPostOrder(BinaryNode node){
        if(node == null) return;

        PrintPreOrder(node.leftChild);
        PrintPreOrder(node.rightChild);
        System.out.print(node.value + " ");
    }

    public static void PrintInOrder(BinaryNode node){
        if(node == null) return;

        PrintPreOrder(node.leftChild);
        System.out.print(node.value + " ");
        PrintPreOrder(node.rightChild);
    }


}
