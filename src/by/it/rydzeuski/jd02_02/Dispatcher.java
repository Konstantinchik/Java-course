package by.it.rydzeuski.jd02_02;

 class Dispatcher {
     final static int K_SPEED=10000;
     final static int PLAN=100;
     private volatile static int bueyrsInMarket=0;
     private volatile static int bueyrsCompleted=0;

     static  void addBueyr(){
         synchronized (Dispatcher.class){
             bueyrsInMarket++;
         }
     }
     static synchronized void completeBueyr(){
         bueyrsInMarket--;
         bueyrsCompleted++;

     }
     static boolean marketIsOpened(){
         return bueyrsInMarket+bueyrsCompleted!=PLAN;
     }
     static boolean marketIsClosed(){
         return bueyrsCompleted==PLAN;
     }

}
