public class UczestnikBitwy extends Statek{
    private int amunicja = 100;
    private String name = "";
    public void strzelaj(){
        amunicja = amunicja - 1;
    }
    public int amunicja(){
        return amunicja;
    }
    public static void zatapia(UczestnikBitwy x){
        x.setName(x.getName() + " - wrak");
        x.amunicja = 0;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}
