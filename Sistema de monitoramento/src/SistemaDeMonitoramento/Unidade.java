package SistemaDeMonitoramento;

public abstract class Unidade{

	private int id;
	private float abscissa;
	private float ordenada;
	private boolean video;
	private boolean termometro;
	private boolean co2;
	private boolean ch4;
	
	public Unidade(int id,float abscissa, float ordenada, boolean video, boolean
			termometro, boolean co2, boolean ch4) {
		this.setId(id);
		this.setAbscissa(abscissa);
		this.setOrdenada(ordenada);
		this.setVideo(video);
		this.setTermometro(termometro);
		this.setCo2(co2);
		this.setCh4(ch4);
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public float getAbscissa() {
		return abscissa;
	}

	protected  void setAbscissa(float abscissa) {
		this.abscissa = abscissa;
	}

	public float getOrdenada() {
		return ordenada;
	}

	protected void setOrdenada(float ordenada) {
		this.ordenada = ordenada;
	}

	public boolean isVideo() {
		return video;
	}

	public void setVideo(boolean video) {
		this.video = video;
	}

	public boolean isTermometro() {
		return termometro;
	}

	public void setTermometro(boolean termometro) {
		this.termometro = termometro;
	}

	public boolean isCo2() {
		return co2;
	}

	public void setCo2(boolean co2) {
		this.co2 = co2;
	}

	public boolean isCh4() {
		return ch4;
	}

	public void setCh4(boolean ch4) {

		this.ch4 = ch4;
	}

	public abstract float distancia(float abscissa, float ordenada);
	
	public boolean contem(boolean video, boolean

			termometro, boolean co2, boolean ch4) {
		if(video)
			if(this.isVideo()!=video)
				return false;
		if(termometro)
			if(this.isTermometro()!=termometro)
				return false;
		if(co2)
			if(this.isCo2()!=co2)
				return false;
		if(ch4)
			if(this.isCh4()!=ch4)
				return false;
		
		return true;
	}
	
	public void mudaPosicao(float abscissa, float ordenada) {
		this.setAbscissa(abscissa);
		this.setOrdenada(ordenada);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Unidade other = (Unidade) obj;
		if (id != other.id)
			return false;
		return true;
	}
	public String toString() {
		return "ID: " + this.getId() + " Abscissa" + this.getAbscissa() + 
				" Ordenada" + this.getOrdenada() + "\n" ;
		
		
		
	}

}
