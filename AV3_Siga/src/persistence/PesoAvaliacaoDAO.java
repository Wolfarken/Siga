package persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import model.Disciplina;
import model.PesoAvaliacao;


public class PesoAvaliacaoDAO 
{

	public Connection connection;
	
	public PesoAvaliacaoDAO() throws ClassNotFoundException, SQLException
	{
		GenericDAO gDAO = new GenericDAO();
		connection = gDAO.getConnection();
	}
	
	
	public String RegistrarPesoAvaliacao(Disciplina disciplina, PesoAvaliacao pesoAvaliacao) throws SQLException
	{
		String saida = "";
		String sql	 = "{CALL sp_PesoAvaliacao(?,?,?,?)}";
		CallableStatement cs = connection.prepareCall(sql);
		
		//	Procedure parameters
		cs.setString(1, disciplina.getCodigo_disciplina());
		cs.setString(2, pesoAvaliacao.getTipo_avaliacao());
		cs.setDouble(3, pesoAvaliacao.getPeso());
		
		cs.registerOutParameter(4, Types.VARCHAR);
		cs.execute();
		cs.close();
		
		//	Procedure exit message
		saida = cs.getString(4);
		
		return saida;	
	}
	
	
	public void CadastrarNovoPesoAvaliacao(PesoAvaliacao pesoAvaliacao) throws SQLException
	{
		String sql	 = "INSERT INTO Avaliacao VALUES (?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1, pesoAvaliacao.getTipo_avaliacao());
		
		ps.execute();
		ps.close();
	}
	
	
	public List<PesoAvaliacao> ListaPesoAvaliacao(String codigo_disciplina) throws SQLException
	{
		
		List<PesoAvaliacao> listaPesoAvaliacao = new ArrayList<PesoAvaliacao>();
		
		String sql = "SELECT codigo_disciplina, tipo_avaliacao, peso FROM PesoAvaliacao WHERE codigo_disciplina = '" + codigo_disciplina + "' ORDER BY codigo_disciplina, tipo_avaliacao ASC";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next())
		{
			PesoAvaliacao pesoAvaliacao = new PesoAvaliacao();
			
			pesoAvaliacao.setCodigo_disciplina(rs.getString("codigo_disciplina"));
			pesoAvaliacao.setTipo_avaliacao(rs.getString("tipo_avaliacao"));
			pesoAvaliacao.setPeso(rs.getDouble("peso"));
			
			listaPesoAvaliacao.add(pesoAvaliacao);
		}
		
		rs.close();
		ps.close();
		
		return listaPesoAvaliacao;
	}
}
