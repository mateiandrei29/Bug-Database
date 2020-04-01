package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.DBConnection;

public class Bug {
    private int idBug;
    private String description;
    private String ss; // just for the sake of this problem, the screenshot is a string containing the
    // name of the image
    private String tag;
    private int statusBug;
    private String priority;
    private int registeredBy;
    private int assignedTo;
    private int idProduct;

    public Bug(String description, String ss, String tag, int statusBug, String priority, int registeredBy,
               int assignedTo, int idProduct) {

        this.description = description;
        this.ss = ss;
        this.tag = tag;
        this.statusBug = statusBug;
        this.priority = priority;
        this.registeredBy = registeredBy;
        this.assignedTo = assignedTo;
        this.idProduct = idProduct;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getStatusBug() {
        return statusBug;
    }

    public void setStatusBug(int statusBug) {
        this.statusBug = statusBug;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public int getRegisteredBy() {
        return registeredBy;
    }

    public void setRegisteredBy(int registeredBy) {
        this.registeredBy = registeredBy;
    }

    public int getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(int assignedTo) {
        this.assignedTo = assignedTo;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdBug() {
        return idBug;
    }

    public void readBug(int bugId) {
        DBConnection mysqlConnect = new DBConnection();
        String sql = "SELECT * FROM `bug` "
                + "join employee on employee.idEmployee=bug.registeredBy"
                + " join product on product.idProduct=bug.idProduct";

        ResultSet rs = null;
        int i = 1;
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {

                if (bugId == rs.getInt("idBug")) {
                    String description = rs.getString("description");
                    String ss = rs.getString("screenshot");
                    String tag = rs.getString("tag");
                    int status = rs.getInt("statusBug");
                    String priority = rs.getString("priority");
//					int registeredBy = rs.getInt("registeredBy");
                    String nameEmp = rs.getString("employee.name");
                    int assignedTo = rs.getInt("assignedTo");
                    int idProduct = rs.getInt("idProduct");
                    String nameProd = rs.getString("product.name");

                    System.out.println("/////////////////Bug " + bugId + "/////////////////\nDescription: "
                            + description + "\nTags: " + tag + "\nStatus: " + status + "\nPriority: " + priority
                            + "\nRegistered by: " + nameEmp + "\nAssigned to employee with id: " + assignedTo
                            + "\nOn product: " + nameProd);

                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.disconnect();
        }

    }

    public static void addBug(Bug bug) {
        DBConnection mysqlConnect = new DBConnection();
        String sql = "insert into bug(description,screenshot,tag,statusBug,priority,registeredBy,assignedTo,idProduct) values(?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, bug.getDescription());
            statement.setString(2, bug.getSs());
            statement.setString(3, bug.getTag());
            statement.setInt(4, bug.getStatusBug());
            statement.setString(5, bug.getPriority());
            statement.setInt(6, bug.getRegisteredBy());
            statement.setInt(7, bug.getAssignedTo());
            statement.setInt(8, bug.getIdProduct());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.disconnect();
        }
    }

}
