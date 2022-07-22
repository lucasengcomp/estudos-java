package com.br.estrutura.vetor.teste;

import com.br.estrutura.vetor.Vetor;

public class VetorTest4 {

    public static void main(String[] args) {
        Vetor vetor = new Vetor(10);

        vetor.adiciona("B");
        vetor.adiciona("C");
        vetor.adiciona("E");
        vetor.adiciona("F");
        vetor.adiciona("G");

        System.out.println(vetor);

        vetor.adiciona(0, "A");
        vetor.adiciona(3, "D");

        System.out.println(vetor);

    }
}
