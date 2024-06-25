/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allan.server.controller;

import java.util.ArrayList;

public class ClientManager {

    ArrayList<Client> clients;

    public ClientManager() {
        clients = new ArrayList<>();
    }

    public boolean add(Client c) {
        if (!clients.contains(c)) {
            clients.add(c);
            return true;
        }
        return true;
    }

    public boolean remove(Client c) {
        if (clients.contains(c)) {
            clients.remove(c);
            return true;
        }
        return false;
    }

    public Client find(String email) {
        for (Client c : clients) {
            if (c.getLoginPlayer() != null && c.getLoginPlayer().getEmail().equals(email)) {
                return c;
            }
        }
        return null;
    }

    public void broadcast(String msg) {
        clients.forEach((c) -> {
            c.sendData(msg);
        });
    }

    public Client findClientFindingMatch() {
        for (Client c : clients) {
            if (c.isFindingMatch()) {
                return c;
            }
        }

        return null;
    }
    
    public Client findClientJoinedRoom(String roomId) {
        for (Client c: clients) {
            System.out.println(c.joinedRoom.getId());
            if (c.joinedRoom.getId() == roomId) {
                return c;
            }
        }
        
        return null;
    }

    public int getSize() {
        return clients.size();
    }
}
