public class Dane
{
	protected int data;

	public Dane(int data) {this.data = data;}
	public void setA(int d) {data = d;}
	public String toString() {return String.valueOf(data);}

	public int getData() {return data;}
	public boolean equals(Object obj) {
		return obj instanceof Dane && data == ((Dane) obj).getData();
	}
	public Object clone() {return new Dane(data);}
	public int hashCode() {
		return Integer.valueOf(data).hashCode();
	}
	public int wynik(int w) throws ZaMaloDanychException, UjemnyParametrException {
		if (w > data)
			throw new ZaMaloDanychException(data);
		else if (w < 0)
			throw new UjemnyParametrException();
		return w * data;
	}
	public int innyWynik(int w) throws RuntimeException {
		ZaMaloDanychException e = new ZaMaloDanychException(data);
		if(w > data){
			throw new RuntimeException("ZaMaloDanychException: " + e.getMessage(), e);
		}
		return w * data;
	}
}