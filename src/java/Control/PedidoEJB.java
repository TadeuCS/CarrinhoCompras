package Control;

import Model.Pedido;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class PedidoEJB {

    @PersistenceContext
    EntityManager em;

    public void salvar(Pedido pedido) {
        em.merge(pedido);
    }

    public void apagar(Pedido pedido) {
        em.getTransaction().begin();
        em.remove(pedido);
        em.getTransaction().commit();
    }

    public void editar(Pedido pedido) {
        em.getTransaction().begin();
        em.refresh(pedido);
        em.getTransaction().commit();
    }

    
}
