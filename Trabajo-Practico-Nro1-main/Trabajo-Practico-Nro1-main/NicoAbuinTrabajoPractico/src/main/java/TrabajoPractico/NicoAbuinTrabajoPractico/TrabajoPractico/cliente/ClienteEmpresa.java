package TrabajoPractico.NicoAbuinTrabajoPractico.TrabajoPractico.cliente;

import lombok.Data;
@Data
public class ClienteEmpresa extends Cliente {

    private String nombreFantasia;
    private String cuit;


    public ClienteEmpresa(int nroCliente, String nombreFantasia, String cuit) {
        super(nroCliente);
        this.nombreFantasia = nombreFantasia;
        this.cuit = cuit;
    }
}
