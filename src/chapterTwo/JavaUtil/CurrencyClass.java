package src.chapterTwo.JavaUtil;

import java.util.Currency;
import java.util.Locale;

public class CurrencyClass {
    public static void main(String[] args) {
        Currency currency = Currency.getInstance(Locale.US);
        System.out.println("Symbol: " + currency.getSymbol());
        System.out.println("Default fraction digits: " + currency.getDefaultFractionDigits());
    }
}
