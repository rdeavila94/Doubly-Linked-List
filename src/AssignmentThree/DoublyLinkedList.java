package AssignmentThree;

import java.util.Arrays;

/**
 * This assignment will  create a data structure called a DoublyLinkedList
 * that consists of linked nodes. Each node will contain a string and pointers to 
 * and from their previous and next node.
 * @author Richard DeAvila *****8448
 *
 */

public class DoublyLinkedList {
	
	/**
	 * This is the default constructor, which will create the front and rear
	 * of a DLL and initialize them pointing to eachother. mPrevious of the front
	 * and mNext of the rear will be null, since nothing comes before or after them.
	 */
	
	public DoublyLinkedList()
	{
		mFront = new Node ("DummyFront");
		mRear = new Node ("DummyRear");
		mFront.mNext = mRear;
		mRear.mPrevious = mFront;
		mFront.mPrevious = null;
		mRear.mNext = null;
	}
	
	/**
	 * Will create a node that will be added to the pseudo-front of the DLL,
	 * which is to say only behind the dummy front. 
	 * @param word The word that the node being appended to the front will contain.
	 */
	
	public void appendFront (String word) 
	{
		Node newNode = new Node(word);
		newNode.mPrevious = mFront;
		newNode.mNext = mFront.mNext;
		newNode.mNext.mPrevious = newNode;
		mFront.mNext = newNode;
	}

	/**
	 * Will create a node that will be added to the pseudo-rear of the DLL,
	 * which is to say only ahead of the dummy rear.
	 * @param word The word that the node being appended to the rear will contain.
	 */
	
	public void appendRear (String word) 
	{
		Node newNode = new Node (word);
		newNode.mNext = mRear;
		mRear.mPrevious.mNext = newNode;
		newNode.mPrevious = mRear.mPrevious;
		mRear.mPrevious = newNode;
	
	}

	/**
	 * Will create a node that is added before another node in the DLL.
	 * @param marker The word of the node we want to insert before.
	 * @param word The word that the node being inserted before our marker will contain.
	 */
	
	public void insertBefore (String marker, String word) 
	{
		Node newNode = new Node (word);
		Node current = finder(marker);
		newNode.mNext = current;
		newNode.mPrevious = current.mPrevious;
		current.mPrevious.mNext = newNode;
		current.mPrevious = newNode;	
	
	}

	/**
	 * Will create a node that is added after another node in the DLL.
	 * @param marker The word of the node we want to insert after.
	 * @param word The word that the node being inserted after our marker will contain.
	 */
	
	public void insertAfter (String marker, String word)
	{
		Node newNode = new Node (word);
		Node current = finder (marker);
		newNode.mPrevious = current;
		newNode.mNext = current.mNext;
		current.mNext = newNode;
		newNode.mNext.mPrevious = newNode;

	}

	/**
	 * Will search if a node with the given data is present in the DLL.
	 * @param word The word that the node were looking for should contain.
	 * @return True or false, on whether the node were looking for is present.
	 */
	
	public boolean isPresent (String word)
	{
		Node current = mFront.mNext;
		while (current != null)
		{
			if (word.equals(current.mData))
				return true;
			current = current.mNext;
		}
		return false;
	
	}

	/**
	 * Will remove a node from a DLL by cutting off all pointers that point to it.
	 * @param word The word that the node were removing should contain.
	 */
	
	public void remove (String word) 
	{
		Node current = finder(word);
		current.mNext.mPrevious = current.mPrevious;
		current.mPrevious.mNext = current.mNext;
	}

	/**
	 * Will print out the DLL in order from first to last, as is.
	 */
	
	public void print () 
	{
		System.out.println("\n\nUnsorted List Forward");
		Node current = mFront;
		while (current != null)
		{
			System.out.print(current.mData + " ");
			current = current.mNext;
		}
	
	}
	
	/**
	 * Will print out the DLL from the rear to the front, as is.
	 */
	
	public void printBackwards ()
	{
		System.out.println("\n\nUnsorted List Backward");
		Node current = mRear;
		while (current != null)
		{
			System.out.print(current.mData + " ");
			current = current.mPrevious;
		}

	}
	

	/**
	 * Will print out the DLL but sorted. This is done by adding the DLL's Node's words 
	 * into a string array and sorting that array.
	 */
	
	public void sortAndPrint ()
	{
		int count = 0;
		Node current = mFront;
		while (current != null)
		{
			count += 1;
			current = current.mNext;
		}
		String [] nodeArray = new String [count];
		current = mFront;
		for (int i = 0; i < count; ++i)
		{
			nodeArray[i] = current.mData;
			current = current.mNext;
		}
		Arrays.sort(nodeArray);
		System.out.print("Sorted list \n");
		for (int ii = 0; ii < nodeArray.length; ++ii)
			System.out.print(nodeArray[ii] + " ");
	}

	/**
	 * Will find a node with the given data and return it.
	 * @param word The word that the node were looking for should contain.
	 * @return The node with the word we were looking for.
	 */
	
	private Node finder (String word)
	{
		Node current = mFront.mNext;
		while (!word.equals(current.mData))
		{
			current = current.mNext;
		}
		return current;
	}

/**
 * @author Richard DeAvila 010668448
 *This class will create a data structure called a node, which contains a 
 *piece of data (in this case a string) and a pointer to the next and previous node.
 */

class Node {
	
	/**
	 * Will create a node and initialize it's previous and next to null.
	 * @param word The word that a created node will contain.
	 */
	
	public Node (String word)
	{
		mData = word;
		mNext = null;
		mPrevious = null;
		
	}
	private String mData;
	private Node mNext;
	private Node mPrevious;

}

private Node mFront;
private Node mRear;
}