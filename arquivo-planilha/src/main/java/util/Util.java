package util;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Iterator;

public class Util {

    public static final String CAMINHO_PLANILHA_PAISES = "src/main/java/planilhas/paises.xlsx";

    public static XSSFSheet declaracaoLibsPlanilhaPadrao(String caminhoArquivo) throws IOException {
        FileInputStream inputstream = new FileInputStream(caminhoArquivo);
        XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        return sheet;
    }

    public static String converteNumeroParaBigDecimal(XSSFCell cell) {
        return new BigDecimal(cell.getNumericCellValue()).toPlainString();
    }

    public static void percorreLinha(XSSFSheet sheet, int linha, int coluna) {
        for (int i = 0; i <= linha; i++) {
            XSSFRow row = sheet.getRow(i);

            percorreColuna(coluna, row);
            System.out.println();
        }
    }

    private static void percorreColuna(int coluna, XSSFRow row) {
        for (int j = 0; j < coluna; j++) {
            XSSFCell cell = row.getCell(j);
            Util.verificaTipoDoDado(cell);
        }
    }

    public static void verificaTipoDoDado(XSSFCell cell) {
        switch (cell.getCellType()) {
            case STRING:
                System.out.print(cell.getStringCellValue());
                break;
            case NUMERIC:
                System.out.print(Util.converteNumeroParaBigDecimal(cell));
                break;
            case BOOLEAN:
                System.out.print(cell.getBooleanCellValue());
                break;
        }
        imprimeComSeparadorPipe();
    }

    public static void percorreTodaLinhaDaPlanilha(Iterator iterator) {
        while (iterator.hasNext()) {
            XSSFRow row = (XSSFRow) iterator.next();
            Iterator cellIterator = row.cellIterator();
            percorreTodaCelulaDaPlanilha(cellIterator);
        }
    }

    private static void percorreTodaCelulaDaPlanilha(Iterator cellIterator) {
        while (cellIterator.hasNext()) {
            XSSFCell cell = (XSSFCell) cellIterator.next();
            Util.verificaTipoDoDado(cell);
        }
        Util.quebraLinha();
    }

    private static void imprimeComSeparadorPipe() {
        System.out.print(" | ");
    }

    public static void quebraLinha() {
        System.out.println();
    }
}
