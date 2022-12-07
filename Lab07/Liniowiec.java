public class Liniowiec extends Statek implements Pasazerski, Silnikowy{
    private final String name;
    private final Pasazerski.Bilet bilet = new Bilet();
    public Liniowiec(String name){
        this.name = name;
    }
    @Override
    public String toString() {
        return "Liniowiec[" + name + "]";
    }
    public void ustawCeneBiletu(int x){
        bilet.cena = x;
    }
    public Bilet bilet(){
        return bilet;
    }
}
