package model;

public class PesoAvaliacao 
{
	private String codigo_disciplina;
	private String tipo_avaliacao;
	private double peso;

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
	public double getPeso() 
	{
		return peso;
	}
	public void setPeso(double peso)
	{
		this.peso = peso;
	}

	@Override
	public String toString() 
	{
		return this.tipo_avaliacao;
	}
}
