package General;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class InputTypesUniversidad {
	public static int readInt(String mensaje,Scanner scanner)
	{
		int valor=0;
		while(true)
		{
			try

			{
				System.out.print(mensaje);
				valor=scanner.nextInt();
				scanner.nextLine();
				break;
			}
			catch(java.util.InputMismatchException e)
			{System.out.println("Debe ingresar valores numericos");
			scanner.nextLine();}
		}

		return valor;
	}

	public static String readString(String mensaje, Scanner scanner) {
		String nombre;
		while(true)
		{
			try

			{
				System.out.print(mensaje);
				nombre=scanner.nextLine();
				break;
			}
			catch(java.util.InputMismatchException e)
			{System.out.println("Debe ingresar caracteres");
			scanner.nextLine();}
		}

		return nombre;
	}

	public static double readDouble(String mensaje, Scanner scanner) {

		double valor=0;
		while(true)
		{
			try

			{
				System.out.print(mensaje);
				valor=scanner.nextDouble();
				scanner.nextLine();

				break;
			}
			catch(java.util.InputMismatchException e)
			{System.out.println("Debe ingresar valores numericos");
			scanner.nextLine();}
		}

		return valor;
	}

	public static boolean readBoolean(String mensaje, Scanner scanner) {

		boolean valor=false;
		while(true)
		{
			try

			{
				System.out.print(mensaje);
				valor=scanner.nextBoolean();
				scanner.nextLine();

				break;
			}
			catch(java.util.InputMismatchException e)
			{System.out.println("Debe ingresar true(si la dio) o false(no la dio) segun haya realizado la prueba");
			scanner.nextLine();}
		}

		return valor;
	}
	public static Date leerFecha(String msg, Scanner leer) {
		Date fecha;
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

		while (true) {
			System.out.print(msg);
			try {
				fecha = (Date) formato.parse(leer.nextLine());
				return fecha;
			} catch (ParseException e) {
				System.out.println("Error en el formato de fecha");
			}
		}
	}
	
}
