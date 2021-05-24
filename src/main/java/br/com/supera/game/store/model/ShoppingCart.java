package br.com.supera.game.store.model;

import br.com.supera.game.store.constants.Constants;
import br.com.supera.game.store.utils.ComparatorUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products = new ArrayList<>();
    private BigDecimal freight = BigDecimal.ZERO;
    private BigDecimal total =BigDecimal.ZERO;
    private BigDecimal subTotal = BigDecimal.ZERO;
    private Integer userId;

    public void addProduct(Product product) {
        this.products.add(product);
        this.subTotal = subTotal.add(product.getPrice());
        setFreight(products.size(),subTotal);
        setTotal(subTotal,freight);

    }

    public void remove(Long id) {
        for (Product product: products){
            if (id.equals(product.getId())) {
                products.remove(product);
                this.subTotal = subTotal.subtract(product.getPrice());
                setFreight(products.size(),subTotal);
                break;
            }
        }
        setTotal(subTotal,freight);
    }

    private void setTotal(BigDecimal subTotal , BigDecimal freight){
        if (subTotal.intValue()<= Constants.VALUE_LIMIT_TO_DISCONT_FREIGHT){
            this.total = subTotal.add(freight);
        }else{
            this.total = subTotal;
        }

    }

    private void setFreight(Integer numberProducts,BigDecimal subTotal ){
        if (subTotal.intValue()<=Constants.VALUE_LIMIT_TO_DISCONT_FREIGHT){
            this.freight = BigDecimal.valueOf(numberProducts).multiply(Constants.FREIGHT_VALUE);
        }
        else {
            this.freight =BigDecimal.ZERO;
        }
    }

    public void sortProducts(String attribute,Boolean ascending){
        ComparatorUtils comparator = new ComparatorUtils(attribute,ascending);
        products.sort(comparator);
    }
    public BigDecimal getTotal(){
        return total;
    }
    public BigDecimal getFreight(){
        return freight;
    }
    public List<Product> getProducts(){
        return products;
    }

    public void setUserId(Integer id){
        this.userId=id;
    }
    public Integer getUserId(){
        return userId;
    }

    public BigDecimal getSubTotal(){return  subTotal;}
}
