package Control;

import Model.Cliente;
import Model.Pedido;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ClienteEJB {

    @PersistenceContext
    EntityManager em;

    public void salvar(Cliente cliente) {
        em.merge(cliente);
    }

    public void apagar(Cliente cliente) {
        em.getTransaction().begin();
        em.remove(cliente);
        em.getTransaction().commit();
    }


}
