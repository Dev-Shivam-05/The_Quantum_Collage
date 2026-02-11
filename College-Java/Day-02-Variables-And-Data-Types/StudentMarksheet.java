public class StudentMarksheet {
    public static void main(String[] args) {
        
        // Student Information
        String studentName = "Rahul Sharma";
        int rollNo = 101;
        String className = "12th";
        String field = "Science (PCM)";
        String fatherName = "Mr. Rajesh Sharma";
        String motherName = "Mrs. Sunita Sharma";
        String dob = "15/08/2006";
        String phone = "9876543210";
        String session = "2024-2025";
        
        // Subject Marks (out of 100)
        int mathematics = 95;
        int physics = 88;
        int chemistry = 82;
        int english = 90;
        int computerScience = 97;
        int physicalEducation = 85;
        
        // Calculations
        int totalMarks = mathematics + physics + chemistry + english + computerScience + physicalEducation;
        int maxMarks = 600;
        double percentage = (totalMarks * 100.0) / maxMarks;
        
        // Grade Calculation
        String grade;
        if (percentage >= 90) grade = "A+";
        else if (percentage >= 80) grade = "A";
        else if (percentage >= 70) grade = "B+";
        else if (percentage >= 60) grade = "B";
        else if (percentage >= 50) grade = "C";
        else if (percentage >= 33) grade = "D";
        else grade = "F";
        
        // Result
        String result;
        if (percentage >= 33) result = "PASSED";
        else result = "FAILED";
        
        // Print Marksheet
        System.out.println("\n");
        System.out.println("╔══════════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                                  ║");
        System.out.println("║              ★ EXCELLENCE ACADEMY ★                              ║");
        System.out.println("║                 STUDENT MARKSHEET                                ║");
        System.out.println("║                 Session: " + session + "                              ║");
        System.out.println("║                                                                  ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════╣");
        System.out.println("║                                                                  ║");
        System.out.println("║  ┌─────────────────── STUDENT DETAILS ───────────────────┐       ║");
        System.out.println("║  │                                                       │       ║");
        System.out.println("║  │  Student Name    :  " + studentName + "                        │       ║");
        System.out.println("║  │  Roll Number     :  " + rollNo + "                                 │       ║");
        System.out.println("║  │  Class           :  " + className + "                                │       ║");
        System.out.println("║  │  Stream/Field    :  " + field + "                       │       ║");
        System.out.println("║  │  Father's Name   :  " + fatherName + "                  │       ║");
        System.out.println("║  │  Mother's Name   :  " + motherName + "                 │       ║");
        System.out.println("║  │  Date of Birth   :  " + dob + "                           │       ║");
        System.out.println("║  │  Phone           :  " + phone + "                          │       ║");
        System.out.println("║  │                                                       │       ║");
        System.out.println("║  └───────────────────────────────────────────────────────┘       ║");
        System.out.println("║                                                                  ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════╣");
        System.out.println("║                                                                  ║");
        System.out.println("║  ┌──────────────────── MARKS OBTAINED ───────────────────┐       ║");
        System.out.println("║  │                                                       │       ║");
        System.out.println("║  │   #   Subject               Max Marks   Obtained      │       ║");
        System.out.println("║  │  ─────────────────────────────────────────────────    │       ║");
        System.out.println("║  │   1   Mathematics              100         " + mathematics + "         │       ║");
        System.out.println("║  │   2   Physics                  100         " + physics + "         │       ║");
        System.out.println("║  │   3   Chemistry                100         " + chemistry + "         │       ║");
        System.out.println("║  │   4   English                  100         " + english + "         │       ║");
        System.out.println("║  │   5   Computer Science         100         " + computerScience + "         │       ║");
        System.out.println("║  │   6   Physical Education       100         " + physicalEducation + "         │       ║");
        System.out.println("║  │  ─────────────────────────────────────────────────    │       ║");
        System.out.println("║  │       TOTAL                    " + maxMarks + "        " + totalMarks + "         │       ║");
        System.out.println("║  │                                                       │       ║");
        System.out.println("║  └───────────────────────────────────────────────────────┘       ║");
        System.out.println("║                                                                  ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════╣");
        System.out.println("║                                                                  ║");
        System.out.println("║  ┌───────────────────── RESULT SUMMARY ──────────────────┐       ║");
        System.out.println("║  │                                                       │       ║");
        System.out.println("║  │        Total Marks Obtained  :  " + totalMarks + " / " + maxMarks + "             │       ║");
        System.out.println("║  │        Percentage            :  " + String.format("%.2f", percentage) + " %                │       ║");
        System.out.println("║  │        Grade                 :  " + grade + "                        │       ║");
        System.out.println("║  │        Result                :  " + result + "                    │       ║");
        System.out.println("║  │                                                       │       ║");
        System.out.println("║  └───────────────────────────────────────────────────────┘       ║");
        System.out.println("║                                                                  ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════╣");
        System.out.println("║                                                                  ║");
        System.out.println("║   GRADE SCALE:  A+ (90-100)  A (80-89)  B+ (70-79)               ║");
        System.out.println("║                 B (60-69)    C (50-59)  D (33-49)   F (<33)      ║");
        System.out.println("║                                                                  ║");
        System.out.println("║                                                                  ║");
        System.out.println("║   Class Teacher: _______________    Principal: _______________   ║");
        System.out.println("║                                                                  ║");
        System.out.println("║                        Date: 15/01/2025                          ║");
        System.out.println("║                                                                  ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════╝");
        System.out.println("\n");
    }
}