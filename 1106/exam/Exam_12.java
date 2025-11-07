/*
 * 실습문제 12
 * 가상의 기계 명령(instruction)으로 구성된 프로그램을 실행하는 가상 기계(Virtual Machine)를 작성하라.
 * 명령 종류는 mov, add, sub, jn0, prt, exi의 6가지이다. mov sum 0은 sum 변수에 0을 저장하고, add sum i는 sum 변수에
 * i 변수의 값을 더하고 add i 1은 변수 i를 1 증가시키며, sub n 1은 변수 n의 값을 1 감소시키고,
 * jn0 n 3은 변수 n의 값이 0과 같지 않으면 3번째 명령(실제 4번째 줄의 명령)으로 점프하도록 처리하며, prt sum은 sum 변수의 값을 화면에 출력하고, exi는 
 * 기계 명령으로 작성된 사용자 프로그램을 종료하는 명령이다.
 * go는 사용자가 입력한 기계 명령 프로그램을 처음부터 실행하도록 하는 지시어이다. prt와 exi를 제외한 명령들의 첫번재 피연산자(operand)는 항상 변수이고, 
 * 두번재 피연산자는 변수이거나 숫자가 될 수 있다.
 * 참고로 실행 예시의 첫번째 프로그램은 5에서 15까지 더하여 프로그램으로 sum 변수의 값을 출력하면 95가 된다. 두번째 프로그램은 100+20-5를 계산하여 115를 출력하는 프로그램이다.
 * 이 문제를 풀면 자바 가상 기계가 어떻게 만들어 지는지 조금이나마 이해할 수 있다.
 */

package generic;

import java.util.*;

public class Exam_12 {
    private Map<String, Integer> memory = new HashMap<>();
    private List<String[]> instructions = new ArrayList<>();

    public void loadProgram(Scanner scanner) {
        System.out.println("명령어를 입력하세요. (go 입력 시 실행 시작)");

        while (true) {
            String line = scanner.nextLine().trim();
            if (line.equals("go")) break;

            String[] tokens = line.split("\\s+");
            instructions.add(tokens);
        }
    }

    public void executeProgram() {
        int pc = 0; // program counter

        while (pc < instructions.size()) {
            String[] inst = instructions.get(pc);
            String cmd = inst[0];

            switch (cmd) {
                case "mov": {
                    String var = inst[1];
                    int value = getValue(inst[2]);
                    memory.put(var, value);
                    pc++;
                    break;
                }
                case "add": {
                    String var1 = inst[1];
                    int value = getValue(inst[2]);
                    memory.put(var1, memory.getOrDefault(var1, 0) + value);
                    pc++;
                    break;
                }
                case "sub": {
                    String var1 = inst[1];
                    int value = getValue(inst[2]);
                    memory.put(var1, memory.getOrDefault(var1, 0) - value);
                    pc++;
                    break;
                }
                case "jn0": {
                    String var = inst[1];
                    int target = Integer.parseInt(inst[2]);
                    if (memory.getOrDefault(var, 0) != 0) {
                        pc = target;
                    } else {
                        pc++;
                    }
                    break;
                }
                case "prt": {
                    String var = inst[1];
                    System.out.println(var + " = " + memory.getOrDefault(var, 0));
                    pc++;
                    break;
                }
                case "exi": {
                    return;
                }
                default: {
                    System.out.println("알 수 없는 명령: " + cmd);
                    pc++;
                }
            }
        }
    }

    private int getValue(String operand) {
        if (operand.matches("-?\\d+")) {
            return Integer.parseInt(operand);
        } else {
            return memory.getOrDefault(operand, 0);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Exam_12 vm = new Exam_12();
        vm.loadProgram(scanner);
        vm.executeProgram();
    }
}





















