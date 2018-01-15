package com.empresa.proyecto.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.empresa.proyecto.entity.Profesor;
import com.empresa.proyecto.util.PersistenceUtil;

public class ProfesorDao {
    
    public void registrar(Profesor profesor){
        EntityManager em=PersistenceUtil.getEmf().createEntityManager();
        em.getTransaction().begin();
        
            em.persist(profesor);
            
        em.getTransaction().commit();
        em.close();        
    }
    
    
    public List<Profesor> buscar(){
       EntityManager em=PersistenceUtil.getEmf().createEntityManager();
       Query emquery = em.createQuery("SELECT f FROM Profesor f");
        
            List<Profesor> profesores=emquery.getResultList();
        
       em.close();
       return profesores;       
    }
    
    public Profesor buscarXID(Integer id){
        EntityManager em=PersistenceUtil.getEmf().createEntityManager();
        
            Profesor profesor=em.find(Profesor.class, id);
        
        em.close();  
        return profesor;        
    }
    
    public void actualizar(Profesor profesor){       
        EntityManager em=PersistenceUtil.getEmf().createEntityManager();
        em.getTransaction().begin();
           
            em.merge(profesor);
            
        em.getTransaction().commit();
        em.close();           
    }
    
    public void eliminar(Integer id){ 
        EntityManager em=PersistenceUtil.getEmf().createEntityManager();
        em.getTransaction().begin();

            Profesor profesor = (Profesor) em.find(Profesor.class, id);
            em.remove(profesor);
        
        em.getTransaction().commit();
        em.close();       
    }
}
