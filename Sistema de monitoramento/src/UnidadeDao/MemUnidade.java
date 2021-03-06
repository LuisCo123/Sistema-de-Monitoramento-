package UnidadeDao;

import java.util.HashSet;
import java.util.Set;

import DTO.CoordenadaDTO;
import SistemaDeMonitoramento.Unidade;

public class MemUnidade implements UnidadeDao{
	private Set<Unidade> unidades;

	public MemUnidade() {
		unidades = new HashSet<Unidade>();

	}
	public void addUnidade(Unidade unidadeNova) {
		this.unidades.add(unidadeNova);
		
	}

	
	public Set<Unidade> getUnidades() {
		return this.unidades;
	}
	public void updateUnidade(Unidade unidade, float abscissa, float ordenada) {
		unidade.mudaPosicao(abscissa, ordenada);
		
	}

}
