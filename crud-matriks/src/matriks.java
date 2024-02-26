import java.util.Scanner;

public class matriks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = null;

        while (true) {
            System.out.println("=== Menu ===");
            System.out.println("1. Lihat Matrix");
            System.out.println("2. Buat Matrix");
            System.out.println("3. Edit Matrix");
            System.out.println("4. Hapus Matrix");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    lihatMatrix(matrix);
                    break;
                case 2:
                    matrix = buatMatrix(scanner);
                    break;
                case 3:
                    editMatrix(scanner, matrix);
                    break;
                case 4:
                    matrix = null;
                    System.out.println("Matrix berhasil dihapus.");
                    break;
                case 5:
                    System.out.println("Keluar dari program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void lihatMatrix(int[][] matrix) {
        if (matrix == null) {
            System.out.println("Matrix belum dibuat.");
            return;
        }

        System.out.println("=== Matrix ===");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static int[][] buatMatrix(Scanner scanner) {
        System.out.print("Masukkan jumlah baris: ");
        int rows = scanner.nextInt();

        System.out.print("Masukkan jumlah kolom: ");
        int columns = scanner.nextInt();

        int[][] newMatrix = new int[rows][columns];

        System.out.println("Masukkan elemen-elemen matrix:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Baris " + (i + 1) + ", Kolom " + (j + 1) + ": ");
                newMatrix[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Matrix berhasil dibuat.");
        return newMatrix;
    }

    private static void editMatrix(Scanner scanner, int[][] matrix) {
        if (matrix == null) {
            System.out.println("Matrix belum dibuat.");
            return;
        }

        System.out.print("Masukkan baris yang ingin diubah: ");
        int row = scanner.nextInt() - 1;

        System.out.print("Masukkan kolom yang ingin diubah: ");
        int column = scanner.nextInt() - 1;

        System.out.print("Masukkan nilai baru: ");
        int newValue = scanner.nextInt();

        if (row >= 0 && row < matrix.length && column >= 0 && column < matrix[0].length) {
            matrix[row][column] = newValue;
            System.out.println("Nilai berhasil diubah.");
        } else {
            System.out.println("Indeks tidak valid.");
        }
    }
}
