package linear;

public class LinkList<T> {

    private Node head;
    private int N;

    public class Node {
        public T item;
        public Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public LinkList() {
        this.head = new Node(null, null);
        this.N = 0;
    }

    //清空链表
    public void clear() {
        head.next = null;
        this.N = 0;
    }

    //获取链表的长度
    public int length() {
        return N;
    }

    //判断链表是否为空
    public boolean isEmpty() {
        return N == 0;
    }

    public T get(int index) {
        if (index < N && index >= 0) {
            Node node = head;
            for (int i = 0; i <= index; i++) {
                node = node.next; //i = 0,1,2,3,...,index
            }
            return node.item;
        }
        return null;
    }

    public void insert(T t) {
        //新建一个结点
        Node newNode = new Node(t, null);
        //将尾结点指向新结点
        Node node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = newNode;
        //长度增1
        N++;
    }

    public void insert(int index, T t) {
        //获取当前index、index-1处的node
        Node preNode = head;
        for (int i = 0; i <= index - 1; i++) {
            preNode = preNode.next; //i = 0,1,2,3,...,index
        }
        Node curNode = preNode.next;

        //创建指向原index处结点的新结点
        Node newNode = new Node(t, curNode);
        //将index-1处结点指向新结点
        preNode.next = newNode;

        //长度自增1
        N++;
    }

    public T remove(int index) {
        //获取当前index、index-1、index+1处的node
        Node preNode = head;
        for (int i = 0; i <= index - 1; i++) {
            preNode = preNode.next; //i = 0,1,2,3,...,index
        }
        Node curNode = preNode.next;
        Node nextNode = curNode.next;

        //preNode指向nextNode
        preNode.next = nextNode;

        //长度减1
        N--;

        return curNode.item;
    }

    public int indexOf(T t) {
        Node node = head.next;
        for (int i = 0; node.next != null; i++) {
            if (node.item.equals(t)) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node node = head.next;
        for (int i = 0; i < N; i++) {
            sb.append(node.item + "\n");
            node = node.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkList<String> ll1 = new LinkList<>();
        ll1.insert("gill");
        ll1.insert("paul");
        ll1.insert("keil");
        ll1.insert("jack");

        ll1.insert("hall");
        ll1.insert("qiyi");
        System.out.println(ll1.toString());

        System.out.println(ll1.get(1));

        System.out.println(ll1.indexOf("hall"));

    }


}