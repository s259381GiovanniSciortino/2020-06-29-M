package it.polito.tdp.imdb.model;

public class DirectorWeight implements Comparable<DirectorWeight>{
	Director director;
	Integer peso;
	public DirectorWeight(Director director, Integer peso) {
		super();
		this.director = director;
		this.peso = peso;
	}
	public Director getDirector() {
		return director;
	}
	public void setDirector(Director director) {
		this.director = director;
	}
	public Integer getPeso() {
		return peso;
	}
	public void setPeso(Integer peso) {
		this.peso = peso;
	}
	@Override
	public int compareTo(DirectorWeight other) {
		return other.getPeso().compareTo(this.getPeso());
	}
	@Override
	public String toString() {
		return  director + " | " + peso + "\n";
	}
	
}
