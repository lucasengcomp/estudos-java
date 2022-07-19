package operacoes;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import util.UtilPlanilha;

import java.io.IOException;

public class LeituraUsandoLoops {

    public static void main(String[] args) throws IOException {

        XSSFSheet planilha = UtilPlanilha.declaracaoLibsPlanilhaPadrao(UtilPlanilha.CAMINHO_PLANILHA_PAISES);

        UtilPlanilha.percorreLinha(planilha, planilha.getLastRowNum(), planilha.getRow(1).getLastCellNum());
    }
}
