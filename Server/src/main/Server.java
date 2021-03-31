package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  private BufferedReader reader;
  private ServerSocket server = null;
  private Socket socket;

  public void start() {
    try {
      // 서버 활성화 (포트 12345 사용)
      server = new ServerSocket(12345);
      System.out.println("서버 활성화");
      while (true) {
        socket = server.accept(); // 연결 수용
        System.out.println(socket.getInetAddress() + "가 접속했습니다.");
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        getMessage();
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      // 통신 끝나고 자원 할당 해제
      try {
        if (reader != null)
          reader.close();
        if (socket != null)
          socket.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public void getMessage() {
    try {
      while (true) {
        System.out.println("클라이언트: " + reader.readLine());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
