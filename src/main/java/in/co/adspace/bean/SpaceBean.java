package in.co.adspace.bean;

public class SpaceBean extends BaseBean {
	private String spacename;
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
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	private String location;
    private String area;
    private String type;
    private String company;
    private String duration;
    private String price;
    public long getAdmine_id() {
		return admine_id;
	}
	public void setAdmine_id(long admine_id) {
		this.admine_id = admine_id;
	}
	private long admine_id;
}
