public class MethodTest {
    public static void main(String[] args) throws Exception {
        NotBooleanMethod nbm = new NotBooleanMethod();
        System.out.println("1. HЕ BOOLEAN-МЕТОДЫ");
        nbm.findLongestWord();
        nbm.selectItemMenu();
        nbm.calculateAverageValue();
        nbm.countNumberWord();
        nbm.printMessageErr();
        nbm.synchronizeDataCloud();
        nbm.restoreBackupData();
        nbm.pauseDownload();
        nbm.resetSettings();
        nbm.writeContenFile();
        nbm.convertTemperature();
        nbm.enterMathExpression();
        nbm.identifyWinner();
        nbm.findBook();

        System.out.println("\n2. BOOLEAN-МЕТОДЫ");
        BooleanMethod bm = new BooleanMethod();
        System.out.println(bm.isRun());
        System.out.println(bm.isFileDeleted());
        System.out.println(bm.containUniqueDigit());
        System.out.println(bm.isLetter());
        System.out.println(bm.hasEqualsDigits());
        System.out.println(bm.hasAttempts());
        System.out.println(bm.isEmptyOrSpaces());
        System.out.println(bm.isEven());
        System.out.println(bm.isPathValid());
        System.out.println(bm.isFileExists());
    }
}