package br.fai.threads;

import br.fai.service.Caminhao;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			Main app  = new Main();
			app.start();

	}
		private void start() {
			// TODO Auto-generated method stub
			Caminhao primeiroCaminhao = new Caminhao("jadlog", 1);
			Caminhao segundoCaminhao = new Caminhao("Fedex", 2);
			
			Thread threadDoPrimeiroCaminhao = new Thread(primeiroCaminhao);
			Thread threadDoSegundoCaminhao = new Thread(segundoCaminhao);
			
			threadDoPrimeiroCaminhao.start();
			threadDoSegundoCaminhao.start();
			
		}

}
