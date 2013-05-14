/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Produto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

        System.out.println("Vou apagar o produto " + produto.getDescricao() + " id=" + produto.getId());
        em.getTransaction().begin();
        em.remove(produto);
        em.getTransaction().commit();
    }
    public void edita(Produto produto){
        em.getTransaction().begin();
        em.refresh(produto);
        em.getTransaction().commit();
    }
}
