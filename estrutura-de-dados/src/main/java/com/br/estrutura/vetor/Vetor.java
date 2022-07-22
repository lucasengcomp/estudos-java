package com.br.estrutura.vetor;

public class Vetor {

    private String[] elementos;
    private int tamanho;

    public Vetor(int capacidade) {
        this.elementos = new String[capacidade];
        this.tamanho = 0;
    }

    /**
     * public void adiciona(String elemento) {
     * for (int i = 0; i < this.elementos.length; i++) {
     * if (this.elementos[i] == null) {
     * this.elementos[i] = elemento;
     * break;
     * }
     * }
     * }
     */
	/*
	public void adiciona(String elemento) throws Exception {
		if(this.tamanho < this.elementos.length) {
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;
		} else {
			throw new Exception("Não pode adicionar mais elementos nesse vetor");
		}
	}*/
    public boolean adiciona(String elemento) {
        this.aumentaCapacidade();

        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
            return true;
        }
        return false;
    }

    public void adiciona(int posicao, String elemento) {
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
            String[] elementosNovos = new String[this.elementos.length * 2];

            for (int i = 0; i < this.elementos.length; i++) {
                elementosNovos[i] = this.elementos[i];
            }
            this.elementos = elementosNovos;
        }
    }

    public int tamanho() {
        return this.tamanho;
    }

    public String busca(int posicao) {
        verificaSePosicaoEValida(posicao);
        return this.elementos[posicao];
    }

    private void verificaSePosicaoEValida(int posicao) {
        if (!(posicao >= 0 && posicao < tamanho)) {
            throw new IllegalArgumentException("Posição não encontrada!");
        }
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
