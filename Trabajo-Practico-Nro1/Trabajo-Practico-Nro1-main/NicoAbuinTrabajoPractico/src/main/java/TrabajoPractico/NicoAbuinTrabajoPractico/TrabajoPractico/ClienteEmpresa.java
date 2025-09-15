package TrabajoPractico.NicoAbuinTrabajoPractico.TrabajoPractico;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ClienteEmpresa extends Cliente {

    private String nombreFantasia;
    private int cuit;


    public ClienteEmpresa(int NroCliente, String nombreFantasia, int cuit) {
        super(NroCliente);
        this.nombreFantasia = nombreFantasia;
        this.cuit = cuit;
    }
}
