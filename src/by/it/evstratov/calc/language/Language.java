package by.it.evstratov.calc.language;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Language {

    INSTANCE;

    private final String BASE = "by.it.evstratov.calc.language.resources.language";
    ResourceBundle bundle;

    Language() {
        setLocale(Locale.getDefault());
    }

    public final void setLocale(Locale locale){
        this.bundle = ResourceBundle.getBundle(BASE, locale);
    }

    public String get(String key){
        return bundle.getString(key);
    }

    Locale getLocale(){
        return bundle.getLocale();
    }
}
