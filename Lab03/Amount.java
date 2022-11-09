public class Amount{
    private int val;
    public Amount(int pln, int gr){
        this.val = pln * 100 + gr;
    }
    public Amount(int gr){
        this.val = gr;
    }
    public int getVal() {
        return val;
    }
    public int getPln(){
        return val / 100;
    }
    public int getGr(){
        return val - getPln() * 100;
    }
    @Override
    public String toString() {
        return getPln() + "zl " + getGr() + "gr ";
    }
    public static Amount add(Amount x, Amount y){
        int pln = x.getPln() + y.getPln();
        int gr = (x.getVal() + y.getVal()) - pln * 100;
        return new Amount(pln, gr);
    }
    public static Amount subtract(Amount x, Amount y){
        int pln = x.getPln()- y.getPln();
        int gr = (x.getVal() - y.getVal()) - pln * 100;
        return new Amount(pln, gr);
    }
    public void set(int pln, int gr){
        this.val = pln * 100 + gr;
    }
}
