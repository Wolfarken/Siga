package view;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.RelatorioController;
import controller.SigaController;
import controller.ViewController;
import model.Aluno;
import model.Aula;
import model.PesoAvaliacao;
import model.Disciplina;

public class SigaView extends JFrame
{
	public enum ActionEnum 	{buttonCadastrarNotaAction, buttonCadastrarFaltaAction, ButtonSetInicioAula, ButtonSetPesoAvaliacao,
								buttonConfirmarNovaAvaliacaoAction,	buttonConfirmarDataAction, buttonConfirmarPesoAvaliacaoAction, 
								buttonConfirmarNotaAction, buttonConfirmarChamadaAction, buttonCadastrarNovaAvaliacaoAction,
								comboDisciplinaAction, buttonGerarRelatorioNotaAction, buttonGerarRelatorioFaltaAction}
	
	private static final long serialVersionUID = 1L;

	
	
	private JPanel panel;
	private JLabel labelSistema;
	private JLabel labelFuncoes;
	private JLabel labelDisciplina;
	private JLabel labelAluno;
	private JLabel labelPesoAvaliacao;
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
	private JButton buttonCadastrarNota;
	private JButton buttonCadastrarFalta;
	private JButton buttonSetInicioAula;
	private JButton buttonSetPesoAvaliacao;
	private JButton buttonConfirmarData;
	private JButton buttonConfirmarPesoAvaliacao;
	private JButton buttonConfirmarNota;
	private JButton buttonConfirmarChamada;
	private JButton buttonConfirmarNovaAvaliacao;
	private JButton buttonCadastrarNovaAvaliacao;
	private JButton buttonGerarRelatorioNota;
	private JButton buttonGerarRelatorioFalta;
	
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater
		(new Runnable() 
			{
				public void run() 
				{
					try 
					{
						SigaView window = new SigaView();
						window.setTitle("LAB BD - AV3 Siga");
						window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						window.setBounds(0, 0, 850, 350);
						window.setVisible(true);
					} 
					catch (Exception e) 
					{
						e.printStackTrace();
					}
				}
			}
		);
	}
	
	
	
	public SigaView()
	{
		//panel setup
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(panel);
		panel.setLayout(null);
		
		
		
		//labelSistema setup
		labelSistema = new JLabel("Sistema");
		labelSistema.setBounds(10, 10, 100, 20);
		panel.add(labelSistema);
		
		//labelFuncoes setup
		labelFuncoes = new JLabel("Funções");
		labelFuncoes.setBounds(10, 130, 100, 20);
		panel.add(labelFuncoes);
		
		
		//labelDisciplina setup
		labelDisciplina = new JLabel("Disciplina: ");
		labelDisciplina.setBounds(300, 40, 100, 20);
		panel.add(labelDisciplina);
		
		//labelAluno setup
		labelAluno = new JLabel("Aluno: ");
		labelAluno.setBounds(300, 70, 100, 20);
		panel.add(labelAluno);
		
		//labelPesoAvaliacao setup
		labelPesoAvaliacao = new JLabel("Avaliacao: ");
		labelPesoAvaliacao.setBounds(300, 100, 100, 20);
		panel.add(labelPesoAvaliacao);
		
		//labelNomeAvaliacao setup
		labelNomeAvaliacao = new JLabel("Nome Avaliacao: ");
		labelNomeAvaliacao.setBounds(500, 100, 100, 20);
		panel.add(labelNomeAvaliacao);
		
		//labelAula setup
		labelAula = new JLabel("Aula Data: ");
		labelAula.setBounds(300, 130, 100, 20);
		panel.add(labelAula);
		
		//labelNota setup
		labelNota = new JLabel("Nota: ");
		labelNota.setBounds(300, 160, 100, 20);
		panel.add(labelNota);
		
		//labelPeso setup
		labelPeso = new JLabel("Peso: ");
		labelPeso.setBounds(450, 160, 100, 20);
		panel.add(labelPeso);
		
		//labelFalta setup
		labelFalta = new JLabel("Faltas: ");
		labelFalta.setBounds(300, 190, 100, 20);
		panel.add(labelFalta);
		
		//labelInicioAulaData setup
		labelInicioAulaData = new JLabel("Inicio do semestre: ");
		labelInicioAulaData.setBounds(300, 220, 100, 20);
		panel.add(labelInicioAulaData);
		
		
		
		//textAvaliacao setup
		textAvaliacao = new JTextField();
		textAvaliacao.setBounds(500, 190, 50, 20);
		textAvaliacao.setColumns(3);
		panel.add(textAvaliacao);
		
		//textNota setup
		textNota = new JTextField();
		textNota.setBounds(400, 160, 50, 20);
		textNota.setColumns(3);
		panel.add(textNota);
		
		//textPeso setup
		textPeso = new JTextField();
		textPeso.setBounds(500, 160, 50, 20);
		textPeso.setColumns(3);
		panel.add(textPeso);
		
		//textFalta setup
		textFalta = new JTextField();
		textFalta.setBounds(400, 190, 50, 20);
		textFalta.setColumns(3);
		panel.add(textFalta);
		
		//textInicioAulaData setup
		textInicioAulaData = new JTextField();
		textInicioAulaData.setBounds(400, 220, 50, 20);
		textInicioAulaData.setColumns(3);
		panel.add(textInicioAulaData);
		
		
		
		//comboAluno setup
		comboAluno = new JComboBox<Aluno>();
		comboAluno.setBounds(400, 70, 400, 25);
		panel.add(comboAluno);
		
		//comboPesoAvaliacao setup
		comboPesoAvaliacao = new JComboBox<PesoAvaliacao>();
		comboPesoAvaliacao.setBounds(400, 100, 400, 25);
		panel.add(comboPesoAvaliacao);
		
		//comboAula setup
		comboAula = new JComboBox<Aula>();
		comboAula.setBounds(400, 130, 400, 25);
		panel.add(comboAula);
		
		//comboDisciplina setup
		comboDisciplina = new JComboBox<Disciplina>();
		comboDisciplina.setBounds(400, 40, 400, 25);
		panel.add(comboDisciplina);
		//comboDisciplina ActionListener
		ActionListener comboDisciplinaSelection = new ViewController(comboDisciplina, comboPesoAvaliacao, comboAula);
		comboDisciplina.setActionCommand(ActionEnum.comboDisciplinaAction.name());
		comboDisciplina.addActionListener(comboDisciplinaSelection);
		
		
		
		
		
		
		//buttonConfirmarData setup
		buttonConfirmarData = new JButton("Confirmar Data");
		buttonConfirmarData.setBounds(600, 250, 200, 25);
		panel.add(buttonConfirmarData);
		//buttonConfirmarData ActionListener
		ActionListener confirmarData = new SigaController(comboDisciplina, textInicioAulaData);
		buttonConfirmarData.setActionCommand(ActionEnum.buttonConfirmarDataAction.name());
		buttonConfirmarData.addActionListener(confirmarData);
		
		
		//buttonConfirmarPesoAvaliacao setup
		buttonConfirmarPesoAvaliacao = new JButton("Confirmar Peso Avaliativo");
		buttonConfirmarPesoAvaliacao.setBounds(600, 250, 200, 25);
		panel.add(buttonConfirmarPesoAvaliacao);
		//buttonConfirmarData ActionListener
		ActionListener confirmarPesoAvaliacao = new SigaController(comboDisciplina, comboPesoAvaliacao, textPeso);
		buttonConfirmarPesoAvaliacao.setActionCommand(ActionEnum.buttonConfirmarPesoAvaliacaoAction.name());
		buttonConfirmarPesoAvaliacao.addActionListener(confirmarPesoAvaliacao);
		
		
		//buttonConfirmarNota setup
		buttonConfirmarNota = new JButton("Confirmar Nota");
		buttonConfirmarNota.setBounds(600, 250, 200, 25);
		panel.add(buttonConfirmarNota);
		//buttonConfirmarNota ActionListener
		ActionListener confirmarNota = new SigaController(comboDisciplina, comboAluno, comboPesoAvaliacao, textNota);
		buttonConfirmarNota.setActionCommand(ActionEnum.buttonConfirmarNotaAction.name());
		buttonConfirmarNota.addActionListener(confirmarNota);
		
		
		//buttonConfirmarChamada setup
		buttonConfirmarChamada = new JButton("Confirmar Chamada");
		buttonConfirmarChamada.setBounds(600, 250, 200, 25);
		panel.add(buttonConfirmarChamada);
		//buttonConfirmarChamada ActionListener
		ActionListener confirmarChamada = new SigaController(comboDisciplina, comboAluno, comboAula, textFalta, 0);
		buttonConfirmarChamada.setActionCommand(ActionEnum.buttonConfirmarChamadaAction.name());
		buttonConfirmarChamada.addActionListener(confirmarChamada);
		
		
		//buttonCadastrarNovaAvaliacao setup
		buttonCadastrarNovaAvaliacao = new JButton("Cadastrar Avaliação");
		buttonCadastrarNovaAvaliacao.setBounds(600, 250, 200, 25);
		panel.add(buttonCadastrarNovaAvaliacao);
		//buttonCadastrarNovaAvaliacao ActionListener
		ActionListener cadastrarNovaAvaliacao = new SigaController(textAvaliacao);
		buttonCadastrarNovaAvaliacao.setActionCommand(ActionEnum.buttonCadastrarNovaAvaliacaoAction.name());
		buttonCadastrarNovaAvaliacao.addActionListener(cadastrarNovaAvaliacao);
		
		
		
		
		
		
		//buttonGerarRelatorioNota setup
		buttonGerarRelatorioNota = new JButton("Gerar Relatório");
		buttonGerarRelatorioNota.setBounds(400, 250, 200, 25);
		panel.add(buttonGerarRelatorioNota);
		//buttonCadastrarNovaAvaliacao ActionListener
		ActionListener gerarRelatorioNota = new RelatorioController(comboDisciplina);
		buttonGerarRelatorioNota.setActionCommand(ActionEnum.buttonGerarRelatorioNotaAction.name());
		buttonGerarRelatorioNota.addActionListener(gerarRelatorioNota);
		
		
		//buttonGerarRelatorioFalta setup
		buttonGerarRelatorioFalta = new JButton("Gerar Relatório");
		buttonGerarRelatorioFalta.setBounds(400, 250, 200, 25);
		panel.add(buttonGerarRelatorioFalta);
		//buttonCadastrarNovaAvaliacao ActionListener
		ActionListener gerarRelatorioFalta = new RelatorioController(comboDisciplina);
		buttonGerarRelatorioFalta.setActionCommand(ActionEnum.buttonGerarRelatorioFaltaAction.name());
		buttonGerarRelatorioFalta.addActionListener(gerarRelatorioFalta);
		
		
		
		

		
		
		
		//buttonCadastrarNota setup
		buttonCadastrarNota = new JButton("Cadastrar Nota");
		buttonCadastrarNota.setBounds(30, 160, 200, 25);
		panel.add(buttonCadastrarNota);
		//buttonCadastrarNota ActionListener
		ActionListener cadastrarNota = new ViewController(labelDisciplina, labelAluno, labelPesoAvaliacao, labelNomeAvaliacao, labelAula, 
																labelNota, labelPeso, labelFalta, labelInicioAulaData, textAvaliacao, 
																textNota, textPeso, textFalta, textInicioAulaData, 
																comboAluno, comboPesoAvaliacao, comboDisciplina, comboAula,
																buttonConfirmarData, buttonConfirmarPesoAvaliacao,
																buttonConfirmarNota, buttonConfirmarChamada, buttonCadastrarNovaAvaliacao,
																buttonGerarRelatorioNota, buttonGerarRelatorioFalta);
		buttonCadastrarNota.setActionCommand(ActionEnum.buttonCadastrarNotaAction.name());
		buttonCadastrarNota.addActionListener(cadastrarNota);

		
		//buttonCadastrarFalta setup
		buttonCadastrarFalta = new JButton("Realizar Chamada");
		buttonCadastrarFalta.setBounds(30, 190, 200, 25);
		panel.add(buttonCadastrarFalta);
		//buttonRegisterAthlete ActionListener
		ActionListener cadastrarFalta = new ViewController(labelDisciplina, labelAluno, labelPesoAvaliacao, labelNomeAvaliacao, labelAula, 
									labelNota, labelPeso, labelFalta, labelInicioAulaData, textAvaliacao, 
									textNota, textPeso, textFalta, textInicioAulaData, 
									comboAluno, comboPesoAvaliacao, comboDisciplina, comboAula,
									buttonConfirmarData, buttonConfirmarPesoAvaliacao,
									buttonConfirmarNota, buttonConfirmarChamada, buttonCadastrarNovaAvaliacao,
									buttonGerarRelatorioNota, buttonGerarRelatorioFalta);
		buttonCadastrarFalta.setActionCommand(ActionEnum.buttonCadastrarFaltaAction.name());
		buttonCadastrarFalta.addActionListener(cadastrarFalta);
		
		
		//buttonSetInicioAula setup
		buttonSetInicioAula = new JButton("Definir começo do semestre");
		buttonSetInicioAula.setBounds(30, 40, 200, 25);
		panel.add(buttonSetInicioAula);
		//buttonRegisterAthlete ActionListener
		ActionListener inicioAula = new ViewController(labelDisciplina, labelAluno, labelPesoAvaliacao, labelNomeAvaliacao, labelAula, 
				labelNota, labelPeso, labelFalta, labelInicioAulaData, textAvaliacao, 
				textNota, textPeso, textFalta, textInicioAulaData, 
				comboAluno, comboPesoAvaliacao, comboDisciplina, comboAula,
				buttonConfirmarData, buttonConfirmarPesoAvaliacao,
				buttonConfirmarNota, buttonConfirmarChamada, buttonCadastrarNovaAvaliacao,
				buttonGerarRelatorioNota, buttonGerarRelatorioFalta);
		buttonSetInicioAula.setActionCommand(ActionEnum.ButtonSetInicioAula.name());
		buttonSetInicioAula.addActionListener(inicioAula);
		
		
		//buttonSetPesoAvaliacao setup
		buttonSetPesoAvaliacao = new JButton("Definir peso das avaliações");
		buttonSetPesoAvaliacao.setBounds(30, 70, 200, 25);
		panel.add(buttonSetPesoAvaliacao);
		//buttonSetPesoAvaliacao ActionListener
		ActionListener pesoAvaliacao = new ViewController(labelDisciplina, labelAluno, labelPesoAvaliacao, labelNomeAvaliacao, labelAula, 
				labelNota, labelPeso, labelFalta, labelInicioAulaData, textAvaliacao, 
				textNota, textPeso, textFalta, textInicioAulaData, 
				comboAluno, comboPesoAvaliacao, comboDisciplina, comboAula,
				buttonConfirmarData, buttonConfirmarPesoAvaliacao,
				buttonConfirmarNota, buttonConfirmarChamada, buttonCadastrarNovaAvaliacao,
				buttonGerarRelatorioNota, buttonGerarRelatorioFalta);
		buttonSetPesoAvaliacao.setActionCommand(ActionEnum.ButtonSetPesoAvaliacao.name());
		buttonSetPesoAvaliacao.addActionListener(pesoAvaliacao);
		
		
		//buttonConfirmarNovaAvaliacao setup
		buttonConfirmarNovaAvaliacao = new JButton("Cadastrar nova Avaliacao");
		buttonConfirmarNovaAvaliacao.setBounds(30, 100, 200, 25);
		panel.add(buttonConfirmarNovaAvaliacao);
		//buttonSetPesoAvaliacao ActionListener
		ActionListener confirmarNovaAvaliacao = new ViewController(labelDisciplina, labelAluno, labelPesoAvaliacao, labelNomeAvaliacao, labelAula, 
				labelNota, labelPeso, labelFalta, labelInicioAulaData, textAvaliacao, 
				textNota, textPeso, textFalta, textInicioAulaData, 
				comboAluno, comboPesoAvaliacao, comboDisciplina, comboAula,
				buttonConfirmarData, buttonConfirmarPesoAvaliacao,
				buttonConfirmarNota, buttonConfirmarChamada, buttonCadastrarNovaAvaliacao,
				buttonGerarRelatorioNota, buttonGerarRelatorioFalta);
		buttonConfirmarNovaAvaliacao.setActionCommand(ActionEnum.buttonConfirmarNovaAvaliacaoAction.name());
		buttonConfirmarNovaAvaliacao.addActionListener(confirmarNovaAvaliacao);
		
		
		
		
		
		
		ViewController viewController = new ViewController(labelDisciplina, labelAluno, labelPesoAvaliacao, labelNomeAvaliacao, labelAula, 
				labelNota, labelPeso, labelFalta, labelInicioAulaData, textAvaliacao, 
				textNota, textPeso, textFalta, textInicioAulaData, 
				comboAluno, comboPesoAvaliacao, comboDisciplina, comboAula,
				buttonConfirmarData, buttonConfirmarPesoAvaliacao,
				buttonConfirmarNota, buttonConfirmarChamada, buttonCadastrarNovaAvaliacao,
				buttonGerarRelatorioNota, buttonGerarRelatorioFalta);
		viewController.TodosCamposVisibleFalse();
		viewController.PopularComboBoxDisciplina();
		viewController.PopularComboBoxAluno();
		viewController.PopularComboBoxPesoAvaliacao();
		viewController.PopularComboBoxAula();
	}
}
