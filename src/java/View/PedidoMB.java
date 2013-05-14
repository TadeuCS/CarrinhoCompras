package View;

import Control.PedidoEJB;
import Model.Pedido;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@ManagedBean
@RequestScoped
public class PedidoMB {

    @EJB
    PedidoEJB pedidoEJB;
    EntityManager em;
    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    Pedido pedido = new Pedido();

    public PedidoMB() {
       
    }

    public void salvar() {
        pedidoEJB.salvar(pedido);
    }

    public void apagar() {
        pedidoEJB.apagar(pedido);
    }

    public void editar() {
        pedidoEJB.editar(pedido);
    }

    public void findAll() {
        Query query = em.createQuery("SELECT u from Pedido u");
    }

    public void calculaTotal() {
        Query query = em.createQuery("SELECT SUM(p.valorTotal) FROM Pedido p where p.id=:codigo");
        query.setParameter("codigo", pedido.getId());
        query.getResultList();
    }
}
