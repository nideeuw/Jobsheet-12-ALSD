public class DoubleLinkedList17 {
    Node17 head;
    Node17 tail;

    public DoubleLinkedList17() {
        head = null;
        tail = null;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void addFirst(Mahasiswa17 data) {
        Node17 newNode = new Node17(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addLast(Mahasiswa17 data) {
        Node17 newNode = new Node17(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void insertAfter(String keyNim, Mahasiswa17 data) {
        Node17 current = head;

        // Cari node dengan nim - keyNim
        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Node dengan NIM " + keyNim + " tidak ditemukan.");
            return;
        }

        Node17 newNode = new Node17(data);

        // Jika current adalah tail, cukup tambahkan di akhir
        if (current == tail) {
            current.next = newNode;
            newNode.prev = current;
            tail = newNode;
        } else {
            // Sisipkan di tengah
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }

        System.out.println("Node berhasil disisipkan setekah NIM " + keyNim);
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong.");
            return;
        }
        Node17 current = head;
        while (current != null) {
            current.data.tampil();
            current = current.next;
        }
    }
    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("List kosong, tidak dapat dihapus");
            return;
        } else if (head == tail) {
            System.out.println("Data sudah berhasil dihapus. Data yang terhapus adalah:");
            head.data.tampil();
            head = tail = null;
        } else {
            System.out.println("Data sudah berhasil dihapus. Data yang terhapus adalah:");
            head.data.tampil();
            head = head.next;
            head.prev = null;
        }
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("List kosong, tidak dapat dihapus");
            return;
        }
        if (head == tail) {
            head = tail = null;
        }else {
            tail = tail.prev;
            tail.next = null;
        }
    }
    public void add(int index, Mahasiswa17 data) {
        if (index < 0) {
            System.out.println("Indeks salah.");
        } else if (index == 0) {
            addFirst(data);
        } else {
            Node17 temp = head;
            int i = 0;
            while (temp != null && i < index - 1) {
                temp = temp.next;
                i++;
            }
            if (temp == null) {
                System.out.println("Indeks melebihi jumlah elemen.");
            } else if (temp.next == null) {
                addLast(data);
            } else {
                Node17 newNode = new Node17(data);
                newNode.next = temp.next;
                newNode.prev = temp;
                temp.next.prev = newNode;
                temp.next = newNode;
            }
        }
    }
    public void removeAfter(String keyNim) {
        Node17 current = head;

        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }
        if (current == null || current.next == null) {
            System.out.println("Tidak ada node yang bisa dihapus setelah NIM tersebut.");
            return;
        }

        Node17 toDelete = current.next;
        current.next = toDelete.next;

        if (toDelete.next != null) {
            toDelete.next.prev = current;
        } else {
            tail = current;
        }
        System.out.println("Data setelah NIM " + keyNim + " berhasil dihapus:");
        toDelete.data.tampil();
    }
    public void remove(int index) {
        if (isEmpty()) {
            System.out.println("Linked List kosong.");
            return;
        }
        if (index < 0) {
            System.out.println("Indeks tidak valid.");
            return;
        }
        if (index == 0) {
            removeFirst();
            return;
        }

        Node17 current = head;
        int currentIndex = 0;

        while (current != null && currentIndex < index) {
            current = current.next;
            currentIndex++;
        }
        if (current == null) {
            System.out.println("Indeks melebihi jumlah data.");
        } else {
            if (current == tail) {
                removeLast();
            } else {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                System.out.println("Data pada indeks " + index + " berhasil dihapus:");
                current.data.tampil();
            }
        }
    }

    Mahasiswa17 getFirst() {
        if (!isEmpty()) {
            return head.data;
        }
        return null;
    }

    Mahasiswa17 getLast() {
        if (!isEmpty()) {
            return tail.data;
        }
        return null;
    }

    Mahasiswa17 getIndex(int index) {
        if (index < 0 || isEmpty()) {
            return null;
        }
        Node17 current = head;
        int currentIndex = 0;

        while (current != null && currentIndex < index) {
            current = current.next;
            currentIndex++;
        }
        if (current != null) {
            return current.data;
        }
        return null;
    }

    int getSize() {
        int count = 0;
        Node17 current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
     Node17 search(String nim) {
        Node17 current = head;
        while (current != null) {
            if (current.data.nim.equalsIgnoreCase(nim)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
}
