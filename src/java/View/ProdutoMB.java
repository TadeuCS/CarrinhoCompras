/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.ProdutoEJB;
import Model.Produto;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Tadeu
 */
@ManagedBean
@RequestScoped
public class ProdutoMB {

    @EJB
    ProdutoEJB produtoEJB;
    EntityManager em;
    private Produto produto = new Produto();

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public ProdutoMB() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarrinhoCompraPU");
        em = emf.createEntityManager();
    }

    public void salvar() {
        produtoEJB.salvar(produto);
    }


    public void apaga() {
        produtoEJB.apaga(produto);
    }
    public List<Produto> findAll() {

        Query query1 = em.createQuery("select u from Produto u");
        return query1.getResultList();
    }  
}
