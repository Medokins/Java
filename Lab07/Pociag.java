public class Pociag implements Pasazerski, Silnikowy{
    private final Pasazerski.Bilet bilet = new Bilet();
    public void ustawCeneBiletu(int x){
        bilet.cena = x;
    }
    public Bilet bilet(){
        return bilet;
    }
}
