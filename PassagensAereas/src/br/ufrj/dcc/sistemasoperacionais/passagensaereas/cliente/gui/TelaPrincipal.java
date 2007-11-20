package br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui.listeners.AtualizarCompras;
import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui.listeners.AtualizarComprasTotais;
import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui.listeners.AtualizarReservas;
import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui.listeners.AtualizarReservasTotais;
import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui.listeners.Conectar;
import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui.listeners.EfetuarCompras;
import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui.listeners.EfetuarReservas;

import com.activetree.view.AtIPAddressField;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.looks.plastic.PlasticXPLookAndFeel;
import com.jgoodies.looks.plastic.theme.Silver;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JButton atualizarTotalReservas;
	private JButton atualizarReservas;
	private JButton atualizarTotalCompras;
	private JButton efetuarCompras;
	private JButton atualizarCompras;
	private JButton efetuarReservas;

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
    										"4dlu, pref, 2dlu, pref, pref, pref, pref, pref, pref, pref, pref pref, pref, pref, pref, pref, 4dlu");
        setLayout(layout);
        
        CellConstraints cellConstraints = new CellConstraints();
        
//      cellConstraints.xywh(int, int, int, int) x,y coordenadas w,h rowspan, colspan
        String enderecoIP = "";
        try {
        	enderecoIP = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
        	enderecoIP = "127.0.0.1";
        	e.printStackTrace();
        }
        AtIPAddressField ip = new AtIPAddressField(enderecoIP);
        JButton conectar = new JButton("Conectar");
        add(ip, cellConstraints.xy(2,2));
        add(conectar, cellConstraints.xy(4,2));
        
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Trechos");
        tableModel.addColumn("Vagas");
        
        JTable table = new JTable();
        table.setModel(tableModel);
        
        table.getColumnModel().getColumn(0).setMaxWidth(20);
        table.getColumnModel().getColumn(1).setMaxWidth(300);
        table.getColumnModel().getColumn(2).setMaxWidth(40);
        
        for (int i = 0; i < 5; i++) {
			tableModel.addRow(new Object[] {"", "", ""});
		}
        
	    add(table.getTableHeader(), cellConstraints.xyw(2, 4, 3));
	    add(table, cellConstraints.xyw(2, 5, 3));
        table.setGridColor(table.getBackground());
		table.getTableHeader().setEnabled(true);
		table.getTableHeader().setVisible(true);
        
        conectar.addActionListener(new Conectar(table, ip, this));
        
//        try {
//			for (Trecho trecho : Cliente.getInstance().obtemTrechos()) {
//				tableModel.addRow(new Object[] {trecho.getId(), trecho.getNome(), trecho.getVagasDisponiveis()});
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

	    JLabel consultarReservas = new JLabel("Reservas: ");
	    consultarReservas.setPreferredSize(new Dimension(100, 14));
	    atualizarReservas = new JButton("Atualizar reservas");
	    add(consultarReservas, cellConstraints.xy(2, 6));
	    add(atualizarReservas, cellConstraints.xy(4, 6));
	    atualizarReservas.addActionListener(new AtualizarReservas(table, consultarReservas));
	    
	    JFormattedTextField quantidadeReservas = new JFormattedTextField(NumberFormat.getIntegerInstance());
	    quantidadeReservas.setText("0");
	    efetuarReservas = new JButton("Efetuar reservas");
	    add(quantidadeReservas, cellConstraints.xy(2, 7));
	    add(efetuarReservas, cellConstraints.xy(4, 7));
	    efetuarReservas.addActionListener(new EfetuarReservas(table, quantidadeReservas, consultarReservas));
	    
	    JLabel consultarCompras = new JLabel("Compras: ");
	    consultarCompras.setPreferredSize(new Dimension(100, 14));
	    atualizarCompras = new JButton("Atualizar Compra");
	    add(consultarCompras, cellConstraints.xy(2, 8));
	    add(atualizarCompras, cellConstraints.xy(4, 8));
	    atualizarCompras.addActionListener(new AtualizarCompras(table, consultarCompras));
	    
	    JFormattedTextField quantidadeCompras = new JFormattedTextField(NumberFormat.getIntegerInstance());
	    quantidadeCompras.setText("0");
	    efetuarCompras = new JButton("Efetuar compra");
	    add(quantidadeCompras, cellConstraints.xy(2, 9));
	    add(efetuarCompras, cellConstraints.xy(4, 9));
	    efetuarCompras.addActionListener(new EfetuarCompras(table, quantidadeCompras, consultarCompras));
	    
	    JLabel totalCompras = new JLabel("Compras totais: ");
	    totalCompras.setPreferredSize(new Dimension(100, 14));
	    atualizarTotalCompras = new JButton("Atualizar Compras Totais");
	    add(totalCompras, cellConstraints.xy(2, 10));
	    add(atualizarTotalCompras, cellConstraints.xy(4, 10));
	    atualizarTotalCompras.addActionListener(new AtualizarComprasTotais(table, totalCompras));
	    
	    JLabel totalReservas = new JLabel("Reservas totais: ");
	    totalReservas.setPreferredSize(new Dimension(100, 14));
	    atualizarTotalReservas = new JButton("Atualizar Reservas Totais");
	    add(totalReservas, cellConstraints.xy(2, 11));
	    add(atualizarTotalReservas, cellConstraints.xy(4, 11));
	    atualizarTotalReservas.addActionListener(new AtualizarReservasTotais(table, totalReservas));
	    
		atualizarTotalReservas.setEnabled(false);
		atualizarReservas.setEnabled(false);
		atualizarTotalCompras.setEnabled(false);
		efetuarCompras.setEnabled(false);
		atualizarCompras.setEnabled(false);
		efetuarReservas.setEnabled(false);

	    pack();
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationByPlatform(true);
	    setResizable(false);
		setVisible(true);
	}
	
	public void habilitarBotoes() {
		atualizarTotalReservas.setEnabled(true);
		atualizarReservas.setEnabled(true);
		atualizarTotalCompras.setEnabled(true);
		efetuarCompras.setEnabled(true);
		atualizarCompras.setEnabled(true);
		efetuarReservas.setEnabled(true);
	}
	
}
