package br.ufrj.dcc.sistemasoperacionais.passagensaereas.servidor.controle;

import java.util.ArrayList;
import java.util.List;

public class Trechos {

	private List<Trecho> trechos;
	
	public Trechos(){
		trechos = new ArrayList<Trecho>();
	}
	
	public void adicionaTrecho(String nomeTrecho, int numeroDeAssentos){
		trechos.add(new Trecho(nomeTrecho, numeroDeAssentos));		
	}
	
	public String obtemTrechos() {
		StringBuilder resultado = new StringBuilder();
		for (Trecho trecho : trechos) {			
			resultado.append(trecho.getNome());
			resultado.append(";");
		}
		return resultado.toString();
	}
	
	public Trecho getTrecho(int trecho) {
		if (trecho < trechos.size()) {
			return trechos.get(trecho);
		} else {
			return null;
		}
	}
	
	
	

}
