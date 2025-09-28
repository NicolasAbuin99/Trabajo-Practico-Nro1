package trabajopracticonro1nicolasabuin.cuentas;

import trabajopracticonro1nicolasabuin.cliente.cliente;
import lombok.Data;

@Data
public class cuentaCorriente extends cuenta {

    private double montoAutorizado;
   
    public cuentaCorriente(int nroCuenta, cliente clienteAsociado, double saldo, double montoAutorizado) {
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
    public void depositarCheque(cheque chequeDeposito){
        // 1. Obtiene el monto del cheque
        double monto = chequeDeposito.getMonto(); 
        
        // 2. Suma el monto al saldo (saldo es protected)
        saldo += monto; 

        System.out.println("Cheque de "+monto+" Depositado");
        System.out.println("Nuevo saldo "+saldo);
    }
}
