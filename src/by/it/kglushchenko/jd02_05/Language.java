package by.it.kglushchenko.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Language {
    INSTANCE;

    private final String BASE = "by.it.kglushchenko.jd02_05.resources.language";
    ResourceBundle bundle;

    Language() {
        setLocale(Locale.getDefault());
    }

    final void setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle(BASE, locale);
    }

    public Locale getLocale() {
        return bundle.getLocale();
    }

    String get(String key) {
        return bundle.getString(key);
    }
}