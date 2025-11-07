/*
 * 실습문제 11
 * 사람별로 매일의 걸음 수를 기록하는 프로그램을 작성하라.
 * 이름을 '키'로 하고 걸음 수를 저장하는 ArrayList를 '값'으로 하는 해시맵을 활용하라.
 * 프로그램 내에서 황기태, 이재문, 정인환의 특정 사람으로 고정하지 말라.
 */

package generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Exam_11 {
	private HashMap<String, ArrayList<Integer>> stepMap = new HashMap<>();
	
	public void recordSteps() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("걸음 수 기록 프로그램입니다.");
		System.out.println("이름과 걸음 수를 입력하세요.");
		
		while(true) {
			System.out.print("이름: ");
			String name = scanner.nextLine();
			if(name.equals("그만")) break;
			
			System.out.print("걸음 수: ");
			try {
				int steps = Integer.parseInt(scanner.nextLine());
				
				ArrayList<Integer> stepList = stepMap.getOrDefault(name, new ArrayList<>());
				stepList.add(steps);
				stepMap.put(name, stepList);
			} catch(NumberFormatException e) {
				System.out.println("숫자 형식을 입력하세요");
			}
		}
		scanner.close();
	}
	public void printAllSteps() {
		System.out.println("\n모든 사람의 걸음 수 기록: ");
		for(String name : stepMap.keySet()) {
			ArrayList<Integer> steps = stepMap.get(name);
			System.out.print(name + " : ");
			for(int s:steps)
				System.out.print(s+ " ");
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Exam_11 tracker = new Exam_11();
		tracker.recordSteps();
		tracker.printAllSteps();
	}
}
