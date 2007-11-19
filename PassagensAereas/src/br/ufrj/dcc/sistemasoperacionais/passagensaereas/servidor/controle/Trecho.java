package br.ufrj.dcc.sistemasoperacionais.passagensaereas.servidor.controle;

import java.util.concurrent.Semaphore;

public class Trecho {
	private String nome;
	private int numeroAssentos;
	private int numeroReservas = 0;
	private int numeroCompras = 0;
	private Reservas reservas;	
	private Semaphore semaforoBinario = new Semaphore(1, true);
	
	public Trecho(String nome, int numeroAssentos) {
		this.nome = nome;
		this.numeroAssentos = numeroAssentos;
		this.reservas = new Reservas(this);
	}
	
	public String getNome(){
		return nome;
	}
	
	public int getNumeroAssentos () {
		return numeroAssentos;
	}
	
	public void setNumeroCompras(int numeroCompras) {
		this.numeroCompras = numeroCompras;
	}
	
	public void setNumeroReservas(int numeroReservas) {
		this.numeroReservas = numeroReservas;
	}
	
	public int getNumeroReservas() {
		return numeroReservas;		
	}
	
	public int getNumeroCompras() {
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
	
	private void notificaAtualizacaoDeTrecho(Trecho trecho){
		System.out.println(
				" Trecho : " + trecho.getNome() + "; " + 				
				" Reservas(" +  trecho.getNumeroReservas() + "), " +
				" Compras (" + trecho.getNumeroCompras() + "), " +
				" Assentos (" + trecho.getNumeroAssentos() + "), " +
				" Disponiveis (" + (trecho.getNumeroAssentos() - trecho.getNumeroCompras()) + ")." );
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
	
}
