import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputFio {
    Scanner scanner = new Scanner(System.in);
    String inputString = new String();
    String inputString2 = new String();
    String inputString3 = new String();
    FioNameSaver fioNameSaver;
    int maxUsersInt;
    int goodFioRecv;

    InputFio() {

        System.out.println("Введите максимальное количество сотрудников");
        String maxUsersString = scanner.next();
        maxUsersInt = Integer.parseInt(maxUsersString);
        System.out.println("Максимальное количество сотрудников - " + maxUsersInt);
        System.out.println("Введите ФИО сотрудников");
        fioNameSaver = new FioNameSaver(maxUsersInt);
    }

    public void InputNames() {
        goodFioRecv = 0;
        while (goodFioRecv < maxUsersInt) {

            inputString = scanner.next();
            inputString += " " + scanner.nextLine();
            int returnValue = fioNameSaver.saveFioName(inputString);
            if (returnValue == 0) {
                System.out.println("Введите ФИО следующего сотрудника или 'X' для завершения");
                goodFioRecv++;
            } else if (returnValue == 1) {
                return;
            } else {
                System.out.println("ФИО введено некорректно, повторите ввод");
            }
        }

    }

    public void printFioTable() {
        String outputString = new String();
        String secSurName = new String();
        //Pattern pattern = Pattern.compile("(.*) (.*)");
        //Matcher matcher = pattern.matcher(text);
        for (int i = 0; i < maxUsersInt; i++) {
            outputString = fioNameSaver.GetFioName(i);
            StringBuilder stringBuilder = new StringBuilder(fioNameSaver.getSecondSurname(i));
            secSurName = stringBuilder.delete(0, stringBuilder.length() - 2).toString();
            if (secSurName.compareTo("ич") == 0) {
                outputString += "   - муж";
            } else if (secSurName.compareTo("на") == 0) {
                outputString += "   - жен";
            }
            System.out.println(outputString);

        }
    }
}

