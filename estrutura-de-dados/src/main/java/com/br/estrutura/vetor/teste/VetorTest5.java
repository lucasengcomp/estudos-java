package com.br.estrutura.vetor.teste;

import com.br.estrutura.vetor.Vetor;

public class VetorTest5 {

    public static void main(String[] args) {
        Vetor vetor = new Vetor(3);

        vetor.adiciona("B");
        vetor.adiciona("C");
        vetor.adiciona("E");
        vetor.adiciona("F");
        vetor.adiciona("G");

        System.out.println(vetor);
    }
}
