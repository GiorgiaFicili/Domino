package it.polito.tdp.domino.model;

public class Tesserina {

	int cella1;
	int cella2;
	
	public Tesserina(int cella1, int cella2) {
		this.cella1 = cella1;
		this.cella2 = cella2;
	}

	
	public int getCella1() {
		return cella1;
	}

	public void setCella1(int cella1) {
		this.cella1 = cella1;
	}

	public int getCella2() {
		return cella2;
	}

	public void setCella2(int cella2) {
		this.cella2 = cella2;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cella1;
		result = prime * result + cella2;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tesserina other = (Tesserina) obj;
		if (cella1 != other.cella1)
			return false;
		if (cella2 != other.cella2)
			return false;
		return true;
	}


	//metodo che ritorna reverse (tesserina con le celle scambiate), sotto forma di INTERI
	public Tesserina reverse() {
		
		return new Tesserina(this.getCella2(), this.getCella1());
		
	}


	

	
	

 
	
	
	
	
}
