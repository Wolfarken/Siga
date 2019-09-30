package model;

public class Falta 
{
	private int ra_aluno;;
	private String codigo_disciplina;
	private int semana_aula;
	private String data_falta;
	private int presenca;
	
	public int getRa_aluno()
	{
		return ra_aluno;
	}
	public void setRa_aluno(int ra_aluno) 
	{
		this.ra_aluno = ra_aluno;
	}
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
	public String getData_falta()
	{
		return data_falta;
	}
	public void setData_falta(String data_falta)
	{
		this.data_falta = data_falta;
	}
	public int getPresenca() 
	{
		return presenca;
	}
	public void setPresenca(int presenca)
	{
		this.presenca = presenca;
	}
}
