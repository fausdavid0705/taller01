package frsf.isi.died.tp.taller03;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import frsf.isi.died.tp.estructuras.Arbol;
import frsf.isi.died.tp.estructuras.ArbolBinarioBusqueda;
import frsf.isi.died.tp.estructuras.ArbolVacio;
import frsf.isi.died.tp.modelo.Biblioteca;
import frsf.isi.died.tp.modelo.BibliotecaABB;
import frsf.isi.died.tp.modelo.productos.Libro;
import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;
import frsf.isi.died.tp.modelo.productos.Video;

public class TestPaso05 {

	private BibliotecaABB biblioteca;
	private Libro matA;
	private Libro matC;
	private Libro matX;
	private Libro matB;
	private Libro matZ;
	private Libro matK;
	private Video matV;
	private Video matW;
	private Video matN;
	private Video matF;
	private Video matH;
	List<MaterialCapacitacion> lista = new ArrayList<MaterialCapacitacion>();

	@Before
	public void init() {
		matA= new Libro(1, "A", 10.0, 20.0, 10);
		matC= new Libro(2, "C", 20.0, 10.0, 10);
		matX= new Libro(3, "X", 30.0, 20.0, 10);
		matB= new Libro(4, "B", 40.0, 30.0, 10);
		matZ= new Libro(5, "Z", 50.0, 25.0, 10);
		matK= new Libro(6, "K", 60.0, 20.0, 10);
		matV= new Video(7, "V", 70.0, 10);
		matW= new Video(8, "W", 80.0, 10);
		matN= new Video(9, "N", 30.0, 10);
		matF= new Video(10, "F", 40.0, 10);
		matH= new Video(11, "H", 50.0, 10);
		biblioteca = new BibliotecaABB();
	}
	
	@Test
	public void testBuscarPorPrecio() {
		biblioteca.agregar(matA);
		biblioteca.agregar(matC);
		biblioteca.agregar(matX);
		biblioteca.agregar(matB);
		biblioteca.agregar(matZ);
		biblioteca.agregar(matK);
		biblioteca.agregar(matV);
		biblioteca.agregar(matW);
		biblioteca.agregar(matN);
		biblioteca.agregar(matF);
		biblioteca.agregar(matH);
		biblioteca.ordenarPorPrecio(true);
		biblioteca.imprimir();
		lista.addAll(biblioteca.rango(30.0,50.0));
		assertTrue(lista.contains(matX));
		assertTrue(lista.contains(matC));
		assertTrue(lista.contains(matA));
		assertTrue(lista.contains(matN));
		assertTrue(lista.contains(matF));
		
	}



}
