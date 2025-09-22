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
        this.setSaldo(this.getSaldo() + (montoDolares * this.tasaConversion));
        System.out.println("Se depositaron " + montoDolares + " USD. Nuevo saldo en pesos: " + this.getSaldo());
    }
    public void ExtraerDolares(double montoDolares){
        double montoEnPesos = montoDolares * this.tasaConversion;
        if (this.getSaldo() >= montoEnPesos) {
            this.setSaldo(this.getSaldo() - montoEnPesos);
            System.out.println("Se extrajeron " + montoDolares + " USD. Nuevo saldo en pesos: " + this.getSaldo());
        } else {
            System.out.println("No se puede extraer. Saldo insuficiente para la operación en dólares.");
        }
    }
    public void ConvertirPesosADolares(double montoPesos){
        double montoDolares = montoPesos/this.tasaConversion;
        System.out.println(montoPesos + " pesos equivalen a " + montoDolares + " dolares.");
    }
    public void ConvertirDolaresAPesos(double montoDolares){
        double montoPesos = montoDolares/this.tasaConversion;
        System.out.println(montoDolares + " dolares equivalen a " + montoPesos + " pesos.");

    }
    
}
