package com.example.demo.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api")
public class MyResource {

    @GET
    @Path("/get")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getOperation() {
        return Response.ok("GET").build();
    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Response postOperation(@FormParam("param1") String param1, @FormParam("param2") String param2) {
        if (param1 != null && param2 != null) {
            return Response.ok("POST").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("Missing parameters").build();
    }

    @PUT
    @Path("/put")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Response putOperation(@FormParam("param1") String param1, @FormParam("param2") String param2) {
        if (param1 != null || param2 != null) {
            return Response.ok("PUT").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("No parameters provided").build();
    }

    @DELETE
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteOperation(@FormParam("param") String param) {
        if (param != null) {
            return Response.ok("DELETE").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("No parameter provided").build();
    }
}
