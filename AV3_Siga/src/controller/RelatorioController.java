package controller;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import model.Disciplina;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;
import persistence.GenericDAO;
import view.SigaView.ActionEnum;

public class RelatorioController implements ActionListener
{
	private JComboBox<Disciplina> comboDisciplina;
	
	
	public RelatorioController(JComboBox<Disciplina> comboDisciplina)
	{
		this.comboDisciplina = comboDisciplina;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//	Button listener decide qual relatório fazer
		if (e.getActionCommand() == ActionEnum.buttonGerarRelatorioNotaAction.name())
		{
			GerarRelatorioNota();
		}
		
		if (e.getActionCommand() == ActionEnum.buttonGerarRelatorioFaltaAction.name())
		{
			GerarRelatorioFalta();
		}
	}
	
	
	
	private void GerarRelatorioNota()
	{
		
		Disciplina disciplina = new Disciplina();
		disciplina = (Disciplina) comboDisciplina.getSelectedItem();
		
		String codigo_disciplina = disciplina.getCodigo_disciplina();
		
		String saida = "";
		String jasperDisciplina = codigo_disciplina;
		String jasper = "C:\\TEMP\\RelatorioAV3Nota.jasper";
		
		HashMap<String, Object> param = new HashMap<String, Object>();
		
		param.put("DISCIPLINA", jasperDisciplina);
		
		byte[] bytes = null;
		
		try 
		{
			JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(jasper);
			bytes = JasperRunManager.runReportToPdf(jasperReport, param, new GenericDAO().getConnection());
			
			File arquivo = new File("C:\\TEMP", jasperDisciplina + "Nota.pdf");

			if (arquivo.exists())
			{
				arquivo.delete();
			}
			
			FileOutputStream fileOutStream = new FileOutputStream(arquivo);
			fileOutStream.write(bytes);
			fileOutStream.flush();
			fileOutStream.close();
			
			Desktop desk = Desktop.getDesktop();
			desk.open(arquivo);
		} 
		catch (JRException | IOException | SQLException | ClassNotFoundException e) 
		{
			saida = e.getMessage();
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, saida);
		}
	}
	
	
	private void GerarRelatorioFalta()
	{
		
		Disciplina disciplina = new Disciplina();
		disciplina = (Disciplina) comboDisciplina.getSelectedItem();
		
		String codigo_disciplina = disciplina.getCodigo_disciplina();
		
		String saida = "";
		String jasperDisciplina = codigo_disciplina;
		String jasper = "C:\\TEMP\\RelatorioAV3Falta.jasper";
		
		HashMap<String, Object> param = new HashMap<String, Object>();
		
		param.put("DISCIPLINA", jasperDisciplina);
		
		byte[] bytes = null;
		
		try 
		{
			JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(jasper);
			bytes = JasperRunManager.runReportToPdf(jasperReport, param, new GenericDAO().getConnection());
			
			File arquivo = new File("C:\\TEMP", jasperDisciplina + "Falta.pdf");

			if (arquivo.exists())
			{
				arquivo.delete();
			}
			
			FileOutputStream fileOutStream = new FileOutputStream(arquivo);
			fileOutStream.write(bytes);
			fileOutStream.flush();
			fileOutStream.close();
			
			Desktop desk = Desktop.getDesktop();
			desk.open(arquivo);
		} 
		catch (JRException | IOException | SQLException | ClassNotFoundException e) 
		{
			saida = e.getMessage();
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, saida);
		}
	}
}
