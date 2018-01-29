package com.taxi_system.db_entities;

import java.io.Serializable;

/**
 * Created by Victoria on 22.12.2017.
 */
public class Client implements Serializable {
    private long clientId;
    private String login;
    private String password;
    private String name;
    private float sum;

    public Client(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
    }


    public Client(long clientId, String login, String password, String name, float sum) {
        this.clientId = clientId;
        this.login = login;
        this.password = password;
        this.name = name;
        this.sum = sum;
    }

    public long getId() {
        return clientId;
    }

    public void setId(int clientId) {
        this.clientId = clientId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        return login != null ? login.equals(client.login) : client.login == null;
    }

    @Override
    public int hashCode() {
        return login != null ? login.hashCode() : 0;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("client name = ").append(name);
        result.append(", client phone number = ").append(login);
        return result.toString();
    }
}
