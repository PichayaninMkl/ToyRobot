import java.util.Scanner;

public class ToyRobot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Robot robot = new Robot();

        System.out.println("Enter commands (PLACE X,Y,F | MOVE | LEFT | RIGHT | REPORT). Type EXIT to quit.");
        while (true) {
            String line = scanner.nextLine().trim();
            if (line.equalsIgnoreCase("EXIT")) break;

            if (line.startsWith("PLACE")) {
                try {
                    String[] parts = line.split(" ")[1].split(",");
                    int x = Integer.parseInt(parts[0]);
                    int y = Integer.parseInt(parts[1]);
                    Facing f = Facing.valueOf(parts[2]);
                    robot.place(x, y, f);
                } catch (Exception e) {
                    System.out.println("Invalid PLACE command. Use: PLACE X,Y,F");
                }
            } else {
                switch (line) {
                    case "MOVE" -> robot.move();
                    case "LEFT" -> robot.left();
                    case "RIGHT" -> robot.right();
                    case "REPORT" -> robot.report();
                    default -> System.out.println("Invalid command!");
                }
            }
        }
        scanner.close();
    }
}
