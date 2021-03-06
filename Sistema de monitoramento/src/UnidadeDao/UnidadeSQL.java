package UnidadeDao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;
import DTO.CoordenadaDTO;
import SistemaDeMonitoramento.Unidade;
import SistemaDeMonitoramento.UnidadeEuclidiana;
import SistemaDeMonitoramento.UnidadeManhattan;

public class UnidadeSQL implements UnidadeDao {
	private static final int UNIDADE_EUCLIDIANA = 1;
	private static final int UNIDADE_MANHATTAN = 2;
	private static String SAVE_UNIDADE = "INSERT INTO UNIDADES (id,abscissa,ordenada,video,termometro,co2,ch4,tipo) \r\n" +
			                             "Values (?,?,?,?,?,?,?,?)";
	private static String UPDATE_UNIDADE = "UPDATE UNIDADES \r\n"
											+ "SET abscissa = ?, ordenada = ? \r\n"
											+ "WHERE id = ?";
	/*private static String DELETE_UNIDADE = "DELETE UNIDADES \r\n "
			+ "Where id = ?";*/
	private static String GET_UNIDADES = "SELECT * FROM UNIDADES";
	
	public UnidadeSQL() throws SQLException {
		DriverManager.registerDriver(new org.h2.Driver());
	}
	
	private Connection getConnection () throws SQLException {
		 Connection con = DriverManager.getConnection("jdbc:h2:~/Unidade");
		 return con;
	}

	public void addUnidade(Unidade unidadeNova) throws SQLException {
		if(unidadeNova instanceof UnidadeEuclidiana)
			this.addUnidadeEuclidiana(unidadeNova);
		if(unidadeNova instanceof UnidadeManhattan)
			this.addUnidadeManhattan(unidadeNova);
	}
	private void addUnidadeEuclidiana(Unidade unidadeNova) throws SQLException {
		PreparedStatement ps = this.getConnection().prepareStatement(SAVE_UNIDADE);
		ps.setInt(1, unidadeNova.getId());
		ps.setFloat(2, unidadeNova.getAbscissa());
		ps.setFloat(3, unidadeNova.getOrdenada());
		ps.setBoolean(4, unidadeNova.isVideo());
		ps.setBoolean(5, unidadeNova.isTermometro());
		ps.setBoolean(6, unidadeNova.isCo2());
		ps.setBoolean(7, unidadeNova.isCh4());
		ps.setInt(8, UnidadeSQL.UNIDADE_EUCLIDIANA);
		ps.executeUpdate();
		ps.close();
	}
	private void addUnidadeManhattan(Unidade unidadeNova) throws SQLException {
		PreparedStatement ps = this.getConnection().prepareStatement(SAVE_UNIDADE);
		ps.setInt(1, unidadeNova.getId());
		ps.setFloat(2, unidadeNova.getAbscissa());
		ps.setFloat(3, unidadeNova.getOrdenada());
		ps.setBoolean(4, unidadeNova.isVideo());
		ps.setBoolean(5, unidadeNova.isTermometro());
		ps.setBoolean(6, unidadeNova.isCo2());
		ps.setBoolean(7, unidadeNova.isCh4());
		ps.setInt(8, UnidadeSQL.UNIDADE_MANHATTAN);
		ps.executeUpdate();
		ps.close();
	}

	@Override
	public Set<Unidade> getUnidades() throws SQLException{
		
		Set<Unidade> unidades = new HashSet<Unidade>();
		Statement ps = this.getConnection().createStatement();
		if(ps.execute(GET_UNIDADES)){
			ResultSet resultado = ps.getResultSet();
			while(resultado.next()) {
				int id = resultado.getInt("ID");
				float abscissa = resultado.getFloat("ABSCISSA");
				float ordenada = resultado.getFloat("ORDENADA");
				boolean video = resultado.getBoolean("VIDEO");
				boolean termometro = resultado.getBoolean("TERMOMETRO");
				boolean co2 = resultado.getBoolean("CO2");
				boolean ch4 = resultado.getBoolean("CH4");
				int tipo = resultado.getInt("TIPO");
				if(tipo == 1)
					unidades.add(new UnidadeEuclidiana(id,abscissa,ordenada,video,termometro,
									co2,ch4));
				else if(tipo == 2)
					unidades.add(new UnidadeManhattan(id,abscissa,ordenada,video,termometro,
							co2,ch4));
			}
			
		}
		ps.close();
		return unidades;
	}

	@Override
	public void updateUnidade(Unidade unidade, float abscissa, float ordenada) throws SQLException {
		PreparedStatement ps = this.getConnection().prepareStatement(UPDATE_UNIDADE);
		ps.setFloat(1, abscissa);
		ps.setFloat(2, ordenada);
		ps.setInt(3, unidade.getId());
		ps.executeUpdate();
		ps.close();
		
	}
	/*public void deletUnidade(int id) throws SQLException {
		PreparedStatement ps = this.getConnection().prepareStatement(DELETE_UNIDADE);
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
		
	}*/
}
