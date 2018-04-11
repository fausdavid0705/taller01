package frsf.isi.died.tp.modelo.productos;

public class Video extends MaterialCapacitacion {
	private static Double costoSegundos;
	private int duracionEnSegundos;
	
	public Video() {
		costoSegundos=0.0;
		duracionEnSegundos=0;
	}
	public Video(Integer id,String titulo)  {
		this.id=id;
		this.titulo=titulo;
	}
	public Video(Integer id,String titulo, Double costo,int duracion){
		this.id=id;
		this.titulo=titulo;
		this.costo=costo;
		this.costoSegundos=0.15;
		this.duracionEnSegundos=duracion;
	}
	
	@Override
	public Double precio() {
		// TODO Auto-generated method stub
		return (costo + (duracionEnSegundos * costoSegundos));
	}

	@Override
	public Boolean esLibro() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Boolean esVideo() {
		// TODO Auto-generated method stub
		return true;
	}
	

}
