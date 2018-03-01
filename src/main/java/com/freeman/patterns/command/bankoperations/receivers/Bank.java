package com.freeman.patterns.command.bankoperations.receivers;

import lombok.Data;

@Data
public class Bank {

    private String bankName;

//    public Bank(String bankName) {
//        this.bankName = bankName;
//    }

    public void send(){
//        System.out.println("Money was sent: ");
    }

    public void receive(){
//        System.out.println("Money was received: ");
    }
}
