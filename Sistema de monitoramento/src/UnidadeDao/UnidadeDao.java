package UnidadeDao;

import java.util.Set;

import DTO.CoordenadaDTO;
import SistemaDeMonitoramento.Unidade;

public interface UnidadeDao {
	public void addUnidade(Unidade unidadeNova) throws Exception;
	public Set<Unidade> getUnidades() throws Exception;
	public void updateUnidade(Unidade unidade, float abscissa, float ordenada) throws Exception;
}
