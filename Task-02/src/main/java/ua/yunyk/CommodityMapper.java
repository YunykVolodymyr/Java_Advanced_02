package ua.yunyk;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommodityMapper {

	public static Commodity map(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id");
		String name = resultSet.getString("name");
		float priceForOne = resultSet.getFloat("price_for_one");
		int quantity = resultSet.getInt("quantity");
		return new Commodity(id, name, priceForOne, quantity);
	}
	
}
