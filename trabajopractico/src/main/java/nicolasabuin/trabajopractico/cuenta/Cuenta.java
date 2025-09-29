package nicolasabuin.trabajopractico.cuenta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nicolasabuin.trabajopractico.cliente.Cliente;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Cuenta {

    protected int nroCuenta;
    protected Cliente clienteAsociado;
    protected double saldo;

    public void depositarEfectivo(double monto){
        if(monto>0){
            saldo+=monto;
            System.out.println("Deposito de "+monto+" realizado");
            System.out.println("Nuevo saldo: "+saldo);
        }else{
            System.out.println("El monto a depositar debe ser positivo.");
        }
    }

    public abstract void extraerEfectivo(double monto);
}
