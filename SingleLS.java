/**
 * a singly linked list 
 * 
 * @author Rosalie Cai
 *
 */
public class SingleLS{
  Node head;
  Node tail;
  int size;
  
  /**
   * O(1)
   * 
   * @param newNode
   */
  public void add (Node newNode) {
    if(head ==null) {
      head=newNode;
      tail= newNode;
      size++;
    }else {
      tail.next=newNode;

      do {
        tail=tail.next;
        size++;
      }
      while(tail.next==null);
      
    }
  }
  
  /**
   * O(N)
   * 
   * @param newNode
   */
  public void add (int index,Node newNode) {
    if(head ==null||index>size) {
      throw new IndexOutOfBoundsException();
    }else if(index==0) {
      Node runner=newNode;
      while (runner.next!=null) {
        runner= runner.next;
      }
      runner.next=head;
      
      head=newNode;
    }else {
      Node runner=head;
      for(int i=0;i<index-1;i++) {
        runner= runner.next;
      }
      
      Node runner2=newNode;
      while (runner2.next!=null) {
        runner2= runner2.next;
      }
      runner2.next=runner.next;
      
      runner.next=newNode;
    }
  }
  
/**
 * O(
 * merge sort  ---------------------------------------------------
 */
public void sort() {
  merge_sort(head); 
}

public Node merge_sort(Node node) {
  if(node==null||node.next==null) {
    return node;
  }else {
    Node middle = split(node);
    Node secondHalf = middle.next;
    middle.next = null;
    
    return merge(merge_sort(node), merge_sort(secondHalf));
  }
}

public Node split(Node node) {
  Node newNode=node;
  if(node==null) {
    return null;
  }else {
    while(newNode.next!=null || newNode.next.next!=null) {
      node=node.next;
      newNode=newNode.next.next;
    }
  }
  return node;
}
public Node merge(Node node1,Node node2) {
  if(node1==null) {
    return node1;
  }else if(node2==null){
    return node2;
  }else {
    Node newStart = null;
    if(node1.value<=node2.value) {
      newStart= node1;
      newStart.next=merge(node1.next,node2);
    }
    else {
      newStart= node2;
      newStart.next=merge(node1,node2.next);
    }
    
    return newStart;
  }
  
}

/**
 *find logest Palindrome
 * @return ------------------------------------------------------
 */
public int findPalindrome(Node head) {
  int max=0;
  head = this.head;
  Node revHead = null;
  while(head!=null) {
    max= Math.max(2*common(head, revHead),2*common(head.next,revHead)+1);
    
    Node temp = head;
    head = head.next;
    temp.next=revHead;
    revHead=temp;
  }
  
  return max;
}

public int common(Node n1, Node n2) {
  int count=0;
  while(n1!=null&&n2!=null) {
    if(n1.value==n2.value) {
      count++;
    }
  }
  return count;
}

  /**
   * node for the linked list
   * 
   * @author Rosalie Cai
   *
   * @param intintalue
   */
  public class Node {
    // priintate fields
    private int value;
    private Node next;


    // constructors-----------------------
    /**
     * default constructor of the node
     */
    public Node() {
    }

    /**
     * ointerloading constructor of the node
     */
    public Node(int value) {
      this.value = value;
    }

    // ----------------------------
    /**
     * get intalue
     * 
     * @return the intalue
     */
    public int getvalue() {
      return value;
    }

    /**
     * set intalue
     * 
     * @param intalue the intalue to set
     */
    public void setvalue(int value) {
      this.value = value;
    }

  }
}
