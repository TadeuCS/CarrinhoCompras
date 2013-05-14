/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.ItemPedidoEJB;
import Model.ItemPedido;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;

/**
 *
 * @author Tadeu
 */
@ManagedBean
@RequestScoped
public class ItemPedidoMB {

    @EJB
    ItemPedidoEJB itemPedidoEJB;
    private ItemPedido itemPedido = new ItemPedido();

    public ItemPedido getItemPedido() {
        return itemPedido;
    }

    public void setItemPedido(ItemPedido itemPedido) {
        this.itemPedido = itemPedido;
    }

    public ItemPedidoMB() {
    }

    public void salvar() {
        itemPedidoEJB.salvar(itemPedido);
    }

    public void apagar() {
        itemPedidoEJB.apagar(itemPedido);
    }

    public void editar() {
        itemPedidoEJB.editar(itemPedido);
    }
}
