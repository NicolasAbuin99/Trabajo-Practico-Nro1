package nicolasabuin.trabajopractico.cuenta;

import lombok.Data;
import nicolasabuin.trabajopractico.cliente.Cliente;

@Data
public class CajaAhorro extends Cuenta {

    private double tasaInteres;

    public CajaAhorro(int nroCuenta, Cliente clienteAsociado, double saldo, double tasaInteres) {
        super(nroCuenta, clienteAsociado, saldo);
        this.tasaInteres = tasaInteres;
    }

    public void cobrarInteres(){
        double interesGanado = saldo * tasaInteres;
        saldo=saldo+interesGanado;
        System.out.println("Se cobro "+interesGanado+" de intereses");
        System.out.println("El nuevo saldo es "+saldo);
    }

    @Override
    public void extraerEfectivo(double monto){
        if(monto>0 && saldo>=monto){
            System.out.println("Se extrajo "+monto+ "de la cuenta");
        }else{
            System.out.println("El monto debe ser positivo");
        }
    }

    @Override
    public String toString() {
        // Llama al toString de la clase padre (cuenta) y agrega el atributo propio
        return super.toString() + " | Tasa de Interés: " + tasaInteres;
    } //lo que hago es llamar al toString de la clase padre y lo uno al toString de la clase hija
}
