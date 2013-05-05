/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackathon.controllers;

import com.hackathon.ejb.ReportesEJB;
import com.hackathon.ejb.UsuariosEJB;
import com.hackathon.entities.Reporte;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author rfelizzola
 *
 */
@ManagedBean
@ViewScoped
public class EmpresaController {

    @EJB
    ReportesEJB reportesEjb;
    private MapModel modelMap;
    private Marker marker;

    /**
     * Creates a new instance of ListarAfiliadoresController
     */
    public EmpresaController() {
    }

    public MapModel getModelMap() {
        return modelMap;
    }

    public void setModelMap(MapModel modelMap) {
        this.modelMap = modelMap;
    }

    @PostConstruct
    public void init() {
        List<Reporte> lista=reportesEjb.getReportes();
        modelMap = new DefaultMapModel();

        //Shared coordinates  
        for(Reporte r:lista){
        /*
            LatLng coord1 = new LatLng(11.015003540372437, -74.81208801269531);
        LatLng coord2 = new LatLng(10.99242382355001,-74.80213165283204);
        LatLng coord3 = new LatLng(10.99242382355001, -74.80213165283206);
        LatLng coord4 = new LatLng(10.99242382355001, -74.81998443603516);

        //Basic marker  
        modelMap.addOverlay(new Marker(coord1, "Konyaalti"));
        modelMap.addOverlay(new Marker(coord2, "Ataturk Parki"));
        modelMap.addOverlay(new Marker(coord3, "Karaalioglu Parki"));
        modelMap.addOverlay(new Marker(coord4, "Kaleici"));*/
            
        }
    }
    
    
    public void onMarkerSelect(OverlaySelectEvent event) {  
        marker = (Marker) event.getOverlay();  
          
        addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Selected", marker.getTitle()));  
    }  
      
    public Marker getMarker() {  
        return marker;  
    }  
      
    public void addMessage(FacesMessage message) {  
        FacesContext.getCurrentInstance().addMessage(null, message);  
    } 
}
