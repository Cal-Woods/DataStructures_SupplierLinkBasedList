package Classes;

public class LinkBasedList {
    //Store first element
    private Node first;
    //Store last element
    private Node last;

    //Store number of elements
    private int numElements;

    public LinkBasedList() {
        this.first = null;
        this.last = null;
        this.numElements = 0;
    }
        //Create inner-class
        private static class Node {
            private String data;
            private Node next;

            //Node constructor
            public Node(String data) {
                this.data = data;
                this.next = null;
        }
    }

    /**
     * Gives back no of added elements.
     * @return size of LinkBasedList
     */
    public int size() {
        return this.numElements;
    }

    public boolean isEmpty() {
        //Return if numElements is 0
        return this.numElements == 0;
    }

    /**
     * Attempts to get a value at the given index, otherwise, gets null
     * @param index Given index to get value from it
     * @return The Node at the index or -1 if it could not be found
     */
    public String get(int index) {
        //Validation
        if (index < 0 || index >= this.numElements) throw new IndexOutOfBoundsException("Given index must be between 0 & size of LinkBasedList inclusive.");
        if(this.isEmpty()) return null;

        //Store reference to current element
        Node current = this.first;

        //Initialise for loop to iterate until index-1
        for (int i = 0; i < index; i++) {
            //Check if current.next is null
            if (current.next == null) {
                return null;
            }

            //Set current to next element
            current = current.next;
        }
        return current.data;
    }

    //Create 'indexOf()' method
    public int indexOf(String data) {
        //Validation
        if(this.numElements == 0) return -1;
        if(data == null) throw new IllegalArgumentException("");
        if(data.isBlank()) return -1;

        Node current = this.first;

        for(int i = 0; i < size(); i++) {
            if (current.data.equals(data)) {
                //return count
                return i;
            }
            //Move to next Node
            current = current.next;
        }

        return -1;
    }

    //Create 'add(String data);
    public void add(String data) {
        //Declare newNode to store new Node
        Node newNode = new Node(data);

        //Validation
        if (this.isEmpty()) {
            this.first = newNode;
            this.last = newNode;
        }
        //Else, if list has more elements
        else {
            //Start current reference at beginning, first element in
            Node current = this.first;

            //Set Node current.next attribute to a new Node object with the data
            current.next = new Node(data);
            this.last = current.next;

        }
        this.numElements++;

        return;
    }

    public boolean addFirst(String data) {
        //Validation
        if(data == null) throw new IllegalArgumentException("Given data must NOT be null!");
        if(data.isBlank()) return false;

        //Declare new node that holds data
        Node newNode = new Node(data);

        //Check if 'first' property is null
        if(this.isEmpty()) {
            this.first = newNode;
            this.last = newNode;
        }
        else {
            //Set newNode.next to 'first'
            newNode.next = this.first;

            //Set 'first' to newNode
            this.first = newNode;
        }
        //Increment numElements by 1
        this.numElements++;

        return true;
    }

    public boolean addLast(String data) {
        if(data == null) throw new IllegalArgumentException("Given data must NOT be null!");
        if(data.isBlank()) return false;

        //Declare Node newNode = a new Node with data
        Node newNode = new Node(data);

        //

        this.numElements++;

        return true;
    }


    /**
     * Removes the element with the specified data.
     * @param data The specified data
     * @return The removed element
     */
    public Node remove(String data) {
        if(this.numElements == 0) return null;

        Node current = this.first;

        //initialise while loop that keeps checking the next reference property of Node
        while(!current.data.equals(data) && current.next != null) {
            current = current.next;
        }

        return current;
    }
}