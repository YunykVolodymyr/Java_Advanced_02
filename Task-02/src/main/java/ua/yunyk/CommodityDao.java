package ua.yunyk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommodityDao {
	
	private String CREATE = "INSERT INTO Commodity(`name`, `price_for_one`, `quantity`) VALUES (?,?,?)";
	private String READ_BY_ID = "SELECT * FROM Commodity WHERE id = ?";
	private String READ_ALL = "SELECT * FROM Commodity";
	private String UPDATE = "UPDATE Commodity SET name=?, price_for_one=?, quantity=? WHERE id = ?";
	private String DELETE = "DELETE FROM Commodity WHERE id=?";
	
	private Connection connection;
	private PreparedStatement preparedStatement;

	public CommodityDao(Connection connection) {
		super();
		this.connection = connection;
	}
	
	public void insert(Commodity commodity) throws SQLException {
		preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setString(1, commodity.getName());
		preparedStatement.setFloat(2, commodity.getPriceForOne());
		preparedStatement.setInt(3, commodity.getQuantity());
		preparedStatement.executeUpdate();
	}
	
	public Commodity read(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		return CommodityMapper.map(resultSet);
	}
	
	public List<Commodity> readAll() throws SQLException{
		List<Commodity> commodities = new ArrayList<Commodity>();
		preparedStatement = connection.prepareStatement(READ_ALL);
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			commodities.add(CommodityMapper.map(resultSet));
		}
		return commodities;
	}
	
	public int update(Commodity commodity) throws SQLException {
		preparedStatement = connection.prepareStatement(UPDATE);
		preparedStatement.setString(1, commodity.getName());
		preparedStatement.setFloat(2, commodity.getPriceForOne());
		preparedStatement.setInt(3, commodity.getQuantity());
		preparedStatement.setInt(4, commodity.getId());
		return preparedStatement.executeUpdate();
	}
	
	public int delete(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE);
		preparedStatement.setInt(1, id);
		return preparedStatement.executeUpdate();
	}

}
