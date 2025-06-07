package relatorios;

import entities.interfaces.Relatorio;
import java.util.Arrays;
import java.util.List;

public class RelatorioFactory {
    public static List<Relatorio> criarTodosRelatorios() {
        return Arrays.asList(
                new RelatorioPDF(),
                new RelatorioHTML(),
                new RelatorioJSON()
        );
    }
}