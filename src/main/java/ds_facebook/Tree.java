package ds_facebook;

class Tree {
    private final int value;

    public Tree leftNode;

    public Tree rightNode;

    public int getValue() {
         return value;
    }

    Tree(int value) {
        this.value = value;
    }
}
