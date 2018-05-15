package domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quotes {
    private String quote;
    private String author;

    public Quotes(){
        setAuthor("Robbe");
        setQuote("Beter een gat in u tafel, dan een tafel in u gat");
    }

    public Quotes(String quote, String author){
        setAuthor(author);
        setQuote(quote);
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
