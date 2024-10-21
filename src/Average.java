import java.util.HashMap;
import java.util.Map;

public class Average {

    public static void main(String[] args) {
        // Given a list of student names and corresponding marks,
        // return the highest average marks (and print the corresponding student name - optional).
        // The marks can be negative as well and a student may have multiple marks.
        //
        // Example:
        // String[][] = {{"Charles", 84},
        // {"John", 100},
        // {"Andy", 37},
        // {"John", 23},
        // {"Charles", 20}};
        //
        // Return 61.5 (which is of John's)

        String[][] cv = {{"Charles", "84"},
                {"John", "100"},
                {"Andy", "37"},
                {"John", "23"},
                {"Charles", "20"}};

        Map<String, int[]> map = new HashMap<>();

        for (var student : cv) {
            String name = student[0];
            int marks = Integer.parseInt(student[1]);

            map.putIfAbsent(name, new int[2]);
            map.get(name)[0] += marks;
            map.get(name)[1]++;
        }

        double studentAvgMarks = Integer.MIN_VALUE;
        String studentName = "";
        for (var i : map.entrySet()) {
            int totalMarks = i.getValue()[0];
            int totalSubjects = i.getValue()[1];
            double avg = (double) totalMarks / totalSubjects;
            if (avg > studentAvgMarks) {
                studentAvgMarks = avg;
                studentName = i.getKey();
            }
        }

        System.out.println(studentName + " " + studentAvgMarks);
    }

}

