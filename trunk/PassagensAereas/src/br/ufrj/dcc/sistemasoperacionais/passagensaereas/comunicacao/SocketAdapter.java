package br.ufrj.dcc.sistemasoperacionais.passagensaereas.comunicacao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SocketAdapter {

	private java.net.Socket socket;
	private DataOutputStream out;
	private DataInputStream in;

	public SocketAdapter() {
		socket = new java.net.Socket();
	}
	
	public SocketAdapter(Socket socket) throws IOException {
		in = new DataInputStream(socket.getInputStream());
		out = new DataOutputStream(socket.getOutputStream());
	}

	public boolean connectTo(String ip, int port) throws ConnectException {
		boolean result = true;
		try {
			socket.connect(new InetSocketAddress(InetAddress.getByName(ip), port));
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
		} catch (IOException ex) {
			ex.printStackTrace();
			result = false;
		}
		return result;
	}

	public void sendInt(int value) throws IOException {
		out.writeInt(value);
	}

	public void sendString(String value) throws IOException {
		out.writeUTF(value);
	}

	public void sendBoolean(boolean value) throws IOException {
		out.writeBoolean(value);
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
	
	public Protocolo getComando() throws IOException {
		return Protocolo.getProtocolo(in.readInt());
	}
	
	public void sendComando(Protocolo protocolo) throws IOException {
		sendInt(protocolo.getComando());
	}

}