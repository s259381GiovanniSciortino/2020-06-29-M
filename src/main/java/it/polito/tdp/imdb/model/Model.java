package it.polito.tdp.imdb.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.imdb.db.ImdbDAO;

public class Model {
	Graph<Director,DefaultWeightedEdge> grafo;
	Map<Integer,Director> directorIdMap;
	
	
	public String doCreaGrafo(int anno) {
		ImdbDAO dao = new ImdbDAO();
		grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		directorIdMap = new HashMap<>();
		for(Director d: dao.listAllDirectors())
			directorIdMap.put(d.getId(), d);
		for(Integer id: dao.getVertex(anno))
			grafo.addVertex(directorIdMap.get(id));
		for(EdgeAndWeight e : dao.getEdgeAndWeight(anno))
			Graphs.addEdge(grafo, directorIdMap.get(e.getDirectorId1()), directorIdMap.get(e.getDirectorId2()), e.getPeso());
		String result = "";
		if(this.grafo==null) {
			result ="Grafo non creato";
			return result;
		}
		result = "Grafo creato con :\n# "+this.grafo.vertexSet().size()+" VERTICI\n# "+this.grafo.edgeSet().size()+" ARCHI\n";
		return result;
	}
	
	public String doRegistiAdiacenti(Director d) {
		List<DirectorWeight> directorWeight = new ArrayList<>();
		for(Director dire: Graphs.neighborListOf(grafo, d))
			directorWeight.add(new DirectorWeight(dire, (int) grafo.getEdgeWeight(grafo.getEdge(d, dire))));
		Collections.sort(directorWeight);
		String res = "\nREGISTI ADIACENTI: \n";
		for(DirectorWeight dw: directorWeight)
			res+= dw;
		return res;
	}
	public List<Director> getDirectors(){
		List<Director> res = new ArrayList<>(grafo.vertexSet());
		Collections.sort(res);
		return res;
	}
}
