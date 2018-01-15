package com.empresa.proyecto.managed;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import com.empresa.proyecto.dao.ProfesorDao;
import com.empresa.proyecto.entity.Profesor;

@ManagedBean(name="profesor")
@SessionScoped
public class ProfesorBean {
    
    private Profesor profesor;
    private List<Profesor> profesores;

    public Profesor getProfesor() {
        if(profesor==null){
            profesor=new Profesor();
        }
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }  
    
    public String nuevo(){
        profesor=null;
        return "edicion";
    }
    
    public String registrar(){
        ProfesorDao service=new ProfesorDao();
        if(profesor.getCodigo()!=null){
            service.actualizar(profesor);
        }else{
            service.registrar(profesor);
        }
      
        profesor=null;
        return buscar();
    }
    
    public String buscar(){
        
       ProfesorDao service=new ProfesorDao();
       profesores=service.buscar();
       return "listado";
       
    }
    
    public String buscarPK(){         
       ProfesorDao service=new ProfesorDao();
       profesor=service.buscarXID(Integer.parseInt(FacesContext.
               getCurrentInstance().getExternalContext().
               getRequestParameterMap().get("codigo")));
       return "edicion";
      
    }
    
    
     public String eliminar(){
       ProfesorDao service=new ProfesorDao();
       
       service.eliminar(Integer.parseInt(FacesContext.
               getCurrentInstance().getExternalContext().
               getRequestParameterMap().get("codigo")));
       
       return buscar();
      
    }
     
     public String cancel(){
         return "listado";
     }
   
}
