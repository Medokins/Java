public enum Funkcja implements Fun{
    SIN{
        public double wartosc(double x){
            return Math.sin(x);
        }
    },
    ARCSIN{
        public double wartosc(double x){
            if (x < -1.0 || x > 1.0){
                throw new BladFunkcji();
            }
            return Math.asin(x);
        }
    },
    LN{
        public double wartosc(double x){
            if (x <= 0){
                throw new BladFunkcji();
            }
            return Math.log(x);
        }
    };
    public double wartosc(double x) {return 0.0;}
}
