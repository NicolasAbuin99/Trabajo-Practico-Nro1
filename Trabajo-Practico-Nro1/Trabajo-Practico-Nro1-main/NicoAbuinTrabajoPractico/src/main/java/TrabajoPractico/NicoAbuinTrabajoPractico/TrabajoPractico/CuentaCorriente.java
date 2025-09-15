package TrabajoPractico.NicoAbuinTrabajoPractico.TrabajoPractico;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
public class CuentaCorriente extends Cuentas{

    private double montoAutorizado;

    public CuentaCorriente(int nroCuenta, Cliente clienteAsociado, double saldo, double montoAutorizado) {
        super(nroCuenta, clienteAsociado, saldo);
        this.montoAutorizado = montoAutorizado;
    }

    @Override
    public void ExtraerEfectivo(double monto){
        if(monto>0 && this.saldo>=monto){
            this.saldo-=monto;
            System.out.println("Se extrajo "+monto+" en la cuenta "+nroCuenta);
        }else{
            System.out.println("El monto a depositar debe ser positivo");
        }
    }

    public void DepositarCheque(Cheque cheque){
        this.saldo += cheque.getMonto();
        System.out.println("Se depositó un cheque de " + cheque.getMonto() + ". Nuevo saldo: " + this.saldo);
    }
}
