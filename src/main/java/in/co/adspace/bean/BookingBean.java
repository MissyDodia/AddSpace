package in.co.adspace.bean;

public class BookingBean extends BaseBean {
	
    public String getSpacename() {
		return spacename;
	}
	public void setSpacename(String spacename) {
		this.spacename = spacename;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public long getSpaceid() {
		return spaceid;
	}
	public void setSpaceid(long spaceid) {
		this.spaceid = spaceid;
	}
	private long spaceid;

	private String spacename;
    private String location;
    private String type;
    private String email;
    private String contactno;
    private String company;
    private String duration;
    private String price;
    private String status; 
    private String payment;
}
