package org.openfact.services.resources.admin;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.jboss.as.controller.UnauthorizedException;
import org.jboss.logging.Logger;
import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.HttpResponse;
import org.jboss.resteasy.spi.NoLogWebApplicationException;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.openfact.authentication.AuthenticationProvider;
import org.openfact.common.ClientConnection;
import org.openfact.models.AdminRoles;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.services.resources.Cors;
import org.openfact.services.resources.admin.info.ServerInfoAdminResource;

public class AdminRootImpl implements AdminRoot {

    private static final Logger logger = Logger.getLogger(AdminRootImpl.class);

    @Context
    protected UriInfo uriInfo;

    @Context
    protected ClientConnection clientConnection;

    @Context
    protected HttpRequest request;

    @Context
    protected HttpResponse response;

    @Context
    protected OpenfactSession session;

    public AdminRootImpl() {

    }

    public static UriBuilder adminBaseUrl(UriInfo uriInfo) {
        return adminBaseUrl(uriInfo.getBaseUriBuilder());
    }

    public static UriBuilder adminBaseUrl(UriBuilder base) {
        return base.path(AdminRoot.class);
    }

    @Override
    public Response masterOrganizationAdminConsoleRedirect() {
        OrganizationModel master = new OrganizationManager(session).getOpenfactAdminstrationOrganization();
        return Response.status(302).location(uriInfo.getBaseUriBuilder().path(AdminRoot.class).path(AdminRoot.class, "getAdminConsole").path("/").build(master.getName())).build();
    }

    @Override
    public Response masterOrganizationAdminConsoleRedirectHtml() {
        return masterOrganizationAdminConsoleRedirect();
    }

    protected OrganizationModel locateOrganization(String name, OrganizationManager organizationManager) {
        OrganizationModel organization = organizationManager.getOrganizationByName(name);
        if (organization == null) {
            throw new NotFoundException("Organization not found.  Did you type in a bad URL?");
        }
        session.getContext().setOrganization(organization);
        return organization;
    }

    public static UriBuilder adminConsoleUrl(UriInfo uriInfo) {
        return adminConsoleUrl(uriInfo.getBaseUriBuilder());
    }

    public static UriBuilder adminConsoleUrl(UriBuilder base) {
        return adminBaseUrl(base).path(AdminRoot.class, "getAdminConsole");
    }

    @Override
    public AdminConsole getAdminConsole(String name) {
        OrganizationManager organizationManager = new OrganizationManager(session);
        OrganizationModel organization = locateOrganization(name, organizationManager);
        AdminConsole service = new AdminConsoleImpl(organization);
        ResteasyProviderFactory.getInstance().injectProperties(service);
        return service;
    }

    protected AdminAuth authenticateOrganizationAdminRequest(HttpHeaders headers, HttpServletRequest httpServletRequest) {       
        AuthenticationProvider authResult = session.getProvider(AuthenticationProvider.class);
        String organizationName = authResult.getOrganizationName(headers, httpServletRequest);
        OrganizationManager organizationManager = new OrganizationManager(session);
        OrganizationModel organization = organizationManager.getOrganizationByName(organizationName);
        if (organization == null) {
            throw new UnauthorizedException("Unknown organization in token");
        }
        session.getContext().setOrganization(organization);

        return new AdminAuth(organization, authResult.getUser(headers, httpServletRequest));
    }

    public static UriBuilder organizationsUrl(UriInfo uriInfo) {
        return organizationsUrl(uriInfo.getBaseUriBuilder());
    }

    public static UriBuilder organizationsUrl(UriBuilder base) {
        return adminBaseUrl(base).path(AdminRoot.class, "getOrganizationsAdmin");
    }

    @Override
    public OrganizationsAdminResource getOrganizationsAdmin(HttpHeaders headers, HttpServletRequest httpServletRequest) {
        handlePreflightRequest();

        AdminAuth auth = authenticateOrganizationAdminRequest(headers, httpServletRequest);
        if (auth != null) {
            logger.debug("authenticated admin access for: " + auth.getUser().getUsername());
        }

        Cors.add(request).allowedOrigins("*").allowedMethods("GET", "PUT", "POST", "DELETE").exposedHeaders("Location").auth().build(response);

        OrganizationsAdminResource adminResource = new OrganizationsAdminResourceImpl(auth);
        ResteasyProviderFactory.getInstance().injectProperties(adminResource);
        return adminResource;
    }

    @Override
    public CodesCatalogAdminResource getCodesCatalogResource(HttpHeaders headers, HttpServletRequest httpServletRequest) {
        handlePreflightRequest();

        AdminAuth auth = authenticateOrganizationAdminRequest(headers, httpServletRequest);

        if (auth != null) {
            logger.debug("authenticated admin access for: " + auth.getUser().getUsername());
        }

        Cors.add(request).allowedOrigins("*").allowedMethods("GET", "PUT", "POST", "DELETE").auth().build(response);

        CodesCatalogAdminResource catalogResource = new CodesCatalogAdminResourceImpl(auth);
        ResteasyProviderFactory.getInstance().injectProperties(catalogResource);
        return catalogResource;
    }

    @Override
    public CommonsAdminResource getCommonsResource(HttpHeaders headers, HttpServletRequest httpServletRequest) {
        handlePreflightRequest();

        AdminAuth auth = authenticateOrganizationAdminRequest(headers, httpServletRequest);

        if (auth != null) {
            logger.debug("authenticated admin access for: " + auth.getUser().getUsername());
        }

        Cors.add(request).allowedOrigins("*").allowedMethods("GET", "PUT", "POST", "DELETE").auth().build(response);

        CommonsAdminResource commonsResource = new CommonsAdminResourceImpl();
        ResteasyProviderFactory.getInstance().injectProperties(commonsResource);
        return commonsResource;
    }

    @Override
    public ServerInfoAdminResource getServerInfo(HttpHeaders headers, HttpServletRequest httpServletRequest) {
        handlePreflightRequest();

        AdminAuth auth = authenticateOrganizationAdminRequest(headers, httpServletRequest);
        if (!isAdmin(auth)) {
            throw new ForbiddenException();
        }

        if (auth != null) {
            logger.debug("authenticated admin access for: " + auth.getUser().getUsername());
        }

        Cors.add(request).allowedOrigins("*").allowedMethods("GET", "PUT", "POST", "DELETE").auth().build(response);

        ServerInfoAdminResource adminResource = new ServerInfoAdminResourceImpl();
        ResteasyProviderFactory.getInstance().injectProperties(adminResource);
        return adminResource;
    }

    protected boolean isAdmin(AdminAuth auth) {
        OrganizationManager organizationManager = new OrganizationManager(session);
        if (auth.getOrganization().equals(organizationManager.getOpenfactAdminstrationOrganization())) {
            if (auth.hasOneOfOrganizationRole(AdminRoles.ADMIN, AdminRoles.CREATE_ORGANIZATION)) {
                return true;
            }            
        }
        return false;
    }

    protected void handlePreflightRequest() {
        if (request.getHttpMethod().equalsIgnoreCase("OPTIONS")) {
            logger.debug("Cors admin pre-flight");
            Response response = Cors.add(request, Response.ok()).preflight().allowedMethods("GET", "PUT", "POST", "DELETE").auth().build();
            throw new NoLogWebApplicationException(response);
        }
    }

}
