package model;

public class Nota 
{
	private int ra_aluno;
	private String codigo_disciplina;
	private String tipo_avaliacao;
	private double nota;
	
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
	public String getTipo_avaliacao()
	{
		return tipo_avaliacao;
	}
	public void setTipo_avaliacao(String tipo_avaliacao)
	{
		this.tipo_avaliacao = tipo_avaliacao;
	}
	public double getNota() 
	{
		return nota;
	}
	public void setNota(double nota) 
	{
		this.nota = nota;
	}
}
