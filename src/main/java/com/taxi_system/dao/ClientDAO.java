package com.taxi_system.dao;

import com.taxi_system.db_entities.Client;
import javafx.util.Pair;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Victoria on 25.12.2017.
 */
public interface ClientDAO {

    Client findByLogin(String login);

    Client findByLoginAndPassword(String login, String password);

    void add(String login, String password, String name);

    int update(Client client);

    int delete(Client client);

    Client getById(long id);

    void updateInDB(Connection connection, Client order) throws SQLException;
}
