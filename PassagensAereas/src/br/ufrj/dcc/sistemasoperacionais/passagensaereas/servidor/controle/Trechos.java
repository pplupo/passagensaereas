package br.ufrj.dcc.sistemasoperacionais.passagensaereas.servidor.controle;

import java.util.ArrayList;

public class Trechos {

	private ArrayList<Trecho> trechos;
	
	public Trechos(){
		trechos = new ArrayList<Trecho>();
	}
	
	public void adicionaTrecho(String nomeTrecho, int numeroDeAssentos){
		trechos.add(new Trecho(nomeTrecho, numeroDeAssentos));		
	}
	
	public String obtemTrechos() {
		String resultado = "";
		int i = 0;
		while (i < trechos.size()) {			
			resultado += trechos.get(i).getNome() + ";";
			i++;
		}
		return resultado;
	}
	
	public Trecho getTrecho(int trecho) {
		if (trecho < trechos.size())
			return trechos.get(trecho);
		else
			return null;
	}
	
	
	

}
