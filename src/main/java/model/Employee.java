package model;

public class Employee {
    private int idEmployee;
    private String name;
    private String username;
    private String password;

    public Employee(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public Employee getEmployeeById(int id) {
        if (id == getIdEmployee())
            return this;
        return null;
    }

}
