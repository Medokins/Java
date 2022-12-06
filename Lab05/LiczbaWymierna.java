class LiczbaWymierna extends Liczba{
    private final int l;
    private final int m;
    LiczbaWymierna(int a, int b){
        l = a;
        m = b;
    }
    @Override
    public String toString(){
        return l + "/" + m;
    }
    @Override
    public Double toDouble(){
        return (double) l / m;
    }
}