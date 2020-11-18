package org.santotomas.library_app;

import java.util.Objects;

/**
 * Modelo que nos ayuda a una mejor comprension al agrupar datos de una entidad, en este caso, ahora sabemos un usuario
 * tiene nombre de usuario y una password
 */
public class User {

    // Atributos
    private String UserName;
    private String password;

    // Constructores

    /**
     * Constructor vacio para "armar la clase durante el camino"
     */
    public User() { }

    /**
     * Constructor basico para armar un usuario en condiciones
     * @param userName nombre del usuario
     * @param password contrasena TODO: en un futuro encriptar password
     */
    public User(String userName, String password) {
        UserName = userName;
        this.password = password;
    }

    // Getters & Setters
    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getUserName().equals(user.getUserName()) &&
                getPassword().equals(user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserName(), getPassword());
    }

    @Override
    public String toString() {
        return "User{" +
                "UserName='" + UserName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
