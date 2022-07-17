package br.com.program;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        File arquivo = new File("C:\\projetos\\estudos\\arquivo-txt-planilhas\\src\\br\\com\\utils\\arquivo.txt");

        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }

        FileWriter escreverNoArquivo = new FileWriter(arquivo);

        escreverNoArquivo.write("Meu texto no arquivo\n");
        escreverNoArquivo.write("Outro texto de teste escrita");
        escreverNoArquivo.flush();
        escreverNoArquivo.close();
    }
}
