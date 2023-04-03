import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class BlockingServer {
    public static void main(String[] args) throws IOException {
        BlockingServer server = new BlockingServer();
        server.run();
    }

    private void run() throws IOException {
        ServerSocket server = new ServerSocket(8888);
        System.out.println("Waiting for connection...");

        while (true) {
            Socket sock = server.accept(); //블로킹 소켓을 이용했으므로 클라이언트가 연결될 때까지 대기하게 됨
            System.out.println("Client connected.");

            OutputStream out = sock.getOutputStream();
            InputStream in = sock.getInputStream();

            while (true) {
                try {
                    int request = in.read(); //데이터를 읽기 위해 클라이언트로부터 입력이 있을 때까지 대기
                    out.write(request); //OS의 송신 버퍼에 전송할 데이터 기록. 송신버퍼의 남은 크기가 write메소드에서 기록한 크기보다 작으면, 송신버퍼가 비워질 때까지 블로킹됨
                } catch (IOException ex) {
                    break;
                }
            }
        }
    }
}
