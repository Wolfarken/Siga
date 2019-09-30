package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import model.Aluno;
import model.Aula;
import model.PesoAvaliacao;
import model.Disciplina;
import model.Falta;
import model.Nota;
import persistence.CalendarioDAO;
import persistence.FaltaDAO;
import persistence.NotaDAO;
import persistence.PesoAvaliacaoDAO;
import view.SigaView.ActionEnum;

public class SigaController implements ActionListener
{

	private JTextField textAvaliacao;
	private JTextField textNota;
	private JTextField textPeso;
	private JTextField textFalta;
	private JTextField textInicioAulaData;
	private JComboBox<Aluno> comboAluno;
	private JComboBox<PesoAvaliacao> comboAvaliacao;
	private JComboBox<Disciplina> comboDisciplina;
	private JComboBox<Aula> comboAula;
	
	
	
	public SigaController(JComboBox<Disciplina> comboDisciplina, JTextField textInicioAulaData) 
	{
		this.comboDisciplina = comboDisciplina;
		this.textInicioAulaData = textInicioAulaData;
	}
	

	public SigaController(JComboBox<Disciplina> comboDisciplina, JComboBox<Aluno> comboAluno,
							JComboBox<PesoAvaliacao> comboAvaliacao, JTextField textNota) 
	{
		this.comboDisciplina = comboDisciplina;
		this.comboAluno = comboAluno;
		this.comboAvaliacao = comboAvaliacao;
		this.textNota = textNota;
	}


	//	Chamada, falta
	public SigaController(JComboBox<Disciplina> comboDisciplina, JComboBox<Aluno> comboAluno, 
							JComboBox<Aula> comboAula, JTextField textFalta, int falta) 
	{
		this.comboDisciplina = comboDisciplina;
		this.comboAluno = comboAluno;
		this.comboAula = comboAula;
		this.textFalta = textFalta;
	}

	
	//	
	public SigaController(JComboBox<Disciplina> comboDisciplina, JComboBox<PesoAvaliacao> comboAvaliacao,
							JTextField textPeso) 
	{
		this.comboDisciplina = comboDisciplina;
		this.comboAvaliacao = comboAvaliacao;
		this.textPeso = textPeso;
	}
	
	
	//	
	public SigaController(JComboBox<Disciplina> comboDisciplina, JTextField textPeso, int peso) 
	{
		this.comboDisciplina = comboDisciplina;
		this.textPeso = textPeso;
	}
	

	//	Nova Avaliação
	public SigaController(JTextField textAvaliacao) 
	{
		this.textAvaliacao = textAvaliacao;
	}


	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//	Controles da DAO
		if (e.getActionCommand() == ActionEnum.buttonConfirmarChamadaAction.name())
		{
			RegistrarChamada();
		}
		
		if (e.getActionCommand() == ActionEnum.buttonConfirmarDataAction.name())
		{
			RegistrarCalendario();
		}
		
		if (e.getActionCommand() == ActionEnum.buttonConfirmarNotaAction.name())
		{
			RegistrarNota();
		}
		
		if (e.getActionCommand() == ActionEnum.buttonConfirmarPesoAvaliacaoAction.name())
		{
			RegistrarPesoAvaliacao();
		}
		
		if (e.getActionCommand() == ActionEnum.buttonCadastrarNovaAvaliacaoAction.name())
		{
			CadastrarNovoPesoAvaliacao();
		}
	}

	
	
	private void CadastrarNovoPesoAvaliacao() 
	{
		PesoAvaliacao pesoAvaliacao = new PesoAvaliacao();
		pesoAvaliacao.setTipo_avaliacao(textAvaliacao.getText());
		
		
		try
		{
			PesoAvaliacaoDAO pesoAvaliacaoDAO = new PesoAvaliacaoDAO();
			pesoAvaliacaoDAO.CadastrarNovoPesoAvaliacao(pesoAvaliacao);
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}

	
	private void RegistrarPesoAvaliacao() 
	{
		Disciplina disciplina = new Disciplina();
		disciplina = (Disciplina) comboDisciplina.getSelectedItem();
		
		PesoAvaliacao pesoAvaliacao = new PesoAvaliacao();
		pesoAvaliacao = (PesoAvaliacao) comboAvaliacao.getSelectedItem();
		
		double novoPeso = Double.parseDouble(textPeso.getText());
		pesoAvaliacao.setPeso(novoPeso);
		
		String saida = "";
		
		try
		{
			PesoAvaliacaoDAO pesoAvaliacaoDAO = new PesoAvaliacaoDAO();
			saida = pesoAvaliacaoDAO.RegistrarPesoAvaliacao(disciplina, pesoAvaliacao);
		}
		catch (ClassNotFoundException | SQLException e)
		{
			saida = e.getMessage();
			e.printStackTrace();
		}
	}

	
	private void RegistrarNota() 
	{
		Disciplina disciplina = new Disciplina();
		disciplina = (Disciplina) comboDisciplina.getSelectedItem();
		
		Aluno aluno = new Aluno();
		aluno = (Aluno) comboAluno.getSelectedItem();
		
		PesoAvaliacao pesoAvaliacao = new PesoAvaliacao();
		pesoAvaliacao = (PesoAvaliacao) comboAvaliacao.getSelectedItem();
		
		Nota nota = new Nota();
		double quantidadeNota = Double.parseDouble(textNota.getText());
		nota.setNota(quantidadeNota);
		
		String saida = "";
		
		try
		{
			NotaDAO notaDAO = new NotaDAO();
			saida = notaDAO.CadastrarNota(aluno, disciplina, pesoAvaliacao, nota);
		}
		catch (ClassNotFoundException | SQLException e)
		{
			saida = e.getMessage();
			e.printStackTrace();
		}
	}

	
	private void RegistrarCalendario() 
	{
		Disciplina disciplina = new Disciplina();
		disciplina = (Disciplina) comboDisciplina.getSelectedItem();
		
		Aula aula = new Aula();
		aula.setData_aula((String) textInicioAulaData.getText());
		
		String saida = "";
		
		try
		{
			CalendarioDAO calendarioDAO = new CalendarioDAO();
			saida = calendarioDAO.CalendarioInicioAulas(disciplina, aula);
		}
		catch (ClassNotFoundException | SQLException e)
		{
			saida = e.getMessage();
			e.printStackTrace();
		}
		finally
		{
			
		}
	}

	
	private void RegistrarChamada() 
	{
		Aluno aluno = new Aluno();
		aluno = (Aluno) comboAluno.getSelectedItem();
		
		Disciplina disciplina = new Disciplina();
		disciplina = (Disciplina) comboDisciplina.getSelectedItem();
		
		Aula aula = new Aula();
		aula = (Aula) comboAula.getSelectedItem();

		Falta falta = new Falta();
		int quantidadeFalta = Integer.parseInt(textFalta.getText());
		falta.setPresenca(quantidadeFalta);
		
		String saida = "";
		
		try
		{
			FaltaDAO faltaDAO = new FaltaDAO();
			saida = faltaDAO.RealizarChamada(aluno, disciplina, aula, falta);
		}
		catch (ClassNotFoundException | SQLException e)
		{
			saida = e.getMessage();
			e.printStackTrace();
		}
		finally
		{
			
		}
	}
}
