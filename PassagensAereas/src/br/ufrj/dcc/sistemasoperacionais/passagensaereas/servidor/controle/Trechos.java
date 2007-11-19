package br.ufrj.dcc.sistemasoperacionais.passagensaereas.servidor.controle;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class Trechos {

	private Map<Integer, Trecho> trechos;
	
	public Trechos(){
		trechos = new TreeMap<Integer, Trecho>();
	}
	
	public void adicionaTrecho(Integer id, String nomeTrecho, int assentos){
		trechos.put(id, new Trecho(id, nomeTrecho, assentos));
	}
	
	public String obtemTrechos() {
		StringBuilder resultado = new StringBuilder();
		for (Trecho trecho : trechos.values()) {
			resultado.append(trecho.getId());
			resultado.append("@");
			resultado.append(trecho.getNome());
			resultado.append("@");
			resultado.append(trecho.getVagas());
			resultado.append(";");
		}
		return resultado.toString();
	}
	
	public Trecho getTrecho(int trecho) {
		return trechos.get(trecho);
	}
	
	public Collection<Trecho> list() {
		return trechos.values();
	}
}
