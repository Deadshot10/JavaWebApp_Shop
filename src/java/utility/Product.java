package utility;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Product implements Comparable<Product> {
	
	private long id;
	private long product_id;
	private String title;
	private String description;
	private float rating;
	private long price;
	private long inet_price;
	private String image;
	
	public Product () {
		
	}
	
	public Product(long product_id, String title, String description, float rating, long price, long inet_price, String image) {
		this.id = -1L;
		this.product_id = product_id;
		this.title = title;
		this.description = description;
		this.rating = rating;
		this.price = price;
		this.inet_price = inet_price;
		this.image = image;
	}

	public Product(ResultSet rs) throws SQLException {
		setId(rs.getLong(1));
		setProduct_id(rs.getLong(2));
		setTitle(rs.getString(3));
		setDescription(rs.getString(4));
		setRating(rs.getFloat(5));
		setPrice(rs.getLong(6));
		setInet_price(rs.getLong(7));
		setImage(rs.getString(8));
        
    }
	
	public long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public long getInet_price() {
		return inet_price;
	}

	public void setInet_price(long inet_price) {
		this.inet_price = inet_price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return " id: " + id + " title: " + title + " product_id: " + product_id + " description: " + description 
				+ " rating: " + rating + " inet_price: " + inet_price + " price: " + price + " image: " + image;
		
	}

	@Override
	public int compareTo(Product o) {
		// TODO Auto-generated method stub
		return this.product_id > o.product_id ? 1 : this.product_id < o.product_id ? -1 : 0;
	}

}
