package nicolasabuin.trabajopractico.cuenta;

import lombok.Data;
import nicolasabuin.trabajopractico.cliente.Cliente;

@Data
public class CuentaCorriente extends Cuenta {

    private double montoAutorizado;

    public CuentaCorriente(int nroCuenta, Cliente clienteAsociado, double saldo, double montoAutorizado) {
        super(nroCuenta, clienteAsociado, saldo);
        this.montoAutorizado = montoAutorizado;
    }

    @Override
    public void extraerEfectivo(double monto){
        double saldoTotalDisponible = saldo + montoAutorizado;
        if(monto>0 && monto<= saldoTotalDisponible){
            saldo=saldo-monto;
            System.out.println("Se extrajo "+monto+ "de la cuenta");
        }else if(monto>saldoTotalDisponible){
            System.out.println("Monto excede el saldo disponible más el giro autorizado");
        }else{
            System.out.println("El monto debe ser positivo");
        }
    }
    public void depositarCheque(Cheque chequeDeposito){
        // 1. Obtiene el monto del cheque
        double monto = chequeDeposito.getMonto(); 
        
        // 2. Suma el monto al saldo (saldo es protected)
        saldo += monto; 

        System.out.println("Cheque de "+monto+" Depositado");
        System.out.println("Nuevo saldo "+saldo);
    }

    @Override
    public String toString() {
        // Llama al toString de la clase padre (cuenta) y agrega el atributo propio
        return super.toString() + " | Monto Autorizado (Giro): $" + montoAutorizado;
    }
}
