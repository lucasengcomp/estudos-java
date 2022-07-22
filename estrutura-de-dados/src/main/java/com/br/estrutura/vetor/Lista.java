package com.br.estrutura.vetor;

import java.lang.reflect.Array;

public class Lista<T> {


    private T[] elementos;
    private int tamanho;

    public Lista(int capacidade) {
        this.elementos = (T[]) new Object[capacidade];
        this.tamanho = 0;
    }

    public Lista(int capacidade, Class<T> tipoDaClase) {
        this.elementos = (T[]) Array.newInstance(tipoDaClase, capacidade);
        this.tamanho = 0;
    }

    public boolean adiciona(T elemento) {
        this.aumentaCapacidade();

        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
            return true;
        }
        return false;
    }

    public void adiciona(int posicao, T elemento) {
        this.verificaSePosicaoEValida(posicao);
        this.aumentaCapacidade();

        for (int i = this.tamanho; i >= posicao; i--) {
            this.elementos[i + 1] = this.elementos[i];
        }
        this.elementos[posicao] = elemento;
        this.tamanho++;
    }

    private void aumentaCapacidade() {
        if (this.tamanho == this.elementos.length) {
            Object[] elementosNovos = (T[]) new Object[this.elementos.length * 2];

            for (int i = 0; i < this.elementos.length; i++) {
                elementosNovos[i] = this.elementos[i];
            }
            this.elementos = (T[]) elementosNovos;
        }
    }

    public int tamanho() {
        return this.tamanho;
    }

    public int busca(Object elemento) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.elementos[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    public Object busca(int posicao) {
        verificaSePosicaoEValida(posicao);
        return this.elementos[posicao];
    }

    private void verificaSePosicaoEValida(int posicao) {
        if (!(posicao >= 0 && posicao < tamanho)) {
            throw new IllegalArgumentException("Posição não encontrada!");
        }
    }

    public void remove(int posicao) {
        verificaSePosicaoEValida(posicao);
        for (int i = posicao; i < this.tamanho - 1; i++) {
            this.elementos[i] = this.elementos[i + 1];
        }
        this.tamanho--;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < this.tamanho - 1; i++) {
            sb.append(this.elementos[i]);
            sb.append(", ");
        }

        if (this.tamanho > 0) {
            sb.append(this.elementos[this.tamanho - 1]);
        }
        sb.append("]");

        return sb.toString();
    }
}
