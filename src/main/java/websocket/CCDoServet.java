package websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/websocket/cc/{un}/{up}", configurator = GetHttpSessionConfigurator.class)
public class CCDoServet {

    private final static AtomicInteger onlineCount = new AtomicInteger(0);
    private static List<CCDoServet> clients = new ArrayList<>();
    private Session session;
    private HttpSession httpSession;
//  ngs static int userid ; 

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) throws IOException, InterruptedException {
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaa");
        this.session = session;
        this.httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
        clients.add(this);  //当前客户端加入集合
        CCDoServet.onlineCount.incrementAndGet();//在线数加1
        sendMessage("打开");//向此用户发送一条最新的偷菜记录
    }

    @OnClose
    public void onClose() throws IOException, InterruptedException {
        clients.remove(this);  //从set中删除
        CCDoServet.onlineCount.decrementAndGet();//在线数减1
        System.out.println("close");

    }

    @OnMessage
    public void onMessage(String message, EndpointConfig config) throws IOException, InterruptedException {
        sendMessage(session.getId());
        Map<String, String> pp = session.getPathParameters();
        pp.forEach((k,v)->{
            try {
                this.sendMessage(k+"//"+v);
            } catch (IOException ex) {
                Logger.getLogger(CCDoServet.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    @OnError
    public void onError(Throwable t) throws Throwable {
        System.out.println("error");
    }

    /**
     * 发送消息给客户端
     *
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException {
        //自己和自己对话
        try {
            this.session.getAsyncRemote().sendText(message);//异步
        } catch (Exception e) {
        }
    }

//    /**
//     * 给某个用户发送消息
//     *
//     * @param userName
//     * @param message
//     */
//    public void sendMessageToUser(String userName, String message) {
//        for (CCDoServet client : clients) {
//            if (client.getAttributes().get("websocket_username").equals(userName)) {
//                try {
//                    client.sendMessage(message);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                break;
//            }
//        }
//    }

    /*广播：遍历客户端集，发送消息，注意发送要用的session，用session.getBasicRemote().sendText(msg)发送消息*/
    public static void broadcast(String msg) {
        for (CCDoServet client : clients) {//遍历所有  
            try {//如果这个client已经在线  
                synchronized (client) {
                    client.session.getBasicRemote().sendText(msg);//发送消息  
                }
            } catch (IOException e) {//如果这个client不在线  
//                   log.debug("Chat Error: 向用户"+client.getUser().getUsername()+"发送消息失败", e);  
                clients.remove(client);
                try {
                    client.session.close();
                } catch (IOException e1) {
                    // Ignore  
                }
//                   String message = String.format("-- %s %s", client.user.getUsername(), "已经下线.");  
//                   broadcast(message);
            }
        }
    }

    /**
     * @触发事件 @param msg
     * @param pa1
     */
    public void triggerEvent(String msg) {
        try {
            onMessage(msg, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取当前在线人数
     *
     * @return
     */
    public static int currentOnline() {
        return onlineCount.get();
    }
}
