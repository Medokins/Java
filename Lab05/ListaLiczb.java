import java.util.Arrays;

class ListaLiczb<Object> extends List<Object>{
    @Override
    public void insert(Object data) {
        try {
            if(!(data instanceof Liczba)){
                throw new Exception("Object not a child of Liczba");
            }
        }catch (Exception e){
            e.printStackTrace();
            return;
        }
        Node newNode = new Node(data);
        if (head == null) {
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

    public double getMin(){
        double min = ((Liczba)getNthElement(0)).toDouble();
        for(int i = 0; i < size; i++){
            if(((Liczba)getNthElement(i)).toDouble() < min){
                min = ((Liczba)getNthElement(i)).toDouble();
            }
        }
        return min;
    }
    public double getMax(){
        double max = ((Liczba)getNthElement(0)).toDouble();
        for(int i = 0; i < size; i++){
            if(((Liczba)getNthElement(i)).toDouble() > max){
                max = ((Liczba)getNthElement(i)).toDouble();
            }
        }
        return max;
    }

    public double[] getTab(){
        var tab = new double[size];
        for(int i = 0; i < size; i++) {
            tab[i] = ((Liczba) getNthElement(i)).toDouble();
        }
        return tab;
    }
    public double getAverage(){
        double summ = 0;
        for(int i = 0; i < size; i++){
            summ += ((Liczba)getNthElement(i)).toDouble();
        }
        return summ / size;
    }
    /*
    public void sort(){
        double[] tab = this.getTab();
        Arrays.stream(tab).sorted();
        Node curr = head;
        int i = 0;
        this.clearList();
        while (curr.next != null) {
            this.insert(1.0);
            i += 1;
        }
    }
   */
}