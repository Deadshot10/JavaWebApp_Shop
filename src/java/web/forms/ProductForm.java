package web.forms;

import utility.Product;

public class ProductForm
{
	private long id;
	private long product_id;
	private String title;
	private String description;
	private float rating;
	private long price;
	private long inet_price;
	private String image;

	public void initFromProduct(Product product) {
		this.id = product.getId();
		this.product_id = product.getProduct_id();
		this.title = product.getTitle();
		this.description = product.getDescription();
		this.rating = product.getRating();
		this.price = product.getPrice();
		this.inet_price = product.getInet_price();
		this.image = product.getImage();
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

}
