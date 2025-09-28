package trabajopracticonro1nicolasabuin.cuentas;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class cheque {

    private double monto;
    private String bancoAsociado;
    private LocalDate fecha;
}
