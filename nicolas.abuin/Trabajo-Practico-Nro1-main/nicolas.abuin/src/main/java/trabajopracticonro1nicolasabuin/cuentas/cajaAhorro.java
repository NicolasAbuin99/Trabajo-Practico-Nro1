package trabajopracticonro1nicolasabuin.cuentas;

import lombok.Data;
import trabajopracticonro1nicolasabuin.cliente.cliente;

@Data
public class cajaAhorro extends cuenta {
    private double tasaInteres;

    
    public cajaAhorro(int nroCuenta, cliente clienteAsociado, double saldo, double tasaInteres) {
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
        //basicamente llama al toString de la clase padre y lo une al toString que acabo de crear
    }
}
