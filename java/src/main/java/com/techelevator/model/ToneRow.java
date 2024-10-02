package com.techelevator.model;

public class ToneRow {

    private int id;
    private String name;
    private int startingPitchValue;
    private int pZero;
    private int pOne;
    private int pTwo;
    private int pThree;
    private int pFour;
    private int pFive;
    private int pSix;
    private int pSeven;
    private int pEight;
    private int pNine;
    private int pTen;
    private int pEleven;
    private int user_id;

    public ToneRow(int id, String name, int startingPitchValue, int pZero, int pOne, int pTwo, int pThree, int pFour, int pFive, int pSix,
                   int pSeven, int pEight, int pNine, int pTen, int pEleven, int userId) {
        this.id = id;
        this.name = name;
        this.startingPitchValue = startingPitchValue;
        this.pZero = pZero;
        this.pOne = pOne;
        this.pTwo = pTwo;
        this.pThree = pThree;
        this.pFour = pFour;
        this.pFive = pFive;
        this.pSix = pSix;
        this.pSeven = pSeven;
        this.pEight = pEight;
        this.pNine = pNine;
        this.pTen = pTen;
        this.pEleven = pEleven;
        this.user_id = userId;
    }

    public ToneRow() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStartingPitchValue() {
        return startingPitchValue;
    }

    public int getpZero() {
        return pZero;
    }

    public int getpOne() {
        return pOne;
    }

    public int getpTwo() {
        return pTwo;
    }

    public int getpThree() {
        return pThree;
    }

    public int getpFour() {
        return pFour;
    }

    public int getpFive() {
        return pFive;
    }

    public int getpSix() {
        return pSix;
    }

    public int getpSeven() {
        return pSeven;
    }

    public int getpEight() {
        return pEight;
    }

    public int getpNine() {
        return pNine;
    }

    public int getpTen() {
        return pTen;
    }

    public int getpEleven() {
        return pEleven;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartingPitchValue(int startingPitchValue) {
        this.startingPitchValue = startingPitchValue;
    }

    public void setpZero(int pZero) {
        this.pZero = pZero;
    }

    public void setpOne(int pOne) {
        this.pOne = pOne;
    }

    public void setpTwo(int pTwo) {
        this.pTwo = pTwo;
    }

    public void setpThree(int pThree) {
        this.pThree = pThree;
    }

    public void setpFour(int pFour) {
        this.pFour = pFour;
    }

    public void setpFive(int pFive) {
        this.pFive = pFive;
    }

    public void setpSix(int pSix) {
        this.pSix = pSix;
    }

    public void setpSeven(int pSeven) {
        this.pSeven = pSeven;
    }

    public void setpEight(int pEight) {
        this.pEight = pEight;
    }

    public void setpNine(int pNine) {
        this.pNine = pNine;
    }

    public void setpTen(int pTen) {
        this.pTen = pTen;
    }

    public void setpEleven(int pEleven) {
        this.pEleven = pEleven;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
