package nuc.web.pojo;

public class Lea {
	private int id;
	private int employee_number;
	private int department_number;
	private String start_time;
	private String end_time;
	private String days;
	private String reason;
	private String type;
	private String manager;
	private String status;
	private String notes;
	
	public Lea() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Lea(int id, int employee_number, int department_number, String start_time, String end_time, String days, String reason,
			String type, String status) {
		super();
		this.id = id;
		this.employee_number = employee_number;
		this.department_number = department_number;
		this.start_time = start_time;
		this.end_time = end_time;
		this.days = days;
		this.reason = reason;
		this.type = type;
		this.status = status;
	}

	
	public Lea(int employee_number, int department_number, String start_time, String end_time, String days,
			String reason, String type, String manager, String status) {
		super();
		this.employee_number = employee_number;
		this.department_number = department_number;
		this.start_time = start_time;
		this.end_time = end_time;
		this.days = days;
		this.reason = reason;
		this.type = type;
		this.manager = manager;
		this.status = status;
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

	public int getDepartment_number() {
		return department_number;
	}

	public void setDepartment_number(int department_number) {
		this.department_number = department_number;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	

}
