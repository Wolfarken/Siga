package model;

public class Disciplina 
{
	private String codigo_disciplina;
	private String nome_disciplina;
	private String sigla_disciplina;
	private String turno_disciplina;
	private int num_aulas_disciplina;
	
	public String getCodigo_disciplina() 
	{
		return codigo_disciplina;
	}
	public void setCodigo_disciplina(String codigo_disciplina) 
	{
		this.codigo_disciplina = codigo_disciplina;
	}
	public String getNome_disciplina() 
	{
		return nome_disciplina;
	}
	public void setNome_disciplina(String nome_disciplina)
	{
		this.nome_disciplina = nome_disciplina;
	}
	public String getSigla_disciplina() 
	{
		return sigla_disciplina;
	}
	public void setSigla_disciplina(String sigla_disciplina) 
	{
		this.sigla_disciplina = sigla_disciplina;
	}
	public String getTurno_disciplina()
	{
		return turno_disciplina;
	}
	public void setTurno_disciplina(String turno_disciplina) 
	{
		this.turno_disciplina = turno_disciplina;
	}
	public int getNum_aulas_disciplina() 
	{
		return num_aulas_disciplina;
	}
	public void setNum_aulas_disciplina(int num_aulas_disciplina) 
	{
		this.num_aulas_disciplina = num_aulas_disciplina;
	}
	
	@Override
	public String toString() 
	{
		return this.nome_disciplina;
	}
}
