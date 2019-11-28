package nuc.web.pojo;


import java.io.Serializable;

/**
 * 部门表
 */
public class Department {

    private Integer id;
    private Integer departmentNumber;
    private String name;
    private String manager;
    private String telephone;
    private String address;
    private String notes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(Integer departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }


    @Override
    public String toString() {
        return "Department [id=" + id + ", departmentNumber=" + departmentNumber + ", name=" + name + ", manager="
                + manager + ", telephone=" + telephone + ", address=" + address + ", notes=" + notes + "]";
    }

}
