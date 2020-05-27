package ua.yunyk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {

	private String CREATE = "INSERT INTO Customer(`first_name`, `last_name`, `amount_of_money`) VALUES(?,?,?)";
	private String READ = "SELECT * FROM Customer WHERE id = ?";	
	private String UPDATE_BY_ID = "UPDATE Customer SET first_name = ?, last_name = ?, amount_of_money = ? WHERE id = ?";
	private String DELETE_BY_ID = "DELETE FROM Customer WHERE id = ?";
	private String READ_ALL = "SELECT * FROM Customer";
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public CustomerDao(Connection connection) {
		super();
		this.connection = connection;
	}

	public void insert(Customer customer) throws SQLException {
		preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setString(1, customer.getFirstName());
		preparedStatement.setString(2, customer.getLastName());
		preparedStatement.setFloat(3, customer.getAmountOfMoney());
		preparedStatement.executeUpdate();
	}
	
	public Customer read(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(READ);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		return CustomerMapper.map(resultSet);
	}
	
	public int update(Customer customer) throws SQLException {
		preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1, customer.getFirstName());
		preparedStatement.setString(2, customer.getLastName());
		preparedStatement.setFloat(3, customer.getAmountOfMoney());
		preparedStatement.setInt(4, customer.getId());
		return preparedStatement.executeUpdate();
	}
	
	public int delete(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, id);
		return preparedStatement.executeUpdate();
	}
	
	public List<Customer> readAll() throws SQLException{
		List<Customer> customers = new ArrayList<Customer>();
		preparedStatement = connection.prepareStatement(READ_ALL);
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			customers.add(CustomerMapper.map(resultSet));
		}
		return customers;
	}
}
