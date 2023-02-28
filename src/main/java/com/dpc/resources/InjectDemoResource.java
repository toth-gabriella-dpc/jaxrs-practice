package com.dpc.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
    @GET
    @Path("annotations")
    public String getParamsUsingAnnotations(
            @MatrixParam("param") String matrixParam,
            @HeaderParam("authSessionID") String header,
            @CookieParam("name") String cookie) {
        return "Matrix param: " + matrixParam
                + " Header param: " + header
                + " Cookie param: " + cookie;
    }

    @GET
    @Path("context")
    public String getParamsUsingContext(
            // provide information about the URI which was accessed
            @Context UriInfo uriInfo,
            @Context HttpHeaders httpHeaders
    ) {
        String path = uriInfo.getAbsolutePath().toString();
        String cookie = httpHeaders.getCookies().toString();
        return "URI path: " + path + " Cookie: " + cookie;
    }
}
