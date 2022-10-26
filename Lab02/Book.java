public class Book {
    private String name;
    private int id;
    private static int bookCount = 0;

    public Book(String name, int id){
        this.name = name;
        this.id = id;
        bookCount = bookCount + 1;
    }
    public String getName() {
        return name;
    }
    public int getId(){
        return id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setId(int id){
        this.id = id;
    }
    public static int getBookCount(){
        return bookCount;
    }
    public void printBook(){
        System.out.println(id + " " + name);
    }
}
