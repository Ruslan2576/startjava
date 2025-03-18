public class BooleanMethod {
    public boolean isRun() {
        String nameMethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.print(nameMethod + "() -> программа выполняется далее или завершается? ");
        return true;
    }

    public boolean isFileDeleted() {
        String nameMethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.print(nameMethod + "() -> удалился ли файл на жестком диске или флешке? ");
        return false;
    }

    public boolean containUniqueDigit() {
        String nameMethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.print(nameMethod + "() -> последовательность содержит уникальную цифру? ");
        return true;
    }

    public boolean isLetter() {
        String nameMethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.print(nameMethod + "() -> пользователь ввел букву или что-то другое? ");
        return false;
    }

    public boolean hasEqualsDigits() {
        String nameMethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.print(nameMethod + "() -> в проверяемых числах, есть равные цифры? ");
        return false;
    }

    public boolean hasAttempts() {
        String nameMethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.print(nameMethod + "() -> в игре \"Марио\" остались попытки? ");
        return true;
    }

    public boolean isEmptyOrSpaces() {
        String nameMethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.print(nameMethod + "() -> пользователь ввёл пустую строку или из  + " + 
                "одних пробелов? ");
        return false;
    }

    public boolean isEven() {
        String nameMethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.print(nameMethod + "() -> на кубике, который бросил компьютер, " + 
                " выпало четное число? ");
        return true;
    }

    public boolean isPathValid() {
        String nameMethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.print(nameMethod + "() -> путь до файла, который вы ищите на ssd, " + 
                " действительный? ");
        return false;
    }

    public boolean isFileExists() {
        String nameMethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.print(nameMethod + "() -> файл по указанному адресу существует? ");
        return true;
    }
}