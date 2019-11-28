package nuc.web.pojo;

public class Employee {

    private int id;
    private int employee_number;
    private String name;
    private String gender;
    private String birthday;
    private String telephone;
    private String email;
    private String address;
    private String photo;
    private String education;
    private int department_number;
    private int position_number;
    private String in_time;
    private String password;
    private String notes;

    @Override
    public String toString() {
        return "Employee [id=" + id + ", employee_number=" + employee_number + ", name=" + name + ", gender=" + gender
                + ", birthday=" + birthday + ", in_time=" + in_time + ", password=" + password + "]";
    }

    public Employee(int id, String name, String gender, String birthday, String telephone, String email, String address,
                    String education, String password) {
        super();
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
        this.education = education;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployee_number() {
        return employee_number;
    }

    public void setEmployee_number(int employee_number) {
        this.employee_number = employee_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public int getDepartment_number() {
        return department_number;
    }

    public void setDepartment_number(int department_number) {
        this.department_number = department_number;
    }

    public Employee(int employee_number, String name, String gender, String birthday, String telephone, String email,
                    String address, String education, int department_number, int position_number, String password) {
        super();
        this.employee_number = employee_number;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
        this.education = education;
        this.department_number = department_number;
        this.position_number = position_number;
        this.password = password;
    }

    public int getPosition_number() {
        return position_number;
    }

    public void setPosition_number(int position_number) {
        this.position_number = position_number;
    }

    public String getIn_time() {
        return in_time;
    }

    public void setIn_time(String in_time) {
        this.in_time = in_time;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Employee(int id, int employee_number, String name, String gender, String birthday, String telephone,
                    String email, String address, String photo, String education, int department_number, int position_number,
                    String in_time, String password, String notes) {
        super();
        this.id = id;
        this.employee_number = employee_number;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
        this.photo = photo;
        this.education = education;
        this.department_number = department_number;
        this.position_number = position_number;
        this.in_time = in_time;
        this.password = password;
        this.notes = notes;
    }

    public Employee() {
        super();
        // TODO Auto-generated constructor stub
    }


}
