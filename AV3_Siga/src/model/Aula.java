package model;

public class Aula 
{
	private String codigo_disciplina;
	private int semana_aula;
	private String data_aula;

	public String getCodigo_disciplina() 
	{
		return codigo_disciplina;
	}
	public void setCodigo_disciplina(String codigo_disciplina) 
	{
		this.codigo_disciplina = codigo_disciplina;
	}
	public int getSemana_aula() 
	{
		return semana_aula;
	}
	public void setSemana_aula(int semana_aula)
	{
		this.semana_aula = semana_aula;
	}
	public String getData_aula() 
	{
		return data_aula;
	}
	public void setData_aula(String data_aula) 
	{
		this.data_aula = data_aula;
	}
	
	@Override
	public String toString() 
	{
		return this.data_aula;
	}
}
