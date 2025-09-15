package TrabajoPractico.NicoAbuinTrabajoPractico.TrabajoPractico;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ClienteIndividual extends Cliente {

    private String nombre;
    private String apellido;
    private int dni;


    public ClienteIndividual(int NroCliente, String nombre, String apellido, int dni) {
        super(NroCliente);
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    
}
