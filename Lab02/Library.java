public class Library {
    private Node root;

    public Library(){root = null;}
    public void add(Book k){
        root = Node.addRec(root, k);
    }

    public Node searchRec(Node current, int id) {
        if (current == null) { return null; }
        if (id == current.getData().getId()) { return current; }
        return id < current.getData().getId()
                ? searchRec(current.getLeft(), id)
                : searchRec(current.getRight(), id);
    }

    public Book searchID(int id){
        long start = System.currentTimeMillis();
        long finish = System.currentTimeMillis();

        Node nodeData = searchRec(this.root, id);

        long timeElapsed = finish - start;
        System.out.println("Time passed since start: " + timeElapsed + "ms");
        return nodeData == null ? null : nodeData.getData();
    }

    public void printTree(){
        printRec(root, 0);
    }
    public void printRec(Node root, int index) {
        if (root == null) {return;}
        for (int i = 0; i < index; i++){
            System.out.print("-");
        }
        System.out.println(root.getData().getName());
        printRec(root.getRight(), index + 2);
        printRec(root.getLeft(), index + 2);
    }
}
