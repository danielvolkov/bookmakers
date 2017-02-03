package bookmakers.controller;

import controller.DispatcherServlet;
import controller.commands.Command;
import controller.commands.authorization.LoginCommand;
import controller.commands.holder.CommandHolder;
import controller.parser.LoginParser;
import controller.security.Encryptor;
import model.entity.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import services.UserService;
import util.constants.Attributes;
import util.constants.Pages;
import util.validators.LoginValidator;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Created by daniel on 2/3/17.
 */
public class ControllerTest {
    @Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;

    @Mock
    HttpSession session;

    @Mock
    LoginParser loginParser;

    @Mock
    LoginValidator loginValidator;

    @Mock
    User user;

    @Mock
    Encryptor encryptor;

    @Mock
    UserService userService;


    private DispatcherServlet dispatcherServlet;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        session.setAttribute(Attributes.USER,user);
    }

    @Test
    public void loginCommandTest() throws IOException {
        LoginCommand loginCommand = new LoginCommand(loginParser,loginValidator);
        when(loginParser.getEntity()).thenReturn(user);
        when(loginValidator.isValid(user)).thenReturn(true);
        when(userService.login(user)).thenReturn(user);
        when(request.getSession()).thenReturn(session);

        assertEquals(Pages.CABINET,loginCommand.execute(request,response));
    }


}
