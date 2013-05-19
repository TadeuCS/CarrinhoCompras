package View;

import Control.ClienteEJB;
import Model.Cliente;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@ManagedBean
@RequestScoped
public class ClienteMB {

    @EJB
    ClienteEJB clienteEJB;
    EntityManager em;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    Cliente cliente = new Cliente();

    public ClienteMB() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarrinhoCompraPU");
        em = emf.createEntityManager();
    }

    public void salvar() {
        clienteEJB.salvar(cliente);
    }

    public void apagar() {
        clienteEJB.apagar(cliente);
    }

    public List<Cliente> findAll() {
        Query query3 = em.createQuery("SELECT s FROM Cliente s");
        return query3.getResultList();
       
    }
}
