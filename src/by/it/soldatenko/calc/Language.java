package by.it.soldatenko.calc;

import java.util.Locale;
import java.util.ResourceBundle;

class Language {


   public static ResourceBundle bundle;
   public static void setLocale(Locale l){

       String BASE= Language.class.getName().replace(Language.class.getSimpleName(), "")+"resources.language";
       bundle=ResourceBundle.getBundle(BASE, l);
    }
    public static String get(String key){
        return bundle.getString(key);
    }


}
