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
public class Socket2 {
    
    private java.net.Socket socket;
    private DataOutputStream out;
    private DataInputStream in;

    /** Creates a new instance of clientSocket */
    public Socket2() {
        socket = new java.net.Socket();
    }
    
    public void Assign(Socket aSocket) throws IOException {
        socket = aSocket;
        in  = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
    }
    
    private byte [] IntToByte(int aValue) {
        byte[] bIntValue = new byte[4];
        bIntValue[3] = (byte)((aValue >>> 24) & 0xFF);
        bIntValue[2] = (byte)((aValue >>> 16) & 0xFF);
        bIntValue[1] = (byte)((aValue >>> 8) & 0xFF);
        bIntValue[0] = (byte)((aValue >>> 0) & 0xFF);
        return bIntValue;
    }
    
    private byte[] BooleanToByte(boolean aValue) {
        byte[] bBoolean = new byte[1];
        if (aValue) bBoolean[0] = 1;
        else bBoolean[0] = 0;
        return bBoolean;
    } 
    
    private byte[] StringToByte(String aValue) {
        byte [] bValue = new byte[0];
        try {
            bValue = aValue.getBytes("UTF-8");
        } catch (UnsupportedEncodingException ex) {}        
        return bValue;
    }
    
    private int ByteToInt(byte[] aValue) {
        int iResultado = 0;
        iResultado |= (aValue[3] << 24) & 0x0FF000000;
        iResultado |= (aValue[2] << 16) & 0x0FF0000;
        iResultado |= (aValue[1] << 8 ) & 0x0FF00;
        iResultado |= (aValue[0] << 0 ) & 0x0FF;
        return iResultado;        
    }
    
    private boolean ByteToBoolean(byte[] aValue) {
        return (aValue[0] == 1);       
    }
    
    private String ByteToString(byte [] aValue) {
        String sResultado = "";
        try {
            sResultado = new String( aValue, "UTF-8" );
        } catch (UnsupportedEncodingException ex) {}
        return sResultado;        
    }
    
    public boolean ConnectTo(String ip, int port) {
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
    
    public void SendInt(int aValue) throws IOException {
        SendBuffer(IntToByte(aValue));
    }
    
    public void SendString(String aValue) throws IOException {
        SendInt(aValue.length());
        SendBuffer(StringToByte(aValue));
    }
    
    public void SendBoolean(boolean aValue) throws IOException {        
        SendBuffer(BooleanToByte(aValue));
    }
    
    public void SendBuffer(byte[] buffer) throws IOException {
        out.write(buffer);
    }
    
    public byte[] ReadBuffer(int length) throws IOException {
        byte[] resultado = new byte[length];
        in.read(resultado, 0, length);
        return resultado;        
    }
    
    public int ReadInt() throws IOException{
        return ByteToInt(ReadBuffer(4));
    }
    
    public String ReadString() throws IOException {
        int iSize = ReadInt();
        return ByteToString(ReadBuffer(iSize));
    }
    
    public boolean ReadBoolean() throws IOException {
        return ByteToBoolean(ReadBuffer(1));
    }
    
}
