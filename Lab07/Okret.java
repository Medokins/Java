public class Okret extends UczestnikBitwy implements Silnikowy {
    private String name;
    public Okret(String name){
        this.name = name;
    }
    @Override
    public String toString() {
        return "Okret[" + name + "]";
    }
    @Override
    public void setName(String name){
        this.name = name;
    }
    @Override
    public String getName(){
        return this.name;
    }
}
