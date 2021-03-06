package SistemaDeMonitoramento;

public class UnidadeEuclidiana extends Unidade{
	public UnidadeEuclidiana(int id,float abscissa, float ordenada, boolean video, boolean
			termometro, boolean co2, boolean ch4) {
		super(id, abscissa, ordenada, video, termometro, co2,  ch4);
	}
	
	public float distancia (float abscissa, float ordenada) {
		
		float p1 = (float)Math.sqrt((this.getAbscissa() - abscissa)*(this.getAbscissa() - abscissa) + (this.getOrdenada() - ordenada)*(this.getOrdenada() - ordenada));
		
		return p1;
	}


	
}
