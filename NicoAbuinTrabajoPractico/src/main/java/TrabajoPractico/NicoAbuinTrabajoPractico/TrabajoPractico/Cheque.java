package TrabajoPractico.NicoAbuinTrabajoPractico.TrabajoPractico;

import java.sql.Date;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@Data
public class Cheque {

    private double monto;
    private String bancoAsociado;
    private LocalDate fecha;

}
