package br.ufrj.dcc.sistemasoperacionais.passagensaereas.servidor.controle;

public class ServicoPassagensServidor {
    
    public synchronized String obtemTrechos() {
        return "RJ-SP;RJ-SA;RJ-BH;RJ-DF;RJ-MN;";
    }
    
    public synchronized int obtemVagasNoTrecho(int trecho) {
        return 0;
    }
    
    public synchronized boolean reservaTrecho(int numeroDeAssentos, int trecho) {
        return false;
    }   
    
    public synchronized boolean compraTrecho(int trecho, int numeroDeAssentos) {
        return false;
    }
    
    public synchronized int consultaReserva(int trecho){
        return 0;
    }
    
    public synchronized int consultaCompras(int trecho){
        return 0;
    }
}
