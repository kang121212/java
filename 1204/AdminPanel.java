package class11_27;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.sql.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AdminPanel extends JPanel {
    private MainFrame mainFrame;
    private DefaultTableModel tModel, sModel;
    
    public AdminPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());
        
        JPanel header = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        header.setBackground(new Color(240, 240, 240));
        JButton logoutBtn = new JButton("로그아웃");
        header.add(new JLabel("관리자 모드 접속중  ")); header.add(logoutBtn);
        add(header, BorderLayout.NORTH);

        JTabbedPane tabs = new JTabbedPane();
        
        // 교사 탭
        tModel = new DefaultTableModel(new String[]{"ID","이름","반","권한"}, 0);
        tabs.addTab("교사 관리", new JScrollPane(new JTable(tModel)));

        // 학생 탭
        JPanel sPanel = new JPanel(new BorderLayout());
        sModel = new DefaultTableModel(new String[]{"ID","이름","학년","반","PW"}, 0);
        JPanel sTool = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton csvBtn = new JButton("📂 CSV 일괄 등록");
        JButton refreshBtn = new JButton("새로고침");
        csvBtn.setBackground(new Color(255, 250, 200));
        sTool.add(csvBtn); sTool.add(refreshBtn);
        sPanel.add(sTool, BorderLayout.NORTH);
        sPanel.add(new JScrollPane(new JTable(sModel)), BorderLayout.CENTER);
        tabs.addTab("학생 대량 관리", sPanel);

        add(tabs, BorderLayout.CENTER);

        logoutBtn.addActionListener(e -> mainFrame.showLogin());
        refreshBtn.addActionListener(e -> refreshData());
        csvBtn.addActionListener(e -> importCSV());
    }

    public void refreshData() {
        tModel.setRowCount(0); sModel.setRowCount(0);
        try(Connection c = ManageProgram.getConnection()) {
            ResultSet rs1 = c.createStatement().executeQuery("SELECT * FROM Teachers");
            while(rs1.next()) tModel.addRow(new Object[]{rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(5)});
            ResultSet rs2 = c.createStatement().executeQuery("SELECT * FROM Students ORDER BY grade, class");
            while(rs2.next()) sModel.addRow(new Object[]{rs2.getString(1), rs2.getString(2), rs2.getInt(3), rs2.getString(4), rs2.getString(5)});
        } catch(Exception e) {}
    }

    private void importCSV() {
        JFileChooser ch = new JFileChooser();
        ch.setFileFilter(new FileNameExtensionFilter("CSV", "csv"));
        if(ch.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File f = ch.getSelectedFile();
            try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f), "MS949"));
                Connection c = ManageProgram.getConnection()) {
                c.setAutoCommit(false);
                PreparedStatement ps = c.prepareStatement("INSERT OR IGNORE INTO Students VALUES(?,?,?,?,?)");
                String line; boolean header=true; int cnt=0;
                while((line=br.readLine())!=null) {
                    if(header) { header=false; continue; }
                    String[] d = line.split(",");
                    if(d.length<4) continue;
                    ps.setString(1, d[0].trim()); ps.setString(2, d[1].trim());
                    ps.setInt(3, Integer.parseInt(d[2].trim())); ps.setString(4, d[3].trim());
                    ps.setString(5, d.length>4?d[4].trim():d[0].trim());
                    ps.addBatch(); cnt++;
                }
                ps.executeBatch(); c.commit();
                JOptionPane.showMessageDialog(this, cnt+"명 등록 완료"); refreshData();
            } catch(Exception e) { JOptionPane.showMessageDialog(this, "오류: "+e.getMessage()); }
        }
    }
}