public class Main {
    public static void main(String[] args) {
        List<Object> list = new List();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert("name");
        System.out.println(list);
        System.out.println("List size: " + list.getSize());

        list.insert(6);
        System.out.println("List size after insert: " + list.getSize());

        list.deleteNthElement(5);
        System.out.println("List size after delete: " + list.getSize());
        System.out.println(list);

        System.out.println("First element: " + list.getHead());
        System.out.println("Last element: " + list.getTail());
        System.out.println("3rd element: " + list.getNthElement(3));
        list.clearList();
        System.out.print("After clearing: ");
        System.out.println(list);

        var x = new LiczbaWymierna(1, 2);
        System.out.println(x.toDouble());

        var exclusive_list = new ListaLiczb<Liczba>();
        exclusive_list.insert(new LiczbaOdZeraDoJeden(0.2));
        exclusive_list.insert(new LiczbaOdZeraDoJeden(0.7));
        exclusive_list.insert(new LiczbaWymierna(2, 10));

        //exclusive_list.insert(new LiczbaOdZeraDoJeden(1.5));
        //exclusive_list.insert(5);

        System.out.println("Min value: " + exclusive_list.getMin());
        System.out.println("Max value: " + exclusive_list.getMax());

        var exclusive_list_tab = exclusive_list.getTab();
        for(int i = 0; i < exclusive_list_tab.length; i++){
            System.out.println(exclusive_list_tab[i]);
        }
        System.out.println("Average of exclusive_list " + exclusive_list.getAverage());
        exclusive_list.sort();
        System.out.println(exclusive_list);
    }
}
