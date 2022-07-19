package operacoes;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import util.Util;

import java.io.IOException;

public class LeituraUsandoIterator {

    public static void main(String[] args) throws IOException {

        String caminhoArquivo = Util.CAMINHO_PLANILHA_PAISES;

        XSSFSheet sheet = Util.declaracaoLibsPlanilhaPadrao(caminhoArquivo);

        Util.percorreTodaLinhaDaPlanilha(sheet.iterator());
    }
}
