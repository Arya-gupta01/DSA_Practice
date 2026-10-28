class LRUCache {
    //hashmap: for fast sarching
    //doubly linked-list: for tracking recency
 private int capacity;
 private HashMap<Integer,Node> map;
 private Node head;
 private Node tail;
class Node{
    int key;
    int value;
    Node prev;
    Node next;
}
public void removeNode(Node node){
    node.prev.next=node.next;
    node.next.prev=node.prev;

}
public void addToFront(Node node){
    Node first=head.next;
    node.next=first;
    node.prev=head;
    first.prev=node;
    head.next=node;

}
    public LRUCache(int capacity) {
        //gives us initial empty capacity
        this.capacity=capacity;
        map=new HashMap<>();
         head=new Node();
         tail=new Node();
        head.next=tail; 
        tail.prev=head;  
    }
    
    public int get(int key) {
        //wants us to find value store at given key
        if(!map.containsKey(key)){
            return -1;
        }
        Node node=map.get(key);
        removeNode(node);
        addToFront(node);

        return node.value;  
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.value=value;

            removeNode(node);
            addToFront(node);
            return;
        }
        Node node=new Node();
        node.key=key;
        node.value=value;

        if(map.size()==capacity){
            Node lru=tail.prev;
            removeNode(lru);
            map.remove(lru.key);
        }
        addToFront(node);
        map.put(key,node);
       



        }
        
    }
