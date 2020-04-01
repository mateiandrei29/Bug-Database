package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import model.Product;

public class ProductRepository {

	public static List<Product> getAllProducts() {
		List<Product> list = new ArrayList<Product>();
		DBConnection mysqlConnect = new DBConnection();
		String sql = "SELECT * FROM `product`";
		ResultSet rs = null;
		int i = 1;
		try {
			PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
			rs = statement.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String description = rs.getString("description");
				int finished = rs.getInt("finished");

				Product p = new Product(name, description, finished);
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			mysqlConnect.disconnect();
		}
		return list;
	}

	public static void insertProduct(Product product) {
		DBConnection mysqlConnect = new DBConnection();
		String sql = "insert into product(name,description,finished) values(?,?,?)";

		try {
			PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);

			statement.setString(1, product.getName());
			statement.setString(2, product.getDescription());
			statement.setInt(3, product.getFinished());

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			mysqlConnect.disconnect();
		}
	}

	public static void deleteProduct(int id) {
		DBConnection mysqlConnect = new DBConnection();
		String sql = "delete from product where idProduct=";
		sql += "?";

		try {
			PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
			statement.setInt(1, id);

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			mysqlConnect.disconnect();
		}
	}

	public static void updateProduct(Product product) {
		DBConnection mysqlConnect = new DBConnection();
		String sql = "update product set name=?, description=?, finished=? where idProduct=?";
		try {
			PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
			statement.setString(1, product.getName());
			statement.setString(2, product.getDescription());
			statement.setInt(3, product.getFinished());
			statement.setInt(4, product.getIdProduct());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			mysqlConnect.disconnect();
		}
	}

	public static List<Product> selectByName(String toBeFound) {
		DBConnection mysqlConnect = new DBConnection();
		String sql = "SELECT * FROM `product` where name=?";

		ResultSet rs = null;
		List<Product> products = new ArrayList<Product>();
		int i = 1;
		try {
			PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
			statement.setString(1, toBeFound);

			rs = statement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("idProduct");
				String name = rs.getString("name");
				String description = rs.getString("description");
				int finished = rs.getInt("finished");
				Product p = new Product(name, description, finished);
				p.setIdProduct(id);
				products.add(p);

			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			mysqlConnect.disconnect();
		}
		return products;
	}
	public static Product selectById(int id) {
		DBConnection mysqlConnect = new DBConnection();
		String sql = "SELECT * FROM `product` where idProduct=?";

		ResultSet rs = null;
		
		int i = 1;
		try {
			PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
			statement.setInt(1, id);

			rs = statement.executeQuery();
			while (rs.next()) {
				//int id = rs.getInt("idProduct");
				String name = rs.getString("name");
				String description = rs.getString("description");
				int finished = rs.getInt("finished");
				Product p = new Product(name, description, finished);
				p.setIdProduct(id);
				return p;

			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			mysqlConnect.disconnect();
		}
		return null;
	}

}
