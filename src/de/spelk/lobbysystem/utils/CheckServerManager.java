package de.spelk.lobbysystem.utils;


import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class CheckServerManager {

    public static boolean isOnline(String server, Integer port) {
        try{
            Socket s = new Socket(server, port);
            s.close();
            return true;
        }catch(SocketException e){
            return false;
        } catch (UnknownHostException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
    }

}
