package class11_27;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

// 1. 회원가입
class SignUpDialog extends JDialog {
    JTextField id=new JTextField(), name=new JTextField(), cls=new JTextField(), pw=new JTextField();
    JComboBox<String> role=new JComboBox<>(new String[]{"교사","학생"});
    
    public SignUpDialog(Frame owner) {
        super(owner, "사용자 등록", true); setSize(300,350); setLocationRelativeTo(owner);
        setLayout(new GridLayout(6,2,5,5));
        add(new JLabel("역할:")); add(role); add(new JLabel("ID:")); add(id);
        add(new JLabel("이름:")); add(name); add(new JLabel("반(3-1):")); add(cls);
        add(new JLabel("PW:")); add(pw); JButton b = new JButton("등록"); add(new JLabel("")); add(b);
        b.addActionListener(e->reg());
    }
    void reg() {
        try(Connection c=ManageProgram.getConnection()) {
            if(role.getSelectedIndex()==0) c.createStatement().executeUpdate(String.format("INSERT INTO Teachers VALUES('%s','%s','%s','%s','TEACHER')", id.getText(),name.getText(),cls.getText(),pw.getText()));
            else {
                String[] p=cls.getText().split("-");
                c.createStatement().executeUpdate(String.format("INSERT INTO Students VALUES('%s','%s',%s,'%s','%s')", id.getText(),name.getText(),p[0],p[1],pw.getText()));
            }
            JOptionPane.showMessageDialog(this,"완료"); dispose();
        } catch(Exception e){ JOptionPane.showMessageDialog(this,"오류: "+e.getMessage()); }
    }
}

// 2. 통계
class StatisticsDialog extends JDialog {
    public StatisticsDialog(Frame owner, String tid, String cls) {
        super(owner, "출석 통계 - "+cls, true); setSize(400,400); setLocationRelativeTo(owner);
        JTextArea area = new JTextArea(); area.setEditable(false); add(new JScrollPane(area));
        try(Connection c=ManageProgram.getConnection()) {
            String sql = "SELECT status, COUNT(*) FROM Attendance WHERE teacher_id='"+tid+"' GROUP BY status";
            ResultSet rs = c.createStatement().executeQuery(sql);
            area.append("== [ "+cls+" 전체 통계 ] ==\n\n");
            int total=0, present=0;
            while(rs.next()) {
                String st=rs.getString(1); int cnt=rs.getInt(2); total+=cnt;
                if("출석".equals(st)) present+=cnt;
                area.append(st + ": " + cnt + "건\n");
            }
            if(total>0) area.append("\n출석률: " + String.format("%.1f%%", (double)present/total*100));
        } catch(Exception e){}
    }
}

// 3. 학생 추가
class StudentAddDialog extends JDialog {
    Runnable callback;
    JTextField id=new JTextField(), name=new JTextField(), pw=new JTextField();
    public StudentAddDialog(Frame owner, String cls, Runnable cb) {
        super(owner, "학생 추가", true); this.callback=cb; setSize(300,250); setLocationRelativeTo(owner);
        setLayout(new GridLayout(4,2));
        add(new JLabel("학번:")); add(id); add(new JLabel("이름:")); add(name);
        add(new JLabel("PW:")); add(pw); JButton b=new JButton("추가"); add(new JLabel("")); add(b);
        b.addActionListener(e->{
            String[] p=cls.split("-");
            try(Connection c=ManageProgram.getConnection()) {
                c.createStatement().executeUpdate(String.format("INSERT INTO Students VALUES('%s','%s',%s,'%s','%s')", id.getText(),name.getText(),p[0],p[1],pw.getText()));
                JOptionPane.showMessageDialog(this,"추가됨"); callback.run(); dispose();
            } catch(Exception ex){ JOptionPane.showMessageDialog(this,"오류"); }
        });
    }
}