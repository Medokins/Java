import java.awt.*;
import java.awt.image.*;
import java.awt.geom.*;
import java.io.*;
import javax.imageio.*;

public class Pochodna {
    private Fun fun;
    private double h = 0.001;
    Pochodna(Funkcja funkcja) {
        fun = funkcja;
    }
    Pochodna(Fun fun) {
        this.fun = fun;
    }
    public void setFun(double val){
        if(val <= 0){
            throw new BladPochodnej();
        }
        h = val;
    }

    public double wartosc(int n, double x) {
        if (n == 1) {
            return (fun.wartosc(x + h / 2) - fun.wartosc(x - h / 2)) / h;
        } else if(n == 2) {
            return (fun.wartosc(x + h) - 2 * fun.wartosc(x) + fun.wartosc(x - h)) / (h * h);
        }
        else {
            throw new BladPochodnej();
        }
    }

    public double[] wartosc(int n, double ... values){
        double[] solution = new double[values.length];
        int iterator = 0;
        for(double elem: values){
            solution[iterator] = wartosc(n, elem);
            iterator += 1;
        }
        return solution;
    }

    public boolean plot(double a, double b) {

        int w = 500;
        int h = 500;
        int n = 50;
        String filename = "graph.png";

        BufferedImage myPicture = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = myPicture.createGraphics();

        int middleX = w / 2;
        int middleY = h / 2;

        // grid
        g.setStroke(new BasicStroke(3));
        g.setColor(Color.BLACK);
        g.draw(new Line2D.Double(0, middleY, w, middleY));
        g.draw(new Line2D.Double(middleX, 0, middleX, h));

        double step = (b-a) / n;

        Pochodna p = new Pochodna(fun);

        for (double x = a; x < b; x += step) {
            // original
            g.setColor(Color.RED);
            Point2D p1 = new Point2D.Double(w - (x + a) * w / (a - b), (fun.wartosc(x) + a) * h / (a - b));
            Point2D p2 = new Point2D.Double(w - ((x + step) + a)* w / (a - b), (fun.wartosc(x + step) + a) * h / (a - b));
            g.draw(new Line2D.Double(p1, p2));

            // first integral
            g.setColor(Color.GREEN);
            Point2D p3 = new Point2D.Double(w - (x + a) * w / (a - b), (p.wartosc(1, x) + a) * h / (a - b));
            Point2D p4 = new Point2D.Double(w - ((x + step) + a)* w / (a - b), (p.wartosc(1,x + step) + a) * h / (a - b));
            g.draw(new Line2D.Double(p3, p4));

            // second integral
            g.setColor(Color.BLUE);
            Point2D p5 = new Point2D.Double(w - (x + a) * w / (a - b), (p.wartosc(2, x) + a) * h / (a - b));
            Point2D p6 = new Point2D.Double(w - ((x + step) + a)* w / (a - b), (p.wartosc(2,x + step) + a) * h / (a - b));
            g.draw(new Line2D.Double(p5, p6));
        }

        try {
            File outputfile = new File(filename);
            ImageIO.write(myPicture, "png", outputfile);
        } catch (IOException e) {
            System.out.println("I/O error while saving " + filename);
            return false;
        }
        return true;
    }
}
