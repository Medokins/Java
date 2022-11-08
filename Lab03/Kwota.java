public class Kwota {
    private int val;

    public Kwota(int pln, int gr){
        this.val = pln * 100 + gr;
    }
    public Kwota(int gr){
        this.val = gr;
    }
    public int getVal() {
        return val;
    }
    @Override
    public String toString() {
        int zl = val / 100;
        int gr = val - zl * 100;
        return zl + "zl " + gr + "gr ";
    }
    public static Kwota dodaj(Kwota x, Kwota y){
        int zl = x.getVal() / 100 + y.getVal() / 100;
        int gr = (x.getVal() + y.getVal()) - zl * 100;
        return new Kwota(zl, gr);
    }
    public static Kwota odejmij(Kwota x, Kwota y){
        int zl = x.getVal() / 100 - y.getVal() / 100;
        int gr = (x.getVal() - y.getVal()) - zl * 100;
        return new Kwota(zl, gr);
    }
    public void set(int pln, int gr){
        this.val = pln * 100 + gr;
    }

}
