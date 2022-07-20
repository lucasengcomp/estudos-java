package operacoes;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class Escrita {

    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Aba Planilha Trabalhadores");

        Object dados[][] = {{"ID", "Nome", "Profissao"},
                {351, "Lucas", "Agricultor"},
                {521, "Ana", "Engenheira"},
                {572, "Ivone", "Violeira"},
                {701, "Bruna", "Sanfoneira"}
        };

//        int linha = dados.length;
//        int coluna = dados[0].length;
//
//        for (int i = 0; i < linha; i++) {
//            XSSFRow linhaCriada = sheet.createRow(i);
//
//            for (int j = 0; j < coluna; j++) {
//                XSSFCell celulaCriada = linhaCriada.createCell(j);
//                Object value = dados[i][j];
//
//                if (value instanceof String)
//                    celulaCriada.setCellValue((String) value);
//                if (value instanceof Integer)
//                    celulaCriada.setCellValue((Integer) value);
//                if (value instanceof Boolean)
//                    celulaCriada.setCellValue((Boolean) value);
//            }
//            FileOutputStream outstream = new FileOutputStream("src/main/java/planilhas/trabalhadores.xlsx");
//            workbook.write(outstream);
//            outstream.close();
//        }
//        System.out.println("Planilha criada com sucesso!");
        int contadorLinha = 0;

        for (Object registro[] : dados) {
            XSSFRow linhaCriada = sheet.createRow(contadorLinha++);
            int contadorColuna = 0;
            for (Object valorEscrito : registro) {
                XSSFCell celulaCriada = linhaCriada.createCell(contadorColuna++);

                if (valorEscrito instanceof String)
                    celulaCriada.setCellValue((String) valorEscrito);
                if (valorEscrito instanceof Integer)
                    celulaCriada.setCellValue((Integer) valorEscrito);
                if (valorEscrito instanceof Boolean)
                    celulaCriada.setCellValue((Boolean) valorEscrito);
            }
        }
        FileOutputStream outstream = new FileOutputStream("src/main/java/planilhas/trabalhadores.xlsx");
        workbook.write(outstream);
        outstream.close();
        System.out.println("Planilha criada com sucesso!");
    }
}
