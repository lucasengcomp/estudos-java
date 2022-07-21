package operacoes;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import util.UtilLeitura;

import java.io.IOException;

public class LeituraUsandoIterator {

    public static void main(String[] args) throws IOException {
        XSSFSheet sheet = UtilLeitura.declaracaoLibsPlanilhaPadrao(UtilLeitura.CAMINHO_PLANILHA_PAISES);

        UtilLeitura.percorreTodaLinhaDaPlanilha(sheet.iterator());
    }
}
