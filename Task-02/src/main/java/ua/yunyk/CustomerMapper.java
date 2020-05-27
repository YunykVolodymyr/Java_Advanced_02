package ua.yunyk;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper {
	
	public static Customer map(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id");
		String firstName = resultSet.getString("first_name");
		String lastName = resultSet.getString("last_name");
		float amountOfMoney = resultSet.getFloat("amount_of_money");
		return new Customer(id, firstName, lastName, amountOfMoney);
	}
	
}
