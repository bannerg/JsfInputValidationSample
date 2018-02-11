package pe.edu.utp.javawebregionlist.controllers;

import pe.edu.utp.javawebregionlist.models.Country;
import pe.edu.utp.javawebregionlist.models.HrService;
import pe.edu.utp.javawebregionlist.models.Region;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "RegionsController", urlPatterns = "/regions")
public class RegionsController extends HttpServlet {
    private Connection connection;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest("Post",request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest("Get",request,response);
    }

    private Connection getConnection() {
        if (connection == null){
            try {
                InitialContext ctx = new InitialContext();
                DataSource dataSource = (DataSource) ctx
                        .lookup("jdbc/MySQLDataSource");
                connection = dataSource.getConnection();
            } catch (SQLException  | NamingException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    private void processRequest(
            String method,
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException{
//        Init Values
        String action = request.getParameter("action");
        String url = "index.jsp";

        if (method.equals("Get") && action == null){   action = "index";    }
        if (method.equals("Post") && action.equalsIgnoreCase("index")){   return;   }
        if (method.equals("Get") && action.equalsIgnoreCase("create")){   return;    }
        if (method.equals("Get") && action.equalsIgnoreCase("update")){   return;    }
//            Accediendo al FACADE
        HrService service = new HrService();
        //Connection Stablishment
        service.setConnection(getConnection());
//        action = index, method = Get
        if (action.equalsIgnoreCase("index")) {
            List<Region> regions = service.findAllRegions();
            request.setAttribute("regions",regions);
            url = "listRegions.jsp";
        }
//        action = show, method = Get
        if (action.equalsIgnoreCase("show")) {
            int id = Integer.parseInt(
                    request
                    .getParameter("id")
            );
            request.setAttribute("region", service.findRegionById(id));
        }
//        action = new, method = Post
        if (action.equalsIgnoreCase("new")) {
            url = "newRegion.jsp";
        }
//        action = create, method = Post
        if (action.equalsIgnoreCase("create")) {
            String name = request
                    .getParameter("name");
            Region region = service.createRegion(name);
            request.setAttribute("regions", service.findAllRegions());
            url = "listRegions.jsp";
        }
//        action = edit, method = Post
        if (action.equalsIgnoreCase("edit")) {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("regions", service.findRegionById(id));
            url = "editRegion.jsp";
        }
//        action = delete, method = Get
        if (action.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            boolean result = service.deleteRegion(id);
            request.setAttribute("regions", service.findAllRegions());
            url = "listRegions.jsp";
        }
//        action = update, method = Post
        if (action.equalsIgnoreCase("update")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            Region region = new Region(id,name);
            boolean result = service.updateRegion(region);
            request.setAttribute("regions", service.findAllRegions());
            url = "listRegions.jsp";
        }
//        action = showCountries, method = Get
        if (action.equalsIgnoreCase("showCountries")){
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            Region region = new Region(id,name);
            List<Country> countries = service.findCountriesByRegion(region);
            request.setAttribute("countries", countries);
            url = "listCountries.jsp";
        }
        //Enviamos los registros
        request.getRequestDispatcher(url).forward(request,response);
    }
}
