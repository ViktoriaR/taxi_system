package com.taxi_system.services;

import com.taxi_system.dao.ClientDAO;
import com.taxi_system.db_entities.Client;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.SQLException;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {

    @Mock
    private ClientDAO dao;

    private Client client = new Client("login", "pass", "name");

    private class ClientServiceTestImpl extends ClientService {
        @Override
        protected ClientDAO initClientDAO() {
            return dao;
        }
    }

    @Test
    public void checkClient_Exists() {
        String login = "login";
        String pass = "pass";
        Mockito.when(dao.findByLoginAndPassword(login, pass)).thenReturn(new Client(login, pass, "name"));

        ClientService service = new ClientServiceTestImpl();
        boolean result = service.checkClient(login, pass);

        Assert.assertTrue("Expected client to be in db", result);
    }

    @Test
    public void checkClient_NotExists() {
        String login = "login";
        String pass = "pass";
        Mockito.when(dao.findByLoginAndPassword(login, pass)).thenReturn(null);

        ClientService service = new ClientServiceTestImpl();
        boolean result = service.checkClient(login, pass);

        Assert.assertFalse("Expected client to be in db", result);
    }

    @Test(expected = Exception.class)
    public void addClient_Exception() throws Exception {
        String login = "login";
        String pass = "pass";
        String name = "name";

        Mockito.when(dao.findByLogin(login)).thenReturn(client);

        ClientService service = new ClientServiceTestImpl();
        service.addClient(login, pass, name);
    }

    @Test
    public void addClient_HappyPath() throws Exception {
        String login = "login";
        String pass = "pass";
        String name = "name";

        Mockito.when(dao.findByLogin(login)).thenReturn(null);

        ClientService service = new ClientServiceTestImpl();
        service.addClient(login, pass, name);

        Mockito.verify(dao).add(Mockito.eq(login), Mockito.eq(pass), Mockito.eq(name));
    }

    @Test
    public void getClient() {
        String login = "login";

        Mockito.when(dao.findByLogin(login)).thenReturn(client);

        ClientService service = new ClientServiceTestImpl();
        Client result = service.getClient(login);

        Assert.assertEquals("Unexpected client", client, result);
    }

    @Test
    public void updateClientInDB() throws SQLException {
        Connection connection = null;

        ClientService service = new ClientServiceTestImpl();
        service.updateClientInDB(connection, client);

        Mockito.verify(dao).updateInDB(Mockito.eq(connection), Mockito.eq(client));
    }
}