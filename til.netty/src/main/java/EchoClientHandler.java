import java.nio.charset.Charset;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class EchoClientHandler extends ChannelInboundHandlerAdapter {
    @Override //소켓 채널이 최초 활성화되었을 때 실행됨
    public void channelActive(ChannelHandlerContext ctx) {
        String sendMessage = "Hello, Netty!";

        ByteBuf messageBuffer = Unpooled.buffer();
        messageBuffer.writeBytes(sendMessage.getBytes());

        System.out.println("Sent message [" + sendMessage + "]");
        ctx.writeAndFlush(messageBuffer);
        // writeAndFlush : 데이터 기록, 전송 두가지 메소드 호출
        // write : 채널에 데이터 기록
        // flush : 채널에 기록된 데이터를 서버로 전송
    }

    @Override //서버로부터 수신된 데이터가 있을 때 호출됨
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        String readMessage = ((ByteBuf) msg).toString(Charset.defaultCharset());
        System.out.println("Received message [" + readMessage + "]");
    }

    @Override //수신된 데이터를 모두 읽은 후 호출됨. channelRead수행 완료 후 실행
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.close(); //서버와 연결된 채널닫음
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
