public class ZaMaloDanychException extends Exception
{
    private int data;

    public ZaMaloDanychException() {}
    public ZaMaloDanychException(int data){
        this.data = data;
    }
    public String getMessage(){
        return "n=" + data;
    }
}