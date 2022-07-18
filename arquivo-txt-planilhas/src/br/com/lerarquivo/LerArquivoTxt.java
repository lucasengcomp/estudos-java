package br.com.lerarquivo;

import br.com.util.Consts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LerArquivoTxt {

    public static void main(String[] args) throws FileNotFoundException {
        lerArquivoEImprimeNoConsole(lerArquivoComPadraoUTF8());
    }

    private static Scanner lerArquivoComPadraoUTF8() throws FileNotFoundException {
        return new Scanner(new FileInputStream(Consts.CAMINHO_ARQUIVO_PESSOA), "UTF-8");
    }

    private static void lerArquivoEImprimeNoConsole(Scanner lerArquivo) {
        while (lerArquivo.hasNext()) {
            String linha = lerArquivo.nextLine();

            validacaoParaImprimirLinhas(linha);
        }
    }

    private static void validacaoParaImprimirLinhas(String linha) {
        if (linha != null && !linha.isEmpty()) {
            System.out.println(linha);
        }
    }
}
