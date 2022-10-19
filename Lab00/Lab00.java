public class Lab00 {
    public static void main(String[] args) {
        Rtab x = new Rtab(10, 5);
        x.fillTab();
        x.prinTab();
        System.out.println("Avg = " + x.getAvg());
        System.out.println("Avg = " + Math.round(x.getAvg() * 10.0) / 10.0);
        System.out.println("Max = " + x.getMax());
        System.out.println("Min = " + x.getMin());
    }
}

class Rtab {
    // Data:
    private double[] tab;
    private int seriesLength;

    // Constructors:
    public Rtab(int tabLength, int seriesLength){
        this.tab = new double[tabLength];
        this.seriesLength = seriesLength;
    }

    // Other
    public void fillTab(){
        for(int i=0; i < this.tab.length; i++){
            double summ = 0;
            for(int j=0; j < this.seriesLength; j++){
                summ += Math.random();
            }
            summ = summ / seriesLength;
            this.tab[i] = summ;
        }
    }
    public double getAvg(){
        double summ = 0;
        for(int i=0; i < this.tab.length; i++) {
            summ += this.tab[i];
        }
        return summ / this.tab.length;
    }
    public double getMax(){
        double max = this.tab[0];
        for(int i=0; i < this.tab.length; i++) {
            if(this.tab[i] > max){
                max = this.tab[i];
            }
        }
        return max;
    }
    public double getMin(){
        double min = this.tab[0];
        for(int i=0; i < this.tab.length; i++) {
            if(this.tab[i] < min){
                min = this.tab[i];
            }
        }
        return min;
    }
    public void prinTab(){
        for(int i=0; i < this.tab.length; i++) {
            System.out.print(this.tab[i] + "   ");
        }
        System.out.println();
    }
}