

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChatJPanel extends JPanel implements ActionListener{
    private final JLabel chatRoomId = new JLabel();
    private final JTextArea chatArea = new JTextArea();
    private final JTextField chatField = new JTextField();
    private final JScrollPane chatAreaScrollPane = new JScrollPane(chatArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
    private final ChatUser chatUser;
    
    public ChatJPanel(String adress, String DBName, String DBTable, 
            String SQLUserName, String SQLPassword,
            int roomId, String chatUserName){
        
        this.chatRoomId.setText("Room_ID: "+roomId);
        chatUser = new ChatUser(adress, DBName, DBTable, SQLUserName, SQLPassword, roomId, chatUserName);
        
        System.out.println(chatUser.isTableReady()+"hello");
        
        chatArea.setEditable(false);
        chatField.addActionListener(this);
        this.setLayout(new BorderLayout());
        this.add(chatRoomId, BorderLayout.NORTH);
        this.add(chatAreaScrollPane, BorderLayout.CENTER);
        this.add(chatField, BorderLayout.SOUTH);
        this.setPreferredSize(new Dimension(300, 400));
        
        if (chatUser.isConnectoinReady() && chatUser.isTableReady()){
            chatUser.autoUpdateLocalChat(chatArea);
        }
    }
    
    public ChatUser getChatUser(){
        return chatUser;
    }public JTextArea getChatArea(){
        return chatArea;
    }public JTextField getChatField(){
        return chatField;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        String message = chatField.getText();
        chatField.setText("");
        if (!message.isBlank()){
            chatUser.sendMessageToDB(message);
        }
    }
}