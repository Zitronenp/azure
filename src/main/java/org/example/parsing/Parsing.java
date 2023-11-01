package org.example.parsing;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Parsing {
    public static String parsing() {
        try {
            Document document = Jsoup.connect("https://rp5.ru/Погода_в_Екатеринбурге")
                    .userAgent("Chrome/4.0.249.0 Safari/532.5")
                    .referrer("http://www.google.com")
                    .get();
            Element contentElem = document.select("div > span.t_0").get(0);
            return contentElem.text();
        } catch (Exception e) {
        }
        return null;
    }
}