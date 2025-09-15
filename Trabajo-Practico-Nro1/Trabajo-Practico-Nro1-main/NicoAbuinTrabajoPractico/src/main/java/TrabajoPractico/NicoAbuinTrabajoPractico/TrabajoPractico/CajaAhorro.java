package TrabajoPractico.NicoAbuinTrabajoPractico.TrabajoPractico;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
public class CajaAhorro extends Cuentas {

    private double tasaInteres;

    public CajaAhorro(int nroCuenta, Cliente clienteAsociado, double saldo, double tasaInteres) {
        super(nroCuenta, clienteAsociado, saldo);
        this.tasaInteres = tasaInteres;
    }

    public void cobraInteres(){
        double interesGanado = this.getSaldo() * this.getTasaInteres();
        this.setSaldo(this.getSaldo()+interesGanado);
        System.out.println("Se cobro "+interesGanado+ " de intereses");
        System.out.println("El nuevo saldo es "+this.getSaldo());
    }
}
