package Hard.dto;

public class WorkRecord {
    private String employeeName;
    private String department;

    public WorkRecord(String employeeName, String department) {
        this.employeeName = employeeName;
        this.department = department;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "WorkRecord{" +
                "employeeName='" + employeeName + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
