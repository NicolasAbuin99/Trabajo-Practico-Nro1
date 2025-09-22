package TrabajoPractico.NicoAbuinTrabajoPractico.TrabajoPractico.cuenta;

import TrabajoPractico.NicoAbuinTrabajoPractico.TrabajoPractico.cliente.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Cuentas {

    protected int nroCuenta;
    protected Cliente clienteAsociado;
    protected double saldo;

    public void DepositarEfectivo(double monto){
        if(monto>0){
            this.saldo+=monto;
            System.out.println("Se deposito "+monto+" en la cuenta "+nroCuenta);
        }else{
            System.out.println("El monto a depositar debe ser positivo");
        }
    }
    public void ExtraerEfectivo(double monto){
        if(monto>0 && this.saldo>=monto){
            this.saldo-=monto;
            System.out.println("Se extrajo "+monto+" en la cuenta "+nroCuenta);
        }else{
            System.out.println("El monto a depositar debe ser positivo");
        }
    }
}
