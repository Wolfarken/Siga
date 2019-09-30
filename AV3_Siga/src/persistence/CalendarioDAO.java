package persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import model.Aula;
import model.Disciplina;

public class CalendarioDAO 
{

	public Connection connection;
	
	public CalendarioDAO() throws ClassNotFoundException, SQLException
	{
		GenericDAO gDAO = new GenericDAO();
		connection = gDAO.getConnection();
	}
	
	
	public String CalendarioInicioAulas(Disciplina disciplina, Aula aula) throws SQLException
	{
		String saida = "";
		String sql	 = "{CALL sp_InicioAula(?,?,?)}";
		CallableStatement cs = connection.prepareCall(sql);
		
		//	Procedure parameters
		cs.setString(1, disciplina.getCodigo_disciplina());
		cs.setString(2, aula.getData_aula());
		cs.registerOutParameter(3, Types.VARCHAR);
		cs.execute();
		
		//	Procedure exit message
		saida = cs.getString(3);
		
		return saida;	
	}
}
