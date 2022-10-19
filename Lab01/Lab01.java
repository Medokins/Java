public class Lab01 {
    public static void main(String[] args) {
        SystemOfEquationsSolver element = new SystemOfEquationsSolver(100,200,3000,400,500,600);
        element.printEquation();
        element.solve();
        element.draw(1000, 700, "solution");
    }
}