public class NotBooleanMethod {
    public void findLongestWord() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.println(methodName + "() -> найти самое длинное слово в предложении " + 
                " из книги по Java");
    }

    public void selectItemMenu() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.println(methodName + "() -> выбрать пункт меню в текстовом редакторе на macOS");
    }

    public void calculateAverageValue() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.println(methodName + "() -> вычислить среднее значение оценок в школе №1234");
    }

    public void countNumberWord() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.println(methodName + "() -> подсчитать количество уникальных слов " + 
                " в \"Война и Мир\"");
    }

    public void printMessageErr() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.println(methodName + "() -> вывести сообщение об ошибке");
    }

    public void synchronizeDataCloud() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.println(methodName + "() -> синхронизировать данные с облачным хранилищем");
    }

    public void restoreBackupData() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.println(methodName + "() -> восстановить данные из резервной копии " + 
                " от 11.03.2024");
    }

    public void pauseDownload() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.println(methodName + "() -> приостановить загрузку mp3-файла группы \"Ария\"");
    }

    public void resetSettings() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.println(methodName + "() -> сбросить настройки до заводских для пылесоса Mi");
    }

    public void writeContenFile() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.println(methodName + "() -> записать содержимое в файл по указанному" + 
                " пути на флешку");
    }

    public void convertTemperature() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.println(methodName + "() -> преобразовать температуру из Цельсия в Фаренгейт");
    }

    public void enterMathExpression() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.println(methodName + "() -> ввести математическое выражение" + 
                " с тремя аргументами");
    }

    public void identifyWinner() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.println(methodName + "() -> выявить победителя среди гонщиков игры " + 
                "\"Need For Speed\"");
    }

    public void findBook() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.println(methodName + "() -> найти книгу по имени писателя");
    }
}
