package model;

public class BugThread {
    private int idComm;
    private String message;
    private int idEmployee;
    private int idBug;
    public BugThread(String message, int idEmployee, int idBug) {
        super();
        this.message = message;
        this.idEmployee = idEmployee;
        this.idBug = idBug;
    }
    public int getIdComm() {
        return idComm;
    }
    public void setIdComm(int idComm) {
        this.idComm = idComm;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public int getIdEmployee() {
        return idEmployee;
    }
    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }
    public int getIdBug() {
        return idBug;
    }


}
