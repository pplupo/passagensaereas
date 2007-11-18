/*
 * ConexaoCliente.java
 *
 * Created on 15 de Novembro de 2007, 07:15
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package servidorpassagensaereas.funcionalidade;

import servidorpassagensaereas.comunicacao.ProtocoloServicoPassagensServidor;
import servidorpassagensaereas.comunicacao.SocketAdapter;

/**
 *
 * @author leone
 */
public class ConexaoCliente implements Runnable {
    
    private SocketAdapter socket;
    private ServicoPassagensServidor servico;
    
    /** Creates a new instance of ConexaoCliente */
    public ConexaoCliente(SocketAdapter socket, ServicoPassagensServidor servico) {
        this.socket = socket;
        this.servico = servico;
    }
    
    public void run() {
        ProtocoloServicoPassagensServidor protocoloNovaConexao = new ProtocoloServicoPassagensServidor(servico, socket);
        protocoloNovaConexao.processaEventos();
    }
}
