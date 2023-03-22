package co.edu.uniquindio.model;

public class Restriccion {
	private double rangoInferior;
	private double rangoSuperior;
	public Restriccion() {
		super();
	}
	public Restriccion(double rangoInferior, double rangoSuperior) {
		super();
		this.rangoInferior = rangoInferior;
		this.rangoSuperior = rangoSuperior;
	}
	public double getRangoInferior() {
		return rangoInferior;
	}
	public void setRangoInferior(double rangoInferior) {
		this.rangoInferior = rangoInferior;
	}
	public double getRangoSuperior() {
		return rangoSuperior;
	}
	public void setRangoSuperior(double rangoSuperior) {
		this.rangoSuperior = rangoSuperior;
	}
	

}
