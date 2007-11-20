package br.ufrj.dcc.sistemasoperacionais.passagensaereas.servidor.controle;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerLiberacaoReserva {
	private Timer timer;
	private Reserva reserva;
	private Trecho trecho; 
	private Reservas reservas;
	
	public TimerLiberacaoReserva(Reserva reserva, Reservas reservas, Trecho trecho, int numeroDeSegundos){
		timer = new Timer();
		this.reserva = reserva;
		this.trecho = trecho;
		this.reservas = reservas;

		int numMilisegundos = numeroDeSegundos * 1000;		
	    Date horaExecucao = new Date(System.currentTimeMillis()+numMilisegundos);		
		timer.schedule(new RunTimerTask(), horaExecucao);
	}
	
	public void CancelaTimer(){
		timer.cancel();
	}	
	
	 private class RunTimerTask extends TimerTask
	  {
	    public final void run()
	    {
        	trecho.bloqueiaTrecho();
        	reservas.removeReserva(reserva);	        	
        	trecho.desbloqueiaTrecho();
        	CancelaTimer();
	    }
	  }	
	

}
