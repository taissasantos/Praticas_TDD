package TesteBonus;

import br.com.alura.tdd.modelo.DesempenhoEnum;
import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.ReajusteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach
    public void inicializar(){
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("Taissa", LocalDate.now(), new BigDecimal("1000.00"));
    }

    @Test
    void reajusteDeveSerTresPorCentoParaDesempenhoADesejar(){

        service.calculaReajuste(funcionario, DesempenhoEnum.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    void reajusteDeveSerQuinzePorCentoParaDesempenhoBom(){

        service.calculaReajuste(funcionario, DesempenhoEnum.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    void reajusteDeveSerVintePorCentoParaDesempenhoOtimo(){

        service.calculaReajuste(funcionario, DesempenhoEnum.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }


}
