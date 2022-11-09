public class Account{
    private final String id;
    private Amount resources;

    public Account(String id, Amount val){
        this.id = id;
        this.resources = new Amount(val.getVal());
    }
    @Override
    public String toString() {
        return "[" +  id + "] " + resources;
    }
    public Amount getResources() {
        return resources;
    }
    public String getId(){
        return id;
    }
    public Amount getBalance(){
        return new Amount(getResources().getVal());
    }
    public void setBalance(Amount x){
        this.resources = x;
    }
}
