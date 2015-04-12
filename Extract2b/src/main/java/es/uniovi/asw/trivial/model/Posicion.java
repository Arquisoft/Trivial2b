package es.uniovi.asw.trivial.model;

public class Posicion {
	
	public Posicion(){
		i=0;
		j=0;
	}
	
	public Posicion(int i2, int j2) {
		i=i2;
		j=j2;
	}

	private int i;
	private int j;
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}

}
