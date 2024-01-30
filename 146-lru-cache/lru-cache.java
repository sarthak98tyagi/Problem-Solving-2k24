class ListNode{
    ListNode next;
    ListNode prev;
    int val;

    public ListNode(ListNode next, ListNode prev, int val){
        this.next=next;
        this.prev=prev;
        this.val=val;
    }
}
class LRUCache {

    ListNode head;
    ListNode tail;
    Map<Integer,Integer> mp;
    Map<Integer,ListNode> lmp;
    int size;
    public LRUCache(int cap) {
        head=null;
        tail=null;
        mp=new HashMap<>();
        lmp=new HashMap<>();
        size=cap;
    }
    
    public int get(int key) {
        if(mp.containsKey(key)){
            update(key);
            return mp.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)){
            update(key);
            mp.put(key,value);
        }
        else{
            if(size>0){
                add(key);
                mp.put(key,value);
                size--;
            }
            else{
                delete();
                add(key);
                mp.put(key,value);
            }
        }
    }

    public void add(int key){
        ListNode nw = new ListNode(null,null,key);
        if(head==null){
            head=nw;
            tail=nw;
        }
        else{
            tail.next=nw;
            nw.prev=tail;
            tail=nw;
        }
        lmp.put(key,nw);
    }

    public void delete(){
        if(head!=null){
            ListNode nx = head.next;
            lmp.remove(head.val);
            mp.remove(head.val);
            if(nx!=null){
                nx.prev=null;
            }
            head.next=null;
            if(tail==head)
                tail=nx;
            head=nx;
        }
    }

    public void update(int key){
        ListNode tmp = lmp.get(key);
        if(tmp==tail)
            return;
        ListNode pr = tmp.prev;
        ListNode nx = tmp.next;
        if(pr!=null)
            pr.next=nx;
        else
            head=nx;
        nx.prev=pr;
        tmp.next=null;
        tmp.prev=null;
        tail.next=tmp;
        tmp.prev=tail;
        tail=tmp;
        if(head==null)
            head=tail;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */