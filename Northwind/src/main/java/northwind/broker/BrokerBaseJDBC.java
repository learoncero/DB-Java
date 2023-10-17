package northwind.broker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public abstract class BrokerBaseJDBC<T> {
	
	public Connection getConnection() throws SQLException{
		Connection connection = DriverManager.getConnection("jdbc:postgresql://elmo.hostingcenter.uclv.net:5432/itb_inf_2022_lro3572", "itb_inf_2022_lro3572", "PW_ROLe");
		return connection;
	}
	
	public abstract void insert(T value) throws SQLException;
	
	public abstract void update(T value) throws SQLException;
	
	public abstract void delete(T value) throws SQLException;
	
	public abstract T get(int value) throws SQLException;
	
	public abstract List<T> getAll() throws SQLException;
}