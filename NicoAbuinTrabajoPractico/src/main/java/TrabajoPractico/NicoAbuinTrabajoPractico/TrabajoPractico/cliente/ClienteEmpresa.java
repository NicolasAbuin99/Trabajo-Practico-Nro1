package TrabajoPractico.NicoAbuinTrabajoPractico.TrabajoPractico.cliente;

import lombok.Data;

@Data

public class ClienteEmpresa extends Cliente {

    private String nombreFantasia;
    private int cuit;


    public ClienteEmpresa(int NroCliente, String nombreFantasia, int cuit) {
        super(NroCliente);
        this.nombreFantasia = nombreFantasia;
        this.cuit = cuit;
    }
}
