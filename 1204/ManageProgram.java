package class11_27;

import java.sql.*;
import java.time.LocalDate;
import java.util.Random;

public class ManageProgram {
    private static final String DB_URL = "jdbc:sqlite:attendance.db";

    static {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement st = conn.createStatement()) {

            // 테이블 생성 (기존과 동일)
            st.execute("CREATE TABLE IF NOT EXISTS Teachers (" +
                       "teacher_id TEXT PRIMARY KEY, name TEXT, class_assigned TEXT, auth_key TEXT, role TEXT)");
            
            st.execute("CREATE TABLE IF NOT EXISTS Students (" +
                       "student_id TEXT PRIMARY KEY, name TEXT, grade INTEGER, class TEXT, auth_key TEXT)");
            
            st.execute("CREATE TABLE IF NOT EXISTS Attendance (" +
                       "attendance_id INTEGER PRIMARY KEY AUTOINCREMENT, student_id TEXT, teacher_id TEXT, date TEXT, period INTEGER, status TEXT)");

        } catch (SQLException e) { e.printStackTrace(); }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    // [PPT용] 풍성한 데이터 자동 생성
    public static void seedSampleData() {
        try (Connection conn = getConnection()) {
            conn.setAutoCommit(false);

            // 1. 기존 데이터 초기화 (중복 방지)
            Statement st = conn.createStatement();
            st.execute("DELETE FROM Teachers");
            st.execute("DELETE FROM Students");
            st.execute("DELETE FROM Attendance");

            // 2. 선생님 & 관리자 데이터
            try (PreparedStatement t = conn.prepareStatement("INSERT INTO Teachers VALUES (?,?,?,?,?)")) {
                // 관리자
                t.setString(1, "ADMIN"); t.setString(2, "관리자"); t.setString(3, "0-0"); t.setString(4, "admin1234"); t.setString(5, "ADMIN"); t.addBatch();
                // 3학년 1반 김선생님
                t.setString(1, "T001"); t.setString(2, "김선생님"); t.setString(3, "3-1"); t.setString(4, "KEY-1234"); t.setString(5, "TEACHER"); t.addBatch();
                // 3학년 2반 박선생님 (비교용)
                t.setString(1, "T002"); t.setString(2, "박선생님"); t.setString(3, "3-2"); t.setString(4, "KEY-5678"); t.setString(5, "TEACHER"); t.addBatch();
                t.executeBatch();
            }

            // 3. 학생 데이터 (50명 생성)
            String[] firstNames = {"김", "이", "박", "최", "정", "강", "조", "윤", "장", "임", "한", "오", "서", "신", "권", "황", "안", "송", "전", "홍"};
            String[] lastNames = {"민수", "서현", "지훈", "서연", "현우", "지우", "준호", "유진", "승우", "수빈", "동현", "하은", "준영", "다은", "우진"};
            
            Random random = new Random();
            try (PreparedStatement s = conn.prepareStatement("INSERT INTO Students VALUES (?,?,?,?,?)")) {
                // 3-1반 학생 25명
                for (int i = 1; i <= 25; i++) {
                    String name = firstNames[random.nextInt(firstNames.length)] + lastNames[random.nextInt(lastNames.length)];
                    String sid = String.format("S31%02d", i); // S3101 ~ S3125
                    s.setString(1, sid); s.setString(2, name); s.setInt(3, 3); s.setString(4, "1"); s.setString(5, sid);
                    s.addBatch();
                }
                // 3-2반 학생 25명
                for (int i = 1; i <= 25; i++) {
                    String name = firstNames[random.nextInt(firstNames.length)] + lastNames[random.nextInt(lastNames.length)];
                    String sid = String.format("S32%02d", i); // S3201 ~ S3225
                    s.setString(1, sid); s.setString(2, name); s.setInt(3, 3); s.setString(4, "2"); s.setString(5, sid);
                    s.addBatch();
                }
                s.executeBatch();
            }

            // 4. 출석 기록 데이터 (최근 7일치 자동 생성)
            // PPT에서 그래프가 예쁘게 나오도록 다양한 상태(출석, 지각, 결석)를 섞어서 넣습니다.
            LocalDate today = LocalDate.now();
            String[] statuses = {"출석", "출석", "출석", "출석", "출석", "출석", "출석", "지각", "결석", "조퇴"}; // 출석 확률 높게
            
            try (PreparedStatement a = conn.prepareStatement("INSERT INTO Attendance (student_id, teacher_id, date, period, status) VALUES (?,?,?,?,?)")) {
                // 지난 7일간의 기록
                for (int day = 0; day < 7; day++) {
                    String date = today.minusDays(day).toString();
                    
                    // 3-1반 기록 (김선생님 T001)
                    for (int i = 1; i <= 25; i++) {
                        String sid = String.format("S31%02d", i);
                        String status = statuses[random.nextInt(statuses.length)];
                        
                        a.setString(1, sid); a.setString(2, "T001"); a.setString(3, date); a.setInt(4, 1); a.setString(5, status);
                        a.addBatch();
                    }
                    
                    // 3-2반 기록 (박선생님 T002)
                    for (int i = 1; i <= 25; i++) {
                        String sid = String.format("S32%02d", i);
                        String status = statuses[random.nextInt(statuses.length)];
                        
                        a.setString(1, sid); a.setString(2, "T002"); a.setString(3, date); a.setInt(4, 1); a.setString(5, status);
                        a.addBatch();
                    }
                }
                a.executeBatch();
            }

            conn.commit();
            System.out.println("✅ PPT용 샘플 데이터 생성 완료 (학생 50명 + 1주일치 출석기록)");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}