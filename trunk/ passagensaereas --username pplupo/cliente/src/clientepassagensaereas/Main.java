/*
 * Main.java
 *
 * Created on 16 de Novembro de 2007, 11:04
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package clientepassagensaereas;


import java.util.List;

import clientepassagensaereas.comunicacao.Socket2;
import clientepassagensaereas.funcionalidade.ServicoPassagensCliente;
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
        try {
            Socket2 socket = new Socket2();
            socket.ConnectTo("localhost", 5000);
            ServicoPassagensCliente servico = new ServicoPassagensCliente(socket);
            List trechos = servico.ObtemTrechos();
            int i;
            for (i = 0; i < trechos.size(); i++) 
                System.out.println((String)trechos.get(i));
            int t = servico.ConsultaCompras(3);
            System.out.println(t);
        }catch (Exception ex){
            System.err.println("Erro de conexão com o servidor...");
        }
    }
    
}
