import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class NonBlockingServer {
    private final Map<SocketChannel, List<byte[]>> keepDataTrak = new HashMap<>();
    private final ByteBuffer buffer = ByteBuffer.allocate(2 * 1024);

    private void startEchoServer() {
        try (
            Selector selector = Selector.open();
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open(); //논블로킹이 가능한 서버소켓채널을 생성함
        ) {
            if ((serverSocketChannel.isOpen()) && (selector.isOpen())) { //Selector와 serverSocketChannel이 정상생성되었는지 확인
                serverSocketChannel.configureBlocking(false); //미설정 시 블로킹 모드로 동작함
                serverSocketChannel.bind(new InetSocketAddress(8888)); //이제 8888포트로 클라이언트 연결 가능해짐

                serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT); //Selector는 이제 연결 요청을 감지함
                System.out.println("Waiting for connection...");

                while (true) {
                    selector.select(); //selector에 아무런 i/o도 발생하지 않았다면 여기서 블로킹됨. 블로킹을 원하지않는다면 selectNow메소드 사용할 것
                    Iterator<SelectionKey> keys = selector.selectedKeys().iterator(); //selector에 등록된 채널 중 i/o가 발생한 채널 목록 조회

                    while (keys.hasNext()) {
                        SelectionKey key = keys.next();
                        keys.remove(); //동일한 이벤트가 감지되는 것을 방지하기 위해 제거

                        if (!key.isValid()) {
                            continue;
                        }

                        if (key.isAcceptable()) { //연결 요청 이벤트면 연결처리 메소드로 이동
                            this.acceptOP(key, selector);
                        } else if(key.isReadable()) { //데이터 수신 이벤트면 데이터 읽기처리 메소드로 이동
                            this.readOP(key);
                        } else if (key.isWritable()) { //데이터 쓰기 이벤트면 데이터 쓰기처리 메소드로 이동
                            this.writeOP(key);
                        }
                    }
                }
            } else {
                System.out.println("Failed to create server socket.");
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private void acceptOP(SelectionKey key, Selector selector) throws IOException {
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
        SocketChannel socketChannel = serverSocketChannel.accept();
        socketChannel.configureBlocking(false);

        System.out.println("Connected client : " + socketChannel.getRemoteAddress());

        keepDataTrak.put(socketChannel, new ArrayList<>());
        socketChannel.register(selector, SelectionKey.OP_READ); //클라이언트 소켓 채널을 selector에 등록해 i/o감시
    }

    private void readOP(SelectionKey key) {
        try {
            SocketChannel socketChannel = (SocketChannel) key.channel();
            buffer.clear();

            int numRead = -1;
            try {
                numRead = socketChannel.read(buffer);
            } catch (IOException e) {
                System.err.println("Data read error!");
            }

            if (numRead == -1) {
                this.keepDataTrak.remove(socketChannel);
                System.out.println("Client connection ended." + socketChannel.getRemoteAddress());
                socketChannel.close();
                key.cancel();
                return;
            }

            byte[] data = new byte[numRead];
            System.arraycopy(buffer.array(), 0, data, 0, numRead);
            System.out.println(new String(data, StandardCharsets.UTF_8) + " from " + socketChannel.getRemoteAddress());

            doEchoJob(key, data);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private void writeOP(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();

        List<byte[]> channelData = keepDataTrak.get(socketChannel);
        Iterator<byte[]> its = channelData.iterator();

        while (its.hasNext()) {
            byte[] it = its.next();
            its.remove();

            socketChannel.write(ByteBuffer.wrap(it));
        }

        key.interestOps(SelectionKey.OP_READ);
    }

    private void doEchoJob(SelectionKey key, byte[] data) {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        List<byte[]> channelData = keepDataTrak.get(socketChannel);
        channelData.add(data);

        key.interestOps(SelectionKey.OP_WRITE);
    }

    public static void main(String[] args) {
        NonBlockingServer main = new NonBlockingServer();
        main.startEchoServer();
    }
}
