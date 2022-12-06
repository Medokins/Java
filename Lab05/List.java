class List<Object> {
    protected Node head;
    protected Node tail;
    protected int size = 0;

    // node Element of class List
    class Node {
        Object data;
        Node next;
        Node(Object o) {
            data = o;
            next = null;
        }
    }
    // method to print content of List
    @Override
    public String toString() {
        Node current = head;
        StringBuilder list_string = new StringBuilder("List: ");
        if(head == null){
            list_string.append("None");
        }
        while (current != null) {
            list_string.append(current.data);
            if (current.next != null){
                list_string.append(", ");
            }
            current = current.next;
        }
        return list_string.toString();
    }

    // method to add element to List
    public void insert(Object object_data) {
        Node newNode = new Node(object_data);
        if(head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public int getSize() {
        return size;
    }
    public Object getHead(){return head.data;}
    public Object getTail(){
        return tail.data;
    }
    public Object getNthElement(int index){
        if(index > size){
            System.out.println("List index out of range!");
            return null;
        }
        Node el = head;
        for(int i = 0; i < index - 1; i++){
            el  = el.next;
        }
        return el.data;
    }
    public void deleteNthElement(int index){
        if(index > size){
            System.out.println("List index out of range!");
        }
        else{
            size--;
            Node el = head;
            for(int i = 0; i < index - 2; i++){
                el = el.next;
            }
            el.next.data = null;
            el.next = el.next.next;
        }
    }
    public void clearList(){
        head = null;
    }
}