package br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui;

import java.io.IOException;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.controle.Cliente;
import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.controle.Trecho;
import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui.listeners.AtualizarCompras;
import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui.listeners.AtualizarComprasTotais;
import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui.listeners.AtualizarReservas;
import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui.listeners.AtualizarReservasTotais;
import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui.listeners.EfetuarCompras;
import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui.listeners.EfetuarReservas;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.looks.plastic.PlasticXPLookAndFeel;
import com.jgoodies.looks.plastic.theme.Silver;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	public TelaPrincipal(){
        try {
//        	"Ext Windows XP L&F", "com.jgoodies.looks.windows.ExtWindowsLookAndFeel"
//        	"Plastic", "com.jgoodies.looks.plastic.PlasticLookAndFeel"
//        	"Plastic 3D", "com.jgoodies.looks.plastic.Plastic3DLookAndFeel"
//        	"Plastic XP", "com.jgoodies.looks.plastic.PlasticXPLookAndFeel"
        	PlasticXPLookAndFeel.setPlasticTheme(new Silver());
         	UIManager.setLookAndFeel("com.jgoodies.looks.plastic.PlasticXPLookAndFeel");
        }
        catch(Exception e){
         	try {
 				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
 			} 
         	catch (Exception ignore) {}
        }
        
        setTitle("Cliente");

//		dlu unidade de tamanho
//		pref tamanho preferencial
//		max(15dlu;pref):grow(0.5)
//		max(x;y) maior entre x e y
//		:grow(0.x) rate de aumento no resize
//		top:Xdlu align top
//		bottom:Xdlu align bottom
        FormLayout layout = new FormLayout("4dlu, pref, 4dlu, pref, 4dlu", 
    										"4dlu, pref, pref, pref, pref, pref, pref, pref, pref pref, pref, pref, pref, pref, 4dlu");
        setLayout(layout);
        
        CellConstraints cellConstraints = new CellConstraints();
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable();
        table.setModel(tableModel);
        tableModel.addColumn("ID");
        tableModel.addColumn("Trechos");
        tableModel.addColumn("Vagas");
        
        try {
			for (Trecho trecho : Cliente.getInstance().obtemTrechos()) {
				tableModel.addRow(new Object[] {trecho.getId(), trecho.getNome(), trecho.getVagasDisponiveis()});
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		table.getTableHeader().setEnabled(true);
		table.getTableHeader().setVisible(true);
		
//      cellConstraints.xywh(int, int, int, int) x,y coordenadas w,h rowspan, colspan
	    add(table.getTableHeader(), cellConstraints.xyw(2, 2, 3));
	    add(table, cellConstraints.xyw(2, 3, 3));

	    JLabel consultarReservas = new JLabel("Reservas: 0");
	    JButton atualizarReservas = new JButton("Atualizar reservas");
	    add(consultarReservas, cellConstraints.xy(2, 4));
	    add(atualizarReservas, cellConstraints.xy(4, 4));
	    atualizarReservas.addActionListener(new AtualizarReservas(table, consultarReservas));
	    
	    JFormattedTextField quantidadeReservas = new JFormattedTextField(NumberFormat.getIntegerInstance());
	    quantidadeReservas.setText("0");
	    JButton efetuarReservas = new JButton("Efetuar reservas");
	    add(quantidadeReservas, cellConstraints.xy(2, 5));
	    add(efetuarReservas, cellConstraints.xy(4, 5));
	    efetuarReservas.addActionListener(new EfetuarReservas(table, quantidadeReservas, consultarReservas));
	    
	    JLabel consultarCompras = new JLabel("Compras: 0");
	    JButton atualizarCompras = new JButton("Atualizar Compra");
	    add(consultarCompras, cellConstraints.xy(2, 6));
	    add(atualizarCompras, cellConstraints.xy(4, 6));
	    atualizarCompras.addActionListener(new AtualizarCompras(table, consultarCompras));
	    
	    JFormattedTextField quantidadeCompras = new JFormattedTextField(NumberFormat.getIntegerInstance());
	    quantidadeCompras.setText("0");
	    JButton efetuarCompras = new JButton("Efetuar compra");
	    add(quantidadeCompras, cellConstraints.xy(2, 7));
	    add(efetuarCompras, cellConstraints.xy(4, 7));
	    efetuarCompras.addActionListener(new EfetuarCompras(table, quantidadeCompras, consultarCompras));
	    
	    JLabel totalCompras = new JLabel("Compras totais: 0");
	    JButton atualizarTotalCompras = new JButton("Atualizar Compras Totais");
	    add(totalCompras, cellConstraints.xy(2, 8));
	    add(atualizarTotalCompras, cellConstraints.xy(4, 8));
	    atualizarTotalCompras.addActionListener(new AtualizarComprasTotais(table, totalCompras));
	    
	    JLabel totalReservas = new JLabel("Reservas totais: 0");
	    JButton atualizarTotalReservas = new JButton("Atualizar Reservas Totais");
	    add(totalReservas, cellConstraints.xy(2, 9));
	    add(atualizarTotalReservas, cellConstraints.xy(4, 9));
	    atualizarTotalReservas.addActionListener(new AtualizarReservasTotais(table, totalReservas));

	    pack();
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationByPlatform(true);
	    setResizable(false);
		setVisible(true);
	}
	
}
