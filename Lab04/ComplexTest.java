import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ComplexTest {
    @Test
    public void set_test1(){
        Complex c = new Complex();
        c.set(1,2);
        Assertions.assertEquals(1,c.getRe());
    }

    @Test
    public void setIm_test2(){
        Complex c = new Complex();
        c.setIm(-2);
        Assertions.assertEquals(-2,c.getIm());
    }

    @Test
    public void getIm_test1(){
        Complex c = new Complex(5,3);
        Assertions.assertTrue(c.getIm() == 3);
    }


    @Test
    public void add_test() {
        Complex c = new Complex(20, 4);
        Complex c2 = new Complex(26,-1);
        double a = 1;
        Assertions.assertTrue(Complex.add(c,c2).toString().equals("46.00 + 3.00i"));
        Assertions.assertTrue(Complex.add(c,a).getRe() == 21);
    }

    @Test
    public void subtract_test() {
        Complex c = new Complex(4, 109);
        Complex c2 = new Complex(2,2);
        Assertions.assertTrue(Complex.subtract(c,c2).getRe() == 8);
    }

    @Test
    public void multiply_test() {
        Complex c = new Complex(3, 51);
        Complex c2 = new Complex(4,3);
        double a = 2;
        Assertions.assertEquals(Complex.multiply(c,c2).getRe(),12);
        Assertions.assertEquals(Complex.multiply(c,a).getRe(), 6);
    }

    @Test
    public void divide_test(){
        Complex c = new Complex(7, 2);
        Complex c2 = new Complex(0,0);
        double a = 2;
        Assertions.assertNull(Complex.divide(c,c2));
        Assertions.assertNull(Complex.divide(a,c2));
    }
}