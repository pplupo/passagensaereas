/*
 * Main.java
 *
 * Created on 15 de Novembro de 2007, 04:44
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package servidorpassagensaereas;

import servidorpassagensaereas.comunicacao.SocketServidor;
import servidorpassagensaereas.funcionalidade.ServicoPassagensServidor;

/**
 *
 * @author leone
 */
public class Main {
    
    /** Creates a new instance of Main */
    public Main() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServicoPassagensServidor servico = new ServicoPassagensServidor();
        SocketServidor socketServidor = new SocketServidor(5000, servico);
        Thread thread = new Thread(socketServidor);
        thread.start();
    }
    
}
