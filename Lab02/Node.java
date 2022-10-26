public class Node {
    private final Book data;
    private Node left;
    private Node right;
    private int counter;

    public Node(Book data, int counter){
        this.data = data;
        this.left = null;
        this.right = null;
        this.counter = counter;
    }
    public Book getData() {
        return data;
    }
    public Node getLeft() {
        return left;
    }
    public Node getRight() {
        return right;
    }

    public static Node addRec(Node current, Book data){
        if(current == null){ return new Node(data, 0); }
        current.counter = current.counter + 1;
        if(data.getId() < current.data.getId()){
            current.left = addRec(current.left, data);
        } else if (data.getId() > current.data.getId()){
            current.right = addRec(current.right, data);
        } else{
            return current;
        }
        return current;
    }
}
