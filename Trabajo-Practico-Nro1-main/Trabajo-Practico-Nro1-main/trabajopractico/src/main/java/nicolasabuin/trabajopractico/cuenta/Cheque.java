package nicolasabuin.trabajopractico.cuenta;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cheque {
    private double monto;
    private String bancoAsociado;
    private LocalDate fecha;
}
