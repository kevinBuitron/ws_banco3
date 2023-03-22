package co.edu.uniquindio.model;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private String nombre;
	private List<Beneficiario> listaBeneficiarios;
	private List<Cuenta> listaCuentas;
	private List<Cliente> listaClientes;

	public Banco(String nombre) {
		super();
		this.nombre = nombre;
		this.listaBeneficiarios = new ArrayList<>();
		this.listaClientes = new ArrayList<>();
		this.listaCuentas = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Beneficiario> getListaBeneficiarios() {
		return listaBeneficiarios;
	}
	public void setListaBeneficiarios(List<Beneficiario> listaBeneficiarios) {
		this.listaBeneficiarios = listaBeneficiarios;
	}
	public List<Cuenta> getListaCuentas() {
		return listaCuentas;
	}
	public void setListaCuentas(List<Cuenta> listaCuentas) {
		this.listaCuentas = listaCuentas;
	}
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}
	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	@Override
	public String toString() {
		return "Banco [nombre=" + nombre + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Banco other = (Banco) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	public String crearCliente(Cliente cliente){
		this.listaClientes.add(cliente);
		return "CLiente creado correctamente";
	}

	public boolean verificarCuenta(String numero){

		boolean respuesta = false;

		for(Cuenta cuenta : listaCuentas){
			if( cuenta.getNumero().equals(numero) ){
				respuesta = true;
			}
		}

		return respuesta;
	}

	public Cliente buscarCliente(String documento){

		Cliente respuesta = null;

		for(Cliente cliente : listaClientes){
			if( cliente.getDocumento().equals(documento) ){
				respuesta = cliente;
			}
		}

		return respuesta;

	}

	public Cuenta buscarCuenta(String numeroCuenta){

		Cuenta respuesta = null;

		for(Cuenta cuenta : listaCuentas){
			if( cuenta.getNumero().equals(numeroCuenta) ){
				respuesta = cuenta;
			}
		}

		return respuesta;

	}

	public String crearCuenta(String documentoCliente, String numeroCuenta, TipoCuenta tipo) throws Exception{

		String mensaje = "La cuenta ha sido registrada";
		boolean cuentaEncontrada = verificarCuenta(numeroCuenta);

		if( cuentaEncontrada == true){
			throw new Exception("La cuenta ya existe");
		}

		Cliente cliente = buscarCliente(documentoCliente);

		if( cliente == null){
			throw new Exception("El documento del cliente no existe");
		}


		Cuenta nuevaCuenta = new Cuenta(0, numeroCuenta, cliente, tipo);
		listaCuentas.add(nuevaCuenta);

		return mensaje;
	}

	public double depositarDinero(String numeroCuenta, double dinero)throws Exception{

		Cuenta cuenta = buscarCuenta(numeroCuenta);

		if(cuenta == null){
			throw new Exception("La cuenta no existe");
		}

		double nuevoSaldo = cuenta.depositarDinero(dinero);
		return nuevoSaldo;
	}

	public double retirarDinero(String numeroCuenta, double dinero)throws Exception{

		Cuenta cuenta = buscarCuenta(numeroCuenta);

		if(cuenta == null){
			throw new Exception("La cuenta no existe");
		}

		double nuevoSaldo = cuenta.retirarDinero(dinero);
		return nuevoSaldo;
	}

	public double consultarSaldo(String numeroCuenta)throws Exception{

		Cuenta cuenta = buscarCuenta(numeroCuenta);

		if(cuenta == null){
			throw new Exception("La cuenta no existe");
		}

		double nuevoSaldo = cuenta.consultarSaldo();
		return nuevoSaldo;
	}


	public String transferirDinero(String numCuentaOrigen, String numCuentaDestino, double dinero) throws Exception{
		retirarDinero(numCuentaOrigen, dinero);

		try{
			depositarDinero(numCuentaDestino, dinero);
		}catch (Exception e) {
			depositarDinero(numCuentaOrigen, dinero);
			throw new Exception(e.getMessage());
		}

		return "Tranferencia exitosa";
	}

	public ArrayList<Cuenta> listarCuentas(String documentoUsuario){

		ArrayList<Cuenta> respuesta = new ArrayList<>();

		for(Cuenta cuenta: listaCuentas){

			if( cuenta.obtenerDocumentoTitular(documentoUsuario) ){
				respuesta.add(cuenta);
			}
			// cuenta.getDocumentoTitular.GetnumeroCuenta

		}

		return respuesta;

	}


}
