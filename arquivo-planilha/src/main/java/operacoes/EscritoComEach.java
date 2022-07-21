package operacoes;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import util.UtilEscrita;

import java.io.IOException;

public class EscritoComEach {

    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Aba Planilha Trabalhadores");

        int contadorLinha = 0;

        UtilEscrita.percorreDadosCriaLinhaComEach(sheet, UtilEscrita.criaDadosParaEscrita(), contadorLinha);
        UtilEscrita.executaEscrita(workbook);
    }
}
