package com.bs.sys.webSocket;

import com.alibaba.fastjson.JSONObject;
import com.bs.sys.entity.Message;
import com.bs.sys.service.MessageService;
import com.bs.sys.service.UserServiceInf;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;


/**
 * @ServerEndpoint 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端,
 * 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端
 * @author uptop
 */
@ServerEndpoint("/websocketMsg/{userId}")
@Component
public class WebSocketMsg {

    String username="";
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    public static int onlineCount = 0;
    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    public static CopyOnWriteArraySet<WebSocketMsg> webSocketSet = new CopyOnWriteArraySet<WebSocketMsg>();

    public static HashMap<Integer,String> idandnameMap=new HashMap<Integer, String>();
    public static ConcurrentHashMap<Integer,Session> websocketMap=new ConcurrentHashMap<Integer, Session>();
    //定义一个数组，用于存放所有的登录用户,显示在聊天页面的用户列表栏中
    public  static List<String> names=new ArrayList<String>();
    public  static List<Integer> ids=new ArrayList<Integer>();
    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    private int userId;
//    @Autowired
//    UserServiceImpl userServic1e;
//    @Autowired
//    MessageServiceImpl messageServi1ce;
    private UserServiceInf userService = (UserServiceInf) ContextLoader.getCurrentWebApplicationContext().getBean("userService");
    private MessageService messageService=(MessageService) ContextLoader.getCurrentWebApplicationContext().getBean("messageService");
    /**
     * 连接建立成功调用的方法
     *
     * @param session 可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(@PathParam("userId")String userId, Session session) {
        this.session = session;
        //将当前连接上的用户session信息全部存到scokets中
        Message message0=new Message();
        message0.setFromId(1);
        message0.setToId(2);
        message0.setMessageText("nihao");
        message0.setMessageId(1);
        System.out.println(JSONObject.toJSONString(message0));
        webSocketSet.add(this);
        try {
            int userid_int=Integer.parseInt(userId);
            this.userId=userid_int;
            ids.add(userid_int);
            this.websocketMap.put(userid_int,session);
            String nickname=userService.findbyid(userid_int).getUserName();
            this.username=nickname;
            names.add(nickname);
            idandnameMap.put(userid_int,nickname);
            System.out.println("用户"+nickname+"进入聊天室");
            Message message = new Message();
            message.setAlert("用户"+nickname+"进入聊天室");
            //将当前所有登录用户存入到message中，用于广播发送到聊天页面
            message.setNames(names);
            //将聊天信息广播给所有通信管道(sockets)
            broadcast(webSocketSet, JSONObject.toJSON(message).toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        addOnlineCount();           //在线数加1
        System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
        System.out.println("new connection ,now the num is " + getOnlineCount());
    }
    /*
     * 广播消息
     */
    public void broadcast(Set<WebSocketMsg> sockets , String msg){
        //遍历当前所有的连接管道，将通知信息发送给每一个管道
        for(WebSocketMsg socket : sockets){
            try {
                //通过session发送信息
                socket.session.getBasicRemote().sendText(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        //移除退出登录用户的通信管道
        webSocketSet.remove(this);
        //将用户名从names中剔除，用于刷新好友列表
        names.remove(this.username);
        idandnameMap.remove(userId);
        Message message = new Message();
        System.out.println("用户"+this.username+"退出聊天室");
        message.setAlert(this.username+"退出当前聊天室！！！");
        //刷新好友列表
        message.setNames(names);
        broadcast(webSocketSet, JSONObject.toJSON(message).toString());
        subOnlineCount();           //在线数减1
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
        System.out.println("one connection is closed,now the num is " + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     * @param session 可选的参数
     * @throws IOException
     */
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        // 把客户端的消息解析为JSON对象并入库
        Message message1=  JSONObject.parseObject(message,Message.class);
        // 在消息中添加发送日期
        message1.setMessageDate(System.currentTimeMillis());
        Date nowTime = new Date(System.currentTimeMillis());
        SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String retStrFormatNowDate = sdFormatter.format(nowTime);
        message1.setFormatDate(retStrFormatNowDate);
//        message1.setFromName(userService.findbyid(message1.getFromId()).getUserName());
        messageService.addmessage(message1);
        //将客户端消息转成json对象
        //如果是群聊，就像消息广播给所有人
        if(message1.getType()==1){
            Message message2 = new Message();
            message2.setMessageDate(System.currentTimeMillis());
            message2.setFromName(this.username);
            message2.setMessageText(message1.getMessageText());
            broadcast(webSocketSet, JSONObject.toJSON(message).toString());
        }else{
            Message message3 = new Message();
            message3.setMessageDate(System.currentTimeMillis());
            message3.setFromName(this.username);
//            message3.setAlert(vo.getMsg());
            message3.setMessageText("<font color=red>正在私聊你：</font>"+message1.getMessageText());
            int to  = message1.getToId();
            //根据单聊对象的名称拿到要单聊对象的Session
            Session to_session = this.websocketMap.get(to);
            //如果是单聊，就将消息发送给对方
            to_session.getBasicRemote().sendText(JSONObject.toJSON(message).toString());
        }
    }
    /**
     * 发生错误时调用
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

    /**
     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
     *
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);

    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketMsg.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketMsg.onlineCount--;
    }


    public void sendMsg(String msg) {

    }


}
