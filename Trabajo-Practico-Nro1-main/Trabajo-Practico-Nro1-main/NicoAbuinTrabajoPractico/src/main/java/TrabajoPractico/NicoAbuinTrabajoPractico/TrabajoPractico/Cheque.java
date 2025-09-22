package TrabajoPractico.NicoAbuinTrabajoPractico.TrabajoPractico;



import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Cheque {

    private double monto;
    private String bancoAsociado;
    private LocalDate fecha;

}
