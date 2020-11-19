package org.santotomas.library_app.models;

/**
 * Modelo que nos ayuda a una mejor comprension al agrupar datos de una entidad, en este caso, ahora sabemos un usuario
 * tiene nombre de usuario y una password
 */
public class User {

    // Atributos
    private String uuid;
    private String userName;
    private String password;
    private String permission;

    // Constructores

    /**
     * Constructor vacio para "armar la clase durante el camino"
     */
    public User() { }

    /**
     * Constructor basico para armar un usuario en condiciones
     * @param userName nombre del usuario
     */
    public User(String uuid, String userName, String permission) {
        this.uuid = uuid;
        this.userName = userName;
        this.permission = permission;
    }

    public User(String uuid, String userName, String password, String permission) {
        this.uuid = uuid;
        this.userName = userName;
        this.password = password;
        this.permission = permission;
    }

    // Getters & Setters
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "User{" +
                "uuid='" + uuid + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", permission='" + permission + '\'' +
                '}';
    }
}
