package controller;

import controller.commands.Command;
import controller.commands.holder.CommandHolder;
import controller.commands.init.CommandHolderInit;
import exceptions.CommandNotFoundException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by daniel on 14/01/17.
 */
public class DispatcherServlet extends HttpServlet {

    private CommandHolder commandHolder;

    @Override
    public void init() throws ServletException {
        super.init();
        commandHolder = CommandHolderInit.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doRequest(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doRequest(request, response);
    }

    private void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String view;
        Command command;
        try {
            command = commandHolder.getCommand(request.getMethod(), request.getRequestURI());
        } catch (CommandNotFoundException e) {
            command = commandHolder.getPageNotFoundCommand();
        }
            view = command.execute(request, response);
            request.getRequestDispatcher(view).forward(request, response);

    }

}
