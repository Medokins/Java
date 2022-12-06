class LiczbaOdZeraDoJeden extends Liczba{
    private double a = 0;
    LiczbaOdZeraDoJeden(double a){
        try {
            if(a < 0 || a > 1){
                throw new Exception("Number " + a + " is not in range <0, 1>!");
            }
        }catch (Exception e){
            e.printStackTrace();
            return;
        }
        this.a = a;
    }
    @Override
    public String toString(){
        return a + " ";
    }
    @Override
    public Double toDouble(){
        return a;
    }
}
