package Transporte.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Scanner;

import Control.Conexion;
import General.InputTypesUniversidad;
import Transporte.entity.Transporte;
import Transporte.entity.VehiculoNoRegistrado;

public class TransporteView {
private Conexion conexion;
private Scanner scanner;
	public TransporteView(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner = scanner;
	}
	public void addVehiculo() {
		Transporte vehiculo = RegistroTransporte.ingresarVehiculo(scanner);
		String sql = "Insert into transporte (CodigoVehiculo,CodigoEstudiante, Placa,Marca, Color, Soat) " + "values(?,?,?,?,?,?)";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, vehiculo.getCodigoVehiculo());
			conexion.getSentencia().setInt(2, vehiculo.getCodigoEstudiante());
			conexion.getSentencia().setString(3, vehiculo.getPlaca());
			conexion.getSentencia().setString(4, vehiculo.getMarca());
			conexion.getSentencia().setString(5,vehiculo.getColor());
			conexion.getSentencia().setBoolean(6, vehiculo.isSoat());
			conexion.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}
	
	
	public void deleteVehiculo() throws SQLException {
		int CodigoVehiculo = InputTypesUniversidad.readInt("C�digo del vehiculo: ", scanner);
		String sql = "delete " + "from transporte " + "where c�digo = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, CodigoVehiculo);
		conexion.modificacion();
	}
	//teamviewer
	
	public void updateVehiculo() throws SQLException, VehiculoNoRegistrado {
		ResultSet resultSet;
		Transporte vehiculo;
		String placa;
		String marca;
		int codigoEstudiante;
	
		String color;
		boolean soat;
			
		int codigoVehiculo = InputTypesUniversidad.readInt("C�digo del vehiculo: ", scanner);
		String sql = "select * from transporte where c�digo = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, codigoVehiculo);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			placa = resultSet.getString("Placa");
			marca = resultSet.getString("Marca");
			codigoEstudiante=resultSet.getInt("codigoCuenta");
			color=resultSet.getString("Color");
			soat=resultSet.getBoolean("Soat");
			
			vehiculo = new Transporte(codigoVehiculo,codigoEstudiante, placa,marca, color, soat);
		} else {
			throw new VehiculoNoRegistrado();
		}

		System.out.println(vehiculo);
		MenuTransporte.ModificarVehiculo(scanner, vehiculo);
		sql = "update transporte set nombre = ?, descripci�n = ? where c�digo = ?";

		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, vehiculo.getCodigoVehiculo());
		conexion.getSentencia().setInt(2, vehiculo.getCodigoEstudiante());
		conexion.getSentencia().setString(3, vehiculo.getPlaca());
		conexion.getSentencia().setString(4, vehiculo.getMarca());
		conexion.getSentencia().setString(5,vehiculo.getColor());
		conexion.getSentencia().setBoolean(6, vehiculo.isSoat());
		conexion.modificacion();
	}
	public void listarVehiculo() throws SQLException {
		Transporte transporte;
		String sql = "select * from transporte ";
		conexion.consulta(sql);
		ResultSet resultSet = conexion.resultado();
		while (resultSet.next()) {
			transporte = new Transporte(resultSet.getInt("CodigoVehiculo"),
					resultSet.getInt("CodigoEstudiante"), 
					resultSet.getString("Placa"),
					resultSet.getString("Marca"),
					resultSet.getString("Color"),
					resultSet.getBoolean("Soat"));
			System.out.println(transporte);
		}
	}
}
