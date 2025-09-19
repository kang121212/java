package control;

public class StarExam02 {

	public static void main(String[] args) {
		int rows = 5; // 출력할 줄 수
        for (int i = 1; i <= rows; i++) {
            // 공백 출력
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            // 별 출력
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            // 줄 바꿈
            System.out.println();
        }
    }
}
