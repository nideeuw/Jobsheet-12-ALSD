import java.util.Scanner;

public class DLLMain17 {
    public static void main(String[] args) {
        DoubleLinkedList17 list = new DoubleLinkedList17();
        Scanner scan = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\nMenu Double Linked List Mahasiswa");
            System.out.println("1. Tambah di awal");
            System.out.println("2. Tambah di akhir");
            System.out.println("3. Hapus di awal");
            System.out.println("4. Hapus di akhir");
            System.out.println("5. Tampilkan data");
            System.out.println("6. Cari Mahasiswa berdasarkan NIM");
            System.out.println("7. Sisipkan Mahasiswa setelah NIM tertentu");
            System.out.println("8. Tambah Mahasiswa pada indeks tertentu");
            System.out.println("9. Hapus Mahasiswa setelah data NIM tertentu");
            System.out.println("10. Hapus Mahasiswa pada indeks tertentu");
            System.out.println("11. Tampilkan data pertama");
            System.out.println("12. Tampilkan data terakhir");
            System.out.println("13. Tampilkan Mahasiswa pada indeks tertentu");
            System.out.println("14. Tampilkan jumlah Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scan.nextInt();
            scan.nextLine();

            switch (pilihan) {
                case 1 -> {
                    Mahasiswa17 mhs = inputMahasiswa(scan);
                    list.addFirst(mhs);
                }
                case 2 -> {
                    Mahasiswa17 mhs = inputMahasiswa(scan);
                    list.addLast(mhs);
                }
                case 3 -> {
                    list.removeFirst();
                }
                case 4 -> {
                    list.removeLast();
                }
                case 5 -> {
                    list.print();
                }
                case 6 -> {
                    System.out.print("Masukkan NIM yang dicari: ");
                    String nim = scan.nextLine();
                    Node17 found = list.search(nim);
                    if (found != null) {
                        System.out.println("Data ditemukan");
                        found.data.tampil();
                    } else {
                        System.out.println("Data tidak ditemukan");
                    }
                }
                case 7 -> {
                    System.out.print("Masukkan NIM yang ingin disisipkan setelahnya: ");
                    String keyNim = scan.nextLine();
                    Mahasiswa17 mhs = inputMahasiswa(scan);
                    list.insertAfter(keyNim, mhs);
                }
                case 8 -> {
                    System.out.print("Masukkan indeks: ");
                    int index = scan.nextInt();
                    scan.nextLine();
                    Mahasiswa17 mhs = inputMahasiswa(scan);
                    list.add(index, mhs);
                }
                case 9 -> {
                    System.out.print("Masukkan NIM: ");
                    String key = scan.nextLine();
                    list.removeAfter(key);
                }
                case 10 -> {
                    System.out.print("Masukkan indeks yang ingin dihapus: ");
                    int index = scan.nextInt();
                    scan.nextLine();
                    list.remove(index);
                }
                case 11 -> {
                    Mahasiswa17 first = list.getFirst();
                    if (first != null) {
                        System.out.println("Data pertama:");
                        first.tampil();
                    } else {
                        System.out.println("Linked list kosong.");
                    }
                }
                case 12 -> {
                    Mahasiswa17 last = list.getLast();
                    if (last != null) {
                        System.out.println("Data terakhir:");
                        last.tampil();
                    } else {
                        System.out.println("Linked list kosong.");
                    }
                }
                case 13 -> {
                    System.out.print("Masukkan indeks data yang ingin ditampilkan: ");
                    int index = scan.nextInt();
                    scan.nextLine();
                    Mahasiswa17 data = list.getIndex(index);
                    if (data != null) {
                        System.out.println("Data pada indeks " + index + ":");
                        data.tampil();
                    } else {
                        System.out.println("Data tidak ditemukan pada indeks tersebut.");
                    }
                }
                case 14 -> {
                    System.out.println("Jumlah data dalam Double Linked List: " + list.getSize());
                }
                case 0 -> {
                    System.out.println("Keluar dari program.");
                }
                default -> {
                    System.out.println("Pilihan tidak valid!");
                }
            }
        } while (pilihan != 0);

        scan.close();
    }

    public static Mahasiswa17 inputMahasiswa(Scanner scan) {
        System.out.print("Masukkan NIM: ");
        String nim = scan.nextLine();
        System.out.print("Masukkan nama: ");
        String nama = scan.nextLine();
        System.out.print("Masukkan kelas: ");
        String kelas = scan.nextLine();
        System.out.print("Masukkan IPK: ");
        double ipk = scan.nextDouble();
        scan.nextLine();
        return new Mahasiswa17(nim, nama, kelas, ipk);
    }
}
