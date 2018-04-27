package frsf.isi.died.tp.modelo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import frsf.isi.died.tp.modelo.productos.Libro;
import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;
import frsf.isi.died.tp.modelo.productos.Video;

public class BibliotecaList implements Biblioteca {
	
	private ArrayList<MaterialCapacitacion> materiales;
	
	public BibliotecaList() {
		this.materiales = new ArrayList<>();
		}

	@Override
	public void agregar(MaterialCapacitacion material) {
		materiales.add(material);		
	}

	@Override
	public Integer cantidadMateriales() {
		return materiales.size();
	}

	@Override
	public Integer cantidadLibros() {
		int contador=0;
		for (MaterialCapacitacion mat : materiales) {
			if(mat instanceof Libro)
				contador++;
		}
		return contador;
	}

	@Override
	public Integer cantidadVideos() {
		int contador=0;
		for (MaterialCapacitacion mat : materiales) {
			if(mat instanceof Video)
				contador++;
		}
		return contador;
	}

	@Override
	public Collection<MaterialCapacitacion> materiales() {
		return this.materiales;
	}

	@Override
	public void imprimir() {
		for (MaterialCapacitacion mat : materiales) {
			System.out.println(mat.toString());
		}
		
	}

	@Override
	public void ordenarPorPrecio(Boolean b) {
		if(b) {
			Collections.sort(materiales, new Comparator<MaterialCapacitacion>() {
				public int compare(MaterialCapacitacion m1, MaterialCapacitacion m2) {
				if(m1.precio().doubleValue() > m2.precio().doubleValue()){
					return 1;
				}
				else {
					if(m1.precio().doubleValue() == m1.precio().doubleValue())
						return 0;
					else {
					return -1;
					}		
				}
			}	
			});
		}
		else {
			Collections.sort(materiales);
		}
	}
	
	@Override
	public MaterialCapacitacion buscar(Integer precio) {
		boolean b = true;
		this.ordenarPorPrecio(b);
		return buscadorBinario(precio,0,materiales.size()-1);
	}
	
	private MaterialCapacitacion buscadorBinario( Integer precio, int inicio, int fin) throws RuntimeException{
		int indice=((inicio+fin)/2);

		if((this.materiales.get(indice).precio().intValue()) == precio.intValue()) {
			return (this.materiales.get(indice));
		}
		else {if ((this.materiales.get(indice).precio().intValue()) > precio.intValue()) {
			return (buscadorBinario(precio, inicio, indice));
		}
		else {
			if(inicio==fin) 
				throw new RuntimeException("Material de precio "+ precio.toString() + " no encontrado");
			return (buscadorBinario(precio, indice+1, fin)); 		
		}
	}
}}
