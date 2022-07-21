package operacoes;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import util.UtilLeitura;

import java.io.IOException;

public class LeituraUsandoLoops {

    public static void main(String[] args) throws IOException {

        XSSFSheet planilha = UtilLeitura.declaracaoLibsPlanilhaPadrao(UtilLeitura.CAMINHO_PLANILHA_PAISES);

        UtilLeitura.percorreLinha(planilha, planilha.getLastRowNum(), planilha.getRow(1).getLastCellNum());
    }
}
