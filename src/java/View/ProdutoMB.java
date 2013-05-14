/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;


import Control.ProdutoEJB;
import Model.Produto;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
    
    private Produto produto= new Produto();

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public ProdutoMB() {
    }
    public void salvar() {
        produtoEJB.salvar(produto);
    }
    public void editar() {
        produtoEJB.edita(produto);
    }
    public void apaga() {
        produtoEJB.apaga(produto);
    }
    public List<Produto> findAll() {
        Query query = em.createQuery("select u from Produto u");
        return query.getResultList();
    }
}
