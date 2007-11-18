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
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * 
 * @author leone
 */
public class SocketAdapter {

	private java.net.Socket socket;
	private DataOutputStream out;
	private DataInputStream in;

	public SocketAdapter() {
		socket = new java.net.Socket();
	}
	
	/** Creates a new instance of clientSocket 
	 * @throws IOException */
	public SocketAdapter(Socket socket) throws IOException {
		in = new DataInputStream(socket.getInputStream());
		out = new DataOutputStream(socket.getOutputStream());
	}

	public boolean connectTo(String ip, int port) {
		boolean result = true;
		try {
			socket.connect(new InetSocketAddress(InetAddress.getByName(ip), port));
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
		} catch (Exception ex) {
			ex.printStackTrace();
			result = false;
		}
		return result;
	}

	public void sendInt(int aValue) throws IOException {
		out.writeInt(aValue);
	}

	public void sendString(String aValue) throws IOException {
		out.writeUTF(aValue);
	}

	public void sendBoolean(boolean aValue) throws IOException {
		out.writeBoolean(aValue);
	}

	public void sendBuffer(byte[] buffer) throws IOException {
		out.write(buffer);
	}

	public byte[] readBuffer(int length) throws IOException {
		byte[] resultado = new byte[length];
		in.readFully(resultado);
		return resultado;
	}

	public int readInt() throws IOException {
		return in.readInt();
	}

	public String readString() throws IOException {
		return in.readUTF();
	}

	public boolean readBoolean() throws IOException {
		return in.readBoolean();
	}

}