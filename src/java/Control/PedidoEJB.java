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
    
    public void salvar(Pedido pedido){
        em.merge(pedido);
    }
    public void apagar(Pedido pedido){
        em.getTransaction().begin();
        em.remove(pedido);
        em.getTransaction().commit();
    }
    public void editar(Pedido pedido){
        em.getTransaction().begin();
        em.refresh(pedido);
        em.refresh(pedido);
    }
    
    public boolean findAll(Pedido pedido){
         Query query = em.createQuery("SELECT u from cliente u WHERE u.data=:data AND u.valorTotal=:valorTotal");
        query.setParameter("Data", pedido.getData());
        query.setParameter("Valor Total", pedido.getValorTotal());
        System.out.println("testando pedido="+pedido.getData()+" e "+pedido.getValorTotal());
        if (query.getResultList().size() ==1){
            System.out.println("Pedido existe");
            return true;
        }else{
            return false;
        }
    }

}
