package nicolasabuin.trabajopractico.cuenta;

import lombok.Data;
import nicolasabuin.trabajopractico.cliente.Cliente;
import nicolasabuin.trabajopractico.cliente.ClienteEmpresa;


@Data
public class CuentaConvertibilidad extends CuentaCorriente{
    private double saldoDolares;
    private double tasaConversion;


    public CuentaConvertibilidad(int nroCuenta, ClienteEmpresa clienteEmpresa, double saldo, double montoAutorizado,
            double saldoDolares, double tasaConversion) {
        super(nroCuenta, clienteEmpresa, saldo, montoAutorizado);
        this.saldoDolares = saldoDolares;
        this.tasaConversion = tasaConversion;
    }

    public void setCliente(Cliente clienteEmpresa){
        if(clienteEmpresa instanceof ClienteEmpresa){
            super.setClienteAsociado(clienteEmpresa);
        }else{
            System.out.println("Error, solo los cliente empresa pueden acceder");
        }
    }

    public void depositarDolares(double monto) { 
        if (monto > 0) {
            saldoDolares += monto;
            System.out.println("Depósito de dolares " +monto+ " realizado. Nuevo saldo: " +saldoDolares);
        }
    }

    public void extraerDolares(double monto) {
        if (monto > 0 && monto <= saldoDolares) {
            saldoDolares -= monto;
            System.out.println("Se extrajo " +monto+ ". Nuevo saldo: " +saldoDolares);
        } else {
            System.out.println("Monto excede el saldo en dólares o es inválido. No se permite giro en descubierto.");
        }
    }

    public void convertirPesosADolares(double montoPesos) { 
        double montoDolares = montoPesos / tasaConversion;
        if (montoPesos > 0 && montoPesos <= saldo) { 
            saldo -= montoPesos; 
            saldoDolares += montoDolares;
            System.out.printf("Convertidos $%.2f a U$D %.2f. Nuevos saldos: $%.2f y U$D %.2f%n", 
                               montoPesos, montoDolares, saldo, saldoDolares);
        } else {
            System.out.println("Saldo en pesos insuficiente o monto inválido para convertir.");
        }
    }

    public void convertirDolaresAPesos(double montoDolares) { 
        double montoPesos = montoDolares * tasaConversion;
        if (montoDolares > 0 && montoDolares <= saldoDolares) {
            saldoDolares -= montoDolares;
            saldo += montoPesos; 
            System.out.printf("Convertidos U$D %.2f a $%.2f. Nuevos saldos: U$D %.2f y $%.2f%n", 
                               montoDolares, montoPesos, saldoDolares, saldo);
        } else {
            System.out.println("Saldo en dólares insuficiente o monto inválido para convertir.");
        }
    }
}
