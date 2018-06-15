/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frsf.isi.died.tp.modelo.productos;
import frsf.isi.died.tp.util.Ordenable;
import java.util.ArrayList;
import java.util.Comparator;


/**
 * Representa de manera abstracta los materiales de capacitación
 * Integrantes del grupo:
 * Brizi, Elias
 * David, Fausto
 * Reyes, Leandro
 * 
 * https://github.com/fausdavid0705/taller01
 * 
 * @author fausdavid0705
 */

public abstract class MaterialCapacitacion implements Comparable<MaterialCapacitacion>, Ordenable {
	
	@Override
	public int compareTo(MaterialCapacitacion o) {
		if(this.equals(o)) {
			if((this.precio().doubleValue())== (o.precio().doubleValue())){
				return 0;
			}
			if(this.precio().doubleValue() > o.precio().doubleValue()) 
				return 1;
			else return -1;
		}
		else{
			return this.titulo.compareTo(o.titulo);
		}
	}


	protected Integer id;
	/**
	 * Titulo del material
	 */
	protected String titulo;

	/**
	 * Costo básico que debe sumarse al precio por el mero hecho de publicarlo en el
	 * portal
	 */
	protected Double costo;
	
	/**
	 * Constructor por defecto
	 */
	public MaterialCapacitacion() {
		this(0,"en desarrollo",0.0);
	}

	/**
	 * Constructor que recibe como argumento un ID y un Titulo
	 * 
	 * @param id
	 * @param titulo
	 */
	public MaterialCapacitacion(Integer id, String titulo) {
		this(id,titulo,0.0);
	}

	/**
	 * Constructor que recibe como argumento un ID y un costo
	 * 
	 * @param id
	 * @param titulo
	 */
	public MaterialCapacitacion(Integer id,String titulo, Double costo) {
		this.id =id;
		this.titulo = titulo;
		this.costo = costo;
	}


	//TODO 01 implementar los metodos getters y setters y escribir el javadoc
	// AYUDA: para implementar estos metodos usar un atajo del IDE 
	// elegir el menu "Source" --> "Generate getters y setters" y elegir alli que metodos generar.
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		MaterialCapacitacion other = (MaterialCapacitacion) obj;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	
	/**
	 * El precio de un material se define según el tipo del material y toma como
	 * base el costo del mismo
	 * 
	 * @return
	 */
	public abstract Double precio();
	
	/**
	 * Retorna verdadero si es una instancia de libro, falso en caso contrario
	 * @return
	 */
	public abstract Boolean esLibro();

	/**
	 * Retorna verdadero si es una instancia de video, falso en caso contrario
	 * @return
	 */
	
	public abstract Boolean esVideo();
	

	//TODO 02: sobrescribir el metodo toString de la clase "Object"
	//	el método toString retorna un string que representa el material actual
	//  retornando el titulo, y el precio 	 * usando el formato : 
	// [Titulo: <titulo> ; Precio: <precio> ]
	public String toString() {
		return "[Titulo: "+titulo+" ; Precio: "+this.precio()+" ]"; 
	}
	
	
	// TODO 10: implementar Ordenable
	public final int valor(){
		/*Funciona aunque sea abstracto
		 * porque el objeto this es una 
		 * instancia de la Clase Libro o la Clase Video 
		 * (donde si est� definida el m�todo precio())*/
		return this.precio().intValue();
	}

}
