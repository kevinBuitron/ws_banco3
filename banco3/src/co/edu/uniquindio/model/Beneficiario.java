package co.edu.uniquindio.model;

import java.util.ArrayList;
import java.util.List;

public class Beneficiario {
	private List<Cuenta> listaCuentasAsociadas = new ArrayList<Cuenta>();
	private Restriccion restriccion;
	public Beneficiario(Restriccion restriccion) {
		super();
		this.restriccion = restriccion;
	}
	public Beneficiario() {
		super();
	}
	public List<Cuenta> getListaCuentasAsociadas() {
		return listaCuentasAsociadas;
	}
	public void setListaCuentasAsociadas(List<Cuenta> listaCuentasAsociadas) {
		this.listaCuentasAsociadas = listaCuentasAsociadas;
	}
	public Restriccion getRestriccion() {
		return restriccion;
	}
	public void setRestriccion(Restriccion restriccion) {
		this.restriccion = restriccion;
	}
	
	

}
