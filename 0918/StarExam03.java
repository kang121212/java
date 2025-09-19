package control;

public class StarExam03 {

	public static void main(String[] args) {
		int height = 5; // 삼각형 높이 고정

        for (int i = 1; i <= height; i++) {
            // 공백 출력 (가운데 정렬)
            for (int j = 1; j <= height - i; j++) {
                System.out.print(" ");
            }

            // 별 출력
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
