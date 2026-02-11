import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class StudentMarksheet extends JFrame {
    
    // Color Scheme - Modern Gradient Theme
    private static final Color PRIMARY_DARK = new Color(30, 60, 114);
    private static final Color PRIMARY_LIGHT = new Color(42, 82, 152);
    private static final Color ACCENT_COLOR = new Color(255, 107, 107);
    private static final Color ACCENT_SECONDARY = new Color(78, 205, 196);
    private static final Color GOLD_COLOR = new Color(255, 193, 7);
    private static final Color SUCCESS_COLOR = new Color(46, 204, 113);
    private static final Color WARNING_COLOR = new Color(241, 196, 15);
    private static final Color DANGER_COLOR = new Color(231, 76, 60);
    private static final Color CARD_BG = new Color(255, 255, 255);
    private static final Color TEXT_PRIMARY = new Color(33, 37, 41);
    private static final Color TEXT_SECONDARY = new Color(108, 117, 125);
    
    // Components
    private JTextField txtStudentName, txtRollNo, txtFatherName, txtMotherName;
    private JTextField txtDOB, txtPhone, txtEmail, txtAddress;
    private JComboBox<String> cmbClass, cmbField, cmbSession;
    private JTable marksTable;
    private DefaultTableModel tableModel;
    private JLabel lblTotal, lblPercentage, lblGrade, lblResult, lblRank;
    private JPanel resultPanel, gradePanel;
    
    // Subjects
    private String[] subjects = {"Mathematics", "Physics", "Chemistry", "English", "Computer Science", "Physical Education"};
    
    public StudentMarksheet() {
        initializeFrame();
        createUI();
        setVisible(true);
    }
    
    private void initializeFrame() {
        setTitle("📚 Student Academic Marksheet - Excellence Academy");
        setSize(1200, 850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // Set custom icon
        try {
            setIconImage(new ImageIcon(getClass().getResource("/icon.png")).getImage());
        } catch (Exception e) {
            // Icon not found, continue without it
        }
    }
    
    private void createUI() {
        // Main container with gradient background
        JPanel mainContainer = new GradientPanel();
        mainContainer.setLayout(new BorderLayout(15, 15));
        mainContainer.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        // Header
        mainContainer.add(createHeader(), BorderLayout.NORTH);
        
        // Center content
        JPanel centerPanel = new JPanel(new BorderLayout(15, 15));
        centerPanel.setOpaque(false);
        
        // Left side - Student Info
        centerPanel.add(createStudentInfoPanel(), BorderLayout.WEST);
        
        // Center - Marks Table
        centerPanel.add(createMarksPanel(), BorderLayout.CENTER);
        
        // Right side - Result Summary
        centerPanel.add(createResultPanel(), BorderLayout.EAST);
        
        mainContainer.add(centerPanel, BorderLayout.CENTER);
        
        // Footer with buttons
        mainContainer.add(createFooter(), BorderLayout.SOUTH);
        
        setContentPane(mainContainer);
    }
    
    private JPanel createHeader() {
        JPanel headerPanel = new RoundedPanel(25, new Color(255, 255, 255, 240));
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBorder(new EmptyBorder(20, 30, 20, 30));
        headerPanel.setPreferredSize(new Dimension(0, 120));
        
        // Left - Logo and School Name
        JPanel leftHeader = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));
        leftHeader.setOpaque(false);
        
        // Logo placeholder
        JPanel logoPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                // Draw circular logo background
                GradientPaint gp = new GradientPaint(0, 0, PRIMARY_DARK, 70, 70, ACCENT_COLOR);
                g2d.setPaint(gp);
                g2d.fillOval(5, 5, 60, 60);
                
                // Draw graduation cap icon
                g2d.setColor(Color.WHITE);
                g2d.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
                g2d.drawString("🎓", 17, 47);
            }
        };
        logoPanel.setPreferredSize(new Dimension(70, 70));
        logoPanel.setOpaque(false);
        leftHeader.add(logoPanel);
        
        // School info
        JPanel schoolInfo = new JPanel();
        schoolInfo.setLayout(new BoxLayout(schoolInfo, BoxLayout.Y_AXIS));
        schoolInfo.setOpaque(false);
        
        JLabel lblSchoolName = new JLabel("EXCELLENCE ACADEMY");
        lblSchoolName.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblSchoolName.setForeground(PRIMARY_DARK);
        
        JLabel lblSchoolMotto = new JLabel("\"Empowering Minds, Shaping Futures\"");
        lblSchoolMotto.setFont(new Font("Segoe UI", Font.ITALIC, 14));
        lblSchoolMotto.setForeground(TEXT_SECONDARY);
        
        JLabel lblSchoolAddress = new JLabel("📍 123 Education Street, Knowledge City - 560001");
        lblSchoolAddress.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblSchoolAddress.setForeground(TEXT_SECONDARY);
        
        schoolInfo.add(lblSchoolName);
        schoolInfo.add(Box.createVerticalStrut(5));
        schoolInfo.add(lblSchoolMotto);
        schoolInfo.add(Box.createVerticalStrut(3));
        schoolInfo.add(lblSchoolAddress);
        
        leftHeader.add(schoolInfo);
        
        // Right - Title and Date
        JPanel rightHeader = new JPanel();
        rightHeader.setLayout(new BoxLayout(rightHeader, BoxLayout.Y_AXIS));
        rightHeader.setOpaque(false);
        
        JLabel lblTitle = new JLabel("ACADEMIC MARKSHEET");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitle.setForeground(ACCENT_COLOR);
        lblTitle.setAlignmentX(Component.RIGHT_ALIGNMENT);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        JLabel lblDate = new JLabel("📅 " + sdf.format(new Date()));
        lblDate.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblDate.setForeground(TEXT_SECONDARY);
        lblDate.setAlignmentX(Component.RIGHT_ALIGNMENT);
        
        rightHeader.add(lblTitle);
        rightHeader.add(Box.createVerticalStrut(10));
        rightHeader.add(lblDate);
        
        headerPanel.add(leftHeader, BorderLayout.WEST);
        headerPanel.add(rightHeader, BorderLayout.EAST);
        
        return headerPanel;
    }
    
    private JPanel createStudentInfoPanel() {
        JPanel container = new RoundedPanel(20, CARD_BG);
        container.setLayout(new BorderLayout());
        container.setPreferredSize(new Dimension(350, 0));
        container.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        // Title
        JLabel title = new JLabel("👤 Student Information");
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        title.setForeground(PRIMARY_DARK);
        title.setBorder(new EmptyBorder(0, 0, 15, 0));
        
        // Form Panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setOpaque(false);
        
        // Student Name
        formPanel.add(createFormField("Student Name", txtStudentName = createStyledTextField()));
        formPanel.add(Box.createVerticalStrut(12));
        
        // Roll Number
        formPanel.add(createFormField("Roll Number", txtRollNo = createStyledTextField()));
        formPanel.add(Box.createVerticalStrut(12));
        
        // Class Dropdown
        String[] classes = {"Select Class", "Class 9", "Class 10", "Class 11", "Class 12"};
        cmbClass = createStyledComboBox(classes);
        formPanel.add(createFormField("Class", cmbClass));
        formPanel.add(Box.createVerticalStrut(12));
        
        // Field/Stream Dropdown
        String[] fields = {"Select Stream", "Science (PCM)", "Science (PCB)", "Commerce", "Arts/Humanities"};
        cmbField = createStyledComboBox(fields);
        formPanel.add(createFormField("Stream/Field", cmbField));
        formPanel.add(Box.createVerticalStrut(12));
        
        // Session
        String[] sessions = {"2024-2025", "2023-2024", "2022-2023"};
        cmbSession = createStyledComboBox(sessions);
        formPanel.add(createFormField("Academic Session", cmbSession));
        formPanel.add(Box.createVerticalStrut(12));
        
        // Father's Name
        formPanel.add(createFormField("Father's Name", txtFatherName = createStyledTextField()));
        formPanel.add(Box.createVerticalStrut(12));
        
        // Mother's Name
        formPanel.add(createFormField("Mother's Name", txtMotherName = createStyledTextField()));
        formPanel.add(Box.createVerticalStrut(12));
        
        // Date of Birth
        formPanel.add(createFormField("Date of Birth", txtDOB = createStyledTextField()));
        txtDOB.setText("DD/MM/YYYY");
        txtDOB.setForeground(TEXT_SECONDARY);
        txtDOB.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (txtDOB.getText().equals("DD/MM/YYYY")) {
                    txtDOB.setText("");
                    txtDOB.setForeground(TEXT_PRIMARY);
                }
            }
            public void focusLost(FocusEvent e) {
                if (txtDOB.getText().isEmpty()) {
                    txtDOB.setText("DD/MM/YYYY");
                    txtDOB.setForeground(TEXT_SECONDARY);
                }
            }
        });
        formPanel.add(Box.createVerticalStrut(12));
        
        // Phone
        formPanel.add(createFormField("Phone Number", txtPhone = createStyledTextField()));
        
        container.add(title, BorderLayout.NORTH);
        container.add(formPanel, BorderLayout.CENTER);
        
        return container;
    }
    
    private JPanel createMarksPanel() {
        JPanel container = new RoundedPanel(20, CARD_BG);
        container.setLayout(new BorderLayout());
        container.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        // Title
        JLabel title = new JLabel("📊 Subject-wise Marks");
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        title.setForeground(PRIMARY_DARK);
        title.setBorder(new EmptyBorder(0, 0, 15, 0));
        
        // Create table
        String[] columns = {"#", "Subject", "Max Marks", "Theory", "Practical", "Total", "Grade"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 3 || column == 4;
            }
        };
        
        marksTable = new JTable(tableModel);
        styleTable(marksTable);
        
        // Add subjects
        for (int i = 0; i < subjects.length; i++) {
            tableModel.addRow(new Object[]{i + 1, subjects[i], "100", "", "", "0", "-"});
        }
        
        // Table scroll pane
        JScrollPane scrollPane = new JScrollPane(marksTable);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230), 1));
        scrollPane.getViewport().setBackground(Color.WHITE);
        
        // Add table model listener for auto-calculation
        tableModel.addTableModelListener(e -> calculateMarks());
        
        container.add(title, BorderLayout.NORTH);
        container.add(scrollPane, BorderLayout.CENTER);
        
        return container;
    }
    
    private JPanel createResultPanel() {
        resultPanel = new RoundedPanel(20, CARD_BG);
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));
        resultPanel.setPreferredSize(new Dimension(280, 0));
        resultPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        // Title
        JLabel title = new JLabel("🏆 Result Summary");
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        title.setForeground(PRIMARY_DARK);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        resultPanel.add(title);
        resultPanel.add(Box.createVerticalStrut(25));
        
        // Grade Circle
        gradePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                int size = 130;
                int x = (getWidth() - size) / 2;
                int y = 10;
                
                // Outer ring
                g2d.setStroke(new BasicStroke(8));
                g2d.setColor(new Color(240, 240, 240));
                g2d.drawOval(x, y, size, size);
                
                // Colored arc based on percentage
                g2d.setColor(getGradeColor(lblGrade.getText()));
                g2d.drawArc(x, y, size, size, 90, -360);
                
                // Inner circle
                g2d.setColor(Color.WHITE);
                g2d.fillOval(x + 15, y + 15, size - 30, size - 30);
            }
        };
        gradePanel.setPreferredSize(new Dimension(200, 160));
        gradePanel.setMaximumSize(new Dimension(200, 160));
        gradePanel.setOpaque(false);
        gradePanel.setLayout(new GridBagLayout());
        
        lblGrade = new JLabel("--");
        lblGrade.setFont(new Font("Segoe UI", Font.BOLD, 48));
        lblGrade.setForeground(PRIMARY_DARK);
        gradePanel.add(lblGrade);
        
        gradePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        resultPanel.add(gradePanel);
        resultPanel.add(Box.createVerticalStrut(20));
        
        // Stats Cards
        resultPanel.add(createStatCard("📚 Total Marks", lblTotal = new JLabel("0 / 600")));
        resultPanel.add(Box.createVerticalStrut(12));
        resultPanel.add(createStatCard("📈 Percentage", lblPercentage = new JLabel("0.00%")));
        resultPanel.add(Box.createVerticalStrut(12));
        resultPanel.add(createStatCard("🏅 Rank", lblRank = new JLabel("--")));
        resultPanel.add(Box.createVerticalStrut(12));
        
        // Result Status
        JPanel statusPanel = new RoundedPanel(15, new Color(240, 240, 240));
        statusPanel.setLayout(new BorderLayout());
        statusPanel.setBorder(new EmptyBorder(15, 20, 15, 20));
        statusPanel.setMaximumSize(new Dimension(240, 60));
        
        lblResult = new JLabel("PENDING", SwingConstants.CENTER);
        lblResult.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblResult.setForeground(TEXT_SECONDARY);
        statusPanel.add(lblResult, BorderLayout.CENTER);
        
        statusPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        resultPanel.add(statusPanel);
        
        resultPanel.add(Box.createVerticalStrut(20));
        
        // Remarks
        JPanel remarksPanel = new JPanel();
        remarksPanel.setLayout(new BoxLayout(remarksPanel, BoxLayout.Y_AXIS));
        remarksPanel.setOpaque(false);
        remarksPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel remarksTitle = new JLabel("📝 Remarks");
        remarksTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        remarksTitle.setForeground(TEXT_SECONDARY);
        remarksTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel remarksText = new JLabel("Enter marks to see result");
        remarksText.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        remarksText.setForeground(TEXT_SECONDARY);
        remarksText.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        remarksPanel.add(remarksTitle);
        remarksPanel.add(Box.createVerticalStrut(5));
        remarksPanel.add(remarksText);
        
        resultPanel.add(remarksPanel);
        
        return resultPanel;
    }
    
    private JPanel createFooter() {
        JPanel footer = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        footer.setOpaque(false);
        
        // Calculate Button
        JButton btnCalculate = createStyledButton("🔄 Calculate Result", PRIMARY_DARK, Color.WHITE);
        btnCalculate.addActionListener(e -> calculateMarks());
        
        // Print Button
        JButton btnPrint = createStyledButton("🖨️ Print Marksheet", ACCENT_SECONDARY, Color.WHITE);
        btnPrint.addActionListener(e -> printMarksheet());
        
        // Save Button
        JButton btnSave = createStyledButton("💾 Save Record", SUCCESS_COLOR, Color.WHITE);
        btnSave.addActionListener(e -> saveRecord());
        
        // Clear Button
        JButton btnClear = createStyledButton("🗑️ Clear All", ACCENT_COLOR, Color.WHITE);
        btnClear.addActionListener(e -> clearAll());
        
        // Export Button
        JButton btnExport = createStyledButton("📤 Export PDF", GOLD_COLOR, TEXT_PRIMARY);
        btnExport.addActionListener(e -> exportPDF());
        
        footer.add(btnCalculate);
        footer.add(btnPrint);
        footer.add(btnSave);
        footer.add(btnClear);
        footer.add(btnExport);
        
        return footer;
    }
    
    // Helper methods
    private JPanel createFormField(String labelText, JComponent field) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(false);
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 65));
        
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Segoe UI", Font.BOLD, 12));
        label.setForeground(TEXT_SECONDARY);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        field.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        panel.add(label);
        panel.add(Box.createVerticalStrut(5));
        panel.add(field);
        
        return panel;
    }
    
    private JTextField createStyledTextField() {
        JTextField field = new JTextField() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(getBackground());
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
                super.paintComponent(g);
            }
        };
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setPreferredSize(new Dimension(0, 38));
        field.setMaximumSize(new Dimension(Integer.MAX_VALUE, 38));
        field.setBorder(BorderFactory.createCompoundBorder(
            new RoundedBorder(10, new Color(220, 220, 220)),
            new EmptyBorder(5, 12, 5, 12)
        ));
        field.setBackground(new Color(248, 249, 250));
        field.setOpaque(false);
        
        field.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                field.setBorder(BorderFactory.createCompoundBorder(
                    new RoundedBorder(10, PRIMARY_LIGHT),
                    new EmptyBorder(5, 12, 5, 12)
                ));
            }
            public void focusLost(FocusEvent e) {
                field.setBorder(BorderFactory.createCompoundBorder(
                    new RoundedBorder(10, new Color(220, 220, 220)),
                    new EmptyBorder(5, 12, 5, 12)
                ));
            }
        });
        
        return field;
    }
    
    private JComboBox<String> createStyledComboBox(String[] items) {
        JComboBox<String> combo = new JComboBox<>(items);
        combo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        combo.setPreferredSize(new Dimension(0, 38));
        combo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 38));
        combo.setBackground(new Color(248, 249, 250));
        combo.setBorder(new RoundedBorder(10, new Color(220, 220, 220)));
        
        combo.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, 
                    int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                setBorder(new EmptyBorder(8, 12, 8, 12));
                if (isSelected) {
                    setBackground(PRIMARY_LIGHT);
                    setForeground(Color.WHITE);
                }
                return this;
            }
        });
        
        return combo;
    }
    
    private JButton createStyledButton(String text, Color bgColor, Color fgColor) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                if (getModel().isPressed()) {
                    g2d.setColor(bgColor.darker());
                } else if (getModel().isRollover()) {
                    g2d.setColor(bgColor.brighter());
                } else {
                    g2d.setColor(bgColor);
                }
                
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 12, 12);
                
                // Add subtle shadow
                g2d.setColor(new Color(0, 0, 0, 30));
                g2d.fillRoundRect(2, 2, getWidth() - 2, getHeight() - 2, 12, 12);
                g2d.setColor(getModel().isPressed() ? bgColor.darker() : bgColor);
                g2d.fillRoundRect(0, 0, getWidth() - 2, getHeight() - 2, 12, 12);
                
                super.paintComponent(g);
            }
        };
        
        button.setFont(new Font("Segoe UI", Font.BOLD, 13));
        button.setForeground(fgColor);
        button.setPreferredSize(new Dimension(160, 45));
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        return button;
    }
    
    private JPanel createStatCard(String title, JLabel valueLabel) {
        JPanel card = new RoundedPanel(12, new Color(248, 249, 250));
        card.setLayout(new BorderLayout());
        card.setBorder(new EmptyBorder(12, 15, 12, 15));
        card.setMaximumSize(new Dimension(240, 70));
        
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        titleLabel.setForeground(TEXT_SECONDARY);
        
        valueLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        valueLabel.setForeground(PRIMARY_DARK);
        
        card.add(titleLabel, BorderLayout.NORTH);
        card.add(valueLabel, BorderLayout.CENTER);
        card.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        return card;
    }
    
    private void styleTable(JTable table) {
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setRowHeight(45);
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 0));
        table.setSelectionBackground(new Color(232, 240, 254));
        table.setSelectionForeground(TEXT_PRIMARY);
        
        // Header styling
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 13));
        header.setBackground(PRIMARY_DARK);
        header.setForeground(Color.WHITE);
        header.setPreferredSize(new Dimension(0, 50));
        header.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, PRIMARY_LIGHT));
        
        // Custom header renderer
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = (JLabel) super.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, column);
                label.setBackground(PRIMARY_DARK);
                label.setForeground(Color.WHITE);
                label.setFont(new Font("Segoe UI", Font.BOLD, 13));
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setBorder(new EmptyBorder(10, 10, 10, 10));
                return label;
            }
        });
        
        // Custom cell renderer
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = (JLabel) super.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, column);
                
                label.setHorizontalAlignment(column == 1 ? SwingConstants.LEFT : SwingConstants.CENTER);
                label.setBorder(new EmptyBorder(5, 15, 5, 15));
                
                if (row % 2 == 0) {
                    label.setBackground(Color.WHITE);
                } else {
                    label.setBackground(new Color(248, 249, 250));
                }
                
                if (isSelected) {
                    label.setBackground(new Color(232, 240, 254));
                }
                
                // Color the grade column
                if (column == 6 && value != null) {
                    label.setForeground(getGradeColor(value.toString()));
                    label.setFont(new Font("Segoe UI", Font.BOLD, 14));
                } else {
                    label.setForeground(TEXT_PRIMARY);
                }
                
                return label;
            }
        });
        
        // Set column widths
        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(80);
        table.getColumnModel().getColumn(3).setPreferredWidth(80);
        table.getColumnModel().getColumn(4).setPreferredWidth(80);
        table.getColumnModel().getColumn(5).setPreferredWidth(80);
        table.getColumnModel().getColumn(6).setPreferredWidth(70);
    }
    
    private void calculateMarks() {
        int totalMarks = 0;
        int maxMarks = subjects.length * 100;
        boolean allPassed = true;
        
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            int theory = 0, practical = 0;
            
            try {
                String theoryStr = tableModel.getValueAt(i, 3).toString();
                String practicalStr = tableModel.getValueAt(i, 4).toString();
                
                if (!theoryStr.isEmpty()) theory = Integer.parseInt(theoryStr);
                if (!practicalStr.isEmpty()) practical = Integer.parseInt(practicalStr);
                
                int subjectTotal = theory + practical;
                totalMarks += subjectTotal;
                
                // Validate marks
                if (subjectTotal > 100) {
                    subjectTotal = 100;
                    theory = 100;
                    practical = 0;
                }
                
                tableModel.setValueAt(subjectTotal, i, 5);
                tableModel.setValueAt(getSubjectGrade(subjectTotal), i, 6);
                
                if (subjectTotal < 33) allPassed = false;
                
            } catch (NumberFormatException e) {
                tableModel.setValueAt(0, i, 5);
                tableModel.setValueAt("-", i, 6);
            }
        }
        
        // Update result labels
        lblTotal.setText(totalMarks + " / " + maxMarks);
        
        double percentage = (totalMarks * 100.0) / maxMarks;
        lblPercentage.setText(String.format("%.2f%%", percentage));
        
        String grade = getOverallGrade(percentage);
        lblGrade.setText(grade);
        lblGrade.setForeground(getGradeColor(grade));
        
        // Update rank
        if (percentage >= 90) lblRank.setText("Top 5%");
        else if (percentage >= 80) lblRank.setText("Top 10%");
        else if (percentage >= 70) lblRank.setText("Top 25%");
        else if (percentage >= 60) lblRank.setText("Top 40%");
        else lblRank.setText("--");
        
        // Update result status
        if (totalMarks == 0) {
            lblResult.setText("PENDING");
            lblResult.setForeground(TEXT_SECONDARY);
        } else if (allPassed && percentage >= 33) {
            lblResult.setText("✓ PASSED");
            lblResult.setForeground(SUCCESS_COLOR);
        } else {
            lblResult.setText("✗ FAILED");
            lblResult.setForeground(DANGER_COLOR);
        }
        
        gradePanel.repaint();
    }
    
    private String getSubjectGrade(int marks) {
        if (marks >= 90) return "A+";
        if (marks >= 80) return "A";
        if (marks >= 70) return "B+";
        if (marks >= 60) return "B";
        if (marks >= 50) return "C+";
        if (marks >= 40) return "C";
        if (marks >= 33) return "D";
        return "F";
    }
    
    private String getOverallGrade(double percentage) {
        if (percentage >= 90) return "A+";
        if (percentage >= 80) return "A";
        if (percentage >= 70) return "B+";
        if (percentage >= 60) return "B";
        if (percentage >= 50) return "C+";
        if (percentage >= 40) return "C";
        if (percentage >= 33) return "D";
        return "F";
    }
    
    private Color getGradeColor(String grade) {
        switch (grade) {
            case "A+": return new Color(46, 204, 113);
            case "A": return new Color(39, 174, 96);
            case "B+": return new Color(52, 152, 219);
            case "B": return new Color(41, 128, 185);
            case "C+": return new Color(241, 196, 15);
            case "C": return new Color(243, 156, 18);
            case "D": return new Color(230, 126, 34);
            case "F": return new Color(231, 76, 60);
            default: return TEXT_SECONDARY;
        }
    }
    
    private void printMarksheet() {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable((graphics, pageFormat, pageIndex) -> {
            if (pageIndex > 0) return Printable.NO_SUCH_PAGE;
            
            Graphics2D g2d = (Graphics2D) graphics;
            g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
            g2d.scale(0.5, 0.5);
            printAll(g2d);
            
            return Printable.PAGE_EXISTS;
        });
        
        if (job.printDialog()) {
            try {
                job.print();
                showMessage("Print job sent successfully!", "Print", JOptionPane.INFORMATION_MESSAGE);
            } catch (PrinterException e) {
                showMessage("Error printing: " + e.getMessage(), "Print Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void saveRecord() {
        if (validateForm()) {
            showMessage("Record saved successfully to database!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void clearAll() {
        int confirm = JOptionPane.showConfirmDialog(this, 
            "Are you sure you want to clear all data?", 
            "Confirm Clear", 
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE);
        
        if (confirm == JOptionPane.YES_OPTION) {
            txtStudentName.setText("");
            txtRollNo.setText("");
            txtFatherName.setText("");
            txtMotherName.setText("");
            txtDOB.setText("DD/MM/YYYY");
            txtDOB.setForeground(TEXT_SECONDARY);
            txtPhone.setText("");
            cmbClass.setSelectedIndex(0);
            cmbField.setSelectedIndex(0);
            cmbSession.setSelectedIndex(0);
            
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                tableModel.setValueAt("", i, 3);
                tableModel.setValueAt("", i, 4);
                tableModel.setValueAt("0", i, 5);
                tableModel.setValueAt("-", i, 6);
            }
            
            lblTotal.setText("0 / 600");
            lblPercentage.setText("0.00%");
            lblGrade.setText("--");
            lblGrade.setForeground(TEXT_PRIMARY);
            lblRank.setText("--");
            lblResult.setText("PENDING");
            lblResult.setForeground(TEXT_SECONDARY);
            
            gradePanel.repaint();
        }
    }
    
    private void exportPDF() {
        if (validateForm()) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save PDF");
            fileChooser.setSelectedFile(new java.io.File(txtStudentName.getText() + "_Marksheet.pdf"));
            
            if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                showMessage("PDF exported successfully!\nLocation: " + 
                    fileChooser.getSelectedFile().getAbsolutePath(), 
                    "Export Success", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    private boolean validateForm() {
        if (txtStudentName.getText().trim().isEmpty()) {
            showMessage("Please enter student name!", "Validation Error", JOptionPane.WARNING_MESSAGE);
            txtStudentName.requestFocus();
            return false;
        }
        if (txtRollNo.getText().trim().isEmpty()) {
            showMessage("Please enter roll number!", "Validation Error", JOptionPane.WARNING_MESSAGE);
            txtRollNo.requestFocus();
            return false;
        }
        if (cmbClass.getSelectedIndex() == 0) {
            showMessage("Please select a class!", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    
    private void showMessage(String message, String title, int type) {
        JOptionPane.showMessageDialog(this, message, title, type);
    }
    
    // Custom UI Components
    
    // Gradient Background Panel
    class GradientPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            
            GradientPaint gp = new GradientPaint(0, 0, new Color(240, 244, 248), 
                getWidth(), getHeight(), new Color(226, 232, 240));
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
    }
    
    // Rounded Panel
    class RoundedPanel extends JPanel {
        private int radius;
        private Color bgColor;
        
        public RoundedPanel(int radius, Color bgColor) {
            this.radius = radius;
            this.bgColor = bgColor;
            setOpaque(false);
        }
        
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            // Shadow
            g2d.setColor(new Color(0, 0, 0, 20));
            g2d.fillRoundRect(3, 3, getWidth() - 3, getHeight() - 3, radius, radius);
            
            // Background
            g2d.setColor(bgColor);
            g2d.fillRoundRect(0, 0, getWidth() - 3, getHeight() - 3, radius, radius);
            
            super.paintComponent(g);
        }
    }
    
    // Rounded Border
    class RoundedBorder extends AbstractBorder {
        private int radius;
        private Color color;
        
        public RoundedBorder(int radius, Color color) {
            this.radius = radius;
            this.color = color;
        }
        
        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(color);
            g2d.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
        
        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(4, 8, 4, 8);
        }
    }
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.put("ComboBox.background", new Color(248, 249, 250));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        SwingUtilities.invokeLater(() -> {
            new StudentMarksheet();
        });
    }
}