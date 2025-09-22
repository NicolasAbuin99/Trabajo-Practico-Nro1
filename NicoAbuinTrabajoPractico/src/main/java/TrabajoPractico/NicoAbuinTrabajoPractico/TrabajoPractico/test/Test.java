package TrabajoPractico.NicoAbuinTrabajoPractico.TrabajoPractico.test;

import java.time.LocalDate;

import TrabajoPractico.NicoAbuinTrabajoPractico.TrabajoPractico.Cheque;
import TrabajoPractico.NicoAbuinTrabajoPractico.TrabajoPractico.cliente.ClienteEmpresa;
import TrabajoPractico.NicoAbuinTrabajoPractico.TrabajoPractico.cliente.ClienteIndividual;
import TrabajoPractico.NicoAbuinTrabajoPractico.TrabajoPractico.cuenta.CajaAhorro;
import TrabajoPractico.NicoAbuinTrabajoPractico.TrabajoPractico.cuenta.CuentaConvertibilidad;
import TrabajoPractico.NicoAbuinTrabajoPractico.TrabajoPractico.cuenta.CuentaCorriente;

public class Test {
    public static void main(String[]args){

        // 1. CREAR CLIENTES
        System.out.println("--- CREACIÓN DE CLIENTES ---");
        ClienteIndividual clientei1 = new ClienteIndividual(1, "Nicolas", "Abuin", 40863806);
        ClienteEmpresa clientee1 = new ClienteEmpresa(1, "Pepito Mongolo", 50128766);
        System.out.println("Cliente individual creado: " + clientei1.getNombre() + " " + clientei1.getApellido());
        System.out.println("Cliente empresa creado: " + clientee1.getNombreFantasia());
        System.out.println("----------------------------\n");

        // 2. PROBAR CAJA DE AHORRO
        System.out.println("--- PROBANDO CAJA DE AHORRO ---");
        CajaAhorro cajaAhorro = new CajaAhorro(101, clientei1, 5000, 0.05); // Tasa de interés del 5%
        cajaAhorro.DepositarEfectivo(2000); // Deposito
        cajaAhorro.ExtraerEfectivo(1000); // Extraccion valida
        cajaAhorro.ExtraerEfectivo(7000); // Extraccion invalida
        cajaAhorro.cobraInteres(); // Cobrar interes
        System.out.println("Saldo final de Caja de Ahorro: " + cajaAhorro.getSaldo());
        System.out.println("---------------------------------\n");

        // 3. PROBAR CUENTA CORRIENTE
        System.out.println("--- PROBANDO CUENTA CORRIENTE ---");
        CuentaCorriente cuentaCorriente = new CuentaCorriente(102, clientei1, 500, 2000); // Saldo 500, descubierto 2000
        cuentaCorriente.DepositarEfectivo(1000); // Deposito
        cuentaCorriente.ExtraerEfectivo(1500); // Extraccion usando saldo
        cuentaCorriente.ExtraerEfectivo(1500); // Extraccion usando descubierto
        cuentaCorriente.ExtraerEfectivo(500); // Extraccion invalida
        
        Cheque cheque = new Cheque(3000, "Banco Central", LocalDate.of(2025, 10, 1));
        cuentaCorriente.DepositarCheque(cheque); // Depositar cheque
        System.out.println("Saldo final de Cuenta Corriente: " + cuentaCorriente.getSaldo());
        System.out.println("-----------------------------------\n");

        // 4. PROBAR CUENTA CONVERTIBILIDAD
        System.out.println("--- PROBANDO CUENTA CONVERTIBILIDAD ---");
        CuentaConvertibilidad cuentaConvertibilidad = new CuentaConvertibilidad(103, clientee1, 10000, 5000, 1000); // Tasa de 1000
        cuentaConvertibilidad.DepositarDolares(5); // Depositar 5 USD
        cuentaConvertibilidad.ExtraerDolares(10); // Extraer 10 USD
        cuentaConvertibilidad.ConvertirPesosADolares(5000); // Convertir 5000 ARS
        cuentaConvertibilidad.ConvertirDolaresAPesos(2); // Convertir 2 USD
        System.out.println("Saldo final de Cuenta Convertibilidad: " + cuentaConvertibilidad.getSaldo());
        System.out.println("---------------------------------------\n");
    }
}