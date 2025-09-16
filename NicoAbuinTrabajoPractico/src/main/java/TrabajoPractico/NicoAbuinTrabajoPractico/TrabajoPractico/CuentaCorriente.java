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
        double saldoTotalDisponible = this.getSaldo() + this.montoAutorizado;
        //Aquí se calcula la cantidad total de dinero que el cliente puede extraer. Se suma el saldo actual de la cuenta
        if(monto > 0 && monto <= saldoTotalDisponible){ //condición para decidir si la extracción es válida
            this.setSaldo(this.getSaldo() - monto); //Se resta el monto a la cantidad actual del saldo de la cuenta y el nuevo valor se establece con el método setSaldo.
            System.out.println("Se extrajo " + monto + ". Nuevo saldo: " + this.getSaldo());
        } else {
            System.out.println("No se puede extraer el monto solicitado. El monto excede el saldo y el descubierto.");
        }
    }

    public void DepositarCheque(Cheque cheque){
        this.saldo += cheque.getMonto();
        System.out.println("Se depositó un cheque de " + cheque.getMonto() + ". Nuevo saldo: " + this.saldo);
    }
}
