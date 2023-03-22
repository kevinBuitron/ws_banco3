package co.edu.co.test;

import co.edu.uniquindio.model.Banco;
import co.edu.uniquindio.model.Cliente;
import co.edu.uniquindio.model.Cuenta;
import co.edu.uniquindio.model.TipoCuenta;

public class Test {

	public static void main (String []args){
		try{
			Banco banco = new Banco ("bancolombia");
			Cliente cliente1 = new Cliente("kevin", "buitron", "105");
			Cliente cliente2 = new Cliente("pepito", "perez", "123");

			String mensajeCLiente1 = banco.crearCliente(cliente1);
			String mensajeCLiente2 = banco.crearCliente(cliente2);

			System.out.println(mensajeCLiente1);
			System.out.println(mensajeCLiente2);

			String mensajeCuenta1 = banco.crearCuenta("105", "771", TipoCuenta.AHORROS);
			String mensajeCuenta2 = banco.crearCuenta("105",  "971", TipoCuenta.CORRIENTE);
			String mensajeCuenta3 = banco.crearCuenta("123", "775", TipoCuenta.AHORROS);

			System.out.println(mensajeCuenta1);
			System.out.println(mensajeCuenta2);

			banco.depositarDinero("771", 120000);
			banco.depositarDinero("771", 120000);

			String deposito = banco.transferirDinero("771", "775", 100000);

			double nuevoSaldo1 = banco.consultarSaldo("771");
			double nuevoSaldo2 = banco.consultarSaldo("775");

			System.out.println( banco.buscarCuenta("771") );

			System.out.println("----------------------------");

			System.out.println( banco.listarCuentas("105") );


		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
