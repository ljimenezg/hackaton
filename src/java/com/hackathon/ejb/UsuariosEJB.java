/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackathon.ejb;

import com.hackathon.entities.Prueba;
import com.hackathon.entities.Reporte;
import com.hackathon.entities.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rfelizzola
 */
@Stateless
public class UsuariosEJB {

    @PersistenceContext(unitName = "HackathonPU")
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void saveUser(String name, String id) {
        Prueba u = new Prueba();
        u.setIdPrueba(id);
        u.setNombrePrueba(name);
        em.persist(u);
    }

    public void UpdateReport(Reporte r) {
        System.out.println(r.getLon());
        System.out.println(r.getLat());
        em.persist(r);
    }
}
