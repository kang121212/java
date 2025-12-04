package class11_27;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import java.util.List;

public class AttendanceFrame extends JFrame {
    private String teacherId, teacherName, classAssigned;
    private JComboBox<String> dateBox;
    private JComboBox<Integer> periodBox;
    private JTable table;
    private DefaultTableModel model;
    private Map<String, String> statusMap = new HashMap<>();

    public AttendanceFrame(String teacherId, String teacherName, String classAssigned) {
        super("출석부 - " + classAssigned + " (" + teacherName + " 선생님)");
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.classAssigned = classAssigned;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        initUI();
        loadStudentsAndAttendance();
    }

    private void initUI() {
        setLayout(new BorderLayout());

        // --- 상단 (날짜/교시) ---
        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        LocalDate today = LocalDate.now();
        dateBox = new JComboBox<>(new String[]{ today.toString(), today.minusDays(1).toString(), today.minusDays(2).toString() });
        periodBox = new JComboBox<>(new Integer[]{1,2,3,4,5,6,7,8});
        
        top.add(new JLabel("날짜:")); top.add(dateBox);
        top.add(new JLabel("교시:")); top.add(periodBox);
        add(top, BorderLayout.NORTH);

        dateBox.addActionListener(e -> loadStudentsAndAttendance());
        periodBox.addActionListener(e -> loadStudentsAndAttendance());

        // --- 중앙 (테이블) ---
        model = new DefaultTableModel(new Object[]{"ID", "이름", "상태"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        table = new JTable(model);
        table.setRowHeight(30);
        table.setFont(new Font("SansSerif", Font.PLAIN, 14));
        add(new JScrollPane(table), BorderLayout.CENTER);

        // --- 우측 (기능 버튼들) ---
        // 버튼이 늘어나서 GridLayout 행 개수를 9로 늘림
        JPanel right = new JPanel(new GridLayout(9,1,10,10)); 
        right.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JButton manageBtn = new JButton("학생 관리");
        JButton statsBtn = new JButton("통계 보기");
        
        JButton allPresentBtn = new JButton("▶ 전원 출석"); // [NEW] 전원 출석 버튼
        
        JButton presentBtn = new JButton("출석");
        JButton lateBtn = new JButton("지각");
        JButton absentBtn = new JButton("결석");
        JButton earlyBtn = new JButton("조퇴");
        JButton clearBtn = new JButton("초기화");

        // 버튼 색상 꾸미기
        manageBtn.setBackground(new Color(220, 230, 255));
        statsBtn.setBackground(new Color(255, 240, 220));
        allPresentBtn.setBackground(new Color(200, 255, 200)); // 초록색 계열로 강조
        allPresentBtn.setFont(new Font("SansSerif", Font.BOLD, 12));

        right.add(manageBtn);
        right.add(statsBtn);
        right.add(new JSeparator()); // 구분선
        right.add(allPresentBtn);    // [NEW] 여기에 추가
        right.add(presentBtn);
        right.add(lateBtn);
        right.add(absentBtn);
        right.add(earlyBtn);
        right.add(clearBtn);

        // 버튼 이벤트 연결
        allPresentBtn.addActionListener(e -> setAllStatus("출석")); // [NEW] 기능 연결

        centerPanelButtons(right, manageBtn, statsBtn, presentBtn, lateBtn, absentBtn, earlyBtn, clearBtn);
        add(right, BorderLayout.EAST);

        // --- 하단 (저장/엑셀/수정) ---
        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton saveButton = new JButton("저장하기");
        JButton excelButton = new JButton("엑셀로 저장");
        JButton editButton = new JButton("기록 조회/수정");

        saveButton.setPreferredSize(new Dimension(120, 40));
        saveButton.setBackground(new Color(200, 255, 200));

        bottom.add(excelButton);
        bottom.add(editButton);
        bottom.add(saveButton);
        add(bottom, BorderLayout.SOUTH);

        // --- 하단 이벤트 연결 ---
        manageBtn.addActionListener(e -> {
            StudentManageFrame f = new StudentManageFrame(classAssigned);
            f.addWindowListener(new WindowAdapter() {
                public void windowClosed(WindowEvent e) { loadStudentsAndAttendance(); }
            });
            f.setVisible(true);
        });

        statsBtn.addActionListener(e -> new StatisticsFrame(teacherId, classAssigned).setVisible(true));
        excelButton.addActionListener(e -> exportToCSV());
        saveButton.addActionListener(e -> saveAttendance());
        editButton.addActionListener(e -> new AttendanceEditFrame(teacherId).setVisible(true));
    }

    // [NEW] 모든 학생의 상태를 일괄 변경하는 메서드
    private void setAllStatus(String status) {
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(status, i, 2); // 테이블 UI 업데이트
        }
    }

    // 선택된 행들만 상태 변경 (기존 기능)
    private void changeStatus(String st) {
        int[] rows = table.getSelectedRows();
        if (rows.length == 0) {
            JOptionPane.showMessageDialog(this, "학생을 선택하세요.");
            return;
        }
        for(int r : rows) model.setValueAt(st, r, 2);
    }
    
    // 버튼 리스너 연결 도우미 (단순화)
    private void centerPanelButtons(JPanel p, JButton... btns) {
        for(JButton b : btns) {
            String txt = b.getText();
            if(txt.equals("출석")) b.addActionListener(e->changeStatus("출석"));
            else if(txt.equals("지각")) b.addActionListener(e->changeStatus("지각"));
            else if(txt.equals("결석")) b.addActionListener(e->changeStatus("결석"));
            else if(txt.equals("조퇴")) b.addActionListener(e->changeStatus("조퇴"));
            else if(txt.equals("초기화")) b.addActionListener(e->changeStatus(""));
        }
    }

    // 엑셀(CSV) 저장 기능
    private void exportToCSV() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("엑셀(CSV) 파일로 저장");
        fileChooser.setSelectedFile(new File("출석부_" + LocalDate.now() + ".csv"));
        
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "MS949"))) {
                bw.write("날짜,교시,학번,이름,상태\n");
                try (Connection conn = ManageProgram.getConnection();
                     PreparedStatement ps = conn.prepareStatement(
                         "SELECT A.date, A.period, S.student_id, S.name, A.status " +
                         "FROM Attendance A JOIN Students S ON A.student_id = S.student_id " +
                         "WHERE A.teacher_id = ? ORDER BY A.date DESC, A.period ASC, S.student_id ASC")) {
                    ps.setString(1, teacherId);
                    try (ResultSet rs = ps.executeQuery()) {
                        while(rs.next()) {
                            String line = String.format("%s,%d,%s,%s,%s", 
                                rs.getString("date"), rs.getInt("period"),
                                rs.getString("student_id"), rs.getString("name"), rs.getString("status"));
                            bw.write(line + "\n");
                        }
                    }
                }
                JOptionPane.showMessageDialog(this, "파일 저장 완료!\n" + file.getAbsolutePath());
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "파일 저장 실패: " + ex.getMessage());
            }
        }
    }

    private void loadStudentsAndAttendance() {
        model.setRowCount(0);
        statusMap.clear();
        String date = (String) dateBox.getSelectedItem();
        int period = (Integer) periodBox.getSelectedItem();
        
        String[] parts = classAssigned.split("-");
        int grade = Integer.parseInt(parts[0]);
        String clazz = parts[1];

        try (Connection conn = ManageProgram.getConnection()) {
            List<String[]> students = new ArrayList<>();
            try(PreparedStatement ps = conn.prepareStatement("SELECT student_id, name FROM Students WHERE grade=? AND class=? ORDER BY student_id")) {
                ps.setInt(1, grade); ps.setString(2, clazz);
                try(ResultSet rs = ps.executeQuery()) {
                    while(rs.next()) students.add(new String[]{rs.getString(1), rs.getString(2)});
                }
            }
            Map<String, String> saved = new HashMap<>();
            try(PreparedStatement ps = conn.prepareStatement("SELECT student_id, status FROM Attendance WHERE teacher_id=? AND date=? AND period=?")) {
                ps.setString(1, teacherId); ps.setString(2, date); ps.setInt(3, period);
                try(ResultSet rs = ps.executeQuery()) {
                    while(rs.next()) saved.put(rs.getString(1), rs.getString(2));
                }
            }
            for(String[] s : students) {
                String status = saved.getOrDefault(s[0], "");
                model.addRow(new Object[]{s[0], s[1], status});
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }

    private void saveAttendance() {
        String date = (String) dateBox.getSelectedItem();
        int period = (Integer) periodBox.getSelectedItem();
        try (Connection conn = ManageProgram.getConnection()) {
            conn.setAutoCommit(false);
            try {
                try(PreparedStatement ps = conn.prepareStatement("DELETE FROM Attendance WHERE teacher_id=? AND date=? AND period=?")) {
                    ps.setString(1, teacherId); ps.setString(2, date); ps.setInt(3, period);
                    ps.executeUpdate();
                }
                try(PreparedStatement ps = conn.prepareStatement("INSERT INTO Attendance (student_id, teacher_id, date, period, status) VALUES (?,?,?,?,?)")) {
                    for(int i=0; i<model.getRowCount(); i++) {
                        String st = (String) model.getValueAt(i, 2);
                        if(st==null || st.isBlank()) continue;
                        ps.setString(1, (String)model.getValueAt(i, 0));
                        ps.setString(2, teacherId);
                        ps.setString(3, date);
                        ps.setInt(4, period);
                        ps.setString(5, st);
                        ps.addBatch();
                    }
                    ps.executeBatch();
                }
                conn.commit();
                JOptionPane.showMessageDialog(this, "저장 완료!");
            } catch(SQLException e) { conn.rollback(); throw e; }
            finally { conn.setAutoCommit(true); }
        } catch (SQLException e) { e.printStackTrace(); JOptionPane.showMessageDialog(this, "오류: "+e.getMessage()); }
    }
}