package TrabajoPractico.NicoAbuinTrabajoPractico.TrabajoPractico.cliente;

import lombok.Data;
@Data
public class ClienteEmpresa extends Cliente {

    private String nombreFantasia;
    private String cuit;


    public ClienteEmpresa(int NroCliente, String nombreFantasia, String cuit) {
        super(NroCliente);
        this.nombreFantasia = nombreFantasia;
        this.cuit = cuit;
    }
}
