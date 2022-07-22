package com.br.estrutura.vetor.teste;

import com.br.estrutura.vetor.Vetor;

public class VetorTest2 {

	public static void main(String[] args) {
		Vetor vetor = new Vetor(10);

		vetor.adiciona("Elemento 1");
		vetor.adiciona("Elemento 2");
		vetor.adiciona("Elemento 3");
		
		System.out.println("Vetor de tamanho " + vetor.tamanho());
		System.out.println(vetor.toString());
	}
}
