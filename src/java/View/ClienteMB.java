package View;

import Control.ClienteEJB;
import Model.Cliente;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class ClienteMB {

  @EJB
    ClienteEJB clienteEJB;
            
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    Cliente cliente = new Cliente();
    
    public ClienteMB() {
    }
    
    public void salvar(){
        clienteEJB.salvar(cliente);
    }
    public void apagar(){
       clienteEJB.apagar(cliente); 
    }
    public void editar(){
        clienteEJB.editar(cliente);
    }
    
}
