import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SystemOfEquationsSolver {
    private final double a;
    private final double b;
    private final double c;
    private final double d;
    private final double e;
    private final double f;
    private double[] solutionTab = null;

    public SystemOfEquationsSolver(double a, double b, double c, double d, double e, double f){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    public void printEquation(){
        System.out.println(a + "x + " + b + " y = " + c);
        System.out.println(d + "x + " + e + " y = " + f);
    }

    public double determinantW() {
        return a*e - b*d;
    }
    public double determinantWX() {
        return c*e - b*f;
    }
    public double determinantWY() {
        return a*f - c*d;
    }

    public double[] solve(){
        double W = determinantW();
        if(W == 0) return null;
        else{
            solutionTab = new double[2];
            solutionTab[0] = determinantWX() / W;
            solutionTab[1] = determinantWY() / W;
            return solutionTab;
        }
    }

    public void draw(int width, int height, String filename) {
        BufferedImage myImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = myImage.createGraphics();
        //To save it as png file
        filename += ".png";

        int centerX = width / 2;
        int centerY = height / 2;

        g.setStroke(new BasicStroke(2));
        //Drawing grid
        g.setColor(Color.lightGray);
        g.drawLine(0, centerY, width, centerY);
        g.drawLine(centerX, 0, centerX, height);
        System.out.print(solutionTab[0] + " " + solutionTab[1]);

        //Drawing solution point
        g.setColor(Color.red);
        if(solutionTab != null)
            g.fillOval(centerX + (int) solutionTab[0], centerY - (int) solutionTab[1], 10, 10);
        try {
            File outfile = new File(filename);
            ImageIO.write(myImage, "png", outfile);
        } catch (IOException e) {
            System.out.println("I/O error while saving " + filename);
        }
    }
}
