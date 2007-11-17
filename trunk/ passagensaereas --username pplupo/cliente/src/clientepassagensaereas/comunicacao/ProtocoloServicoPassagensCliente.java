/*
 * ProtocoloServicoPassagensServidor.java
 *
 * Created on 15 de Novembro de 2007, 04:49
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package clientepassagensaereas.comunicacao;

import java.io.IOException;
/**
 *
 * @author leone
 */
public class ProtocoloServicoPassagensCliente {
    
    private Socket2 socket;
    private final int c_ObtemTrechos       = 1;
    private final int c_CompraTrecho       = 4;
    private final int c_ReservaTrecho      = 3;
    private final int c_ConsultaReserva    = 5;
    private final int c_ConsultaCompras    = 6;
    private final int c_ObtemVagasNoTrecho = 2;
    
    
    /** Creates a new instance of ProtocoloServicoPassagensCliente */
    public ProtocoloServicoPassagensCliente(Socket2 aSocket) {
        socket  = aSocket;
    }
    
    public String ObtemTrechos() throws IOException {
        socket.SendInt(c_ObtemTrechos);
        return socket.ReadString();
    }
    
    public int ObtemVagasNoTrecho(int aTrecho) throws IOException {
        socket.SendInt(c_ObtemVagasNoTrecho);
        socket.SendInt(aTrecho);
        return socket.ReadInt();
    }
    
    public boolean ReservaTrecho(int aNumeroAssentos, int aTrecho) throws IOException {
        socket.SendInt(c_ReservaTrecho);
        socket.SendInt(aNumeroAssentos);
        socket.SendInt(aTrecho);
        return socket.ReadBoolean();
    }
    
    public boolean CompraTrecho(int aNumeroAssentos, int aTrecho) throws IOException {
        socket.SendInt(c_CompraTrecho);
        socket.SendInt(aNumeroAssentos);
        socket.SendInt(aTrecho);
        return socket.ReadBoolean();
    }
    
    public int ConsultaReserva(int aTrecho) throws IOException {
        socket.SendInt(c_ConsultaReserva);
        socket.SendInt(aTrecho);
        return socket.ReadInt();
    }
    
    public int ConsultaCompras(int aTrecho) throws IOException {
        socket.SendInt(c_ConsultaCompras);
        socket.SendInt(aTrecho);
        return socket.ReadInt();
    }
    
}
