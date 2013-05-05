/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackathon.controllers;

import com.hackathon.ejb.ReportesEJB;
import com.hackathon.entities.Reporte;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

@ManagedBean
@ViewScoped
/**
 *
 * @author user
 */
public class ReporteController {

    @EJB
    ReportesEJB reportesEjb;

    public void ActualizarReporte() {

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
                    //System.out.println(event.getString("id"));

                    Reporte r = new Reporte();
                    r.setLat(Double.parseDouble(event.getString("latitude")));
                    r.setLon(Double.parseDouble(event.getString("longitude")));

                    JSONObject event_data = new JSONObject(event.getString("data"));
                    //System.out.println(jsonObj.getString("cod_vigia"));

                    r.setCodActivo(event_data.getInt("codigo_activo"));
                    r.setCodVigia(event_data.getString("cod_vigia"));
                    r.setObservacion(event_data.getString("observacion"));

                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(event_data.getString("created_at"));
                    
                    r.setFecha(date);
                    
                    JSONArray event_photo = event.getJSONArray("photos");
                    
                    JSONObject photo = event_photo.getJSONObject(0);
                    //System.out.println(json.getString("small"));
                    
                    r.setFoto(photo.getString("small"));
                    
                    reportesEjb.UpdateReport(r);
                }

            }

        } catch (JSONException e) {
        }catch(Exception e){
            
        }
    }
}
