package operacoes;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import util.UtilPlanilha;

import java.io.IOException;

public class LeituraUsandoIterator {

    public static void main(String[] args) throws IOException {
        XSSFSheet sheet = UtilPlanilha.declaracaoLibsPlanilhaPadrao(UtilPlanilha.CAMINHO_PLANILHA_PAISES);

        UtilPlanilha.percorreTodaLinhaDaPlanilha(sheet.iterator());
    }
}
