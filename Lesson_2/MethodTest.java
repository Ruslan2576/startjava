public class MethodTest {

    private static BooleanMethod bm = new BooleanMethod();
    private static NotBooleanMethod nbm = new NotBooleanMethod();

    public static void main(String[] args) throws Exception {
        System.out.println("1. HЕ BOOLEAN-МЕТОДЫ");
        showFindLongestWord();
        showSelectItemMenu();
        showCalculateAverageValue();
        showCountNumberWord();
        showPrintMessageErr();
        showSynchronizeDataCloud();
        showRestoreBackupData();
        showPauseDownload();
        showResetSettings();
        showWriteContenFile();
        showConvertTemperature();
        showEnterMathExpression();
        showIdentifyWinner();
        showFindBook();

        System.out.println("\n2. BOOLEAN-МЕТОДЫ");
        showIsRight();
        showIsFileDeleted();
        showContainUniqueDigit();
        showIsLetter();
        showHasEqualsDigits();
        showHasAttempts();
        showIsEmptyOrSpaces();
        showIsEven();
        showIsPathValid();
        showIsFileExists();

        // Вызов статического метода возвращающего имя метода в котором он был вызван
        // можно поместить в любой из методов ниже, но по заданию этого не было,
        // так что это просто демонстрация его работоспособности.
        System.out.println(StaticMethod.getMethodName());
    }

    public static void showFindLongestWord() {
        nbm.findLongestWord();
    }

    public static void showSelectItemMenu() {
        nbm.selectItemMenu();
    }

    public static void showCalculateAverageValue() {
        nbm.calculateAverageValue();
    }

    public static void showCountNumberWord() {
        nbm.countNumberWord();
    }

    public static void showPrintMessageErr() {
        nbm.printMessageErr();
    }

    public static void showSynchronizeDataCloud() {
        nbm.synchronizeDataCloud();
    }

    public static void showRestoreBackupData() {
        nbm.restoreBackupData();
    }

    public static void showPauseDownload() {
        nbm.pauseDownload();
    }

    public static void showResetSettings() {
        nbm.resetSettings();
    }

    public static void showWriteContenFile() {
        nbm.writeContenFile();
    }

    public static void showConvertTemperature() {
        nbm.convertTemperature();
    }

    public static void showEnterMathExpression() {
        nbm.enterMathExpression();
    }

    public static void showIdentifyWinner() {
        nbm.identifyWinner();
    }

    public static void showFindBook() {
        nbm.findBook();
    }

    public static void showIsRight() {
        System.out.println(bm.isRun());
    }

    public static void showIsFileDeleted() {
        System.out.println(bm.isFileDeleted());
    }

    public static void showContainUniqueDigit() {
        System.out.println(bm.containUniqueDigit());
    }

    public static void showIsLetter() {
        System.out.println(bm.isLetter());
    }

    public static void showHasEqualsDigits() {
        System.out.println(bm.hasEqualsDigits());
    }

    public static void showHasAttempts() {
        System.out.println(bm.hasAttempts());
    }

    public static void showIsEmptyOrSpaces() {
        System.out.println(bm.isEmptyOrSpaces());
    }

    public static void showIsEven() {
        System.out.println(bm.isEven());
    }

    public static void showIsPathValid() {
        System.out.println(bm.isPathValid());
    }

    public static void showIsFileExists() {
        System.out.println(bm.isFileExists());
    }
}