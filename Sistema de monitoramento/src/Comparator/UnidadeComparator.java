package Comparator;

import java.util.Comparator;

import SistemaDeMonitoramento.Unidade;

public class UnidadeComparator implements Comparator<Unidade>{
	float abscissa;
	float ordenada;
	public UnidadeComparator(float abcissa, float ordenada) {
		this.setAbcissa(abcissa);
		this.setOrdenada(ordenada);
	}
	
	public void setAbcissa(float abcissa) {
		this.abscissa = abcissa;
	}
	public void setOrdenada(float ordenada) {
		this.ordenada = ordenada;
	}
	public int compare(Unidade u1, Unidade u2) {
		if (u1.distancia(abscissa, ordenada) < u2.distancia(abscissa, ordenada)) {
            return -1;
        }
        if (u1.distancia(abscissa, ordenada) > u2.distancia(abscissa, ordenada)) {
            return 1;
        }
        return 0;
	}

}
