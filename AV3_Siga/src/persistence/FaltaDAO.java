package persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import model.Aluno;
import model.Aula;
import model.Disciplina;
import model.Falta;

public class FaltaDAO 
{

	public Connection connection;
	
	public FaltaDAO() throws ClassNotFoundException, SQLException
	{
		GenericDAO gDAO = new GenericDAO();
		connection = gDAO.getConnection();
	}
	
	
	public String RealizarChamada(Aluno aluno, Disciplina disciplina, Aula aula, Falta falta) throws SQLException
	{
		String saida = "";
		String sql	 = "{CALL sp_CadastrarFalta(?,?,?,?,?)}";
		CallableStatement cs = connection.prepareCall(sql);
		
		//	Procedure parameters
		cs.setInt(1, aluno.getRa_aluno());
		cs.setString(2, disciplina.getCodigo_disciplina());
		cs.setString(3, aula.getData_aula());
		cs.setInt(4, falta.getPresenca());
		
		cs.registerOutParameter(5, Types.VARCHAR);
		cs.execute();
		
		//	Procedure exit message
		saida = cs.getString(5);
		
		return saida;	
	}
}
