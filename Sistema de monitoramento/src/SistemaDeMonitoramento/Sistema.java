package SistemaDeMonitoramento;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import Comparator.UnidadeComparator;
import DTO.CoordenadaDTO;
import DTO.UnidadeDTO;
import UnidadeDao.MemUnidade;
import UnidadeDao.UnidadeDao;
import UnidadeDao.UnidadeSQL;


public class Sistema {
	private UnidadeDao memUnidade ;
		
	public Sistema() throws SQLException {
		memUnidade = new UnidadeSQL();
	};
	public void addUnidadeEuclidiana(int id,float abscissa, float ordenada, boolean video, boolean
			termometro, boolean co2, boolean ch4) throws Exception {
		UnidadeEuclidiana novaUnidade = 
				new UnidadeEuclidiana(id, abscissa, ordenada, video, termometro, co2, ch4);
		this.addUnidade(novaUnidade);	
	}
	public void addUnidadeManhattan(int id,float abscissa, float ordenada, boolean video, boolean
			termometro, boolean co2, boolean ch4) throws Exception {
		UnidadeManhattan novaUnidade = 
				new UnidadeManhattan(id, abscissa, ordenada, video, termometro, co2, ch4);
		this.addUnidade(novaUnidade);	
	}
	private void addUnidade(Unidade unidadeNova) throws Exception {
		this.memUnidade.addUnidade(unidadeNova);
	};
	public String monitorar(float abscissa, float ordenada, boolean video, boolean
			termometro, boolean co2, boolean ch4) throws Exception {
		
		List<Unidade> unidadesDisponiveis = new ArrayList<Unidade>();
	
		for (Unidade unidade : this.memUnidade.getUnidades()) {
			if(unidade.contem(video, termometro, co2, ch4))
				unidadesDisponiveis.add(unidade);		
		}
		
		if(!unidadesDisponiveis.isEmpty()){
			
			Collections.sort(unidadesDisponiveis, new UnidadeComparator(abscissa, ordenada));
			this.memUnidade.updateUnidade(unidadesDisponiveis.get(0), abscissa, ordenada);
			
			return new UnidadeDTO(unidadesDisponiveis.get(0).getId(), abscissa, ordenada).toString();
		
		}else{
			return "Sem maquinas Disponiveis para essa configuração";
		}
	}
	//public void updatePosicao(Unidade unidade, float abscissa, float ordenada) throws Exception {
		//this.memUnidade.updateUnidade(unidade, abscissa, ordenada);
		
	//}
	public Set<Unidade> getUnidades() throws Exception{
		return this.memUnidade.getUnidades();
		
	}

}
