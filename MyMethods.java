package MyGym;
import java.util.*;


class myClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String input = scanner.nextLine();

        try {
            String result = calc(input);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static String calc(String input) throws Exception {
        boolean isRome;
        String result = "";
        String[] parts = input.split(" ");

        if (parts.length != 3) {
            throw new Exception("Неверное количество элементов");
        }

        String operator = parts[1];
        int num1 = Integer.parseInt(parts[0]);
        int num2 = Integer.parseInt(parts[2]);

        if (operator.equals("+") | operator.equals("-") | operator.equals("/") | operator.equals("*") ){

            if (RomeNumber.isFound(parts[0]) && RomeNumber.isFound(parts[2])) {

                isRome = true;
                int rome1 = RomeNumber.convertRome(parts[0]);
                int rome2 = RomeNumber.convertRome(parts[2]);

                int num = romeCalc(rome1, rome2, operator);

                if (num > 0) {

                    result = String.valueOf(num);

                } else {
                    throw new Exception("Результат меньше 0");
                }

            } else if (!RomeNumber.isFound(parts[0]) && !RomeNumber.isFound(parts[2])) {
                isRome = false;
                int c = arabCalc(num1, num2, operator);
                result = String.valueOf(c);
            } else {
                throw new Exception("Разные системы счисления");
            }

            return result;
        }
        else {
            throw new Exception("неверное");
        }

    }

    public static int arabCalc(int a, int b, String operator) throws Exception {
        if(a <= 10 && b <= 10) {
            if (operator.equals("+")) return a + b;
            else if (operator.equals("-")) return a - b;
            else if (operator.equals("*")) return a * b;
            else if (operator.equals("/")) return a / b;
        }
        else {
            throw new Exception("Разные системы счисления");
        }
        return 0;
    }

    public static int romeCalc(int a, int b, String operator) {
        if (operator.equals("+")) return a + b;
        else if (operator.equals("-")) return a - b;
        else if (operator.equals("*")) return a * b;
        else if (operator.equals("/")) return a / b;
        else return 0;
    }
}
class RomeNumber{
    static String [] romeNum = new String[]
            {"I","II","III","IV","V","VI","VII","VIII","IX","X",
            "XX","XXI","XXV","XXX","XL","L","LX","LXX","LXXX","XC","C"};

    public static boolean isFound(String list) {
        for (int i = 1; i < romeNum.length; i++){
            if (list.equals(romeNum[i])){
                return true;
            }
        }
        return false;
    }

    public static int convertRome(String list){



        return -1;
    }
}

