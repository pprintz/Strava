package com.company;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //Opgave 1-3
        Node a = new Node<>("Times");
        Node b = new Node<>("Plus");
        Node c = new Node<>("Int");
        Node d = new Node<>("Var");
        Node e = new Node<>("Var");
        Node f = new Node<>("\"1\"");
        Node g = new Node<>("\"a\"");
        Node h = new Node<>("\"n\"");
        a.setLeftChild(b);
        a.setRightChild(c);
        b.setLeftChild(d);
        b.setRightChild(e);
        c.setLeftChild(f);
        d.setLeftChild(g);
        e.setLeftChild(h);
        System.out.println("\nPost order:");
        Node.postOrderDFS(a);
        System.out.println("\nPre order:");
        Node.preOrderDFS(a);
        System.out.println("\nInorder order:");
        Node.inOrderDFS(a);
        //Opgave 4
        System.out.println();
        SplitAndPrint("1 * 2    * n    + 3  ");
        //Opgave 5
        /*C#, F#, C, Python, Assembly, XAML, html, javascript, php, SQL, Scheme, Lisp, Haskell, c++,
        * smalltalk, Cobol, Java, objective C, Go, Fortran, Pascal, Swift, Matlab/octave*/
    }
    public static List<Character> SplitAndPrint(String input){
        List<Character> charsInInput = new LinkedList<>();
        for (char c: input.toCharArray()) {
            if(!Character.isWhitespace(c)) {
                System.out.println(c);
                charsInInput.add(c);
            }
        }
        return charsInInput;
    }
}
