public class BooleanMethod {
    public boolean isRun() {
        System.out.print(SomeMethod.getMethodName() + "() -> программа выполняется далее" +
                " или завершается? ");
        return true;
    }

    public boolean isFileDeleted() {
        System.out.print(SomeMethod.getMethodName() + "() -> удалился ли файл на жестком" +
                " диске или флешке? ");
        return false;
    }

    public boolean containUniqueDigit() {
        System.out.print(SomeMethod.getMethodName() + "() -> последовательность содержит" +
                " уникальную цифру? ");
        return true;
    }

    public boolean isLetter() {
        System.out.print(SomeMethod.getMethodName() + "() -> пользователь ввел букву или" +
                " что-то другое? ");
        return false;
    }

    public boolean hasEqualsDigits() {
        System.out.print(SomeMethod.getMethodName() + "() -> в проверяемых числах, есть" +
                " равные цифры? ");
        return false;
    }

    public boolean hasAttempts() {
        System.out.print(SomeMethod.getMethodName() + "() -> в игре \"Марио\" остались попытки? ");
        return true;
    }

    public boolean isEmptyOrSpaces() {
        System.out.print(SomeMethod.getMethodName() + "() -> пользователь ввёл пустую" +
                " строку или из одних пробелов? ");
        return false;
    }

    public boolean isEven() {
        System.out.print(SomeMethod.getMethodName() + "() -> на кубике, который бросил" +
                " компьютер, выпало четное число? ");
        return true;
    }

    public boolean isPathValid() {
        System.out.print(SomeMethod.getMethodName() + "() -> путь до файла, который вы" +
                " ищите на ssd, действительный? ");
        return false;
    }

    public boolean isFileExists() {
        System.out.print(SomeMethod.getMethodName() + "() -> файл по указанному адресу существует? ");
        return true;
    }
}