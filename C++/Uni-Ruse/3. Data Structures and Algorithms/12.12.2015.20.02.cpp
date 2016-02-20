#include "stdafx.h"
#include <iostream>
#include <vector>
#include <map>

int numberOfVertices, numberOfEdges;
std::vector<int> vertexChildren[1024], vertexParents[1024];
std::map<int, int> numberOfVertexChildren, numberOfVertexParents;
std::map<int, int>::iterator i;

void makeGraph()
{
	int u, v;

	for (int i = 0; i < numberOfEdges; ++i)
	{
		std::cout << "Enter start point vertex: "; std::cin >> u; 
		std::cout << "Enter end point vertex: "; std::cin >> v; 

		vertexChildren[u].push_back(v);
		vertexParents[v].push_back(u);
		
		// Get number of children
		numberOfVertexChildren[u] = vertexChildren[u].size();

		// Get number of parents
		numberOfVertexParents[v] = vertexParents[v].size();
	} 
	
	std::cout << std::endl;
}

int main()
{
	std::cout << "Enter number of vertices: "; std::cin >> numberOfVertices;
	std::cout << "Enter number of edges: "; std::cin >> numberOfEdges; std::cout << std::endl;
	
	// Enter graph info
	makeGraph();

	// Print number of vertex children
	for (i = numberOfVertexChildren.begin(); i != numberOfVertexChildren.end(); ++i) {
		std::cout << i->first << ": " << i->second << " children" << std::endl;
	} std::cout << std::endl;

	// Print number of vertex parents
	for (i = numberOfVertexParents.begin(); i != numberOfVertexParents.end(); ++i) {
		std::cout << i->first << ": " << i->second << " parents" << std::endl;
	} std::cout << std::endl;

	return 0;
}