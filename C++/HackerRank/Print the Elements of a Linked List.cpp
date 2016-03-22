/*
  Print elements of a linked list on console 
  head pointer input could be NULL as well for empty list
  Node is defined as 
  struct Node
  {
     int data;
     struct Node *next;
  }
*/

// This is a "method-only" submission.  

void Print(Node *head)
{
  while (head != NULL)
  {
      std::cout << head->data << std::endl;
      head = head->next;
  }
}
