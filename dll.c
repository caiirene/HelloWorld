// =================== Support Code =================
// Doubly Linked List ( DLL ).
//
// - Do NOT just replace this file with your DLL file - some of the 
//     signatures have changed data types! Our data is now a void*
// - Implement each of the functions to create a working DLL.
// - Do not change any of the function declarations
//   - (i.e. dll_t* create_dll() should not have additional arguments)
//   - (You may write helper functions to help you debug your code such as print_list etc)
// ==================================================
#ifndef MYDLL_H
#define MYDLL_H
#include <stdint.h>


// Create a node data structure. 
// NOTE THE CHANGES from your original node - we are using a 
// void pointer for data so that we can use the same dll 
// but we're not storing integers anymore.

typedef struct node {
    void* data;
    struct node* next;
    struct node* previous;
} node_t;

// Create a DLL data structure
// Our DLL holds a pointer to the first node in our DLL called head,
// and a pointer to the last node in our DLL called tail.

typedef struct DLL {
    int count;              // count keeps track of how many items are in the DLL.
    node_t* head;           // head points to the first node in our DLL.
    node_t * tail;          //tail points to the last node in our DLL.
} dll_t;

// Creates a DLL
// Returns a pointer to a newly created DLL.
// The DLL should be initialized with data on the heap.
// (Think about what the means in terms of memory allocation)
// The DLLs fields should also be initialized to default values.
// Returns NULL if we could not allocate memory.

dll_t* create_dll(){
	// Modify the body of this function as needed.
	dll_t* myDLL= (dll_t*)malloc(sizeof(dll_t));
	if (myDLL == NULL) {return NULL;}
	myDLL->head = NULL;
	myDLL->tail = NULL;
	myDLL->count = 0;

	return myDLL;
}

// DLL Empty
// Check if the DLL is empty
// Exits if the DLL is NULL.
// Returns 1 if true (The DLL is completely empty)
// Returns 0 if false (the DLL has at least one element enqueued)
int dll_empty(dll_t* l){
	if (l == NULL) {exit(1);}
	if (l->head == NULL) {return 1;}
	else {return 0;}
}


// push a new item to the front of the DLL ( before the first node in the list).
// Exits if DLL is NULL.
// Returns 1 on success
// Returns 0 on failure ( i.e. we couldn't allocate memory for the new node)
// (i.e. the memory allocation for a new node failed).

int dll_push_front(dll_t* l, void* item){
	if (l == NULL) { return -1;}
	node_t* newFront = (node_t*)malloc(sizeof(node_t));
	if (newFront == NULL) {return 0;}

  	if (l->count == 0) {
		l->head = newFront;
		l->tail = newFront;
    
		newFront->next = NULL;
		newFront->previous = NULL;
		newFront->data = item;
		l->count = l->count + 1;
        
		return 1;
	}

	else {
		newFront->next = l->head;
		newFront->previous = NULL;
		newFront->data = item;
		
		l->head->previous = newFront;
		l->head = newFront;
		l->count = l->count + 1;
		return 1;
	}
}

// push a new item to the end of the DLL (after the last node in the list).
// Exits if DLL is NULL.
// Returns 1 on success
// Returns 0 on failure ( i.e. we couldn't allocate memory for the new node)
// (i.e. the memory allocation for a new node failed).

int dll_push_back(dll_t* l, void* item){
	
	if (l == NULL) { return -1;}
	node_t* newBack = (node_t*)malloc(sizeof(node_t));
	if (newBack == NULL) {return 0;}
	
	if (l->count == 0) {
		l->head = newBack;
		l->tail = newBack;
    
		newBack->next = NULL;
		newBack->previous = NULL;
		newBack->data = item;
		l->count = l->count + 1;
		
		return 1;
	}
	
	else {
		newBack->previous = l->tail;
		newBack->data = item;
		newBack->next = NULL;
		
		l->tail->next = newBack;
		l->tail = newBack;
		l->count = l->count + 1;
		
		return 1; 
	}
}

// Returns the first item in the DLL and also removes it from the list.
// Exits if the DLL is NULL. 
// Returns NULL on failure, i.e. there is noting to pop from the list.
// Assume no negative numbers in the list or the number zero.

int dll_pop_front(dll_t* t){
	if (t == NULL) {return -1;}
	if (t->count == 0) {return 0;}
	
	node_t* remember = t->head;
	int returnVal = (int)(intptr_t)remember->data;

	t->head = remember->next;
	
	if (t->head == NULL) {
		t->tail = NULL;
	} //因为如果刚刚pop掉的是唯一node，那么t->head就没有->previous
	else {
		t->head->previous = NULL;
	}
	
	free(remember);	
	t->count = t->count - 1;
	
	return returnVal; // Note: This line is a 'filler' so the code compiles.
}

node_t* dll_pop_front_node(dll_t* t){
	if (t == NULL) {exit(1);}
	if (t->count == 0) {return NULL;}
	
	node_t* remember = t->head;
	void* returnVal = remember;

	t->head = remember->next;
	
	if (t->head == NULL) {
		t->tail = NULL;
	} //因为如果刚刚pop掉的是唯一node，那么t->head就没有->previous
	else {
		t->head->previous = NULL;
	}
	
	free(remember);	
	t->count = t->count - 1;
	
	return returnVal; 
}

// Returns the last item in the DLL, and also removes it from the list.
// Exits if the DLL is NULL. 
// Returns NULL on failure, i.e. there is noting to pop from the list.
// Assume no negative numbers in the list or the number zero.

int dll_pop_back(dll_t* t){
	if (t == NULL) {return -1;}
	if (t->count == 0) {return 0;}

	node_t* remember = t->tail;
	int returnVal = (int)(intptr_t)t->tail->data;

	t->tail = remember->previous;
	
	if (t->tail == NULL) {
		t->head = NULL;
	}
	else {
		t->tail->next = NULL;
	}
	
	free(remember);	
	t->count = t->count - 1;
	
	return returnVal; 
}

// Inserts a new node before the node at the specified position.
// Exits if the DLL is NULL
// Returns 1 on success
// Retruns 0 on failure:
//  * we couldn't allocate memory for the new node
//  * we tried to insert at a negative location.
//  * we tried to insert past the size of the list
//   (inserting at the size should be equivalent as calling push_back).

int dll_insert(dll_t* l, int pos, void* item){
	if (l == NULL) {return 0;}
	if (pos < 0) {return 0;}
	if (pos > l->count) {return 0;}
	if (pos == 0) {return dll_push_front(l, item);}
	if (pos == l->count) {return dll_push_back(l, item);}
	//这里没错吧，如果pos刚好大于最大index，就是指，要在最后面加上一个node
	
	node_t* iterator = l->head;
	for (int i=0; i<pos-1; i++) {
		iterator = iterator->next;
	}//此时，iterator已经挪动到该添加新节点的前面位置了
	node_t* newNode = (node_t*)malloc(sizeof(node_t));
	if (newNode == NULL) {return 0;}
	//创建heap内存成功
	newNode->next = iterator->next;
	newNode->data = item;
	newNode->previous = iterator;//这里是没有问题的，因为iterator是个地址，newNode->previous里存的也该是地址
	iterator->next->previous = newNode;//这里原本存储的是iterator，现在改为newNode
	iterator->next = newNode;
	l->count = l->count + 1;
	
	return 1;
}

// Returns the item at position pos starting at 0 ( 0 being the first item )
// Exits if the DLL is NULL
// Returns NULL on failure:
//  * we tried to get at a negative location.
//  * we tried to get past the size of the list
// Assume no negative numbers in the list or the number zero.

int dll_get(dll_t* l, int pos){
	if (l == NULL) {return 0;}
	if (pos < 0) {return 0;}
	if (pos >= l->count) {return 0;}
	//检查完毕
	
	node_t* iterator = l->head;
	for (int i=0; i<pos; i++) {
		iterator = iterator->next;
	} //iterator此时是pos位置的node
	int returnVal = (int)(intptr_t)iterator->data;
	
	return returnVal; // Note: This line is a 'filler' so the code compiles.
}

// Removes the item at position pos starting at 0 ( 0 being the first item )
// Exits if the DLL is NULL
// Returns NULL on failure:
//  * we tried to remove at a negative location.
//  * we tried to remove get past the size of the list
// Assume no negative numbers in the list or the number zero.

int dll_remove(dll_t* l, int pos){
	if (l == NULL) {return 0;}
	if (pos < 0) {return 0;}
	if (pos >= l->count) {return 0;} //假设index从0开始，然后pos指的是index
	//检查完毕
	if (pos == 0) { return dll_pop_front(l);}
	if (pos == l->count-1) { return dll_pop_back(l);}
	//如果pos在0或末尾，直接使用前面的function，然后它们都有return，就会return那个数字
	
	node_t* iterator = l->head;
	for (int i=0; i<pos; i++) {
		iterator = iterator->next;
	} //iterator此时是pos位置(index)的node，也是就要被删除的那一个node
	  //即使pos是0，也没关系，因为在for loop之前，iterator就已经被赋值成为l->head，然后就不会进入for循环
	
	//int returnVal = iterator->data;
	
	//有了iterator后我们进行判断，因为后续无论如何都要free掉iterator，然后return 1
	if (l->count == 1) {
		l->head = NULL;
		l->tail = NULL;
		l->count = 0;
	}
	else {
		iterator->previous->next = iterator->next;
		iterator->next->previous = iterator->previous;
	}

	free(iterator);
	return 1;
	
	//return returnVal; // Note: This line is a 'filler' so the code compiles.
}


// DLL Size
// Exits if the DLL is NULL.
// Queries the current size of a DLL

int dll_size(dll_t* t){
	if (t == NULL) {return -1;}
	return t->count;
}

// Free DLL
// Exits if the DLL is NULL.
// Removes a DLL and all of its elements from memory.
// This should be called before the proram terminates.

void free_dll(dll_t* t){
	if (t == NULL) {return;}
	
	node_t* iterator = t->head;
	
	while (t->head != NULL) {
		//iterator = t->head;
		t->head = iterator->next;
		free(iterator);
		iterator = t->head;
		t->count = t->count - 1;
	}
	
	free(t);	
}

void dll_remove_data(dll_t* l, void* data) {
    int index = 0;
    node_t* current = l->head;

    while (current != NULL) {
        if (current->data == data) {
            dll_remove(l, index);
            return;
        }
        current = current->next;
        index++;
    }
}

node_t* find_pointer_dll(dll_t* l, void* target) {
	if (l==NULL) {return NULL;}
	//if (dll_empty(l)) {return NULL;}
	node_t* iterator = l->head;
	while (iterator!=NULL) {
		if (iterator->data==target) {return iterator;}
		iterator = iterator->next;
	}
	return NULL;
} //GPT, check here

#endif
