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
					return new Integer(m1.getCosto().compareTo(m2.getCosto()));
			}	
			});
		}
		else {
			Collections.sort(materiales);
		}
	}
	
	@Override
	public MaterialCapacitacion buscar(Integer precio) {
		this.ordenarPorPrecio(true);
		return buscadorBinario(precio,0,(materiales.size()-1));
	}
	
	private MaterialCapacitacion buscadorBinario (Integer precio , Integer ini ,Integer fin) {
		Integer index;
		index = (((fin - ini)/2)+ini);
		if (((materiales.get(index).getCosto()).intValue()) == (precio.intValue())) return materiales.get(index);
		else {
			if (fin == ini) {
				throw new RuntimeException("Material de precio "+ precio.toString() + " no encontrado");
			}
			else {
				if (((materiales.get(index).getCosto()).intValue()) > (precio.intValue())) {
					return (buscadorBinario (precio,ini,index));
				}
				else {
					index++;
					return (buscadorBinario (precio,index,fin));
				}
			}
		}
	}
}
	
