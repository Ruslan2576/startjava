package com.startjava.lesson_2_3_4.method.naming;

public class BooleanMethods {
    public boolean isRun() {
        System.out.print(MethodName.getCurrent() +
                 "() -> программа выполняется далее или завершается? ");
        return true;
    }

    public boolean isDeleted() {
        System.out.print(MethodName.getCurrent() +
                "() -> удалился ли файл на жестком диске или флешке? ");
        return false;
    }

    public boolean hasUniqueDigit() {
        System.out.print(MethodName.getCurrent() +
                "() -> последовательность содержит уникальную цифру? ");
        return true;
    }

    public boolean isLetter() {
        System.out.print(MethodName.getCurrent() +
                "() -> пользователь ввел букву или что-то другое? ");
        return false;
    }

    public boolean hasEqualsDigits() {
        System.out.print(MethodName.getCurrent() +
                 "() -> в проверяемых числах, есть равные цифры? ");
        return false;
    }

    public boolean hasAttempts() {
        System.out.print(MethodName.getCurrent() +
                "() -> в игре \"Марио\" остались попытки? ");
        return true;
    }

    public boolean isEmptyOrSpaces() {
        System.out.print(MethodName.getCurrent() +
                 "() -> пользователь ввёл пустую строку или из одних пробелов? ");
        return false;
    }

    public boolean isEven() {
        System.out.print(MethodName.getCurrent() +
                 "() -> на кубике, который бросил компьютер, выпало четное число? ");
        return true;
    }

    public boolean isValidPath() {
        System.out.print(MethodName.getCurrent() +
                 "() -> путь до файла, который вы ищите на ssd, действительный? ");
        return false;
    }

    public boolean isExists() {
        System.out.print(MethodName.getCurrent() +
                "() -> файл по указанному адресу существует? ");
        return true;
    }
}