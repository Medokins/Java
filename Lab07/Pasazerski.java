public interface Pasazerski {
    void ustawCeneBiletu(int x);
    Bilet bilet();
    class Bilet{
        public int cena;
        public int cena(){
            return cena;
        }
    }
}