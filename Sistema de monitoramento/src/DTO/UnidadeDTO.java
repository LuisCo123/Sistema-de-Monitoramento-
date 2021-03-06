package DTO;

public class UnidadeDTO {
	private int id;
	private float abscissa;
	private float ordenada;
	
	public UnidadeDTO(int id, float abscissa, float ordenada) {
		this.setId(id);
		this.setAbscissa(abscissa);
		this.setOrdenada(ordenada);
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getAbscissa() {
		return abscissa;
	}

	public void setAbscissa(float abscissa) {
		this.abscissa = abscissa;
	}

	public float getOrdenada() {
		return ordenada;
	}

	public void setOrdenada(float ordenada) {
		this.ordenada = ordenada;
	}

	@Override
	public String toString() {
		return "[Unidade Modificada \n id=" + id + "\n Novas coordenadas: abscissa=" + abscissa + " ordenada=" + ordenada + "]";
	}
	
}
