package TesteBonus;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusServiceTest {

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioAlto(){

        BonusService service = new BonusService();
//    forma limpa
//    assertThrows(IllegalArgumentException.class, () ->service.calcularBonus
//                (new Funcionario("Taissa", LocalDate.now(), new BigDecimal("25000"))));

        //possivel forma de capturar exception
        try {
            service.calcularBonus(new Funcionario("Taissa", LocalDate.now(), new BigDecimal("25000")));
        }catch (Exception e){
            assertEquals("Funcionário não elegível ao bônus", e.getMessage());
        }

    }

    @Test
    void bonusDeveriaSerDezPorCentoDoSalario(){

        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Taissa", LocalDate.now(),
                new BigDecimal("2500")));

        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    void bonusDeveriaSerDezPorCentoParaSalarioDeDezMil(){

        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Taissa", LocalDate.now(),
                new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.00"), bonus);
    }

}
