package br.com.supera.game.store.model;

public class CreditCard {


    private String cardNumber;
    private Integer expirationMonth;
    private Integer expirationYaer;
    private Integer cvv;
    private String flag;
    private String cardHolder ;

    public CreditCard(){}


    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(Integer expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public Integer getExpirationYaer() {
        return expirationYaer;
    }

    public void setExpirationYaer(Integer expirationYaer) {
        this.expirationYaer = expirationYaer;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }
}
