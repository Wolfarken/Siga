package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Aula;


public class AulaDAO
{

	public Connection connection;
	
	public AulaDAO() throws ClassNotFoundException, SQLException
	{
		GenericDAO gDAO = new GenericDAO();
		connection = gDAO.getConnection();
	}
	
	
	public List<Aula> ListaAula(String codigo_disciplina) throws SQLException
	{
		
		List<Aula> listaAula = new ArrayList<Aula>();
		
		String sql = "SELECT codigo_disciplina, semana_aula, CONVERT(varchar, data_aula, 103) AS data_aula FROM Aula WHERE codigo_disciplina = '" + codigo_disciplina + "'";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next())
		{
			Aula aula = new Aula();
			
			aula.setCodigo_disciplina(rs.getString("codigo_disciplina"));
			aula.setSemana_aula(rs.getInt("semana_aula"));
			aula.setData_aula(rs.getString("data_aula"));
			
			listaAula.add(aula);
		}
		
		rs.close();
		ps.close();
		
		return listaAula;
	}
}
