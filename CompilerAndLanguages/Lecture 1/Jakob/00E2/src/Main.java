import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Tree tree = new Tree(
//            new Times(
//                new Plus(
//                    new Var(
//                        new Value("a")
//                    ),
//                        new Var(
//                            new Value("n")
//                        )
//                ),
//                new Int(
//                    new Value("1")
//                )
//            )
//        );
//
//        System.out.println("Pre-order DFS:");
//        tree.print_preorder_dfs();
//        System.out.println();
//        System.out.println("In-order DFS:");
//        tree.print_inorder_dfs();
//        System.out.println();
//        System.out.println("Post-order DFS:");
//        tree.print_postorder_dfs();

        Tree tree = new Tree(null);
        System.out.println("Please enter a string:");
        String input = new Scanner(System.in).nextLine();
        char[] split = input.toLowerCase().toCharArray();
        for (char c : split) {
            if (isLetter(c)) {

            } else if (isOperator(c)){
                if (c == '*') {
                    
                }
                System.out.println("Operator");
            } else if (isNumber(c)){
                System.out.println("Number");
            }
        }
    }

    public static boolean isLetter(char c) {
        char lowercase = Character.toLowerCase(c);
        return lowercase >= 97 && lowercase <= 122;
    }

    public static boolean isOperator(char c) {
        return c >= 42 && c <= 43;
    }

    public static boolean isNumber(char c) {
        return c >= 48 && c <= 57;
    }
}
