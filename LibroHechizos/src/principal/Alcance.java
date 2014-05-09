package principal;

public class Alcance {
	private int pies; // -1 es Ilimitado

	public void alcancePersonal() {
		setPies(0);
	}
	
	public void alcanceToque() {
		setPies(5);
	}
	
	public void alcanceCorto(int nivelLanzador) {
		int bonificador = 5*((int)nivelLanzador/2);
		setPies(25+bonificador);
	}
	
	public void alcanceIntermedio(int nivelLanzador) {
		setPies(100+10*nivelLanzador);
	}
	
	public void alcanceLargo(int nivelLanzador) {
		setPies(400+40*nivelLanzador);
	}
	
	public void alcanceIlimitado() {
		setPies(-1);
	}
	
	public void alcanceConcreto(int alcance) {
		if (alcance<0) {
			setPies(0);
		} else {
			setPies(alcance);
		}
	}
	
	/**
	 * @return the pies
	 */
	public int getPies() {
		return pies;
	}

	/**
	 * @param pies the pies to set
	 */
	private void setPies(int pies) {
		this.pies = pies;
	}
	
	
}
