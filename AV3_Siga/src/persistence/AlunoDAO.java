package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;

public class AlunoDAO 
{

	public Connection connection;
	
	public AlunoDAO() throws ClassNotFoundException, SQLException
	{
		GenericDAO gDAO = new GenericDAO();
		connection = gDAO.getConnection();
	}
	
	
	public List<Aluno> ListaAluno() throws SQLException
	{
		
		List<Aluno> listaAluno = new ArrayList<Aluno>();
		
		String sql = "SELECT ra_aluno, nome_aluno FROM Aluno";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next())
		{
			Aluno aluno = new Aluno();
			
			aluno.setRa_aluno(rs.getInt("ra_aluno"));
			aluno.setNome_aluno(rs.getString("nome_aluno"));
			
			listaAluno.add(aluno);
		}
		
		rs.close();
		ps.close();
		
		return listaAluno;
	}
}
