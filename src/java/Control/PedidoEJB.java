package Control;

import Model.Pedido;
import java.util.List;
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

    public List<Pedido> findAll() {
        Query query = em.createQuery("SELECT s FROM Pedido s");
        return query.getResultList();
        //Outra forma possivel:
        //        return em.createQuery("SELECT s FROM Setor s").getResultList();
    }
}
