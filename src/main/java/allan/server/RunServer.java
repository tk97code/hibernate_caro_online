/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allan.server;

import allan.server.controller.Admin;
import allan.server.controller.Client;
import allan.server.controller.ClientManager;
import allan.server.controller.RoomManager;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import allan.shared.security.RSA;

public class RunServer {

    public static volatile ClientManager clientManager;
    public static volatile RoomManager roomManager;
    public static volatile RSA serverSide;
    public static boolean isShutDown = false;
    public static ServerSocket ss;

    public RunServer() {

        try {
            int port = 5056;

            ss = new ServerSocket(port);
            System.out.println("Created Server at port " + port + ".");

            // init rsa key
            serverSide = new RSA()
                    .preparePrivateKey("D:\\IntelliJ_Java\\hibernate_caro_online\\src\\main\\java\\allan\\server\\rsa_keypair\\privateKey");

            // init managers
            clientManager = new ClientManager();
            roomManager = new RoomManager();

            // create threadpool
            ThreadPoolExecutor executor = new ThreadPoolExecutor(
                    10, // corePoolSize
                    100, // maximumPoolSize
                    10, // thread timeout
                    TimeUnit.SECONDS,
                    new ArrayBlockingQueue<>(8) // queueCapacity
            );

            // admin
            executor.execute(new Admin());

            // server main loop - listen to client's connection
            while (!isShutDown) {
                try {
                    // socket object to receive incoming client requests
                    Socket s = ss.accept();
                    // System.out.println("+ New Client connected: " + s);

                    // create new client runnable object
                    Client c = new Client(s);
                    clientManager.add(c);

                    // execute client runnable
                    executor.execute(c);

                } catch (IOException ex) {
                    // Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    isShutDown = true;
                }
            }

            System.out.println("shutingdown executor...");
            executor.shutdownNow();

        } catch (IOException ex) {
            Logger.getLogger(RunServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        new RunServer();
    }
}
