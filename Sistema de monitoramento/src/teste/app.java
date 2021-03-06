package teste;

import java.sql.SQLException;

import DTO.CoordenadaDTO;
import SistemaDeMonitoramento.Sistema;
import SistemaDeMonitoramento.Unidade;
import SistemaDeMonitoramento.UnidadeManhattan;
import UnidadeDao.UnidadeDao;
import UnidadeDao.UnidadeSQL;

public class app {

	public static void main(String[] args) throws Exception {
		
		Sistema sistema = new Sistema();
		sistema.addUnidadeManhattan(001, 28, 16, true, true, true, false);
		sistema.addUnidadeEuclidiana(002, 10, 46, false, false, true, true);
		sistema.addUnidadeEuclidiana(003, 30, 49, true, false, true, false);
		sistema.addUnidadeManhattan(004, 15, 20, false, true, true, true);
		
		/*System.out.println(sistema.monitorar(30, 10, false, false, true, false));
		System.out.println(sistema.monitorar(30, 49, false, false, true, false));
		System.out.println(sistema.monitorar(30, 49, true, true, true, true));*/
		
		
		//REMOVER AS UNIDADES
		/*UnidadeSQL sqlDeleteUnidades = new UnidadeSQL();
		sqlDeleteUnidades.clearTableUnidade();*/
		
	}

}
