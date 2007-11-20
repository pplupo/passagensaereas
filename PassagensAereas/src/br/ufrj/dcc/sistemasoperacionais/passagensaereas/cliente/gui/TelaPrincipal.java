package br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui;

/*import java.awt.Dimension;
import java.net.InetAddress;
import java.net.UnknownHostException;*/
import java.text.NumberFormat;

/*import javax.swing.JButton;
import javax.swing.JFormattedTextField;*/
import javax.swing.JFrame;
/*import javax.swing.JLabel;
import javax.swing.JTable;*/
import javax.swing.UIManager;
/*import javax.swing.table.DefaultTableModel;*/

import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui.listeners.AtualizarCompras;
import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui.listeners.AtualizarComprasTotais;
import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui.listeners.AtualizarReservas;
import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui.listeners.AtualizarReservasTotais;
import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui.listeners.Conectar;
import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui.listeners.ConsultaVagas;
import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui.listeners.EfetuarCompras;
import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui.listeners.EfetuarReservas;

/*import com.activetree.view.AtIPAddressField;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;*/
import com.jgoodies.looks.plastic.PlasticXPLookAndFeel;
import com.jgoodies.looks.plastic.theme.Silver;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
/*	private JButton atualizarTotalReservas;
	private JButton atualizarReservas;
	private JButton atualizarTotalCompras;
	private JButton efetuarCompras;
	private JButton atualizarCompras;
	private JButton efetuarReservas;*/
	
    private javax.swing.JButton btnConectar;
    private javax.swing.JButton btnConsultaAssentos;
    private javax.swing.JButton btnConsultaCompras;
    private javax.swing.JButton btnConsultaReservas;
    private javax.swing.JButton btnConsultaTotalCompras;
    private javax.swing.JButton btnConsultaTotalReservas;
    private javax.swing.JButton btnEfetuaCompra;
    private javax.swing.JButton btnEfetuaReserva;
    private javax.swing.JLabel lblTrechosExistentes;
    private javax.swing.JLabel lblTrechoSelecionado;
    private javax.swing.JLabel lblNumeroAssentosReserva;
    private javax.swing.JLabel lblNumeroAssentosCompra;
    private javax.swing.JLabel lblOperacoes;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel pnlFuncionalidades;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTable tabTrechos;
    private javax.swing.JFormattedTextField txtNumeroAssentosCompra;
    private javax.swing.JFormattedTextField txtNumeroAssentosReserva;
    private javax.swing.JTextField txtServidor;
	
/*	private void InicializarComponentesAntigo () {
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
        
//        conectar.addActionListener(new Conectar(table, ip, this));
        
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
	    //atualizarTotalCompras.addActionListener(new AtualizarComprasTotais(table, consultarCompras, totalCompras));
	    
	    JLabel totalReservas = new JLabel("Reservas totais: ");
	    totalReservas.setPreferredSize(new Dimension(100, 14));
	    atualizarTotalReservas = new JButton("Atualizar Reservas Totais");
	    add(totalReservas, cellConstraints.xy(2, 11));
	    add(atualizarTotalReservas, cellConstraints.xy(4, 11));
	    //atualizarTotalReservas.addActionListener(new AtualizarReservasTotais(table, consultarReservas, totalReservas));
	    
		atualizarTotalReservas.setEnabled(false);
		atualizarReservas.setEnabled(false);
		atualizarTotalCompras.setEnabled(false);
		efetuarCompras.setEnabled(false);
		atualizarCompras.setEnabled(false);
		efetuarReservas.setEnabled(false);
	}*/
	
	private void inicializarComponentesNovo() {
        pnlFuncionalidades = new javax.swing.JPanel();
        lblTrechosExistentes = new javax.swing.JLabel();
        btnConsultaAssentos = new javax.swing.JButton();
        btnConsultaReservas = new javax.swing.JButton();
        btnConsultaCompras = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lblTrechoSelecionado = new javax.swing.JLabel();
        btnEfetuaReserva = new javax.swing.JButton();
        lblNumeroAssentosReserva = new javax.swing.JLabel();
        txtNumeroAssentosReserva = new javax.swing.JFormattedTextField(NumberFormat.getIntegerInstance());
        lblNumeroAssentosCompra = new javax.swing.JLabel();
        txtNumeroAssentosCompra = new javax.swing.JFormattedTextField(NumberFormat.getIntegerInstance());
        btnEfetuaCompra = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        lblOperacoes = new javax.swing.JLabel();
        btnConsultaTotalReservas = new javax.swing.JButton();
        btnConsultaTotalCompras = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabTrechos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtServidor = new javax.swing.JTextField();
        btnConectar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        pnlFuncionalidades.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlFuncionalidades.setEnabled(false);
        pnlFuncionalidades.setMinimumSize(new java.awt.Dimension(0, 0));
        lblTrechosExistentes.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblTrechosExistentes.setText("Trechos existentes:");

        btnConsultaAssentos.setText("Consulta disponiblidade de assentos");

        btnConsultaReservas.setText("Consulta reservas j\u00e1 efetuadas");

        btnConsultaCompras.setText("Consulta compras j\u00e1 efetuadas");

        lblTrechoSelecionado.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblTrechoSelecionado.setText("Opera\u00e7\u00f5es no trecho selecionado:");

        btnEfetuaReserva.setText("Efetua reserva");

        lblNumeroAssentosReserva.setText("N\u00famero de Assentos :");

        txtNumeroAssentosReserva.setText("0");

        lblNumeroAssentosCompra.setText("N\u00famero de Assentos :");

        txtNumeroAssentosCompra.setText("0");

        btnEfetuaCompra.setText("Efetua compra");

        lblOperacoes.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblOperacoes.setText("Opera\u00e7\u00f5es relativas a todos os trechos:");

        btnConsultaTotalReservas.setText("Consulta total de reservas");

        btnConsultaTotalCompras.setText("Consulta total de compras");

        tabTrechos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Trecho", "Vagas"
            }
        ));
        jScrollPane1.setViewportView(tabTrechos);

        javax.swing.GroupLayout pnlFuncionalidadesLayout = new javax.swing.GroupLayout(pnlFuncionalidades);
        pnlFuncionalidades.setLayout(pnlFuncionalidadesLayout);
        pnlFuncionalidadesLayout.setHorizontalGroup(
            pnlFuncionalidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFuncionalidadesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFuncionalidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                    .addComponent(btnConsultaTotalReservas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                    .addComponent(lblTrechosExistentes, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblOperacoes, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTrechoSelecionado, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                    .addGroup(pnlFuncionalidadesLayout.createSequentialGroup()
                        .addGroup(pnlFuncionalidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNumeroAssentosCompra)
                            .addComponent(lblNumeroAssentosReserva))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFuncionalidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNumeroAssentosCompra)
                            .addComponent(txtNumeroAssentosReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFuncionalidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEfetuaCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                            .addComponent(btnEfetuaReserva, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)))
                    .addComponent(btnConsultaTotalCompras, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                    .addComponent(btnConsultaCompras, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                    .addComponent(btnConsultaReservas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                    .addComponent(btnConsultaAssentos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlFuncionalidadesLayout.setVerticalGroup(
            pnlFuncionalidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFuncionalidadesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTrechosExistentes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(lblTrechoSelecionado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultaAssentos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultaReservas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultaCompras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFuncionalidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlFuncionalidadesLayout.createSequentialGroup()
                        .addComponent(btnEfetuaReserva)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEfetuaCompra))
                    .addGroup(pnlFuncionalidadesLayout.createSequentialGroup()
                        .addGroup(pnlFuncionalidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNumeroAssentosReserva)
                            .addComponent(txtNumeroAssentosReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFuncionalidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNumeroAssentosCompra)
                            .addComponent(txtNumeroAssentosCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15)
                .addComponent(lblOperacoes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(btnConsultaTotalReservas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultaTotalCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel6.setText("Servidor:");

        txtServidor.setText("127.0.0.1");

        btnConectar.setText("Conectar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConectar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtServidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConectar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setText("Status:");

        lblStatus.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblStatus.setForeground(new java.awt.Color(0, 51, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
                    .addComponent(pnlFuncionalidades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFuncionalidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblStatus))
                .addContainerGap())
        );
        pack();
	}

	private void configuraEventos(){
		btnConectar.addActionListener(new Conectar(tabTrechos, txtServidor, this));
		btnConsultaAssentos.addActionListener(new ConsultaVagas(tabTrechos, lblStatus));
		btnConsultaReservas.addActionListener(new AtualizarReservas(tabTrechos, lblStatus));
		btnConsultaCompras.addActionListener(new AtualizarCompras(tabTrechos, lblStatus));
		btnEfetuaReserva.addActionListener(new EfetuarReservas(tabTrechos, txtNumeroAssentosReserva, lblStatus));
		btnEfetuaCompra.addActionListener(new EfetuarCompras(tabTrechos, txtNumeroAssentosCompra, lblStatus));
		btnConsultaTotalReservas.addActionListener(new AtualizarReservasTotais(tabTrechos, lblStatus));
		btnConsultaTotalCompras.addActionListener(new AtualizarComprasTotais(tabTrechos, lblStatus));		
	}
	
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
        
        inicializarComponentesNovo();
        configuraEventos();
        habilitarBotoes(false);
	    pack();
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationByPlatform(true);
	    setResizable(false);
		setVisible(true);
	}
	
	public void habilitarBotoes(boolean ativar) {
		btnConsultaAssentos.setEnabled(ativar);
		btnConsultaCompras.setEnabled(ativar);
		btnConsultaReservas.setEnabled(ativar);
		btnConsultaTotalCompras.setEnabled(ativar);
		btnConsultaTotalReservas.setEnabled(ativar);
		txtNumeroAssentosCompra.setEnabled(ativar);
		txtNumeroAssentosReserva.setEnabled(ativar);
		btnEfetuaReserva.setEnabled(ativar);		
		btnEfetuaCompra.setEnabled(ativar);
		lblTrechosExistentes.setEnabled(ativar);
		lblTrechoSelecionado.setEnabled(ativar);
		lblOperacoes.setEnabled(ativar);
		lblNumeroAssentosCompra.setEnabled(ativar);
		lblNumeroAssentosReserva.setEnabled(ativar);
		tabTrechos.setEnabled(ativar);
		
		if (!ativar) {
			lblStatus.setText("");			
	        tabTrechos.setModel(new javax.swing.table.DefaultTableModel(
	                new Object [][] {
	                    {null, null, null},
	                    {null, null, null},
	                    {null, null, null},
	                    {null, null, null},
	                    {null, null, null}
	                },
	                new String [] {
	                    "Id", "Trecho", "Vagas"
	                }
	            ));
		}
/*		atualizarTotalReservas.setEnabled(ativar);
		atualizarReservas.setEnabled(ativar);
		atualizarTotalCompras.setEnabled(ativar);
		efetuarCompras.setEnabled(ativar);
		atualizarCompras.setEnabled(ativar);
		efetuarReservas.setEnabled(ativar);*/
	}
	
}
