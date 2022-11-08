import java.util.ArrayList;

public class Bank {
    private final ArrayList<Konto> members = new ArrayList<>();

    public void utworzKonto(String id){
        members.add(new Konto(id, new Kwota(0)));
    }
    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder();
        for(Konto konto: members) temp.append(konto).append(" ; ");
        return temp.toString();
    }
    public void wplataNaKonto(String id, Kwota x){
        for(Konto konto: members){
            if(id.equals(konto.getId())){
                konto.setStan(x);
            }
        }
    }
    public void wyplataZKonta(String id, Kwota x){
        Kwota copy = new Kwota(x.getVal());
        for(Konto konto: members){
            if(id.equals(konto.getId())){
                konto.setStan(Kwota.odejmij(konto.getStan(), copy));
            }
        }
    }
    public Kwota stanKonta(String id){
        for(Konto konto: members){
            if(id.equals(konto.getId())){
                return new Kwota(konto.getStan().getVal());
            }
        }
        return null;
    }
}
