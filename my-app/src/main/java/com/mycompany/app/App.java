package com.mycompany.app;
import java.io.IOException;
import java.net.InetSocketAddress;

import com.mycompany.app.config.DatabaseConfig;
import com.mycompany.app.handler.AccountHandler;
import com.mycompany.app.handler.HomeHandler;
import com.mycompany.app.repository.AccountRepository;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;


public class App {
    public static void main(String[] args) throws IOException {

        // Server
        HttpServer server = HttpServer.create(new InetSocketAddress(8008), 0);
        HttpContext context = server.createContext("/");
        HttpContext accountContext = server.createContext("/account");

        // Database
        DatabaseConfig databaseConfig = new DatabaseConfig();

        // Repositories
        AccountRepository accountRepository = new AccountRepository(databaseConfig);
        
        // Handlers
        AccountHandler accountHandler = new AccountHandler(accountRepository);
        HomeHandler homeHandler = new HomeHandler();

        accountContext.setHandler(accountHandler);
        context.setHandler(homeHandler);

        server.start();
    }
}
