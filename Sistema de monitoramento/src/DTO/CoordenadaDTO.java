package DTO;

public class CoordenadaDTO {
	private float abscissa;
	private float ordenada;
	
	public CoordenadaDTO (float abscissa, float ordenada) {
		this.setAbcissa(abscissa);
		this.setOrdenada(ordenada);
		
	}

	public float getAbscissa() {
		return abscissa;
	}

	public void setAbcissa(float abscissa) {
		this.abscissa = abscissa;
	}

	public float getOrdenada() {
		return ordenada;
	}

	public void setOrdenada(float ordenada) {
		this.ordenada = ordenada;
	}

}
