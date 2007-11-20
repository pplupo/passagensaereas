package br.ufrj.dcc.sistemasoperacionais.passagensaereas.servidor.gui;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import br.ufrj.dcc.sistemasoperacionais.passagensaereas.servidor.controle.Servidor;
import br.ufrj.dcc.sistemasoperacionais.passagensaereas.servidor.controle.Trecho;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.looks.plastic.PlasticXPLookAndFeel;
import com.jgoodies.looks.plastic.theme.Silver;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private static TelaPrincipal instance;
	
	private JTable table;
	
	public static TelaPrincipal getInstance(){
		if (instance == null) {
			instance = new TelaPrincipal();
		}
		return instance;
	}

	private TelaPrincipal(){
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
        
        setTitle("Servidor");

//		dlu unidade de tamanho
//		pref tamanho preferencial
//		max(15dlu;pref):grow(0.5)
//		max(x;y) maior entre x e y
//		:grow(0.x) rate de aumento no resize
//		top:Xdlu align top
//		bottom:Xdlu align bottom
        FormLayout layout = new FormLayout("4dlu, pref, 4dlu", 
    										"4dlu, pref, pref, 4dlu");
        setLayout(layout);
        
        CellConstraints cellConstraints = new CellConstraints();
        table = new JTable();
        
        DefaultTableModel tableModel = new DefaultTableModel();
        table.setModel(tableModel);		
        tableModel.addColumn("ID");
        tableModel.addColumn("Trechos");
        tableModel.addColumn("Reservas");
        tableModel.addColumn("Compras");
        tableModel.addColumn("Assentos");
        tableModel.addColumn("Vagas");
        
		for (Trecho trecho : Servidor.getServico().getTrechos().list()) {
			tableModel.addRow(new Object[] {trecho.getId(), trecho.getNome(), trecho.getReservas(), trecho.getCompras(), trecho.getAssentos(), trecho.getVagas()});
		}
		
		table.getTableHeader().setEnabled(true);
		table.getTableHeader().setVisible(true);
		
//      cellConstraints.xywh(int, int, int, int) x,y coordenadas w,h rowspan, colspan
	    add(table.getTableHeader(), cellConstraints.xy(2, 2));
	    add(table, cellConstraints.xy(2, 3));

	    pack();
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationByPlatform(true);
		setVisible(true);
		setResizable(false);
	}
	
	public void atualizaTrecho(Trecho trecho) {
		int linha = trecho.getId() - 1;
		TableModel tableModel = table.getModel();

		tableModel.setValueAt(trecho.getReservas(), linha, 2);
		tableModel.setValueAt(trecho.getCompras(), linha, 3);
		tableModel.setValueAt(trecho.getAssentos(), linha, 4);
		tableModel.setValueAt(trecho.getVagas(), linha, 5);
	}
}
