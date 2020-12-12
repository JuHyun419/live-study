package four;

class ListNode {
    private String data;    // 데이터 저장
    public ListNode link;   // 다른 노드를 참조할 링크 노드

    public ListNode() {
    }

    public ListNode(String data) {
        this.data = data;
    }

    public ListNode(String data, ListNode link) {
        this.data = data;
        this.link = link;
    }

    public String getData() {
        return this.data;
    }
}

public class LinkedList {
    
    private ListNode head;  // ListNode 타입의 head 노드

    // 객체 생성 시 head 노드 초기화
    public LinkedList() {
        head = null;
    }

    // 중간 노드 삽입
    public void insertMid(ListNode preNode, String data) {
        ListNode newNode = new ListNode(data);

        // preNode.link 는 preNode의 다음 노드로,
        // 아래 새로운 노드의 link가 preNode의 다음 노드를 참조하도록 한다.
        newNode.link = preNode.link;

        // preNode의 link가 새로운 노드를 참조
        // preNode -> newNode -> 기존 preNode의 다음 노드
        preNode.link = newNode;
    }

    // 마지막에 노드 삽입
    public void insertLast(String data) {
        ListNode newNode = new ListNode(data);

        if (head == null) {
            this.head = newNode;
        } else {
            
            // tempNode는 마지막 노드를 찾고 참조하기 위해 사용
            ListNode tempNode = head;

            // tempNode의 link가 null이 아닐 때 까지 다음 노드 참조(마지막 Node)
            // tempNode = tempNode.link 는 tempNode의 다음 노드를 참조
            // while문이 종료되면, tempNode는 가징 마지막 노드를 참조
            while (tempNode.link != null) {
                tempNode = tempNode.link;
            }

            // 가장 마지막 노드의 link가 다음 노드를 참조하도록 함
            tempNode.link = newNode;
        }
    }
    
    // 중간 Node 삭제
    public void deleteMid(String data) {

        // preNode = head가 가리키는 노드
        // tempNode = head가 가리키는 노드의 다음 Node, 즉 preNode의 다음 노드 할당
        ListNode preNode = head;
        ListNode tempNode = head.link;

        // 삭제할 Node
        if (data.equals(preNode.getData())) {
            // head는 preNode의 다음 노드를 참조
            head = preNode.link;

            // preNode의 link를 null로 할당함으로써 연결 끊음
            preNode.link = null;
        } else {
            while (tempNode != null) {
                if (data.equals(tempNode.getData())) {
                    if (tempNode.link == null) {
                        preNode.link = null;
                    } else {
                        preNode.link = tempNode.link;
                        tempNode.link = null;
                    }
                    break;
                } else {
                    // 데이터가 일치하지 않을 경우
                    preNode = tempNode;
                    tempNode = tempNode.link;
                }
            }
        }
    }

    // 마지막 노드 삭제
    public void deleteLast() {
        ListNode preNode;
        ListNode tempNode;
        
        // head 노드가 null일 경우 모든 노드가 삭제된 경우
        if (head == null) {
            return;
        }

        if (head.link == null) {    // 노드가 1개남은 경우
            head = null;
        } else {
            // preNode는 head가 가리키는 노드
            preNode = head;

            // tempNode는 headr가 가리키는 다음의 노드(preNode의 다음 노드)
            tempNode = head.link;

            // 최종적으로 preNode는 마지막 노드의 이전 노드가 되고, tempNode는 마지막 노드가 됨
            while (tempNode.link != null) {
                preNode = tempNode;
                tempNode = tempNode.link;
            }
            
            // 가장 마지막 노드 삭제
            preNode.link = null;
        }
    }

    // 모든 노드 출력
    public void printNodeList() {
        ListNode tempNode = this.head;

        while (tempNode != null) {
            System.out.print(tempNode.getData() + " ");
            tempNode = tempNode.link;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertLast("1");
        linkedList.insertLast("2");
        linkedList.insertLast("3");
        linkedList.insertLast("4");
        linkedList.insertLast("5");
        linkedList.insertLast("6");
        linkedList.insertLast("7");

        linkedList.printNodeList();

        linkedList.deleteLast();
        linkedList.printNodeList();

        linkedList.deleteMid("3");
        linkedList.printNodeList();
    }
}
