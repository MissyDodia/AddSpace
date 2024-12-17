package in.co.adspace.bean;

import java.io.InputStream;
import java.sql.Blob;

public class SpaceBean extends BaseBean {
    private String spacename;
    private String location;
    private String area;
    private String type;
    private String company;
    private String duration;
    private String price;
    private long admine_id;

    // Fields for image data
    private InputStream image1;
    private InputStream image2;
    private InputStream image3;
    private Blob photo1;
    private Blob photo2;
    private Blob photo3;

    // Getters and setters for all fields
    public String getSpacename() { return spacename; }
    public void setSpacename(String spacename) { this.spacename = spacename; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }
    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }
    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }
    public long getAdmine_id() { return admine_id; }
    public void setAdmine_id(long admine_id) { this.admine_id = admine_id; }

    public InputStream getImage1() { return image1; }
    public void setImage1(InputStream image1) { this.image1 = image1; }
    public InputStream getImage2() { return image2; }
    public void setImage2(InputStream image2) { this.image2 = image2; }
    public InputStream getImage3() { return image3; }
    public void setImage3(InputStream image3) { this.image3 = image3; }
	public Blob getPhoto1() {
		return photo1;
	}
	public void setPhoto1(Blob photo1) {
		this.photo1 = photo1;
	}
	public Blob getPhoto2() {
		return photo2;
	}
	public void setPhoto2(Blob photo2) {
		this.photo2 = photo2;
	}
	public Blob getPhoto3() {
		return photo3;
	}
	public void setPhoto3(Blob photo3) {
		this.photo3 = photo3;
	}
    
    
}
