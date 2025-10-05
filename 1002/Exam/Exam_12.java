/* 연습문제 12
 * 다음은 '키'와 '값'의 두 문자열을 하나의 아이템으로 저장하는 추상 클래스 PairMap이다.
 * put() 은 '키'와 '값'을 저장하고 get()은 '키'로 검색하여 '값'을 리턴하는 메소드 이다.
 * PairMap을 상속받아 Dictionary 클래스를 구현하고 이를 다음과 활용하는 main() 
 * 메소드를 가진 DictionaryApp 클래스로 작성하라.
 */
package Exam_1002;

abstract class PairMap{
	protected String keyArray[];	//키 문자열 저장 배열
	protected String valueArray[];	//값 문자열 저장 배열
	protected int size = 0;
	
	public PairMap(int capacity) {
		keyArray= new String[capacity];
		valueArray = new String[capacity];
	}
	abstract public String get(String key);	//key 값으로 value 검색
	abstract public void put(String key, String value);
	//key와 value를 쌍으로 저장, key가 이미 저장되어 있으면 값을 value로 수정
	abstract public String delete(String key);
	//key 값을 가진 아이템(value와 함께) 삭제. 삭제된 value 값 리턴
	abstract public int length();	//현재 저장된 아이템 개수 리턴
}
class Dictionary extends PairMap{
	public Dictionary(int capacity) {
		super(capacity);
	}
	public String get(String key) {
		for(int i=0; i<size; i++) {
			if(keyArray[i].equals(key)) {
				return valueArray[i];
			}
		}
		return null;
	}
	public void put(String key, String value) {
		for(int i=0; i<size; i++) {
			if(keyArray[i].equals(key)) {
				valueArray[i] = value;
				return;
			}
		}
		if(size<keyArray.length) {
			keyArray[size]=key;
			valueArray[size]=value;
			size++;
		}
	}
	public String delete(String key) {
		for(int i=0; i<size; i++) {
			if(keyArray[i].equals(key)) {
				String deletedValue = valueArray[i];
				for(int j = i; j<size-1; j++) {
					keyArray[j] = keyArray[j+1];
					valueArray[j] = valueArray[j+1];
				}
				size--;
				return deletedValue;
			}
		}
		return null;
	}
	public int length() {
		return size;
	}
}

public class Exam_12 {
	public static void main(String[] args) {
		Dictionary dic = new Dictionary(10);
		dic.put("황기태", "자바");
		dic.put("이재문", "파이선");
		dic.put("이재문", "C++");
		System.out.println("이재문의 값은 "+dic.get("이재문"));
		System.out.println("황기태의 값은 "+dic.get("황기태"));
		dic.delete("황기태");
		System.out.println("황기태의 값은 " + dic.get("황기태"));
	}
}
