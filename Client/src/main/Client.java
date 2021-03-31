package main;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
  private PrintWriter writer;
  private Socket socket;

  public void start() {
    try {
      // 자기자신이 12345포트로 접속시도
      socket = new Socket("127.0.0.1", 12345);
      System.out.println("서버에 접속했습니다.");
      // 연결이 된 소켓에서 메시지를 보낼 수 있도록 하는 작업
      writer = new PrintWriter(socket.getOutputStream(), true);
      // 사용자 입력 받기
      Scanner scan = new Scanner(System.in);
      while (true) {
        writer.println(scan.next());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
