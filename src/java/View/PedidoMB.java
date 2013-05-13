package View;

import Control.PedidoEJB;
import Model.Pedido;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class PedidoMB {

    @EJB
    PedidoEJB pedidoEJB;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
        
    Pedido pedido = new Pedido();
    
    public PedidoMB(){
    
    }
    public void salvar(){
   pedidoEJB.salvar(pedido);
    }
   public void apagar(){
     pedidoEJB.apagar(pedido);
    }
   public void editar(){
     pedidoEJB.editar(pedido);
    }
}
