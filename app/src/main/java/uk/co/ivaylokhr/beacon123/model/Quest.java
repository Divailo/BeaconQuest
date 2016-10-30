package uk.co.ivaylokhr.beacon123.model;

/**
 * Created by Ivaylo on 29/10/2016.
 */

public class Quest {

    private String string1, string2, string3;

    public Quest(String string1, String string2, String string3){
        this.string1 = string1; this.string2 = string2; this.string3 = string3;
    }

    public String getString1(){
        return string1;
    }

    public String getString2(){
        return string2;
    }

    public String getString3(){
        return string3;
    }
}
