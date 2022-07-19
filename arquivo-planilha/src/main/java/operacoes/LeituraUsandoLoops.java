package operacoes;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import util.Util;

import java.io.IOException;

public class LeituraUsandoLoops {

    public static void main(String[] args) throws IOException {

        String caminhoArquivo = Util.CAMINHO_PLANILHA_PAISES;
        XSSFSheet sheet = Util.declaracaoLibsPlanilhaPadrao(caminhoArquivo);

        int linha = sheet.getLastRowNum();
        int coluna = sheet.getRow(1).getLastCellNum();

        Util.percorreLinha(sheet, linha, coluna);
    }
}
