/*
 * ServicoPassagensServidor.java
 *
 * Created on 15 de Novembro de 2007, 05:32
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package servidorpassagensaereas.funcionalidade;

/**
 *
 * @author leone
 */
public class ServicoPassagensServidor {
    
    /** Creates a new instance of ServicoPassagensServidor */
    public ServicoPassagensServidor() {
    }
    
    public String ObtemTrechos() {
        return "RJ-SP;RJ-SA;RJ-BH;RG-BR;RJ-MN;";
    }
    
    public int ObtemVagasNoTrecho(int aTrecho) {
        return 0;
    }
    
    public boolean ReservaTrecho(int aNumeroDeAssentos, int aTrecho) {
        return false;
    }   
    
    public boolean CompraTrecho(int aTrecho, int aNumeroDeAssentos) {
        return false;
    }
    
    public int ConsultaReserva(int aTrecho){
        return 0;        
    }
    
    public int ConsultaCompras(int aTrecho){
        return 0;
    }
}
