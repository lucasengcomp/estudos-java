package util;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class UtilEscrita {

    public static void verificaTipoDeDado(XSSFCell celulaCriada, Object value) {
        if (value instanceof String)
            celulaCriada.setCellValue((String) value);
        if (value instanceof Integer)
            celulaCriada.setCellValue((Integer) value);
        if (value instanceof Boolean)
            celulaCriada.setCellValue((Boolean) value);
    }

    public static void executaEscrita(XSSFWorkbook workbook) throws IOException {
        FileOutputStream outstream = new FileOutputStream("src/main/java/planilhas/trabalhadores.xlsx");
        workbook.write(outstream);
        outstream.close();
    }

    public static void percorreLinha(XSSFWorkbook workbook, XSSFSheet sheet, Object[][] dados, int linha, int coluna) throws IOException {
        for (int i = 0; i < linha; i++) {
            percorreColuna(coluna, sheet.createRow(i), dados[i]);
            executaEscrita(workbook);
        }
    }

    public static void percorreColuna(int coluna, XSSFRow linhaCriada, Object[] dados) {
        for (int j = 0; j < coluna; j++) {
            XSSFCell celulaCriada = linhaCriada.createCell(j);
            Object value = dados[j];
            verificaTipoDeDado(celulaCriada, value);
        }
    }

    public static Object[][] criaDadosParaEscrita() {
        Object dados[][] = {{"ID", "Nome", "Profissao"},
                {351, "Lucas", "Agricultor"},
                {521, "Ana", "Engenheira"},
                {572, "Ivone", "Violeira"},
                {701, "Bruna", "Sanfoneira"}
        };
        return dados;
    }

    public static void main(String... args) {
        System.out.println(args[0].getBytes());
    }

    public static void percorreDadosCriaLinhaComEach(XSSFSheet sheet, Object[][] dados, int contadorLinha) {
        for (Object registro[] : dados) {
            XSSFRow linhaCriada = sheet.createRow(contadorLinha++);
            int contadorColuna = 0;
            percorreValorEscritoComEach(registro, linhaCriada, contadorColuna);
        }
    }

    private static void percorreValorEscritoComEach(Object[] registro, XSSFRow linhaCriada, int contadorColuna) {
        for (Object valorEscrito : registro) {
            XSSFCell celulaCriada = linhaCriada.createCell(contadorColuna++);
            tipoDado(valorEscrito, celulaCriada);
        }
    }

    private static void tipoDado(Object valorEscrito, XSSFCell celulaCriada) {
        if (valorEscrito instanceof String)
            celulaCriada.setCellValue((String) valorEscrito);
        if (valorEscrito instanceof Integer)
            celulaCriada.setCellValue((Integer) valorEscrito);
        if (valorEscrito instanceof Boolean)
            celulaCriada.setCellValue((Boolean) valorEscrito);
    }
}
