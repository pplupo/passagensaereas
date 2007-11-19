package br.ufrj.dcc.sistemasoperacionais.passagensaereas.servidor;

import java.io.IOException;

import br.ufrj.dcc.sistemasoperacionais.passagensaereas.servidor.controle.Servidor;
import br.ufrj.dcc.sistemasoperacionais.passagensaereas.servidor.gui.TelaPrincipal;

public class ServidorMain {
    
    public static void main(String[] args) throws IOException {
    	Servidor.getInstance();
    	TelaPrincipal.getInstance();
    }
    
}