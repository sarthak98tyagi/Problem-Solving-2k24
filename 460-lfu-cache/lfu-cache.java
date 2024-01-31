class Node{
    Node next;
    Node prev;
    int key;
    int val;
    int f;
    public Node(int key,int val){
        this.key=key;
        this.val=val;
        f=1;
    }
}
class DoublyLinkedList{
    Node head;
    Node tail;

    public DoublyLinkedList(){
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
    }

    public void add(Node node){
        node.next=head.next;
        head.next.prev=node;
        node.prev=head;
        head.next=node;
    }

    public void remove(Node v){
        Node pr = v.prev;
        Node nx = v.next;
        pr.next=nx;
        nx.prev=pr;
    }

    public int remove(){
        Node tmp = tail.prev;
        tmp.prev.next=tail;
        tail.prev=tmp.prev;
        return tmp.key;
    }
    public boolean isEmpty(){
        if(head.next==tail)
            return true;
        return false;
    }
}
class LFUCache {

    int size;
    Map<Integer,Node> cache;
    Map<Integer, DoublyLinkedList> fmap;
    int min;
    public LFUCache(int capacity) {
        size=capacity;
        cache=new HashMap<>();
        fmap=new HashMap<>();
        min=0;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key))
            return -1;
        Node tmp = cache.get(key);
        int f = tmp.f;
        DoublyLinkedList d1 = fmap.get(f);
        if(!d1.isEmpty())
            d1.remove(tmp);
        if(d1.isEmpty() && min==f){
            min=f+1;
        }
        f=f+1;
        DoublyLinkedList dl = fmap.getOrDefault(f, new DoublyLinkedList());
        tmp.f=f;
        dl.add(tmp);
        fmap.put(f,dl);
        System.out.println(key+" "+f+" "+min);
        return tmp.val;
    }
    
    public void put(int key, int val) {
        if(cache.containsKey(key)){
            Node tmp = cache.get(key);
            int f = tmp.f;
            fmap.get(f).remove(tmp);
            if(fmap.get(f).isEmpty() && min==f){
                min=f+1;
            }
            f=f+1;
            DoublyLinkedList dl = fmap.getOrDefault(f, new DoublyLinkedList());
            tmp.f=f;
            tmp.val=val;
            dl.add(tmp);
            fmap.put(f,dl);
        }
        else{
            if(size==cache.size()){
                DoublyLinkedList dl = fmap.getOrDefault(min, new DoublyLinkedList());
                int v=dl.remove();
                cache.remove(v);
            }
            Node nw = new Node(key,val);
            DoublyLinkedList dl = fmap.getOrDefault(1, new DoublyLinkedList());
            min=1;
            dl.add(nw);
            fmap.put(1,dl);
            cache.put(key,nw);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */