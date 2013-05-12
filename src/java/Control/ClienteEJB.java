package Control;

import Model.Cliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ClienteEJB {
    
    @PersistenceContext
    EntityManager em;
    
    public void salvar(Cliente cliente){
        em.merge(cliente);
    }
    
    public boolean findByLoginSenha(Cliente cliente){
        Query query = em.createQuery("SELECT u from cliente u WHERE u.nome=:nome AND u.senha=:senha");
        query.setParameter("nome", cliente.getNome());
        query.setParameter("email", cliente.getEmail());
        query.setParameter("senha", cliente.getSenha());
        System.out.println("testando login para cliente="+cliente.getNome()+" e "+cliente.getEmail()+" e "+cliente.getSenha());
        if (query.getResultList().size() ==1){
            System.out.println("Login existe");
            return true;
        }else{
            return false;
        }
        
    }

}
