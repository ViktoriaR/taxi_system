package com.taxi_system.services;

import com.taxi_system.dao.ClientDAO;
import com.taxi_system.dao.factory.FactoryDAO;
import com.taxi_system.dao.impl.ClientDAOImpl;
import com.taxi_system.db_entities.Client;
import com.taxi_system.variables.Variables;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Victoria on 03.01.2018.
 */
public class ClientService {
    private ClientDAO clientDao;

    public ClientService() {
        clientDao = initClientDAO();
    }

    /**
     * This method checks, if there is a client with this login and
     * password in db
     *
     * @param login
     * @param password
     * @return true, if there is a client with this login and
     * password in db, otherwise false
     */
    public boolean checkClient(String login, String password) {
        return clientDao.findByLoginAndPassword(login, password) != null;
    }

    /**
     * This method create new client with this login, password and name in db
     *
     * @param login
     * @param password
     * @param name
     *
     * @throws Exception if client with such login is already exists
     */
    public void addClient(String login, String password, String name) throws Exception {
        if (clientDao.findByLogin(login) != null) throw new Exception(Variables.LOGIN_EXISTS_EXCEPTION_MESSAGE.getValue());
        clientDao.add(login, password, name);
    }

    /**
     * This method get client with this login from db
     *
     * @param login
     * @return Client, if there is a client with this login in db, otherwise null
     */
    public Client getClient(String login) {
        return clientDao.findByLogin(login);
    }

    /**
     * This method add update SQL statements to transaction in connection
     *
     * @param connection to db
     * @param client is Client, that should be update
     */
    public void updateClientInDB(Connection connection, Client client) throws SQLException {
        clientDao.updateInDB(connection, client);
    }

    protected ClientDAO initClientDAO() {
        return FactoryDAO.getClientDAO();
    }
}
