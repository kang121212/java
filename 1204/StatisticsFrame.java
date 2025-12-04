package class11_27;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class StatisticsFrame extends JFrame {
    private String teacherId, classAssigned;

    public StatisticsFrame(String teacherId, String classAssigned) {
        super("우리 반 출석 통계 (" + classAssigned + ")");
        this.teacherId = teacherId;
        this.classAssigned = classAssigned;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 450);
        setLocationRelativeTo(null);

        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());

        JTabbedPane tab = new JTabbedPane();
        
        // 탭 1: 결석 랭킹
        JPanel rankPanel = new JPanel(new BorderLayout());
        DefaultTableModel rankModel = new DefaultTableModel(new Object[]{"순위", "이름", "결석 횟수"}, 0);
        JTable rankTable = new JTable(rankModel);
        rankPanel.add(new JScrollPane(rankTable), BorderLayout.CENTER);
        
        // 탭 2: 전체 요약
        JPanel summaryPanel = new JPanel(new GridLayout(4, 1));
        JLabel lblTotal = new JLabel("총 수업 횟수: -", SwingConstants.CENTER);
        JLabel lblPresent = new JLabel("평균 출석률: -", SwingConstants.CENTER);
        summaryPanel.add(lblTotal);
        summaryPanel.add(lblPresent);

        tab.addTab("결석 랭킹", rankPanel);
        tab.addTab("전체 요약", summaryPanel);
        add(tab, BorderLayout.CENTER);

        // 데이터 로드
        loadStats(rankModel, lblTotal, lblPresent);
    }

    private void loadStats(DefaultTableModel rankModel, JLabel lblTotal, JLabel lblPresent) {
        try (Connection conn = ManageProgram.getConnection()) {
            // 1. 결석 랭킹 (결석이 많은 학생 순)
            String sqlRank = 
                "SELECT S.name, COUNT(*) as cnt " +
                "FROM Attendance A JOIN Students S ON A.student_id = S.student_id " +
                "WHERE A.teacher_id=? AND A.status='결석' " +
                "GROUP BY A.student_id " +
                "ORDER BY cnt DESC";
            
            try (PreparedStatement ps = conn.prepareStatement(sqlRank)) {
                ps.setString(1, teacherId);
                try (ResultSet rs = ps.executeQuery()) {
                    int rank = 1;
                    while (rs.next()) {
                        rankModel.addRow(new Object[]{rank++, rs.getString("name"), rs.getInt("cnt") + "회"});
                    }
                }
            }
            if (rankModel.getRowCount() == 0) {
                rankModel.addRow(new Object[]{"-", "결석생 없음", "-"});
            }

            // 2. 전체 통계
            // 총 기록 수
            int totalRecords = 0;
            int presentCount = 0;
            String sqlCount = "SELECT status, COUNT(*) FROM Attendance WHERE teacher_id=? GROUP BY status";
            try (PreparedStatement ps = conn.prepareStatement(sqlCount)) {
                ps.setString(1, teacherId);
                try (ResultSet rs = ps.executeQuery()) {
                    while(rs.next()) {
                        int cnt = rs.getInt(2);
                        totalRecords += cnt;
                        if(rs.getString(1).equals("출석")) presentCount += cnt;
                    }
                }
            }

            lblTotal.setText("총 출석 체크(학생*교시) 누적: " + totalRecords + "건");
            if (totalRecords > 0) {
                double rate = (double) presentCount / totalRecords * 100.0;
                lblPresent.setText(String.format("우리 반 전체 출석률: %.1f%%", rate));
                lblPresent.setForeground(rate >= 90 ? Color.BLUE : Color.RED);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}