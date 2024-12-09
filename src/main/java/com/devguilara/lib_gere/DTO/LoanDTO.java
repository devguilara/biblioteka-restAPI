package com.devguilara.lib_gere.DTO;

public class LoanDTO {

    private String book;
    private boolean aval;

    public LoanDTO(String book, boolean aval){
        this.book = book;
        this.aval = aval;
    }

    public boolean isAval() {
        return aval;
    }

    public void setAval(boolean aval) {
        this.aval = aval;
    }

    public String getBookName() {
        return book;
    }

    public void setbook(String book) {
        this.book = book;
    }

}
