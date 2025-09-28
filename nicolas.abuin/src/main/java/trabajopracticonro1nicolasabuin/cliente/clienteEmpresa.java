package trabajopracticonro1nicolasabuin.cliente;

import lombok.Data;

@Data
public class clienteEmpresa extends cliente {

    private String nombreFantasia;
    private String cuit;
    
    public clienteEmpresa(int nroCliente, String nombreFantasia, String cuit) {
        super(nroCliente);
        this.nombreFantasia = nombreFantasia;
        this.cuit = cuit;
    }

    
}
