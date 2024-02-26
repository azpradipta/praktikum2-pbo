import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan operasi matematika: ");
        String ekspresi = scanner.nextLine();

        // Menampilkan hasil ekspresi
        try {
            int hasil = evaluasiEkspresi(ekspresi);
            System.out.println("Hasil: " + hasil);
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan dalam mengevaluasi ekspresi.");
        } finally {
            // Close the scanner in the finally block to ensure it gets closed even if an exception occurs
            scanner.close();
        }
    }

    // Fungsi evaluasi ekspresi
    public static int evaluasiEkspresi(String ekspresi) {
        String[] tokens = ekspresi.split(" ");

        int hasil = Integer.parseInt(tokens[0]);

        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];
            int operand = Integer.parseInt(tokens[i + 1]);

            switch (operator) {
                case "+":
                    hasil += operand;
                    break;
                case "-":
                    hasil -= operand;
                    break;
                case "*":
                    hasil *= operand;
                    break;
                case "/":
                    hasil /= operand;
                    break;
                default:
                    throw new IllegalArgumentException("Operator tidak valid: " + operator);
            }
        }

        return hasil;
    }
}
