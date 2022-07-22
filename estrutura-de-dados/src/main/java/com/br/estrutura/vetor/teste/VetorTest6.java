package com.br.estrutura.vetor.teste;

import com.br.estrutura.vetor.Vetor;
import jdk.swing.interop.SwingInterOpUtils;

public class VetorTest6 {

    public static void main(String[] args) {
        Vetor vetor = new Vetor(3);

        vetor.adiciona("B");
        vetor.adiciona("G");
        vetor.adiciona("D");
        vetor.adiciona("E");
        vetor.adiciona("F");

        System.out.println(vetor);

        vetor.remove(1);

        System.out.println(vetor);

        System.out.println("Remover o elemento D");
        int posicao = vetor.busca("J");

        if (posicao >= 0) {
            vetor.remove(posicao);
        } else {
            System.out.println("Elemento não existe no vetor");
        }
        System.out.println(vetor);
    }
}
