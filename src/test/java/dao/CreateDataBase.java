package dao;

import java.sql.Connection;
import java.sql.SQLException;

import junit.framework.Assert;

public class CreateDataBase extends ConnectionOne {
	
	public void createSDatabaseMasses() {
		try {
			Connection conn = openConnection();
			conn.createStatement().executeUpdate("CREATE TABLE `massas` ( \r\n"
					+ "`IDMASSAS` int(11) NOT NULL AUTO_INCREMENT, \r\n"
					+ "`NAME_PRODUCT` varchar(45) DEFAULT NULL, \r\n" + "`CUSTOMIZATION` varchar(45) DEFAULT NULL, \r\n"
					+ "`DISPLAY` varchar(600) DEFAULT NULL, \r\n"
					+ "`DISPLAY_RESOLUTION` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL, \r\n"
					+ "`DISPLAY_SIZE` varchar(45) DEFAULT NULL, \r\n" + "`MEMORY` varchar(45) DEFAULT NULL,\r\n"
					+ "`OPERATING_SYSTEM` varchar(45) DEFAULT NULL, \r\n"
					+ "`PROCESSOR` varchar(255) DEFAULT NULL, \r\n" + "`TOUCHSCREEN` varchar(45) DEFAULT NULL, \r\n"
					+ "`WEIGHT` varchar(45) DEFAULT NULL, \r\n"
					+ "`COLOR` varchar(45) DEFAULT NULL, PRIMARY KEY (`IDMASSAS`) ) \r\n"
					+ "ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci");
			closeConnection();
		} catch (SQLException e) {
			System.err.println("Ocorreu um erro na criação da tabela");
			System.err.println(e.getMessage());
			junit.framework.Assert.fail();
		}
	}

	public void insertDatabaseMasses() {
		try {
			Connection conn = openConnection();
			conn.createStatement().executeUpdate(
					"insert into massas(NAME_PRODUCT,CUSTOMIZATION,DISPLAY,DISPLAY_RESOLUTION,DISPLAY_SIZE,MEMORY,OPERATING_SYSTEM,PROCESSOR,TOUCHSCREEN,WEIGHT,COLOR) \r\n"
							+ "values(\"HP PAVILION 15Z TOUCH LAPTOP\",\r\n" + "\"Simplicity\",\r\n"
							+ "\"15.6-inch diagonal Full HD WLED-backlit Display (1920x1080) Touchscreen\",\r\n"
							+ "\"1920x1080\"\r\n" + ",\"15.6\",\r\n" + "\"16GB DDR3 - 2 DIMM\",\"Windows 10\",\r\n"
							+ "\"AMD Quad-Core A10-8700P Processor + AMD Radeon(TM) R6 Graphics\",\r\n"
							+ "\"Yes\",\"5.51 lb\",\r\n" + "\"GRAY\");");
			closeConnection();
		} catch (SQLException e) {
			System.err.println("Ocorreu um erro no insert da tabela");
			System.err.println(e.getMessage());
			Assert.fail();
		}
	}

}
