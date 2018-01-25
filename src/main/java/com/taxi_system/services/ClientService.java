package com.taxi_system.services;

import com.taxi_system.dao.ClientDAO;
import com.taxi_system.dao.factory.FactoryDAO;
import com.taxi_system.db_entities.Client;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Victoria on 03.01.2018.
 */
public class ClientService {
    private ClientDAO clientDao;

    public ClientService() {
        clientDao = FactoryDAO.getClientDAO();
    }

    public boolean checkClient(String login, String password) {
        return clientDao.findByLoginAndPassword(login, password) != null;
    }

    public void addClient(String login, String password, String name) throws Exception {
        if (clientDao.findByLogin(login) != null) throw new Exception("Login is already exists");
        if (password.equals("")) throw new Exception("Enter password");
        clientDao.add(login, password, name);
    }

    public void updateClient(Client client) {
        clientDao.update(client);
    }

    public void deleteClient(String login, String password) {
        clientDao.delete(new Client(login, password, null));
    }

    public Client getClient(String login) {
        return clientDao.findByLogin(login);
    }

    public void updateClientInDB(Connection connection, Client client) throws SQLException {
        clientDao.updateInDB(connection, client);
    }
}
