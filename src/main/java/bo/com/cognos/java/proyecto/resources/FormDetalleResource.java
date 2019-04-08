/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.com.cognos.java.proyecto.resources;

import java.util.List;
import bo.com.cognos.java.proyecto.model.FormDetalle;
import bo.com.cognos.java.proyecto.model.ProyectoException;
import bo.com.cognos.java.proyecto.services.FormDetalleService;
import java.util.Date;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author KAREN
 */
@Path("formdetalle")
public class FormDetalleResource {

    @Autowired
    FormDetalleService formDetalleService;

    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public FormDetalle guardar(FormDetalle obj) throws ProyectoException {
        obj.setIdUsuarioRegistro(0);
        return formDetalleService.guardar(obj);

    }

    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public FormDetalle modificar(FormDetalle obj) throws ProyectoException {
        return formDetalleService.guardar(obj);

    }

    @DELETE
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void borrar(Short id) throws ProyectoException {
        formDetalleService.borrar(id);
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<FormDetalle> buscar(@QueryParam("filtro")  String filtro) throws ProyectoException {
        return formDetalleService.buscar(filtro);
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("buscarDetalleParametros")

    public List<FormDetalle> buscar(@QueryParam("filtro") String filtro,@QueryParam("fechaPartida") Date fechaPartida,@QueryParam("fechaRetorno")  Date fechaRetorno) throws ProyectoException {
        return formDetalleService.buscar(filtro, fechaPartida, fechaRetorno);

    }

}
