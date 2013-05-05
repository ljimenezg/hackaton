/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackathon.controllers;

import com.hackathon.ejb.ReportesEJB;
import com.hackathon.ejb.UsuariosEJB;
import com.hackathon.entities.Reporte;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author rfelizzola
 *
 */
@ManagedBean
@ViewScoped
public class userController {

    @EJB
    UsuariosEJB usuariosEjb;
    private String nombre;
    private String id;
    @EJB
    ReportesEJB reportesEjb;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void saveUser() {
        //usuariosEjb.saveUser(nombre, id);

        try {

            String url = "http://190.145.115.27/api/consumers/events";

            Client client = Client.create();

            WebResource service = client.resource(url);

            MultivaluedMap<String, String> params = new MultivaluedMapImpl();
            params.add("auth_token", "af8b19fcfcdd039ee68920ae38a088c996836975");
            params.add("pusher_key", "e3b6ff60a21e714afa5cd657e615afdf5bff7f08");
            //ClientResponse response = service.queryParams(params).type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(ClientResponse.class);

            String response = service.queryParams(params).type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(String.class);


            JSONObject respo = new JSONObject(response.toString());

            if (respo.getBoolean("status")) {
                JSONObject data = respo.getJSONObject("data");

                JSONArray events = data.getJSONArray("events");


                for (int i = 0; i < events.length(); i++) {
                    JSONObject event = events.getJSONObject(i);


                    Reporte r = new Reporte();
                    r.setLat(Double.parseDouble(event.getString("latitude")));
                    r.setLon(Double.parseDouble(event.getString("longitude")));

                    JSONObject event_data = new JSONObject(event.getString("data"));
                    //System.out.println(jsonObj.getString("cod_vigia"));

                    r.setCodActivo(Integer.parseInt(event_data.getString("codigo_activo")));
                    r.setCodVigia(event_data.getString("cod_vigia"));
                    r.setObservacion(event_data.getString("observacion"));

                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(event.getString("created_at"));

                    r.setFecha(date);

                    JSONArray event_photo = event.getJSONArray("photos");

                    JSONObject photo = event_photo.getJSONObject(0);
                    //System.out.println(json.getString("small"));

                    r.setFoto(photo.getString("small"));

                    System.out.println(r.getCodActivo());
                    System.out.println(r.getCodVigia());
                    System.out.println(r.getLat());
                    System.out.println(r.getLon());
                    System.out.println(r.getObservacion());
                    System.out.println(r.getFoto());
                    System.out.println(r.getFecha());
                    System.out.println("---");

                    reportesEjb.UpdateReport(r);
                    
                    String url2 = "http://190.145.115.27/api/consumers/events/" + event.getString("id") + "/destroy";

                    Client client2 = Client.create();

                    WebResource service2 = client2.resource(url2);

                    String response2 = service2.queryParams(params).type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(String.class);
                    JSONObject respo2 = new JSONObject(response2.toString());
                    if (respo2.getBoolean("status")) {
                        System.out.println("Eliminado: " + event.getString("id"));
                    }
                }

            }

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates a new instance of ListarAfiliadoresController
     */
    public userController() {
    }

    @PostConstruct
    public void init() {
    }

    public void ActualizarReporte() {

        System.out.println("holamundo");
    }

    public void ActualizarReporte2() {
    }
}
