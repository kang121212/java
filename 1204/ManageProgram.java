package class11_27;

import java.sql.*;

public class ManageProgram {
    private static final String DB_URL = "jdbc:sqlite:attendance.db";

    static {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement st = conn.createStatement()) {

            // 1. 교사 테이블
            st.execute("CREATE TABLE IF NOT EXISTS Teachers (" +
                       "teacher_id TEXT PRIMARY KEY," +
                       "name TEXT NOT NULL," +
                       "class_assigned TEXT NOT NULL," +
                       "auth_key TEXT NOT NULL" +
                       ");");

            // 2. 학생 테이블
            st.execute("CREATE TABLE IF NOT EXISTS Students (" +
                       "student_id TEXT PRIMARY KEY," +
                       "name TEXT NOT NULL," +
                       "grade INTEGER NOT NULL," +
                       "class TEXT NOT NULL" +
                       ");");

            // 3. 출석 테이블
            st.execute("CREATE TABLE IF NOT EXISTS Attendance (" +
                       "attendance_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                       "student_id TEXT NOT NULL," +
                       "teacher_id TEXT NOT NULL," +
                       "date TEXT NOT NULL," +
                       "period INTEGER NOT NULL," +
                       "status TEXT NOT NULL" +
                       ");");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    public static void seedSampleData() {
        try (Connection conn = getConnection()) {
            conn.setAutoCommit(false);
            try (PreparedStatement t = conn.prepareStatement(
                    "INSERT OR IGNORE INTO Teachers VALUES (?, ?, ?, ?)");
                 PreparedStatement s = conn.prepareStatement(
                    "INSERT OR IGNORE INTO Students VALUES (?, ?, ?, ?)")) {

                // 기본 교사 (ID: T001)
                t.setString(1, "T001");
                t.setString(2, "김선생님");
                t.setString(3, "3-1");
                t.setString(4, "KEY-1234");
                t.executeUpdate();

                // 기본 학생들
                String[][] students = {
                    {"S1001","이민수","3","1"}, {"S1002","최선아","3","1"},
                    {"S1003","박지훈","3","1"}, {"S1004","한유진","3","1"}
                };
                for (String[] stRow : students) {
                    s.setString(1, stRow[0]); s.setString(2, stRow[1]);
                    s.setInt(3, Integer.parseInt(stRow[2])); s.setString(4, stRow[3]);
                    s.executeUpdate();
                }
                conn.commit();
            } catch (SQLException ex) {
                conn.rollback();
            } finally {
                conn.setAutoCommit(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}