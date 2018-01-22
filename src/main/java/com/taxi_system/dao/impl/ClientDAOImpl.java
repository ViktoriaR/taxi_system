package com.taxi_system.dao.impl;

import com.taxi_system.dao.ClientDAO;
import com.taxi_system.db_entities.Client;
import javafx.util.Pair;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Victoria on 25.12.2017.
 */
public class ClientDAOImpl extends AbstractCRUD<Client> implements ClientDAO {

    @Override
    public String getCreateQuery(Client object) {
        StringBuilder stringBuilder = new StringBuilder("INSERT INTO client(login, password, name, sum) VALUES('");
        stringBuilder.append(object.getLogin()).append("', '");
        stringBuilder.append(object.getPassword()).append("', '");
        stringBuilder.append(object.getName()).append("', '");
        stringBuilder.append(object.getSum()).append("')");
        return stringBuilder.toString();
    }

    @Override
    public String getReadQuery(String conditions) {
        return "SELECT * FROM client WHERE 1 = 1" + conditions;
    }

    @Override
    public String getUpdateQuery(Client object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE client SET login = '").append(object.getLogin());
        stringBuilder.append("', password = '").append(object.getPassword());
        stringBuilder.append("', name = '").append(object.getName());
        stringBuilder.append("', sum = '").append(object.getSum());
        stringBuilder.append("' WHERE id = ").append(object.getId());
        return stringBuilder.toString();
    }

    @Override
    public String getDeleteQuery(Client object) {
        return "DELETE FROM client WHERE login = " + object.getLogin();
    }

    @Override
    protected Client convertRs(ResultSet rs) {
        Client client = null;
        try {
            long id = rs.getLong("id");
            String login = rs.getString("login");
            String password = rs.getString("password");
            String name = rs.getString("name");
            float sum = rs.getFloat("sum");
            client = new Client(id, login, password, name, sum);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public Client findByLogin(String login) {
        List<Client> list = read(Arrays.asList("login = " + login));
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public Client findByLoginAndPassword(String login, String password) {
        List<Client> list = read(Arrays.asList("login = " + login, "password = " + password));
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public void add(String login, String password, String name) {
        create(new Client(login, password, name));
    }
}
