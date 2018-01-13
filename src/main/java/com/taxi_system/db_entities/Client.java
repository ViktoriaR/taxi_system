package com.taxi_system.db_entities;

import java.io.Serializable;

/**
 * Created by Victoria on 22.12.2017.
 */
public class Client implements Serializable {
    private int clientId;
    private String login;
    private String password;
    private String name;
    private long sum;

    public Client(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
    }


    public Client(int clientId, String login, String password, String name, long sum) {
        this.clientId = clientId;
        this.login = login;
        this.password = password;
        this.name = name;
        this.sum = sum;
    }

    public int getId() {
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

    public boolean changePassword(String oldPassword, String newPassword) {
        boolean result = false;
        if (this.password.equals(oldPassword)) {
            this.password = newPassword;
            result = true;
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    public String clientInfo() {
        StringBuilder result = new StringBuilder();
        result.append("com.taxi_system.db_entities.client: ");
        result.append("id = ").append(clientId);
        result.append(", name = ").append(name);
        result.append(", phone number = ").append(login);
        result.append(", spent money =  ").append(sum);
        return result.toString();
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
