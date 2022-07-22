package com.br.estrutura.vetor.teste;

import com.br.estrutura.vetor.VetorObject;

public class VetorTest7 {

    public static void main(String[] args) {
        VetorObject vetor = new VetorObject(3);

        Contato contato1 = new Contato("Pessoa 1", "6291234-5678","emailpessoa1@email.com");
        Contato contato2 = new Contato("Pessoa 2", "6290000-5678","emailpessoa2@email.com");
        Contato contato3 = new Contato("Pessoa 3", "6291111-5678","emailpessoa3@email.com");

        vetor.adiciona(contato1);
        vetor.adiciona(contato2);
        vetor.adiciona(contato3);

        System.out.println("Tamanho = " + vetor.tamanho());
        System.out.println(vetor);

        int posicao = vetor.busca(contato1);

        if (posicao > 0) {
            System.out.println("Elemento existe no vetor");
        } else {
            System.out.println("Elemento não existe no vetor");
        }
    }
}
