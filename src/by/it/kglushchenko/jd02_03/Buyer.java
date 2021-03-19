package by.it.kglushchenko.jd02_03;


class Buyer extends Thread implements IBuyer, IUseBasket {

    private boolean processedByCashier; // логика isRunnable

    private final QueueBuyers queueBuyers;

    private final boolean pensioner = false;

    private Basket basket;


    public void setProcessedByCashier(boolean processedByCashier) {
        // готов ли посетитель быть обработанным кассиром
        this.processedByCashier = processedByCashier;
    }

    // Передаем в конструктор Имя посетителя и очередь
    public Buyer(int visitorNumber, QueueBuyers queueBuyers) {
        super("Buyer " + visitorNumber);
        this.queueBuyers = queueBuyers; // добавляем покупателя в очередь
        Dispatcher.addBuyer();
    }

    // Чтобы Buyer стал потоком ему нужно переопроеделить метод run()

    @Override
    public void run() {

        enterToMarket();
        chooseGoods();
        goToQueue();
        goOut();
        Dispatcher.completeBuyers();
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
        takeBasket();
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " started choose goods");
        int k = getK();         //
        sleepRandom(500, 2000); // выбирает товар
        System.out.println(this + " finished choose goods");
        putGoodsToBasket();
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
            queueBuyers.add(this);
            // даем команду не покупателю а монитору
            // wait длится пока наш this не runnable
            while (!this.processedByCashier)
                try {
                    this.wait();        // пока кто-нибудь 1) не изменит isRunnable на true, 2) не пришлет notify
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        System.out.println(this + " left to queue");
    }

    public Object getMonitor() {
        return this;
    }

    @Override
    public void goOut() {
        System.out.println(this + " left Market");
    }

    @Override
    public boolean IsPensioneer() {
        return this.pensioner;
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

            sleepRandom(500, 2000); // берет товар

            basket.add(item, 1);

            System.out.println(this + " has put " + item.getName() + " into the basket");
        }
        System.out.println(this + " has finished putting goods into the basket");
    }

    private void sleepRandom(int min, int max) {
        int k = getK();
        Helper.sleepRandom(min * k, max * k); // берет товар
    }

    private int getK() {
        int k = 1;
        if (IsPensioneer()) {
            k = Helper.getRandom(1, 2); // коэффициент пенсионера, в среднем 1,5
        }
        return k;
    }
}
