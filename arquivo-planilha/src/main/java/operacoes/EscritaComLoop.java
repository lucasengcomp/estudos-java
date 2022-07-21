package operacoes;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import util.UtilEscrita;

import java.io.IOException;

public class EscritaComLoop {

    public static void main(String[] args) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Aba Planilha Trabalhadores");

        Object[][] dados = UtilEscrita.criaDadosParaEscrita();

        int linha = dados.length;
        int coluna = dados[0].length;

        UtilEscrita.percorreLinha(workbook, sheet, dados, linha, coluna);
        System.out.println("Planilha criada com sucesso!");
    }
}
