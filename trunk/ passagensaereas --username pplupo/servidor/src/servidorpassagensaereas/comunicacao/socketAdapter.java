/*
 * clientSocket.java
 *
 * Created on 10 de Novembro de 2007, 05:17
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package servidorpassagensaereas.comunicacao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 *
 * @author leone
 */
public class socketAdapter {
    
    private java.net.Socket socket;
    private DataOutputStream out;
    private DataInputStream in;

    /** Creates a new instance of clientSocket */
    public socketAdapter() {
        socket = new java.net.Socket();
    }
    
    public void assign(Socket aSocket) throws IOException {
        socket = aSocket;
        in  = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
    }
    
    private byte [] intToByte(int aValue) {
        byte[] bIntValue = new byte[4];
        bIntValue[3] = (byte)((aValue >>> 24) & 0xFF);
        bIntValue[2] = (byte)((aValue >>> 16) & 0xFF);
        bIntValue[1] = (byte)((aValue >>> 8) & 0xFF);
        bIntValue[0] = (byte)((aValue >>> 0) & 0xFF);
        return bIntValue;
    }
    
    private byte[] booleanToByte(boolean aValue) {
        byte[] bBoolean = new byte[1];
        if (aValue) bBoolean[0] = 1;
        else bBoolean[0] = 0;
        return bBoolean;
    } 
    
    private byte[] stringToByte(String aValue) {
        byte [] bValue = new byte[0];
        try {
            bValue = aValue.getBytes("UTF-8");
        } catch (UnsupportedEncodingException ex) {}        
        return bValue;
    }
    
    private int byteToInt(byte[] aValue) {
        int iResultado = 0;
        iResultado |= (aValue[3] << 24) & 0x0FF000000;
        iResultado |= (aValue[2] << 16) & 0x0FF0000;
        iResultado |= (aValue[1] << 8 ) & 0x0FF00;
        iResultado |= (aValue[0] << 0 ) & 0x0FF;
        return iResultado;        
    }
    
    private boolean byteToBoolean(byte[] aValue) {
        return (aValue[0] == 1);       
    }
    
    private String byteToString(byte [] aValue) {
        String sResultado = "";
        try {
            sResultado = new String( aValue, "UTF-8" );
        } catch (UnsupportedEncodingException ex) {}
        return sResultado;        
    }
    
    public boolean connectTo(String ip, int port) {
        boolean result = true;
        try {
            socket.connect(new InetSocketAddress(InetAddress.getByName(ip), port));
            in  = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }
    
    public void sendInt(int aValue) throws IOException {
        sendBuffer(intToByte(aValue));
    }
    
    public void SendString(String aValue) throws IOException {
        sendInt(aValue.length());
        sendBuffer(stringToByte(aValue));
    }
    
    public void sendBoolean(boolean aValue) throws IOException {        
        sendBuffer(booleanToByte(aValue));
    }
    
    public void sendBuffer(byte[] buffer) throws IOException {
        out.write(buffer);
    }
    
    public byte[] readBuffer(int length) throws IOException {
        byte[] resultado = new byte[length];
        in.read(resultado, 0, length);
        return resultado;        
    }
    
    public int readInt() throws IOException{
        return byteToInt(readBuffer(4));
    }
    
    public String readString() throws IOException {
        int iSize = readInt();
        return byteToString(readBuffer(iSize));
    }
    
    public boolean readBoolean() throws IOException {
        return byteToBoolean(readBuffer(1));
    }
    
}
