package br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui;

import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.UIManager;

import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.controle.Cliente;

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
    										"4dlu, pref, 4dlu");
        setLayout(layout);
        
        CellConstraints cellConstraints = new CellConstraints();
        DefaultListModel listModel = new DefaultListModel();
        JList list = new JList(listModel);
        try {
			for (String trecho : Cliente.getInstance().obtemTrechos()) {
				listModel.addElement(trecho);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
//      cellConstraints.xywh(int, int, int, int) x,y coordenadas w,h rowspan, colspan
	    add(list, cellConstraints.xy(2, 2));    

	    pack();
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationByPlatform(true);
		setVisible(true);
	}
	
}
