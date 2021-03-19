package by.it.plehanova.calc;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Lang {
    INSTANCE;
    private static final String PATH= "by.it.plehanova.calc.resources.language";
    ResourceBundle bundle;

    Lang(){
        setLocale(Locale.getDefault());
    }
    public Locale getLocale() {
        return bundle.getLocale();
    }
    final void setLocale(Locale locale){
        bundle = ResourceBundle.getBundle(PATH,locale);
    }
    public String get(String key){
        return bundle.getString(key);
    }
}
