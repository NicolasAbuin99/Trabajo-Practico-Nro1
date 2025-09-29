package trabajopracticonro1nicolasabuin.cliente;

import lombok.Data;

@Data
public class clienteIndividual extends cliente {

    private String nombre;
    private String apellido;
    private String dni;

    public clienteIndividual(int nroCliente, String nombre, String apellido, String dni) {
        super(nroCliente);
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    } 
}
