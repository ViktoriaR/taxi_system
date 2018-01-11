package com.taxi_system.servlet;

import com.taxi_system.commands.Command;
import com.taxi_system.db_connection.Config;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Victoria on 24.12.2017.
 */
@WebServlet(
        name = "TaxiSystemServlet",
        urlPatterns = {""}
)
public class TaxiSystemServlet extends HttpServlet {

    TaxiSystemServletHelper helper = TaxiSystemServletHelper.getInstance();

    public TaxiSystemServlet() {
        super();
    }

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        SessionLogic.print(request,response);
//        CookieLogic.setCokkie(response);
//        CookieLogic.printCookie(request,response);
        String page = null;
        try {
            Command command = helper.getCommand(request);
            page = command.execute(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
//            request.setAttribute("messageError", Message.getInstance().getProperty(Message.SERVLET_EXECPTION));
            page = Config.getInstance().getProperty(Config.ERROR);
        } catch (IOException e) {
            e.printStackTrace();
//            request.setAttribute("messageError", Message.getInstance().getProperty(Message.IO_EXCEPTION));
            page = Config.getInstance().getProperty(Config.ERROR);
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String jsp = "/jsp/first.jsp";
//        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(jsp);
//        req.setAttribute("testMessage", "My first request attribute");
//        addDBResultToRequest(req);
//        requestDispatcher.forward(req, resp);
//    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
