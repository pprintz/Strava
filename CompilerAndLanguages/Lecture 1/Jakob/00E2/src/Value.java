public class Value extends Node {
    private String value;

    public Value(String value) {
        this.value = value;
    }

    @Override
    public void print_preorder_dfs() {
        System.out.println(this.toString());
    }

    @Override
    public void print_inorder_dfs() {
        System.out.println(this.toString());
    }

    @Override
    public void print_postorder_dfs() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return value;
    }
}
