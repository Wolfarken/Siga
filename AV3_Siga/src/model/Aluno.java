package model;

public class Aluno
{
	private int ra_aluno;
	private String nome_aluno;
	
	public int getRa_aluno() 
	{
		return ra_aluno;
	}
	public void setRa_aluno(int ra_aluno) 
	{
		this.ra_aluno = ra_aluno;
	}
	public String getNome_aluno() 
	{
		return nome_aluno;
	}
	public void setNome_aluno(String nome_aluno) 
	{
		this.nome_aluno = nome_aluno;
	}
	
	@Override
	public String toString() 
	{
		return this.nome_aluno;
	}
}
