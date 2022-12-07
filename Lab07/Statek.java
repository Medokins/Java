public class Statek {
    private String name;
    public Statek(){}
    public Statek(String name){
        this.name = name;
    }
    @Override
    public String toString() {
        return "Statek[" + name + "]";
    }
}
