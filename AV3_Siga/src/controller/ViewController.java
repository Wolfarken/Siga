package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Aluno;
import model.Aula;
import model.PesoAvaliacao;
import model.Disciplina;
import persistence.AlunoDAO;
import persistence.AulaDAO;
import persistence.PesoAvaliacaoDAO;
import persistence.DisciplinaDAO;
import view.SigaView.ActionEnum;

public class ViewController implements ActionListener
{

	private JLabel labelDisciplina;
	private JLabel labelAluno;
	private JLabel labelAvaliacao;
	private JLabel labelNomeAvaliacao;
	private JLabel labelAula;
	private JLabel labelNota;
	private JLabel labelPeso;
	private JLabel labelFalta;
	private JLabel labelInicioAulaData;
	private JTextField textAvaliacao;
	private JTextField textNota;
	private JTextField textPeso;
	private JTextField textFalta;
	private JTextField textInicioAulaData;
	private JComboBox<Aluno> comboAluno;
	private JComboBox<PesoAvaliacao> comboPesoAvaliacao;
	private JComboBox<Disciplina> comboDisciplina;
	private JComboBox<Aula> comboAula;
	private JButton buttonConfirmarData;
	private JButton buttonConfirmarPesoAvaliacao;
	private JButton buttonConfirmarNota;
	private JButton buttonConfirmarChamada;
	private JButton buttonCadastrarNovaAvaliacao;
	private JButton buttonGerarRelatorioNota;
	private JButton buttonGerarRelatorioFalta;
	
	
	
	public ViewController(JLabel labelDisciplina, JLabel labelAluno, 
			JLabel labelAvaliacao, JLabel labelNomeAvaliacao, JLabel labelAula, JLabel labelNota, JLabel labelPeso, JLabel labelFalta, 
			JLabel labelInicioAulaData,	JTextField textAvaliacao, JTextField textNota, JTextField textPeso, JTextField textFalta, 
			JTextField textInicioAulaData, JComboBox<Aluno> comboAluno, JComboBox<PesoAvaliacao> comboPesoAvaliacao, 
			JComboBox<Disciplina> comboDisciplina, JComboBox<Aula> comboAula, JButton buttonConfirmarData, 
			JButton buttonConfirmarPesoAvaliacao, JButton buttonConfirmarNota, JButton buttonConfirmarChamada,
			JButton buttonCadastrarNovaAvaliacao, JButton buttonGerarRelatorioNota, JButton buttonGerarRelatorioFalta) 
	{
		this.labelDisciplina = labelDisciplina;
		this.labelAluno = labelAluno;
		this.labelAvaliacao = labelAvaliacao;
		this.labelNomeAvaliacao = labelNomeAvaliacao;
		this.labelAula = labelAula;
		this.labelNota = labelNota;
		this.labelPeso = labelPeso;
		this.labelFalta = labelFalta;
		this.labelInicioAulaData = labelInicioAulaData;
		this.textAvaliacao = textAvaliacao;
		this.textNota = textNota;
		this.textPeso = textPeso;
		this.textFalta = textFalta;
		this.textInicioAulaData = textInicioAulaData;
		this.comboAluno = comboAluno;
		this.comboPesoAvaliacao = comboPesoAvaliacao;
		this.comboDisciplina = comboDisciplina;
		this.comboAula = comboAula;
		this.buttonConfirmarData = buttonConfirmarData;
		this.buttonConfirmarPesoAvaliacao = buttonConfirmarPesoAvaliacao;
		this.buttonConfirmarNota = buttonConfirmarNota;
		this.buttonConfirmarChamada = buttonConfirmarChamada;
		this.buttonCadastrarNovaAvaliacao = buttonCadastrarNovaAvaliacao;
		this.buttonGerarRelatorioNota = buttonGerarRelatorioNota;
		this.buttonGerarRelatorioFalta = buttonGerarRelatorioFalta;
	}
	
	
	public ViewController(JComboBox<Aluno> comboAluno, JComboBox<PesoAvaliacao> comboPesoAvaliacao,
							JComboBox<Disciplina> comboDisciplina, JComboBox<Aula> comboAula)
	{
		this.comboAluno = comboAluno;
		this.comboPesoAvaliacao = comboPesoAvaliacao;
		this.comboDisciplina = comboDisciplina;
		this.comboAula = comboAula;
	}



	public ViewController(JComboBox<Disciplina> comboDisciplina, JComboBox<PesoAvaliacao> comboPesoAvaliacao, JComboBox<Aula> comboAula) 
	{
		this.comboDisciplina = comboDisciplina;
		this.comboPesoAvaliacao = comboPesoAvaliacao;
		this.comboAula = comboAula;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//	Controles da View
		if (e.getActionCommand() == ActionEnum.buttonCadastrarFaltaAction.name())
		{
			TodosCamposVisibleFalse();
			CadastrarFalta();
		}
		
		if (e.getActionCommand() == ActionEnum.buttonCadastrarNotaAction.name())
		{
			TodosCamposVisibleFalse();
			CadastrarNota();
		}
		
		if (e.getActionCommand() == ActionEnum.ButtonSetPesoAvaliacao.name())
		{
			TodosCamposVisibleFalse();
			PesoAvaliacao();
		}
		
		if (e.getActionCommand() == ActionEnum.ButtonSetInicioAula.name())
		{
			TodosCamposVisibleFalse();
			InicioAula();
		}
		
		if (e.getActionCommand() == ActionEnum.buttonConfirmarNovaAvaliacaoAction.name())
		{
			TodosCamposVisibleFalse();
			CadastrarNovaAvaliacao();
		}
		
		//	Combo Controller
		if (e.getActionCommand() == ActionEnum.comboDisciplinaAction.name())
		{
			PopularComboBoxPesoAvaliacao();
			PopularComboBoxAula();
		}
	}

	
	
	public void TodosCamposVisibleFalse()
	{
		labelNomeAvaliacao.setVisible(false);
		labelDisciplina.setVisible(false);
		labelInicioAulaData.setVisible(false);
		textInicioAulaData.setVisible(false);
		comboDisciplina.setVisible(false);
		buttonConfirmarData.setVisible(false);
		labelAluno.setVisible(false);
		labelAvaliacao.setVisible(false);
		labelAula.setVisible(false);
		labelFalta.setVisible(false);
		labelNota.setVisible(false);
		labelPeso.setVisible(false);
		textAvaliacao.setVisible(false);
		textNota.setVisible(false);
		textPeso.setVisible(false);
		textFalta.setVisible(false);
		comboAula.setVisible(false);
		comboAluno.setVisible(false);
		comboPesoAvaliacao.setVisible(false);
		buttonConfirmarPesoAvaliacao.setVisible(false);
		buttonConfirmarNota.setVisible(false);
		buttonConfirmarChamada.setVisible(false);
		buttonCadastrarNovaAvaliacao.setVisible(false);
		buttonGerarRelatorioNota.setVisible(false);
		buttonGerarRelatorioFalta.setVisible(false);
	}
	
	
	private void CadastrarNovaAvaliacao() 
	{
		labelNomeAvaliacao.setVisible(true);
		textAvaliacao.setVisible(true);
		buttonCadastrarNovaAvaliacao.setVisible(true);
	}


	private void InicioAula() 
	{
		labelDisciplina.setVisible(true);
		labelInicioAulaData.setVisible(true);
		textInicioAulaData.setVisible(true);
		comboDisciplina.setVisible(true);
		buttonConfirmarData.setVisible(true);
	}

	
	private void PesoAvaliacao() 
	{
		labelDisciplina.setVisible(true);
		labelAvaliacao.setVisible(true);
		labelPeso.setVisible(true);
		textPeso.setVisible(true);
		comboDisciplina.setVisible(true);
		comboPesoAvaliacao.setVisible(true);
		buttonConfirmarPesoAvaliacao.setVisible(true);
	}

	
	private void CadastrarNota() 
	{
		labelDisciplina.setVisible(true);
		labelAluno.setVisible(true);
		labelAvaliacao.setVisible(true);
		labelNota.setVisible(true);
		textNota.setVisible(true);
		comboAluno.setVisible(true);
		comboDisciplina.setVisible(true);
		comboPesoAvaliacao.setVisible(true);
		buttonConfirmarNota.setVisible(true);
		buttonGerarRelatorioNota.setVisible(true);
	}

	
	private void CadastrarFalta() 
	{
		labelDisciplina.setVisible(true);
		labelAula.setVisible(true);
		labelAluno.setVisible(true);
		labelFalta.setVisible(true);
		textFalta.setVisible(true);
		comboDisciplina.setVisible(true);
		comboAluno.setVisible(true);
		comboAula.setVisible(true);
		buttonConfirmarChamada.setVisible(true);
		buttonGerarRelatorioFalta.setVisible(true);
	}
	
	
	
	
	
	
	//	Popular ComboBox
	public void PopularComboBoxDisciplina()
	{
		try
		{
			DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
			List<Disciplina> listaDisciplina = disciplinaDAO.ListaDisciplina();
			
			if (comboDisciplina.getItemCount() > 0)
			{
				comboDisciplina.removeAllItems();
			}
			
			if (listaDisciplina != null)
			{
				for (Disciplina disciplina : listaDisciplina)
				{
					comboDisciplina.addItem(disciplina);
				}
			}
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
	
	
	public void PopularComboBoxAluno()
	{
		try
		{
			AlunoDAO alunoDAO = new AlunoDAO();
			List<Aluno> listaAluno = alunoDAO.ListaAluno();
			
			if (comboAluno.getItemCount() > 0)
			{
				comboAluno.removeAllItems();
			}
			
			if (listaAluno != null)
			{
				for (Aluno aluno : listaAluno)
				{
					comboAluno.addItem(aluno);
				}
			}
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
	
	
	public void PopularComboBoxPesoAvaliacao()
	{
		try
		{
			Disciplina disciplina = new Disciplina();
			disciplina = (Disciplina) comboDisciplina.getSelectedItem();
			
			String codigo_disciplina = disciplina.getCodigo_disciplina();
			
			PesoAvaliacaoDAO avaliacaoDAO = new PesoAvaliacaoDAO();
			List<PesoAvaliacao> listaAvaliacao = avaliacaoDAO.ListaPesoAvaliacao(codigo_disciplina);
			
			if (comboPesoAvaliacao.getItemCount() > 0)
			{
				comboPesoAvaliacao.removeAllItems();
			}
			
			if (listaAvaliacao != null)
			{
				for (PesoAvaliacao avaliacao : listaAvaliacao)
				{
					comboPesoAvaliacao.addItem(avaliacao);
				}
			}
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
	
	
	public void PopularComboBoxAula()
	{
		try
		{
			Disciplina disciplina = new Disciplina();
			disciplina = (Disciplina) comboDisciplina.getSelectedItem();

			String codigo_disciplina = disciplina.getCodigo_disciplina();

			AulaDAO aulaDAO = new AulaDAO();
			List<Aula> listaAula = aulaDAO.ListaAula(codigo_disciplina);
			
			if (comboAula.getItemCount() > 0)
			{
				comboAula.removeAllItems();
			}
			
			if (listaAula != null)
			{
				for (Aula aula : listaAula)
				{
					comboAula.addItem(aula);
				}
			}
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
}
