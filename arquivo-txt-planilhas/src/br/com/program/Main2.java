package br.com.program;

import br.com.modelo.Pessoa;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main2 {

    private static final String CAMINHO = "C:\\projetos\\estudos\\arquivo-txt-planilhas\\src\\br\\com\\arquivotxt\\arquivoPessoa.txt";

    public static void main(String[] args) throws IOException {

        validaSeArquivoExiste(pegaCaminhoArquivo());

        persisteObjetosNoArquivo(instanciaEscritaArquivo());
    }

    private static FileWriter instanciaEscritaArquivo() throws IOException {
        FileWriter escreveNoArquivo = new FileWriter(pegaCaminhoArquivo());
        return escreveNoArquivo;
    }

    private static void persisteObjetosNoArquivo(FileWriter escreveNoArquivo) throws IOException {
        for (Pessoa p : criaObjetosPessoa()) {
            objetoPessoa(escreveNoArquivo, p);
            escreveNoArquivo.flush();
        }
        escreveNoArquivo.close();
    }

    private static List<Pessoa> criaObjetosPessoa() {
        Pessoa pessoa1 = criaPessoa(1L, "Lucas", "emailpessoa1@email.com", 19, "333332222");
        Pessoa pessoa2 = criaPessoa(2L, "Ana", "emailpessoa2@email.com", 28, "333444444");
        Pessoa pessoa3 = criaPessoa(3L, "Ambrosio", "emailpessoa3@email.com", 31, "57755555");
        Pessoa pessoa4 = criaPessoa(4L, "Peter Parker", "emailpessoa4@email.com", 55, "00112233");

        List<Pessoa> pessoas = adicionaPessoaLista(pessoa1, pessoa2, pessoa3, pessoa4);
        return pessoas;
    }

    private static void objetoPessoa(FileWriter escreveNoArquivo, Pessoa p) throws IOException {
        escreveNoArquivo.write(p.getId() + "|"
                + p.getNome() + "|"
                + p.getEmail() + "|"
                + p.getTelefone() + "|"
                + p.getIdade() + "\n");
    }

    private static void validaSeArquivoExiste(File arquivo) throws IOException {
        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }
    }

    private static File pegaCaminhoArquivo() {
        return new File(CAMINHO);
    }

    private static List<Pessoa> adicionaPessoaLista(Pessoa pessoa1, Pessoa pessoa2, Pessoa pessoa3, Pessoa pessoa4) {
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);
        pessoas.add(pessoa4);
        return pessoas;
    }

    private static Pessoa criaPessoa(long id, String nome, String email, int idade, String telefone) {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(id);
        pessoa.setNome(nome);
        pessoa.setEmail(email);
        pessoa.setIdade(idade);
        pessoa.setTelefone(telefone);
        return pessoa;
    }
}
