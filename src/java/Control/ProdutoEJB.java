/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Produto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Tadeu
 */
@Stateless
public class ProdutoEJB {

    @PersistenceContext
    EntityManager em;

    public void salvar(Produto produto) {
        em.merge(produto);
    }

    public void apaga(Produto produto) {
        em.getTransaction().begin();
        em.remove(produto);
        em.getTransaction().commit();
    }
}
