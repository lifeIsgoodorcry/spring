package com.example.demo1.suanfa.sort.lru;

public class DubboNodeList {
    Node head;
    Node tail;

    public DubboNodeList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
    }

    /**
     * 新增节点，在头部插入
     *
     * @param node null<- (pre)  head  (next)-> node
     * @return null<- ( pre ) head->  current  (next)-> node  添加以后
     * <p>
     * node.next   = head.next;
     * node.prev   = head;
     * <p>
     * head.next.prev = node;
     * head.next      = node;
     */
    public void addHead(Node node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    /**
     * 删除尾部节点
     * <p>
     * node1 <- node<- (pre)  tail  (next)-> null
     *
     * @return node1-》tail
     */
    public int deleteTail() {
        //删除尾结点
        Node node = tail.pre; //需要删除的节点
        Node pre = node.pre; //删除节点的前面的节点
        pre.next = tail; //前面的节点的next变更
        tail.pre = pre; //tail节点的前节点原来是node，现在变更成 pre节点
        return node.key; //返回删除元素的值
    }


    public int delete(Node node) {
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
        return node.key;
    }


    public void iter() {
        System.out.println("头节点：" + this.head.value + "，当前节点 node:" + this.head.next.value
                + "，尾结点：" + this.tail.value + "，尾结点的前节点：" + this.tail.pre.value);
        Node node = this.head;

    }

    public int delete2() {
        if (head.next == tail) {
            return -1;
        }
        Node node = tail.pre;
        return delete(node);
    }


    public static void main(String[] args) {
        DubboNodeList list =
                new DubboNodeList();
        Node node = new Node(1, 2);
        list.addHead(node);

        Node node1 = new Node(2, 3);
        list.addHead(node1);

        list.iter();

        //删除
        list.delete(node1);

        list.iter();



    }


}
