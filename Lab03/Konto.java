public class Konto {
    private final String id;
    private Kwota resources;

    public Konto(String id, Kwota val){
        this.id = id;
        this.resources = new Kwota(val.getVal());
    }
    @Override
    public String toString() {
        return "[" +  id + "] " + resources;
    }
    public Kwota getResources() {
        return resources;
    }
    public String getId(){
        return id;
    }
    public Kwota getStan(){
        return new Kwota(getResources().getVal());
    }
    public void setStan(Kwota x){
        this.resources = x;
    }
}