package it.polito.tdp.imdb.model;

public class EdgeAndWeight {
	int directorId1;
	int directorId2;
	Integer peso;
	public EdgeAndWeight(int directorId1, int directorId2, Integer peso) {
		super();
		this.directorId1 = directorId1;
		this.directorId2 = directorId2;
		this.peso = peso;
	}
	public int getDirectorId1() {
		return directorId1;
	}
	public void setDirectorId1(int directorId1) {
		this.directorId1 = directorId1;
	}
	public int getDirectorId2() {
		return directorId2;
	}
	public void setDirectorId2(int directorId2) {
		this.directorId2 = directorId2;
	}
	public Integer getPeso() {
		return peso;
	}
	public void setPeso(Integer peso) {
		this.peso = peso;
	}
	
}
