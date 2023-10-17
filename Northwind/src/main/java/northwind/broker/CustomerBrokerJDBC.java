package northwind.broker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import northwind.model.Address;
import northwind.model.Customer;


public class CustomerBrokerJDBC extends BrokerBaseJDBC<Customer> {
	
	public void insert(Customer customer) throws SQLException {
		Connection connection = getConnection();
		
		try {
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO northwind.customer (customer_id, customer_code, company_name, contact_name, "
					+ "contact_title, address, city, region, postal_code, country, phone, fax) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setInt(1, customer.getCustomerID());
			stmt.setString(2, customer.getCustomerCode());
			stmt.setString(3, customer.getCompanyName());
			stmt.setString(4, (customer.getContactName() != null ? customer.getContactName() : null));
			stmt.setString(5, (customer.getContactTitle() != null ? customer.getContactTitle() : null));
			Address address = customer.getAddress();
			stmt.setString(6, (address.getStreet() != null ? address.getStreet() : null));
			stmt.setString(7, (address.getCity() != null ? address.getCity() : null));
			stmt.setString(8, (address.getRegion() != null ? address.getRegion() : null));
			stmt.setString(9, (address.getPostalCode() != null ? address.getPostalCode() : null));
			stmt.setString(10, (address.getCountry() != null ? address.getCountry() : null));
			stmt.setString(11, (customer.getPhoneNumber() != null ? customer.getPhoneNumber() : null));
			stmt.setString(12, (customer.getFaxNumber() != null ? customer.getFaxNumber() : null));
			
			stmt.toString();
			stmt.execute();
		}
		catch (SQLException e) {
			throw(e);
		}
		finally {
			connection.close();
		}
	}
	
	public void update(Customer customer) throws SQLException {
		Connection connection = getConnection();
		
		try {
			PreparedStatement stmt = connection.prepareStatement("UPDATE northwind.customer SET customer_code = ?, company_name = ?, contact_name = ?, contact_title = ?, "
	                + "address = ?, city = ?, region = ?, postal_code = ?, country = ?, phone = ?, fax = ? WHERE customer_id = ?");
			
			stmt.setString(1, customer.getCustomerCode());
			stmt.setString(2, customer.getCompanyName());
			stmt.setString(3, (customer.getContactName() != null ? customer.getContactName() : null));
			stmt.setString(4, (customer.getContactTitle() != null ? customer.getContactTitle() : null));
			Address address = customer.getAddress();
			stmt.setString(5, (address.getStreet() != null ? address.getStreet() : null));
			stmt.setString(6, (address.getCity() != null ? address.getCity() : null));
			stmt.setString(7, (address.getRegion() != null ? address.getRegion() : null));
			stmt.setString(8, (address.getPostalCode() != null ? address.getPostalCode() : null));
			stmt.setString(9, (address.getCountry() != null ? address.getCountry() : null));
			stmt.setString(10, (customer.getPhoneNumber() != null ? customer.getPhoneNumber() : null));
			stmt.setString(11, (customer.getFaxNumber() != null ? customer.getFaxNumber() : null));
			stmt.setInt(12, customer.getCustomerID());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw(e);
		} finally {
			connection.close();
		}
	}
	
	public void delete(Customer customer) throws SQLException {
		Connection connection = getConnection();
		int customerID = customer.getCustomerID();
		
		try {
			PreparedStatement stmt = connection.prepareStatement("DELETE FROM northwind.customer WHERE customer_id = ?");
			stmt.setInt(1, customerID);
			stmt.executeUpdate();
		}
		catch (SQLException e) {
			throw(e);
		} finally {
			connection.close();
		}
		
	}
	
	public Customer get(int customerID) throws SQLException {
		Connection connection = getConnection();
		Customer customer = null;

		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM northwind.customer WHERE customer_id = ?");
			stmt.setInt(1, customerID);
			ResultSet rs = stmt.executeQuery();
			
			
			while (rs.next()) {
				customer = mapCustomer(rs);
			}
			return customer;
		}
		catch (SQLException e) {
			throw(e);
		} finally {
			connection.close();
		}
	}
	
	public List<Customer> getAll() throws SQLException {
		Connection connection = getConnection();
		List<Customer> customers = new ArrayList<Customer>();

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM northwind.customer");
			

			while(rs.next()) {
				Customer customer = mapCustomer(rs);
				customers.add(customer);
			}
			return customers;
		}
		catch (SQLException e) {
			throw(e);
		} finally {
			connection.close();
		}
	}
	
	private Customer mapCustomer(ResultSet rs) throws SQLException {
		Customer customer = new Customer();
		
		customer.setCustomerID(rs.getInt("customer_id"));
		customer.setCustomerCode(rs.getString("customer_code"));
		customer.setCompanyName(rs.getString("company_name"));
		if (rs.getString("contact_name") != null) {
			customer.setContactName(rs.getString("contact_name"));
		}
		if (rs.getString("contact_title") != null) {
			customer.setContactTitle(rs.getString("contact_title"));
		}
		Address address = new Address();
		if (rs.getString("address") != null) {
			address.setStreet(rs.getString("address"));
		}
		if (rs.getString("city") != null) {
			address.setCity(rs.getString("city"));
		}
		if (rs.getString("region") != null) {
			address.setRegion(rs.getString("region"));
 		}
		if (rs.getString("postal_code") != null) {
			address.setPostalCode(rs.getString("postal_code"));
		}
		if (rs.getString("country") != null) {
			address.setCountry(rs.getString("country"));
		}
		customer.setAddress(address);
		if (rs.getString("phone") != null) {
			customer.setPhoneNumber(rs.getString("phone"));
		}
		if (rs.getString("fax") != null) {
			customer.setFaxNumber(rs.getString("fax"));
		}
		
		return customer;
	}
}
