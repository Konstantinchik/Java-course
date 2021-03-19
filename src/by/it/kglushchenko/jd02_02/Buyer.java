package by.it.kglushchenko.jd02_02;

class Buyer extends Thread implements IBuyer, IUseBasket {

    private boolean processedByCashier;   // логика isRunnable

    private Basket basket;

    private final boolean pensioner;

    public void setProcessedByCashier(boolean processedByCashier) {
        // готов ли посетитель быть обработанным кассиром
        this.processedByCashier = processedByCashier;
    }

    // Передаем в конструктор Имя посетителя
    public Buyer(int visitorNumber, boolean pensioner) {
        super("Buyer " + visitorNumber);
        this.pensioner = pensioner;
        Dispatcher.addBuyer();
    }

    // Чтобы Buyer стал потоком ему нужно переопроеделить метод run()
    @Override
    public void run() {
        //super.run();
        //System.out.println(this + " do smth");
        enterToMarket();
        chooseGoods();
        goToQueue();
        goOut();
        Dispatcher.completeBuyer();
    }

    /**
     * Returns a string representation of this thread, including the
     * thread's name, priority, and thread group.
     *
     * @return a string representation of this thread.
     */
    @Override
    public String toString() {      // Здесь будем возвращать name
        return this.getName();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " entered to Market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " started choose goods");
        sleepRandom(500, 2000);                               // выбирает товар, скорость пенсионеров учтена
        System.out.println(this + " finished choose goods");
    }

    @Override
    public void goToQueue() {
        System.out.println(this + " goes to queue");
        // метод wait нельзя вызвать пока мы не обладаем каким либо монитором
        // не все покупатели хотят стазу заснуть
        // нужно ли им иметь один общий монитор? не нужно
        // монитор нужен для того чтобы прислать notify
        // и у каждого покупателя он может быть свой собственный
        synchronized (this) {
            // покупатель не должен занимать ресурсы процессора
            // можно перейти в состояние wait и ждать notify
            // в этой точке покупатель говорит что он перестает быть активным
            this.setProcessedByCashier(false);

            // в очередь покупатель добавляет сам себя
            QueueBuyers.add(this);

            // даем команду не покупателю а монитору
            // wait длится пока наш this не runnable
            // Дожидаемся, когда мы станем true
            // То есть, мы дожидаемся, когда нас ослужит кассир
            while (!this.processedByCashier) {
                try {

                    // Просыпаемся, если:
                    //     Кто-то сделала на нас же buyer.notify()
                    //     Можем проснуться просто так

                    this.wait();        // пока кто-нибудь 1) не изменит isRunnable на true, 2) не пришлет notify
                } catch (InterruptedException e) {
                    System.out.println(this + " is interrupted");
                    break;
                }
            }

            // Как работает реакция на buyer.interrupt() извне
            // ...
            /*
            try (*//*Закрывающиеся штуки*//*) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // Завершить
                    return;
                }

                for (int i = 0; i < 100; i++) {
                    if (interrupted()) {
                        // Завершить
                        return;
                    }
                }
            } finally {
                // Тоже что-то закрываем
            }
            */

        }
        System.out.println(this + " left to queue");
    }

    @Override
    public void goOut() {
        System.out.println(this + " left Market");
    }

    @Override
    public void takeBasket() {
        // взял корзину
        System.out.println(this + " takes a basket");
        basket = new Basket();
    }

    @Override
    public void putGoodsToBasket() {
        int thisBuyerGoodsCount = Helper.getRandom(1, 4); // покупатель выбирает от 1 до 4 товаров
        for (int i = 0; i < thisBuyerGoodsCount; i++) {
            int itemIndex = Helper.getRandom(0, Market.goods.size() - 1);
            Good item = Market.goods.get(itemIndex);

            sleepRandom(500, 2000);

            basket.add(item, 1);

            System.out.println(this + " has put " + item.getName() + " into the basket");
        }
        System.out.println(this + " has finished putting goods into the basket");
    }

    @Override
    public boolean isPensioner() {
        return pensioner;
    }

    private void sleepRandom(int min, int max) {
        int k = getK();
        Helper.sleepRandom(min * k, max * k); // берет товар
    }

    private int getK() {
        int k = 1;
        if (pensioner) {
            k = Helper.getRandom(1, 2); // коэффициент пенсионера, в среднем 1,5
        }
        return k;
    }
}
