package java_exam;

import java.util.Scanner;

public class Square {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("가로 길이를 입력하세요: ");
        int 가로 = scanner.nextInt();
        System.out.print("세로 길이를 입력하세요: ");
        int 세로 = scanner.nextInt();

        for (int i = 0; i < 가로; i++) {
            for (int j = 0; j < 세로; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        scanner.close();
    }
}