public class Complex {
    private double re;
    private double im;

    public Complex(double a,double b){
        re = a;
        im = b;
    }

    public Complex(){
        this(0,0);
    }

    public Complex(double a){
        this(a,0);
    }

    public void set(double a,double b){
        re = a;
        im = b;
    }

    public void setRe(double a){
        re = a;
    }

    public void setIm(double a){
        im = a;
    }

    public double getRe(){
        return(re);
    }

    public double getIm(){
        return(im);
    }

    public static Complex add(Complex c1,Complex c2){
        return new Complex(c1.getRe() + c2.getRe(),c1.getIm()+c2.getIm());
    }

    public static Complex add(Complex c1,double a){
        return new Complex(c1.getRe() + a,c1.getIm());
    }

    public static Complex add(double a,Complex c1){
        return Complex.add(c1,a);
    }

    public static Complex subtract(Complex c1,Complex c2){
        return new Complex(c1.getRe() - c2.getRe(),c1.getIm() - c2.getIm());
    }

    public static Complex subtract(Complex c1,double a){
        return new Complex(c1.getRe() - a,c1.getIm());
    }

    public static Complex subtract(double a,Complex c1){
        return new Complex(a-c1.getRe(),-c1.getIm());
    }

    public static Complex multiply(Complex c1,Complex c2){
        double c1Re = c1.getRe();
        double c1Im = c1.getIm();

        double c2Re = c2.getRe();
        double c2Im = c2.getIm();

        return new Complex(c1Re*c2Re - c1Im*c2Im,c1Im*c2Re + c1Re*c2Im);
    }

    public static Complex multiply(Complex c1,double a){
        return new Complex(c1.getRe() * a,c1.getIm() * a);
    }

    public static Complex multiply(double a,Complex c1){
        return Complex.multiply(c1,a);
    }

    public static Complex divide(Complex c1,Complex c2){
        double c1Re = c1.getRe();
        double c1Im = c1.getIm();

        double c2Re = c2.getRe();
        double c2Im = c2.getIm();

        if(Math.abs(c2Re) < 1e-8 && Math.abs(c2Im) < 1e-8) {
            System.out.println("Dzielenie przez zero!");
            return null;
        }

        double rePart = (c1Re*c2Re + c1Im*c2Im)/(c2Re*c2Re + c2Im*c2Im);
        double imPart = (-c1Re*c2Im + c1Im*c2Re)/(c2Re*c2Re + c2Im*c2Im);

        return new Complex(rePart,imPart);
    }

    public static Complex divide(Complex c1,double a){
        return Complex.divide(c1,new Complex(a,0));
    }

    public static Complex divide(double a,Complex c1){
        return Complex.divide(new Complex(a,0),c1);
    }

    @Override
    public String toString(){
        return(String.format("%.2f + %.2fi",re,im));
    }
}
