package model;

public class Product {
	private int idProduct;
	private String name;
	private String description;
	private int finished;

	public Product(String name, String description, int finished) {

		this.name = name;
		this.description = description;
		this.finished = finished;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getFinished() {
		return finished;
	}

	public void setFinished(int finished) {
		this.finished = finished;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", description=" + description + ", finished=" + finished + "]\n";
	}
	

}
