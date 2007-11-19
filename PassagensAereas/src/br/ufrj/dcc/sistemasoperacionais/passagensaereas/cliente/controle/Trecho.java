package br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.controle;

public class Trecho implements Comparable<Trecho>{

	private int id;
	private String nome;
	private int vagasDisponiveis;
	
	public Trecho(int id, String nome, int vagasDisponiveis) {
		this.id = id;
		this.nome = nome;
		this.vagasDisponiveis = vagasDisponiveis;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getVagasDisponiveis() {
		return vagasDisponiveis;
	}

	public int compareTo(Trecho o) {
		return new Integer(id).compareTo(o.id);
	}
	
	@Override
	public String toString() {
		return "ID=" + id + " nome=" + nome + " vagas=" + vagasDisponiveis;
	}
}
