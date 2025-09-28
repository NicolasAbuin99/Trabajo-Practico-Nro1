package trabajopracticonro1nicolasabuin.test;

import java.time.LocalDate;

import trabajopracticonro1nicolasabuin.cliente.clienteEmpresa;
import trabajopracticonro1nicolasabuin.cliente.clienteIndividual;
import trabajopracticonro1nicolasabuin.cuentas.cajaAhorro;
import trabajopracticonro1nicolasabuin.cuentas.cheque;
import trabajopracticonro1nicolasabuin.cuentas.cuentaConvertibilidad;
import trabajopracticonro1nicolasabuin.cuentas.cuentaCorriente;

public class test {

    public static void main(String[] args) {
        
       
        System.out.println("INICIO DEL TEST DEL SISTEMA BANCARIO");
        

        // ----------------------------------------------------
        // 1. CREACIÓN DE CLIENTES
        // ----------------------------------------------------
        System.out.println("\n--- CREACIÓN DE CLIENTES ---");
        
        clienteIndividual cliente1 = new clienteIndividual(1001, "Nicolás", "Abuin", "35000000");
        clienteEmpresa cliente2 = new clienteEmpresa(2002, "Niko99", "30712345678L");

        System.out.println("Cliente 1: " + cliente1.toString());
        System.out.println("Cliente 2: " + cliente2.toString());


        // ----------------------------------------------------
        // 2. CAJA DE AHORRO (Cliente Individual)
        // ----------------------------------------------------
        System.out.println("\n--- TEST: CAJA DE AHORRO ---");
        cajaAhorro ca1 = new cajaAhorro(1, cliente1, 5000.0, 0.05); 

        ca1.depositarEfectivo(2000.0);
        
        // 2.1 Extraer dentro del límite
        ca1.extraerEfectivo(3000.0); 
        
        // 2.2 Intentar extraer fuera del límite (Debería fallar)
        ca1.extraerEfectivo(5000.0); 
        
        // 2.3 Cobrar Intereses
        ca1.cobrarInteres(); 


        // ----------------------------------------------------
        // 3. CUENTA CORRIENTE (Cliente Individual)
        // ----------------------------------------------------
        System.out.println("\n--- TEST: CUENTA CORRIENTE ---");
        cuentaCorriente cc1 = new cuentaCorriente(2, cliente1, 1000.0, 5000.0); // Saldo: 1000, Autorizado: 5000

        // 3.1 Extraer usando saldo disponible (1000 - 1500 = -500.0, usa descubierto)
        cc1.extraerEfectivo(1500.0); 
        
        // 3.2 Intentar extraer fuera del límite total (1000 + 5000 = 6000 total disponible)
        cc1.extraerEfectivo(6000.0); 

        // 3.3 Depositar Cheque (requiere un cheque)
        cheque chequeEmpresa = new cheque(3500.0, "Banco Central", LocalDate.now().plusDays(15));
        cc1.depositarCheque(chequeEmpresa); 
        
        
        // ----------------------------------------------------
        // 4. CUENTA CONVERTIBILIDAD (Cliente Empresa)
        // ----------------------------------------------------
        System.out.println("\n--- TEST: CUENTA CONVERTIBILIDAD (Dólares) ---");
        cuentaConvertibilidad cv1 = new cuentaConvertibilidad(
            3, cliente2, 10000.0, 10000.0, // Herencia de Cuenta Corriente (Pesos)
            500.0, 1000.0 // Saldo Dolares: 500, Tasa: 1000 (1 USD = 1000 ARS)
        );

        // 4.1 Operaciones en Dólares
        cv1.depositarDolares(100.0);
        cv1.extraerDolares(200.0);
        
        // 4.2 Intentar extraer fuera de saldo en Dólares (Debería fallar, sin descubierto)
        cv1.extraerDolares(500.0);

        // 4.3 Conversiones
        System.out.println("\n* Conversiones (Tasa: 1000 ARS/USD):");
        // Convertir 2000 ARS a Dólares
        cv1.convertirPesosADolares(2000.0);
        
        // Convertir 10 USD a Pesos
        cv1.convertirDolaresAPesos(10.0);
    }
}