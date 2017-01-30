package controller.i18n;



import util.constants.Attributes;

import java.util.Locale;

/**
  *
 * @author Daniil Volkov
 * @see Locale
 */
public class LocaleHolder {

    private Locale currentLocale;


    public static final Locale[] SUPPORTED = { new Locale(Attributes.EN, Attributes.EN.toUpperCase()),
            new Locale(Attributes.RU, Attributes.RU.toUpperCase()),
            new Locale(Attributes.UA, Attributes.UA.toUpperCase()) };

    /**
     * Default locale
     */
    public static final Locale DEFAULT = new Locale(Attributes.EN, Attributes.EN.toUpperCase());

    public LocaleHolder(Locale currentLocale) {
        this.currentLocale = currentLocale;
    }

    public Locale getCurrentLocale() {
        return currentLocale;
    }

    public void setCurrentLocale(Locale currentLocale) {
        this.currentLocale = currentLocale;
    }
}
