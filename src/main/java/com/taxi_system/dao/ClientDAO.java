package com.taxi_system.dao;

import com.taxi_system.db_entities.Client;
import javafx.util.Pair;

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
}
