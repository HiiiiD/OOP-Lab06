package it.unibo.oop.lab06.generics1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class GraphImpl<N> implements Graph<N> {

	private Set<N> nodes;
	private Map<N,Set<N>> edges;
	
	public GraphImpl() {
		this.nodes = new HashSet<N>();
		this.edges = new HashMap<N,Set<N>>();
	}
	
	
	@Override
	public void addNode(N node) {
		nodes.add(node);
	}

	@Override
	public void addEdge(N source, N target) {
		
		if (source == null || target == null) {
			return;
		}
		
		if (!edges.containsKey(source)) {
			Set<N> edgesList = new HashSet<N>();
			edgesList.add(target);
			this.edges.put(source, edgesList);
		}
		else {
			Set<N> edgesList = edges.get(source);
			edgesList.add(target);
		}
	}

	@Override
	public Set<N> nodeSet() {
		return new HashSet<N>(nodes);
	}

	@Override
	public Set<N> linkedNodes(N node) {
		if (edges.containsKey(node)) {
			return new HashSet<N>(edges.get(node));
		}
		return new HashSet<N>();
	}

	@Override
	public List<N> getPath(N source, N target) {
		LinkedList<N> returnList = new LinkedList<N>();
		HashSet<N> triedNodes = new HashSet<N>();
		getPath(source,target,returnList, triedNodes);
		returnList.addFirst(source);
		return returnList;
	}
	
	private boolean getPath(N source, N target, LinkedList<N> appendList, HashSet<N> triedNodes) {
		if (source == target) {
			return true;
		}
		if (triedNodes.contains(source)) {
			triedNodes = new HashSet<N>();
			return false;
		}
		triedNodes.add(source);
		
		for (N adjacent : this.edges.get(source)) {
			if (getPath(adjacent,target,appendList, triedNodes)) {
				appendList.addFirst(adjacent);
				return true;
			}
		}
		
		return false;
	}

}
