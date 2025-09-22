package TrabajoPractico.NicoAbuinTrabajoPractico.TrabajoPractico.cliente;

import lombok.Data;


@Data
public class ClienteIndividual extends Cliente {

    private String nombre;
    private String apellido;
    private String dni;


    public ClienteIndividual(int nroCliente, String nombre, String apellido, String dni) {
        super(nroCliente);
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    
}
