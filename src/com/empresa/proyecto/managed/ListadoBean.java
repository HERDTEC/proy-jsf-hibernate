package com.empresa.proyecto.managed;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

@ManagedBean(name = "listados")
@ApplicationScoped
public class ListadoBean {

    private List<SelectItem> generos;
    private List<SelectItem> estados;

    public ListadoBean() {
        generos = new ArrayList<SelectItem>();
        generos.add(new SelectItem("M", "Masculino"));
        generos.add(new SelectItem("F", "Femenino"));

        estados = new ArrayList<SelectItem>();
        estados.add(new SelectItem("0", "Inactivo"));
        estados.add(new SelectItem("1", "Activo"));

    }

    public List<SelectItem> getGeneros() {
        return generos;
    }

    public void setGeneros(List<SelectItem> generos) {
        this.generos = generos;
    }

    public List<SelectItem> getEstados() {
        return estados;
    }

    public void setEstados(List<SelectItem> estados) {
        this.estados = estados;
    }

}
