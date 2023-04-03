import java.nio.charset.Charset;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class EchoServerHandler extends ChannelInboundHandlerAdapter {
    // 클라이언트가 데이터를 전송하면 자동으로 실행
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        String readMessage = ((ByteBuf) msg).toString(Charset.defaultCharset());
        System.out.println("Received message [" + readMessage + "]");
        ctx.write(msg); //클라이언트로부터 입력받은 데이터를 그대로 클라이언트에 돌려줌
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush(); //channelRead이벤트 처리완료 후 자동 수행. 채널 파이프라인에 저장된 버퍼를 전송함
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
