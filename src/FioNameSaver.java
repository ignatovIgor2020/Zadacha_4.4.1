import java.util.Locale;

public class FioNameSaver {
    String[] fioStringMass;
    String retSring = new String();
    int maxNumberPersons;
    int savedNamesLen;

    FioNameSaver(int maxPersons) {
        maxNumberPersons = maxPersons;
        fioStringMass = new String[maxPersons];
        for (int i = 0; i < maxPersons; i++) {

            this.fioStringMass[i] = new String();
        }
        savedNamesLen = 0;

    }

    public String GetFioName(int pos) {
        retSring = "";
        retSring = fioStringMass[pos];

        return retSring;
    }

    public int saveFioName(String str) {
        String saveSring = new String();
        fioStringMass[savedNamesLen] = "";
        String[] stringFromFio = str.split(" ");
        if (stringFromFio.length == 1) {
            if ((str.charAt(0) == 'х') || (str.charAt(0) == 'Х') || (str.charAt(0) == 'x') || (str.charAt(0) == 'X'))
                return 1;
        }
        int fioNameWords = 0;
        for (int i = 0; i < stringFromFio.length; i++) {
            if (stringFromFio[i].length() <= 2)
                continue;
            fioNameWords++;
            saveSring += stringFromFio[i].substring(0, 1).toUpperCase();
            saveSring += stringFromFio[i].substring(1, stringFromFio[i].length()) + " ";
        }
        if (fioNameWords == 3) {
            fioStringMass[savedNamesLen] = saveSring;
            savedNamesLen++;
            return 0;
        } else {
            return -1;
        }
    }


    public String getSecondSurname(int pos) {
        String secondSurname;
        String[] stringFromFio = fioStringMass[pos].split(" ");
        return stringFromFio[2];
    }

    public int inputFio() {
        return 1;
    }

}
