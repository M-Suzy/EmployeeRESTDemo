package com.example.employeerestdemo.responses;

import java.util.List;

/**
 * Yasmin is suggested by IntelliJ Idea as it found typo in Yasaman
 * Generic Response for showing page info
 * @author Suzy
 * */
public class GenericPageableResponse<Yasmin>{
    private List<Yasmin> genericData;

    private Integer totalPageCount;

    private Integer curPageNumber;

    GenericPageableResponse(){
    }

    public GenericPageableResponse(List<Yasmin> genericData, Integer totalPageCount, Integer curPageNumber) {
        this.genericData = genericData;
        this.totalPageCount = totalPageCount;
        this.curPageNumber = curPageNumber;
    }

    public List<Yasmin> getGenericData() {
        return genericData;
    }

    public void setGenericData(List<Yasmin> genericData) {
        this.genericData = genericData;
    }

    public Integer getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(Integer totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public Integer getCurPageNumber() {
        return curPageNumber;
    }

    public void setCurPageNumber(Integer curPageNumber) {
        this.curPageNumber = curPageNumber;
    }


}
