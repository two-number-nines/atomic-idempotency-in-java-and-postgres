package com.mycompany.app.handler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.mycompany.app.repository.AccountRepository;

public class AccountHandler implements HttpHandler {

    private AccountRepository accountRepo;

    // the easiest form of dep injection happens here
    public AccountHandler(AccountRepository repo) {
        this.accountRepo = repo;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        try {

            String method = exchange.getRequestMethod();
            if (!"GET".equals(method)) {
                exchange.getResponseHeaders().set("Allow", "GET");
                exchange.sendResponseHeaders(405, -1);
                return;
            }

            URI uri = exchange.getRequestURI();

            String[] urlPathStrings = uri.getPath().split("/");
            String urlSuffix = urlPathStrings[urlPathStrings.length - 1];
            int requestedAccountId = Integer.parseInt(urlSuffix);

            String account = accountRepo.getAccountById(requestedAccountId).toString();
            byte[] responseBytes = account.getBytes();
            exchange.sendResponseHeaders(200, responseBytes.length);

            OutputStream outputStream = exchange.getResponseBody();
            outputStream.write(responseBytes);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            exchange.sendResponseHeaders(500, 0);
            exchange.close();
        }
    }
}
