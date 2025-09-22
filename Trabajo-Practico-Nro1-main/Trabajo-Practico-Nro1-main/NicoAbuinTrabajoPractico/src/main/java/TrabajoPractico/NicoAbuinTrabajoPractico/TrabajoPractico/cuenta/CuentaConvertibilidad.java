package TrabajoPractico.NicoAbuinTrabajoPractico.TrabajoPractico.cuenta;

import TrabajoPractico.NicoAbuinTrabajoPractico.TrabajoPractico.cliente.Cliente;
import lombok.Data;

@Data

public class CuentaConvertibilidad extends CuentaCorriente {

    private double tasaConversion;

    public CuentaConvertibilidad(int nroCuenta, Cliente clienteAsociado, double saldo, double montoAutorizado, double tasaConversion) {
        super(nroCuenta, clienteAsociado, saldo, montoAutorizado);
        this.tasaConversion = tasaConversion;
    }

    public void DepositarDolares(double montoDolares){
        // Convierte los dólares a pesos y los suma al saldo de la cuenta.
        this.setSaldo(this.getSaldo() + (montoDolares * this.tasaConversion));
        System.out.println("Se depositaron " + montoDolares + " USD. Nuevo saldo en pesos: " + this.getSaldo());
    }
    public void ExtraerDolares(double montoDolares){
        // Calcula el equivalente en pesos del monto a extraer.
        double montoEnPesos = montoDolares * this.tasaConversion;
        // Condición: verifica que el saldo en pesos sea suficiente para la extracción en dólares.
        if (this.getSaldo() >= montoEnPesos) {
            this.setSaldo(this.getSaldo() - montoEnPesos);
            System.out.println("Se extrajeron " + montoDolares + " USD. Nuevo saldo en pesos: " + this.getSaldo());
        } else {
            System.out.println("No se puede extraer. Saldo insuficiente para la operación en dólares.");
        }
    }
    public void ConvertirPesosADolares(double montoPesos){
        // Calcula el equivalente en dólares.
        double montoDolares = montoPesos/this.tasaConversion;
        System.out.println(montoPesos + " pesos equivalen a " + montoDolares + " dolares.");
    }
    public void ConvertirDolaresAPesos(double montoDolares){
        double montoPesos = montoDolares/this.tasaConversion;
        System.out.println(montoDolares + " dolares equivalen a " + montoPesos + " pesos.");

    }
    
}
