package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Disciplina;

public class DisciplinaDAO 
{

	public Connection connection;
	
	public DisciplinaDAO() throws ClassNotFoundException, SQLException
	{
		GenericDAO gDAO = new GenericDAO();
		connection = gDAO.getConnection();
	}
	
	
	public List<Disciplina> ListaDisciplina() throws SQLException
	{
		
		List<Disciplina> listaDisciplina = new ArrayList<Disciplina>();
		
		String sql = "SELECT codigo_disciplina, nome_disciplina, sigla_disciplina, turno_disciplina, num_aulas_disciplina FROM Disciplina";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next())
		{
			Disciplina disciplina = new Disciplina();
			
			disciplina.setCodigo_disciplina(rs.getString("codigo_disciplina"));
			disciplina.setNome_disciplina(rs.getString("nome_disciplina"));
			disciplina.setSigla_disciplina(rs.getString("sigla_disciplina"));
			disciplina.setTurno_disciplina(rs.getString("turno_disciplina"));
			disciplina.setNum_aulas_disciplina(rs.getInt("num_aulas_disciplina"));
			
			listaDisciplina.add(disciplina);
		}
		
		rs.close();
		ps.close();
		
		return listaDisciplina;
	}
}
