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
    public void set_test2(){
        Complex c = new Complex();
        c.set(8,5);
        Assertions.assertEquals(5,c.getIm());
    }

    @Test
    public void setRe_test1(){
        Complex c = new Complex();
        c.setRe(10);
        Assertions.assertEquals(10,c.getRe());
    }

    @Test
    public void setRe_test2(){
        Complex c = new Complex();
        c.setRe(0);
        Assertions.assertEquals(0,c.getRe());
    }

    @Test
    public void setIm_test1(){
        Complex c = new Complex();
        c.setIm(11);
        Assertions.assertEquals(11,c.getIm());
    }

    @Test
    public void setIm_test2(){
        Complex c = new Complex();
        c.setIm(-1);
        Assertions.assertEquals(-1,c.getIm());
    }

    @Test
    public void getRe_test1(){
        Complex c = new Complex(5,8);
        Assertions.assertTrue(c.getRe() == 5);
    }

    @Test
    public void getRe_test2(){
        Complex c = new Complex(105,8);
        Assertions.assertTrue(c.getRe() == 105);
    }

    @Test
    public void getIm_test1(){
        Complex c = new Complex(7,9);
        Assertions.assertTrue(c.getIm() == 9);
    }

    @Test
    public void getIm_test2(){
        Complex c = new Complex(7,109);
        Assertions.assertTrue(c.getIm() == 109);
    }

    @Test
    public void add_test() {
        Complex c = new Complex(19, 4);
        Complex c2 = new Complex(26,2);
        double a = 1;
        Assertions.assertTrue(Complex.add(c,c2).toString().equals("45.00 + 6.00i"));
        Assertions.assertTrue(Complex.add(c,a).getRe() == 20);
        Assertions.assertTrue(Complex.add(a,c).getRe() == 20);
    }

    @Test
    public void subtract_test() {
        Complex c = new Complex(7, 109);
        Complex c2 = new Complex(26,2);
        double a = -100;
        Assertions.assertTrue(Complex.subtract(c,c2).getRe() == -19);
        Assertions.assertTrue(Complex.subtract(c,a).getRe()==107);
        Assertions.assertTrue(Complex.subtract(a,c2).getRe() == -126 && Complex.subtract(a,c2).getIm() == - 2);
    }

    @Test
    public void multiply_test() {
        Complex c = new Complex(15, 11);
        Complex c2 = new Complex(4,7);
        double a = -2;
        Assertions.assertEquals(Complex.multiply(c,c2).getRe(),-17);
        Assertions.assertEquals(Complex.multiply(c,a).getRe(),-30);
        Assertions.assertTrue(Complex.multiply(a,c2).getRe() == -8 && Complex.multiply(a,c2).getIm() == -14);
    }

    @Test
    public void divide_test(){
        Complex c = new Complex(7, 2);
        Complex c2 = new Complex(0,0);
        double a = -2;
        Assertions.assertNull(Complex.divide(c,c2));
        Assertions.assertEquals(Complex.divide(c,a).getRe(),-3.5);
        Assertions.assertNull(Complex.divide(a,c2));
    }
}