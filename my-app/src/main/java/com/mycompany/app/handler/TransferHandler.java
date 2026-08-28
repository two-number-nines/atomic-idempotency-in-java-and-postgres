package com.mycompany.app.handler;

import java.io.IOException;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class TransferHandler implements HttpHandler {
    String idemPotentKey = null;
    String receiveAccount = null;
    int amount = 0;

    // need the db repository in the init

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        
    }


}
