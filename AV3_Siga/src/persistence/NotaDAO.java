package persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import model.Aluno;
import model.Disciplina;
import model.Nota;
import model.PesoAvaliacao;

public class NotaDAO 
{

	public Connection connection;
	
	public NotaDAO() throws ClassNotFoundException, SQLException
	{
		GenericDAO gDAO = new GenericDAO();
		connection = gDAO.getConnection();
	}
	
	
	public String CadastrarNota(Aluno aluno, Disciplina disciplina, PesoAvaliacao pesoAvaliacao, Nota nota) throws SQLException
	{
		String saida = "";
		String sql	 = "{CALL sp_CadastrarNota(?,?,?,?,?)}";
		CallableStatement cs = connection.prepareCall(sql);
		
		//	Procedure parameters
		cs.setInt(1, aluno.getRa_aluno());
		cs.setString(2, disciplina.getCodigo_disciplina());
		cs.setString(3, pesoAvaliacao.getTipo_avaliacao());
		cs.setDouble(4, nota.getNota());
		
		cs.registerOutParameter(5, Types.VARCHAR);
		cs.execute();
		
		//	Procedure exit message
		saida = cs.getString(5);
		
		return saida;	
	}
}
