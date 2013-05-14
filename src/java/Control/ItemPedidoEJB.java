/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.ItemPedido;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Tadeu
 */
@Stateless
public class ItemPedidoEJB {

    @PersistenceContext
    EntityManager em;

    public void salvar(ItemPedido obj) {
        em.merge(obj);
    }

    public void apagar(ItemPedido obj1) {
        em.getTransaction().begin();
        em.remove(obj1);
        em.getTransaction().commit();
    }

    public void editar(ItemPedido obj2) {
        em.getTransaction().begin();
        em.refresh(obj2);
        em.getTransaction().commit();
    }

    public void findAll() {
        Query query = em.createQuery("SELECT u from ItemPedido u");
    }
}
