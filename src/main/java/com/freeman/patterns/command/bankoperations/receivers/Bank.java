package com.freeman.patterns.command.bankoperations.receivers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bank {

    private String bankName;

    public void send(){
//        System.out.println("Money was sent: ");
    }

    public void receive(){
//        System.out.println("Money was received: ");
    }
}
