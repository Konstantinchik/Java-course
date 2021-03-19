package by.it.evstratov.jd02_01;

import java.util.*;

class Good {

 private String name;
 private int price;

 public Good(String name, int price) {
  this.name = name;
  this.price = price;
 }

 private static Map<String, Integer> goods = new HashMap<>();

  static{
   goods.put("Сосиски", 1000);
   goods.put("Хлеб", 400);
   goods.put("Яблоки", 1200);
   goods.put("Груша", 1400);
   goods.put("Конфеты", 3400);
   goods.put("Мясо", 5400);
  }

  public static Good takeRandomGood(){

   Good good = null;
   List<String> nameGoods = new ArrayList<>(goods.keySet());
   String randomGood = nameGoods.get(Helper.getRandom(0, nameGoods.size() -1));

   Iterator<Map.Entry<String, Integer>> entries = goods.entrySet().iterator();

   while (entries.hasNext()) {
    Map.Entry<String, Integer> entry = entries.next();
    if(entry.getKey().equals(randomGood)){
      good = new Good(entry.getKey(), entry.getValue());
    }
   }

   return good;

  }

 @Override
 public String toString() {
  return name + " по цене " + price;
 }
}
