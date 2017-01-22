package controller.commands;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by daniel on 1/19/17.
 */
public interface Command {
    String execute(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
