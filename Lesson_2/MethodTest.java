public class MethodTest {
    public static void main(String[] args) {
        System.out.println("1. HЕ BOOLEAN-МЕТОДЫ");
        doNotBooleanMethod();

        System.out.println("\n2. BOOLEAN-МЕТОДЫ");
        doBooleanMethod();
    }

    public static void doNotBooleanMethod() {
        NonBooleanMethods nbm = new NonBooleanMethods();
        nbm.findLongestWord();
        nbm.selectMenuItem();
        nbm.calculateAverageGrade();
        nbm.countUniqueWord();
        nbm.printError();
        nbm.syncDataCloud();
        nbm.restoreBackup();
        nbm.pauseDownload();
        nbm.resetSettings();
        nbm.writeFile();
        nbm.convertTemperature();
        nbm.enterMathExpression();
        nbm.determineWinner();
        nbm.findBookByWriterName();
    }

    public static void doBooleanMethod() {
        BooleanMethods bm = new BooleanMethods();
        System.out.println(bm.isRun());
        System.out.println(bm.isDeleted());
        System.out.println(bm.hasUniqueDigit());
        System.out.println(bm.isLetter());
        System.out.println(bm.hasEqualsDigits());
        System.out.println(bm.hasAttempts());
        System.out.println(bm.isEmptyOrSpaces());
        System.out.println(bm.isEven());
        System.out.println(bm.isValidPath());
        System.out.println(bm.isExists());
    }
}