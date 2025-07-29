package com.thetestingacdemy.ex_02_RA_Concepts;

public class APITesting_Lab04_NP {
    public APITesting_Lab04_NP step1(){
        System.out.println("Step1");
        return this;
    }
    public APITesting_Lab04_NP step2(){
        System.out.println("Step2");
        return this;
    }
    public APITesting_Lab04_NP step3(){
        System.out.println("Step3");
        return this;
    }

    public static void main(String[] args) {
        APITesting_Lab04_NP np=new APITesting_Lab04_NP();
        np.step1().step2().step3();
    }
}
