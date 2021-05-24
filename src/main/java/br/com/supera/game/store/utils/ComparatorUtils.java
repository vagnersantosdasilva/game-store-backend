package br.com.supera.game.store.utils;

import org.apache.commons.beanutils.PropertyUtils;

import java.util.Comparator;

public class ComparatorUtils implements Comparator<Object> {

    private String attribute;
    private Boolean ascending;

    public ComparatorUtils(String attribute, Boolean ascending){
        this.attribute=attribute;
        this.ascending=ascending;
    }

    public ComparatorUtils(){}

    public int compare(Object o , Object t)  {
        try {
            Object object1 = PropertyUtils.getProperty(o, attribute);
            Object object2 = PropertyUtils.getProperty(t, attribute);
            if (object1 instanceof Comparable && object2 instanceof Comparable){
                Comparable comparable1 = (Comparable) object1;
                Comparable comparable2 = (Comparable) object2;

                if(ascending) return comparable1.compareTo(comparable2);
                return comparable2.compareTo(comparable1);
            }

            if  (object1 == object2) return 0;
            return  -1;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;

    }

    public String getAttribute(){
        return attribute;
    }

    public void setAttribute(String attribute){
        this.attribute=attribute;
    }



}