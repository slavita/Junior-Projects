import java.util.ArrayList;
import java.util.Collection;
/**
 * Интерфейс BlockingQueue является очередью (Queue),
 * т.е. его элементы хранятся в порядке «первый пришел,
 * первый вышел» (FIFO – first in, first out). Элементы,
 * вставленные в коллекцию в определенном порядке,
 * будут извлечены из нее в том же самом порядке.
 */
import java.util.concurrent.BlockingQueue;
/**
 * Интерфейс Callable использует дженерики для определения типа
 * возвращаемого объекта. Класс Executors предоставляет полезные
 * методы для выполнения Callable в пуле потоков.
 * Callable таски (задачи) возвращают java.util.concurrent.Future объект.
 * Используя Future мы можем узнать статус Callable таска и
 * получить возвращенный объект. Это обеспечивает get() метод,
 * который ждет завершение Callable, чтобы вернуть результат.
 */
import java.util.concurrent.Callable;


public class SimpleExecutorService {
    /**
     * Группа потока представляет ряд потоков.
     * Кроме того, группа потока может также включать
     * другие группы потока. Группы потока формируют дерево,
     * в котором у каждой группы потока кроме начальной
     * группы потока есть родитель.
     * Потоку позволяют получить доступ к информации
     * о ее собственной группе потока, но не к информации
     * о доступе о ее групповой родительской группе потока
     * потока или любых других группах потока.
     */
    private final ThreadGroup group = new ThreadGroup("");
    private final Collection<Thread> workersPool = new ArrayList<>();
    private final BlockingQueue<Callable> taskQueue;

    private class Worker implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Callable nextTask = taskQueue.take();/** Получает и удаляет главу этой очереди,
                                                             ожидая в случае необходимости,
                                                             пока элемент не становится доступным.*/
                    nextTask.call();
                } catch (InterruptedException e) {
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public SimpleExecutorService(int threadGroup, final BlockingQueue<Callable> taskQueue) {
        this.taskQueue = taskQueue;
        for(int k = 0; k < threadGroup; k++) {
            Thread worker = new Thread(group, new Worker());
            worker.start();
            workersPool.add(worker);
        }
    }

    public <T> void submit (Collection<T> task) throws InterruptedException {
        taskQueue.put((Callable) task);
    }

    public void shutdown() {
        group.interrupt();
    }
}