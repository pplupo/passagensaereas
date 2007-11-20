package br.ufrj.dcc.sistemasoperacionais.passagensaereas.servidor.controle;

import java.util.concurrent.Semaphore;

import br.ufrj.dcc.sistemasoperacionais.passagensaereas.servidor.gui.TelaPrincipal;

public class Trecho {
	private String nome;
	private int id;
	private int numeroAssentos;
	private int numeroReservas = 0;
	private int numeroCompras = 0;
	private Reservas reservas;	
	private Semaphore semaforoBinario = new Semaphore(1, true);
	
	public Trecho(int id, String nome, int numeroAssentos) {
		this.id = id;
		this.nome = nome;
		this.numeroAssentos = numeroAssentos;
		this.reservas = new Reservas(this);
	}
	
	public String getNome(){
		return nome;
	}
	
	public int getAssentos () {
		return numeroAssentos;
	}
	
	public int getVagas() {
		return (int)numeroAssentos - numeroCompras - numeroReservas;
	}
	
	public void setCompras(int numeroCompras) {
		this.numeroCompras = numeroCompras;
	}
	
	public void setReservas(int numeroReservas) {
		this.numeroReservas = numeroReservas;
	}
	
	public int getReservas() {
		return numeroReservas;
	}
	
	public int getCompras() {
		return numeroCompras;
	}
	
	public void bloqueiaTrecho(){
		try {
			semaforoBinario.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void desbloqueiaTrecho(){
		notificaAtualizacaoDeTrecho(this);
		semaforoBinario.release();
	}
	
	private static void notificaAtualizacaoDeTrecho(Trecho trecho){
		TelaPrincipal.getInstance().atualizaTrecho(trecho);
	}
	
	public boolean adicionaReserva(Object cliente, int numeroDeAssentos){
		bloqueiaTrecho();
		boolean resultado = reservas.adicionaReserva(cliente, numeroDeAssentos);
		desbloqueiaTrecho();
		return resultado;
	}
	
	public boolean efetuaCompra(Object cliente, int numeroDeAssentos) {
		bloqueiaTrecho();
		boolean resultado = reservas.efetuaCompra(cliente, numeroDeAssentos);
		desbloqueiaTrecho();
		return resultado;
	}

	public int getId() {
		return id;
	}
	
}
