package br.ufrj.dcc.sistemasoperacionais.passagensaereas.servidor.controle;

public class ServicoPassagensServidor {
	
	private Trechos trechos;

	public ServicoPassagensServidor() {
		trechos = new Trechos();
		trechos.adicionaTrecho("RJ-SP", 100);
		trechos.adicionaTrecho("RJ-SA", 50);
		trechos.adicionaTrecho("RJ-BH", 30);
		trechos.adicionaTrecho("RJ-BR", 100);
		trechos.adicionaTrecho("RJ-MN", 20);
	}
    
    public synchronized String obtemTrechos() {
		return trechos.obtemTrechos();
    }
    
    public synchronized int obtemVagasNoTrecho(int trecho) {
		Trecho objTrecho = trechos.getTrecho(trecho);
		return (objTrecho != null ? objTrecho.getNumeroAssentos() : -1);
    }
    
    public synchronized boolean reservaTrecho(int numeroDeAssentos, int trecho, Object cliente) {
		Trecho objTrecho = trechos.getTrecho(trecho);
		return (objTrecho != null ? objTrecho.adicionaReserva(cliente, numeroDeAssentos) : false);
    }   
    
    public synchronized boolean compraTrecho(int trecho, int numeroDeAssentos, Object cliente) {
		Trecho objTrecho = trechos.getTrecho(trecho);
		return (objTrecho != null ? objTrecho.efetuaCompra(cliente, numeroDeAssentos) : false);
    }
    
    public synchronized int consultaReserva(int trecho){
		Trecho objTrecho = trechos.getTrecho(trecho);
		return (objTrecho != null ? objTrecho.getNumeroReservas() : -1);
    }
    
    public synchronized int consultaCompras(int trecho){
		Trecho objTrecho = trechos.getTrecho(trecho);
		return (objTrecho != null ? objTrecho.getNumeroCompras() : -1);
    }
}
