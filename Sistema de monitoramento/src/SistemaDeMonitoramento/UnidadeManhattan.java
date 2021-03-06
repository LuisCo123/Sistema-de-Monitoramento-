package SistemaDeMonitoramento;

public class UnidadeManhattan extends Unidade {
		
	public UnidadeManhattan(int id,float abscissa, float ordenada, boolean video, boolean
				termometro, boolean co2, boolean ch4) {
			super(id, abscissa, ordenada, video, termometro, co2,  ch4);
		}
	
	public float distancia(float abscissa, float ordenada) {
		
		 float p1;
		 float p2;
			
			p1 = (this.getAbscissa() > abscissa) ? this.getAbscissa() - abscissa 
							: abscissa - this.getAbscissa();
			
			p2 = (this.getOrdenada() > ordenada) ? this.getOrdenada() - ordenada : ordenada - this.getOrdenada();
			
			return p1+p2;
			
	}

}


