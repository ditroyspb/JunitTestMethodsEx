import java.util.Scanner;

public class Main {

    public static int taxEarningsMinusSpend(int earnings, int spend) { //метод расчета УСН доходы минус расходы
        int tax = (earnings - spend) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

    public static int taxEarnings(int earnings) { //метод расчета УСН доходы
        int tax1 = earnings * 6 / 100;
        return tax1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int earnings = 0; //доходы
        int spend = 0; //расходы
        while (true) {
            int xx = (earnings > 0) ? 1 : 0;
            int yy = (spend > 0) ? 1 : 0;
            if (xx == 1) {
                System.out.println("Income entered: " + earnings + ";");
            }
            if (yy == 1) {
                System.out.println("consumption entered: " + spend + ";");
            }
            System.out.println("Choose number of operation: ");
            System.out.println("1. Add new income.");
            System.out.println("2. Add new consumption.");
            System.out.println("3. Choose a tax system.");
            System.out.println("For exit write end.");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                System.out.println("Program completed. Thank you!");
                break;
            }
            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Enter the amount of income:");
                    String moneyStr = scanner.nextLine();
                    int money = Integer.parseInt(moneyStr);
                    earnings += money;
                    break;
                case 2:
                    System.out.println("Enter the amount of consumption:");
                    String consumptionStr = scanner.nextLine();
                    int consumption = Integer.parseInt(consumptionStr);
                    spend += consumption;
                    break;
                case 3:
                    int tax = taxEarningsMinusSpend(earnings, spend);
                    int tax1 = taxEarnings(earnings);
                    int difference = tax1 - tax;
                    if (difference > 0) {
                        System.out.println("We advise system 'USN income minus consumptions';");
                        System.out.println("The tax will be " + tax + " $;");
                        System.out.println("The tax on another system is " + tax1 + " $;");
                        System.out.println("Your benefit is " + Math.abs(tax - tax1) + " $;");
                        System.out.println("        ");
                    } else {
                        System.out.println("We advise system 'USN income';");
                        System.out.println("The tax will be " + tax1 + " $;");
                        System.out.println("The tax on another system is " + tax + " @;");
                        System.out.println("Your benefit is " + Math.abs(tax1 - tax) + " $ ;");
                        System.out.println("        ");
                    }
                    break;
                default:
                    System.out.println("Unknown operation");
            }
        }
    }
}
