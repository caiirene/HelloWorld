// =================== Support Code =================
// Graph.
//
// - Implement each of the functions to create a working graph.
// - Do not change any of the function declarations
//   - (i.e. graph_t* create_graph() should not have additional arguments)
// - You should not have any 'printf' statements in your graph functions.
//   - (You may consider using these printf statements to debug, but they 
//      should be removed from your final version)
// ==================================================
#ifndef MYGRAPH_H
#define MYGRAPH_H

#include "my_dll.h"
#include <stdlib.h>
#include <assert.h>
// Create a graph data structure
typedef struct graph{
    int numNodes;
    int numEdges;
    dll_t* nodes;     //an array of nodes storing all of our nodes.
} graph_t;

typedef struct graph_node{
    int data;
    dll_t* inNeighbors;
    dll_t* outNeighbors;
} graph_node_t;

// Creates a graph
// Returns a pointer to a newly created graph.
// The graph should be initialized with data on the heap.
// The graph fields should also be initialized to default values.
// Returns NULL if we cannot allocate memory.


graph_t* create_graph(){
    
    graph_t* myGraphPointer = (graph_t*)malloc(sizeof(graph_t));
    if (myGraphPointer == NULL) {return NULL;}
    
    myGraphPointer->numNodes = 0;
    myGraphPointer->numEdges = 0;
    
    dll_t* dllStoreAllNode = create_dll();
    myGraphPointer->nodes = dllStoreAllNode;
    
    return myGraphPointer;
}


// Returns the node pointer if the node exists.
// Returns NULL if the node doesn't exist or the graph is NULL

graph_node_t* find_node( graph_t * g, int value){
    
    if (g==NULL) {return NULL;}
    
    int i;
    node_t* iterator = g->nodes->head;
    for (i=0; i<g->numNodes; i++) {
        if (((graph_node_t*)iterator->data)->data == value) {return iterator->data;}

        else {iterator = iterator->next;}
    }
        
    return NULL;
}


// Creates a graph node
// Note: This relies on your dll implementation.

graph_node_t * create_graph_node(int value){
    graph_node_t * graph_node = malloc(sizeof(graph_node_t));
    
    if ( graph_node == NULL ) {return NULL;}
    
    graph_node->data = value;
    graph_node->inNeighbors = create_dll();
    graph_node->outNeighbors = create_dll();
    
    return graph_node;
}


// Returns 1 on success
// Returns 0 on failure ( or if the node already exists )
// Returns -1 if the graph is NULL.

int graph_add_node(graph_t* g, int value){
    if ( g == NULL ) return -1;
    
    if (find_node(g, value) != NULL) {return -1;}
    
    graph_node_t * newNode = create_graph_node(value);
    if ( newNode == NULL ) {return -1;}
    
    assert(g->nodes); //这个就等于 if (g->nodes==NULL) {return;}
    dll_push_back(g->nodes, newNode);
    g->numNodes++;
    
    return 1;
}


int graph_remove_node(graph_t* g, int value){
    if (g == NULL) {return -1;}
    graph_node_t* target = find_node(g, value);
    if (target == NULL) {return 0;}

    node_t* helper;
    graph_node_t* tempGraphNode;

    // Remove target from its inNeighbors' outNeighbor lists
    helper = target->inNeighbors->head;
    while (helper != NULL) {
        tempGraphNode = (graph_node_t*)helper->data;
        dll_remove_data(tempGraphNode->outNeighbors, target);
        g->numEdges--;
        helper = helper->next;
    }

    // Remove target from its outNeighbors' inNeighbor lists
    helper = target->outNeighbors->head;
    while (helper != NULL) {
        tempGraphNode = (graph_node_t*)helper->data;
        dll_remove_data(tempGraphNode->inNeighbors, target);
        g->numEdges--;
        helper = helper->next;
    }

    // Remove target node from the graph's node list
    dll_remove_data(g->nodes, target);

    // Free the target node's memory
    free_dll(target->inNeighbors);
    free_dll(target->outNeighbors);
    free(target);

    g->numNodes--;

    return 1;
}

int contains_edge(graph_t *g, int source, int destination);

// Returns 1 on success
// Returns 0 on failure ( or if the source or destination nodes don't exist, or the edge already exists )
// Returns -1 if the graph is NULL.

int graph_add_edge(graph_t *g, int source, int destination) {
    if (g == NULL) {return -1;}
    
    int edge_exists = contains_edge(g, source, destination);
    if (edge_exists != 0) {return 0;}

    graph_node_t* sourceNode = find_node(g, source);
    graph_node_t* destinationNode = find_node(g, destination);

    dll_push_back(sourceNode->outNeighbors, destinationNode);
    dll_push_back(destinationNode->inNeighbors, sourceNode);

    g->numEdges++;

    return 1;
}

// Returns 1 on success
// Returns 0 on failure ( or if the source or destination nodes don't exist, or the edge doesn't exists )
// Returns -1 if the graph is NULL.

int graph_remove_edge(graph_t *g, int source, int destination) {
    if (g == NULL) {return -1;}
    
    int edge_exists = contains_edge(g, source, destination);
    if (edge_exists != 1) {return 0;}

    graph_node_t* sourceNode = find_node(g, source);
    graph_node_t* destinationNode = find_node(g, destination);

    dll_remove_data(sourceNode->outNeighbors, destinationNode);
    dll_remove_data(destinationNode->inNeighbors, sourceNode);

    g->numEdges--;

    return 1;
}


// Returns 1 on success
// Returns 0 on failure ( or if the source or destination nodes don't exist )
// Returns -1 if the graph is NULL.

int contains_edge( graph_t * g, int source, int destination){
    
    if (g == NULL) {return -1;}
    graph_node_t* sourceNode = find_node(g, source);
    graph_node_t* destinationNode = find_node(g, destination);
    if (sourceNode==NULL || destinationNode==NULL) {return 0;}
    
    //检查是否真的存在edge
    dll_t* outDLL = sourceNode->outNeighbors;
    node_t* checker = outDLL->head;
    bool hasEdge = false;
    while (checker != NULL) {
        if (checker->data == destinationNode) {
            hasEdge = true;
            break;
        }
        checker = checker->next;
    }
    if (!hasEdge) {return 0;}

    return 1;
}

// Returns dll_t* of all the in neighbors of this node.
// Returns NULL if thte node doesn't exist or if the graph is NULL.

dll_t* getInNeighbors( graph_t * g, int value ){
    
    if (g==NULL) {return NULL;}
    graph_node_t* tryFind = find_node(g, value);
    if (tryFind==NULL) {return NULL;}

    return tryFind->inNeighbors;
}

// Returns the number of in neighbors of this node.
// Returns -1 if the graph is NULL or the node doesn't exist.

int getNumInNeighbors( graph_t * g, int value){
    if (getInNeighbors( g, value)==NULL) {return -1;}
    return find_node(g, value)->inNeighbors->count;
}

// Returns dll_t* of all the out neighbors of this node.
// Returns NULL if thte node doesn't exist or if the graph is NULL.
dll_t* getOutNeighbors( graph_t * g, int value ){
    if (g==NULL) {return NULL;}
    graph_node_t* tryFind = find_node(g, value);
    if (tryFind==NULL) {return NULL;}

    return tryFind->outNeighbors;
}

// Returns the number of out neighbors of this node.
// Returns -1 if the graph is NULL or the node doesn't exist.
int getNumOutNeighbors( graph_t * g, int value){
    if (getOutNeighbors( g, value)==NULL) {return -1;}
    return find_node(g, value)->outNeighbors->count;
}

// Returns the number of nodes in the graph
// Returns -1 if the graph is NULL.
int graph_num_nodes(graph_t* g){
    if (g==NULL) {return -1;}
    return g->numNodes;
}

// Returns the number of edges in the graph,
// Returns -1 on if the graph is NULL
int graph_num_edges(graph_t* g){
    if (g==NULL) {return -1;}
    return g->numEdges;
}

void free_graph(graph_t* g){
    if (g == NULL) {
        return;
    }
    node_t* current_node = g->nodes->head;
    graph_node_t* graph_node;
    while (current_node != NULL) {
        graph_node = (graph_node_t*)current_node->data;
        free_dll(graph_node->inNeighbors);
        free_dll(graph_node->outNeighbors);
        free(graph_node);
        current_node = current_node->next;
    }
    free_dll(g->nodes);
    free(g);
}

int seenNode(int target, int* array, int arraySize) {
    if (array==NULL) {exit(1);}
    int i;
    for (i=0; i<arraySize; i++) {
        if (array[i]==target) {return 1;}
    }
    return 0;
} 


// returns 1 if there is a cycle in the graph
// returns 0 if no cycles exist in the graph
// returns -1 if the graph is NULL 
// You may use either BFS or DFS to complete this task.
int graph_has_cycle(graph_t * g){
    if (g==NULL) {return -1;}
    
    dll_t* allNodeList = g->nodes;
    node_t* startNode = allNodeList->head;
    graph_node_t* startData = startNode->data;
    
    dll_t* my_queue = create_dll();
    dll_push_back(my_queue, startData);
    
    

}


int graph_is_reachable(graph_t * g, int source, int dest){
    
    if (g == NULL) {return -1;}
    
    graph_node_t* start = find_node(g, source);
    graph_node_t* end = find_node(g, dest);
    if (start == NULL || end == NULL) {return 0;}
    
    dll_t* my_queue = create_dll();
    dll_push_back(my_queue, start);
    
    int seen[g->numNodes];
    int seenListIndex = 0;
    seen[seenListIndex] = start->data;
    
    graph_node_t* iterator = start;
    
    while(!dll_empty(my_queue) && seenListIndex<(g->numNodes)) {
        iterator = (graph_node_t *)dll_pop_front_node(my_queue);
        if (iterator == end) {
            free_dll(my_queue);
            return 1;
        }
        if (!seenNode(iterator->data, seen, g->numNodes)) {
            seen[seenListIndex] = iterator->data;
            seenListIndex++;
        }
        dll_t* outList = iterator->outNeighbors;
        node_t* addToQueue = outList->head;
        while (addToQueue != NULL) {
            graph_node_t* nextGraphNode = (graph_node_t*)addToQueue->data;
            dll_push_back(my_queue, nextGraphNode);
            addToQueue = addToQueue->next;
        }
    }
    free_dll(my_queue);
    return 0;    
}


////

#endif
