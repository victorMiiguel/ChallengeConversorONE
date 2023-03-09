package challengeConversor;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurrencyConverter {

	 private static final Map<String, Double> EXCHANGE_RATE = new HashMap<>();

	    static {
	    	
	        EXCHANGE_RATE.put("USD_BRL", 5.24);
	        EXCHANGE_RATE.put("USD_EUR", 0.95);
	        EXCHANGE_RATE.put("USD_GBP", 0.84);
	        EXCHANGE_RATE.put("USD_CLP", 801.40);
	        EXCHANGE_RATE.put("USD_ARS", 199.67);
	        EXCHANGE_RATE.put("USD_JPY", 136.78);
	        EXCHANGE_RATE.put("BRL_USD", 0.19);
	        EXCHANGE_RATE.put("BRL_EUR", 0.18);
	        EXCHANGE_RATE.put("BRL_GBP", 0.16);
	        EXCHANGE_RATE.put("BRL_CLP", 154.41);
	        EXCHANGE_RATE.put("BRL_ARS", 38.47);
	        EXCHANGE_RATE.put("BRL_JPY", 26.35);
	        EXCHANGE_RATE.put("EUR_USD", 1.05);
	        EXCHANGE_RATE.put("EUR_BRL", 5.49);
	        EXCHANGE_RATE.put("EUR_GBP", 0.89);
	        EXCHANGE_RATE.put("EUR_CLP", 848.12);
	        EXCHANGE_RATE.put("EUR_ARS", 211.31);
	        EXCHANGE_RATE.put("EUR_JPY", 144.75);
	        EXCHANGE_RATE.put("GBP_USD", 1.18);
	        EXCHANGE_RATE.put("GBP_BRL", 6.16);
	        EXCHANGE_RATE.put("GBP_EUR", 1.12);
	        EXCHANGE_RATE.put("GBP_CLP", 951.66);
	        EXCHANGE_RATE.put("GBP_ARS", 237.10);
	        EXCHANGE_RATE.put("GBP_JPY", 162.42);
	        EXCHANGE_RATE.put("CLP_USD", 0.0012);
	        EXCHANGE_RATE.put("CLP_BRL", 0.0064);
	        EXCHANGE_RATE.put("CLP_EUR", 0.0011);
	        EXCHANGE_RATE.put("CLP_GBP", 0.0010);
	        EXCHANGE_RATE.put("CLP_ARS", 0.24);
	        EXCHANGE_RATE.put("CLP_JPY", 0.17);
	        EXCHANGE_RATE.put("ARS_USD", 0.0050);
	        EXCHANGE_RATE.put("ARS_BRL", 0.0062);
	        EXCHANGE_RATE.put("ARS_EUR", 0.0047);
	        EXCHANGE_RATE.put("ARS_GBP", 0.0042);
	        EXCHANGE_RATE.put("ARS_CLP", 4.01);
	        EXCHANGE_RATE.put("ARS_JPY", 0.68);
	        EXCHANGE_RATE.put("JPY_USD", 0.0073);
	        EXCHANGE_RATE.put("JPY_BRL", 0.0379);
	        EXCHANGE_RATE.put("JPY_EUR", 0.0069);
	        EXCHANGE_RATE.put("JPY_GBP", 0.0061);
	        EXCHANGE_RATE.put("JPY_CLP", 5.85);
	        EXCHANGE_RATE.put("JPY_ARS", 1.45);

	    }
	    
	    public static String convertCurrency(String fromCurrency, String toCurrency, double value) {
	    	if(fromCurrency.isEmpty()) {
	    		if(toCurrency.isEmpty()) {
	    			return "";
	    		} else {
	    			return "";
	    		}
	    	} else if (!fromCurrency.isEmpty()) {
	    		if(toCurrency.isEmpty()) {
	    			return "";
	    		}
			}
	    	String baseCurrencyCode = extractCurrencyCode(fromCurrency);
	        String targetCurrencyCode = extractCurrencyCode(toCurrency);
	        double exchangeRate = getExchangeRate(baseCurrencyCode, targetCurrencyCode);
	        double convertedValue = value * exchangeRate;
	        return formatCurrency(convertedValue) + " " + toCurrency;
	    }

	    private static String extractCurrencyCode(String currency) {
	        Matcher matcher = Pattern.compile("\\((.*?)\\)").matcher(currency);
	        return matcher.find() ? matcher.group(1) : "";
	    }

	    private static double getExchangeRate(String baseCurrencyCode, String targetCurrencyCode) {
	        String rateKey = baseCurrencyCode + "_" + targetCurrencyCode;	        
	        return EXCHANGE_RATE.getOrDefault(rateKey, 1.00);
	    }

	    private static String formatCurrency(double value) {
	        DecimalFormat formatter = new DecimalFormat("#.00");
	        return formatter.format(value);
	    }
}
