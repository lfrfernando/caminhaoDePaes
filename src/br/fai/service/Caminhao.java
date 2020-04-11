package br.fai.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Caminhao implements Runnable {
	private String nome;
	private int intervalo;
	
	private Map<Integer, Integer> limiteDeCadaCaixa = new HashMap<Integer, Integer>();
    
	private Map<Integer, ArrayList<Integer>> caixaDePaes = new HashMap<Integer, ArrayList<Integer>>();
	
	private final int MAX_CAIXAS = 4;
	
    public Caminhao(String nome, int intervalo) {

		this.nome = nome;
		this.intervalo = intervalo * 1000;
}
    @Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("caminhão" + this.nome + "começou a ser carregado....");
		
		
		setarLimitesDeCaixa();
		
		int numeroDaCaixa = 1;
		
		while (numeroDaCaixa <= MAX_CAIXAS ) {
			
			carregarOCaminhao(numeroDaCaixa);
			System.out.println("a caixa " + numeroDaCaixa + "do caminho" + this.nome + "terminou de carregar");
			
			
			numeroDaCaixa += 1;
		}
		System.out.println("Caminhao " + this.nome + "terminou de ser carregado");
	}
		
		
		private void setarLimitesDeCaixa() {
			
			limiteDeCadaCaixa.put(1, 4);
			limiteDeCadaCaixa.put(2, 2);
			limiteDeCadaCaixa.put(3, 5);
			limiteDeCadaCaixa.put(4, 6);
			
			
			
		}
		
		private void carregarOCaminhao(int numeroDaCaixa) {
			
			caixaDePaes.put(numeroDaCaixa, new ArrayList<Integer>());
			
			int capacidadeDaCaixa  = limiteDeCadaCaixa.get(numeroDaCaixa);
			
			for(int i = 0 ; i < capacidadeDaCaixa; i++) {
			
				caixaDePaes.get(numeroDaCaixa).add(i);
				
				try {
					Thread.sleep(this.intervalo);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("O pão" + i + "foi inserido na caixa de numero" + numeroDaCaixa + "no caminhão" +this.nome);
				
				
		}

	}
}
