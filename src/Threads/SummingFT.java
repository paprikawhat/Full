package src.Threads;

import java.util.stream.IntStream;

public class SummingFT {
    // Объявление статических полей класса
    private final static int FROM_NUMBER_FIRST_THREAD = 1;
    private final static int TO_NUMBER_FIST_THREAD = 500;
    private final static int FROM_NUMBER_SECOND_THREAD = 501;
    private final static int TO_NUMBER_SECOND_THREAD = 1000;
    // Шаблон для вывода имени потока %s для String, %d для Digits
    private final static String TEMPLATE_MESSAGE_THREAD_NAME_AND_NUMBER = "%s : %d";
    // Статический метод для вывода имени и номера потока
    private static void printThreadNameAndNumber(final int number) {
        System.out.printf(TEMPLATE_MESSAGE_THREAD_NAME_AND_NUMBER, Thread.currentThread().getName(), number);
    }
    // Выполнение основного потока
    public static void main(String[] args) throws InterruptedException {
        // Создание объекта реализующего через Runnable сложение всех чисел в потоке
        final TaskSummingNumbers firstTask = new TaskSummingNumbers(FROM_NUMBER_FIRST_THREAD, TO_NUMBER_FIST_THREAD);
        // Все то же самое для secondTask
        final TaskSummingNumbers secondTask = new TaskSummingNumbers(FROM_NUMBER_SECOND_THREAD, TO_NUMBER_SECOND_THREAD);
        // startThread(secondTask);
        // Ожидание выполнения всех переданных потоков через запуск виртуальных потоков
        waitingForJoin(Thread.startVirtualThread(firstTask), Thread.startVirtualThread(secondTask));
        // Суммирование результатов работы потоков firstTask и secondTask
        final int result = firstTask.getResultNumber() + secondTask.getResultNumber();
        printThreadNameAndNumber(result);
    }
    // Метод для запуска задачи в отдельном потоке
    private static void startThread(final Runnable runnable) {
        final Thread thread = new Thread(runnable);
        thread.start();
    }
    // Статический метод для проверки завершения выполнения переданных потоков
    private static void waitingForJoin(final Thread... threads) throws InterruptedException {
        for(final Thread thread : threads) {
            thread.join();
        }
    }
    private static final class TaskSummingNumbers implements Runnable {
        private static final int INITIAL_VALUE_RESULT_NUMBER = 0;
        private final int fromNumber;
        private final int toNumber;
        private int resultNumber;
        // Конструктор класса
        public TaskSummingNumbers(final int fromNumber, final int toNumber) {
            this.fromNumber = fromNumber;
            this.toNumber = toNumber;
            this.resultNumber = INITIAL_VALUE_RESULT_NUMBER;
        }
        public int getResultNumber() {
            return this.resultNumber;
        }

        @Override
        public void run() {
            // IntStream - поток последовательности примитивных значений
            // rangeClosed() возвращает все значения в заданном промежутке
            // forEach() выполняет resultNumber += i для каждого i из промежутка
            IntStream.rangeClosed(this.fromNumber, this.toNumber).forEach(i -> this.resultNumber += i);
            printThreadNameAndNumber(this.resultNumber); // Вывод результата
        }
    }
}

