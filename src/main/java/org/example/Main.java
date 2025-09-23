package org.example;

import java.net.http.HttpTimeoutException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TodoClient client = new TodoClient();
        try {
            client.request();
        }catch (Exception e){
            e.getMessage();
        }
    }
}