public class Q4FindTheFinalCoOrdinatesReachedByFollowingASequenceOfDirections {
    public void call() {
        //Given the string (containing directions e.g., U, R, D, L) and initial coordinates (0,0),
        //return the final coordinates after traversing the string.
        //
        //Examples:
        //Given (0,0) and String - "UUU"
        //    Answer : (0,3)
        //
        //Given (0,0) and String - "URRDDL"
        //    Answer : (1,-1)
        //
        //Additional testcase : String - "DOWN UP 2xRIGHT DOWN 3xLEFT"
        //    Answer : (-1,-1)

//        String str = "UUU";
//        String str = "URRDDL";
        String str = "DOWN UP 2xRIGHT DOWN 3xLEFT";
        int x = 0;
        int y = 0;

        if (str.contains(" ")) {
            str = str.replaceAll("UP", "U")
                    .replaceAll("DOWN", "D")
                    .replaceAll("RIGHT", "R")
                    .replaceAll("LEFT", "L");
            StringBuilder tempStr = new StringBuilder();
            String[] moves = str.split(" ");
            for (String move : moves) {
                if (move.contains("x")) {
                    String[] parts = move.split("x");
                    int count = Integer.parseInt(parts[0]);
                    String direction = parts[1];
                    for (int i = 0; i < count; i++) {
                        tempStr.append(direction);
                    }
                } else {
                    tempStr.append(move);
                }
            }
            str = tempStr.toString();
        }

        for (char ch : str.toCharArray()) {
            if (ch == 'U') y++;
            else if (ch == 'D') y--;
            else if (ch == 'R') x++;
            else if (ch == 'L') x--;
        }

        System.out.println("(" + x + " " + y + ")");
    }
}
