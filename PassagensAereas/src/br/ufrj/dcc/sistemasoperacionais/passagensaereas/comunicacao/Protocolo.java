package br.ufrj.dcc.sistemasoperacionais.passagensaereas.comunicacao;

public enum Protocolo {

	OBTEM_TRECHOS(1),
	COMPRA_TRECHO(4),
	RESERVA_TRECHO(3),
	CONSULTA_RESERVA(5),
	CONSULTA_COMPRAS(6),
	OBTEM_VAGAS_NO_TRECHO(2),
	CONSULTA_TOTAL_RESERVAS(7),
	CONSULTA_TOTAL_COMPRAS(8);
	
	int comando;
	
	Protocolo (int comando) {
		this.comando = comando;
	}
	
	int getComando() {
		return comando;
	}
	
	static Protocolo getProtocolo (int comando) {
		switch (comando) {
			case 1: return OBTEM_TRECHOS;
			case 4: return COMPRA_TRECHO;
			case 3: return RESERVA_TRECHO;
			case 5: return CONSULTA_RESERVA;
			case 6: return CONSULTA_COMPRAS;
			case 2: return OBTEM_VAGAS_NO_TRECHO;
			case 7: return CONSULTA_TOTAL_RESERVAS;
			case 8: return CONSULTA_TOTAL_COMPRAS;
			default: return OBTEM_TRECHOS;
		}
	}
}
