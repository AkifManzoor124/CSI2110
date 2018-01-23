/** 
 * Builds a singly linked list of size 5 and prints it to the console.
 * 
 * @author Jochen Lang
 */

class LinkList {
    Node header;
    Node trailer;

    LinkList( int sz ) {

	header = new Node("0", null, null);
	trailer = new Node(null, null, header);
	
	header.setNext(trailer);
	
	Node current = header;
	
	for(int i = 1;i<sz;i++) {
		
		Node node2Add = new Node(Integer.toString(i), trailer,current);
		trailer.setPrev(node2Add);
		current.setNext(node2Add);
		current = node2Add; 
	}
    }
    
    /**
     * Print all the elements of the list assuming that they are Strings
     */
    public void print() {
	/* Print the list */
	Node current = header; // point to the first node
	while (current != trailer) {
	    System.out.print((String)current.getElement() + " ");	
	    current = current.getNext(); // move to the next
	}
	System.out.println();	
    }

    public void deleteFirst() {
	if ( header != null ) {
		Node node = header.getNext().getNext();
	    header.setNext(node);
	    node.setPrev(header);
	}
    }

    public void deleteLast() {
	if ( header == null ) return; // no node
	trailer.getPrev().getPrev().setNext(trailer);
	trailer.setPrev(trailer.getPrev().getPrev());
	return;
    }

    // create and display a linked list
    public static void main(String [] args){
	/* Create the list and print */
	LinkList llist = new LinkList( 5 );
	llist.print();
	
	
	/* delete first and print */
	llist.deleteFirst();
	llist.print();
	/* delete last and print 5 times */
	for ( int i=0; i< 3; ++i ) {
	    llist.deleteLast();
	    llist.print();
	}
    }
}
