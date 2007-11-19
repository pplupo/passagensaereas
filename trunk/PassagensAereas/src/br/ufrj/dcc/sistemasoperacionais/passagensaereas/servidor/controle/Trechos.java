package br.ufrj.dcc.sistemasoperacionais.passagensaereas.servidor.controle;

import java.util.HashMap;
import java.util.Map;

public class Trechos {

	private Map<Integer, Trecho> trechosId;
	
	public Trechos(){
		trechosId = new HashMap<Integer, Trecho>();
	}
	
	public void adicionaTrecho(Integer id, String nomeTrecho, int assentos){
		trechosId.put(id, new Trecho(nomeTrecho, assentos));
	}
	
	public String obtemTrechos() {
		StringBuilder resultado = new StringBuilder();
		for (Map.Entry<Integer, Trecho> trecho : trechosId.entrySet()) {
			resultado.append(trecho.getKey());
			resultado.append("@");
			resultado.append(trecho.getValue().getNome());
			resultado.append("@");
			resultado.append(trecho.getValue().getVagas());
			resultado.append(";");
		}
		return resultado.toString();
	}
	
	public Trecho getTrecho(int trecho) {
		return trechosId.get(trecho);
	}
	
}
