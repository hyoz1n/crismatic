package Clases;

import java.util.Arrays;
import java.util.Objects;

public class Administrador {
    private int id;
    private String user;
    private String pass;
public Administrador()
    {
        user = "Cristian";
        pass = "123";
    }

    public Administrador(int id, String user, String contraseña) {
        this.id = id;
        this.user = user;
        this.pass = contraseña;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}