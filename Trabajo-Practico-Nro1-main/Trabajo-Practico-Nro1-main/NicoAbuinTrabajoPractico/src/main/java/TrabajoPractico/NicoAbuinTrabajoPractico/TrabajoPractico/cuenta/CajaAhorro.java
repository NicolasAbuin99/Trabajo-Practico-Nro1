package TrabajoPractico.NicoAbuinTrabajoPractico.TrabajoPractico.cuenta;

import TrabajoPractico.NicoAbuinTrabajoPractico.TrabajoPractico.cliente.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data

public class CajaAhorro extends Cuenta {

    private double tasaInteres;

    public CajaAhorro(int nroCuenta, Cliente clienteAsociado, double saldo, double tasaInteres) {
        super(nroCuenta, clienteAsociado, saldo);
        this.tasaInteres = tasaInteres;
    }

    public void cobraInteres(){
        double interesGanado = this.getSaldo() * this.getTasaInteres();
        // Calcula el interés ganado multiplicando el saldo actual por la tasa de interés. 
        //Usa los métodos `get` de Lombok para acceder a los atributos.
        this.setSaldo(this.getSaldo()+interesGanado);
        // Suma el interés ganado al saldo actual, usando el método `setSaldo` de Lombok.
        System.out.println("Se cobro "+interesGanado+ " de intereses");//imprime interes
        System.out.println("El nuevo saldo es "+this.getSaldo());//imprimis el saldo
    }
}
