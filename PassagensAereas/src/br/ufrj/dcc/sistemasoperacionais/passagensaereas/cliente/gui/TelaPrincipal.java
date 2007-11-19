package br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.controle.Cliente;
import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.controle.Trecho;

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
        FormLayout layout = new FormLayout("4dlu, pref, 4dlu", 
    										"4dlu, pref, pref, 4dlu");
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
	    add(table.getTableHeader(), cellConstraints.xy(2, 2));
	    add(table, cellConstraints.xy(2, 3));

	    pack();
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationByPlatform(true);
		setVisible(true);
	}
	
}
