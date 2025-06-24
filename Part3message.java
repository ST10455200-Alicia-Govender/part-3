/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.part3message;

//Code Attribution
//OpenAI. (2025). ChatGPT (April 2025 version) [Large language model].
//https.//chat.openai.com/

/**
 *
 * @author lab_services_student
 */
public class Part3message {
    private final String recipient;
    private final String message;
    private final String flag;
    private final String messageId;
    private final String messageHash;
    
    public Part3message(String recipient, String message, String flag, 
                   String messageId, String messageHash) {
        this.recipient = recipient;
        this.message = message;
        this.flag = flag;
        this.messageId = messageId;
        this.messageHash = messageHash;
     }

// Getters 
public String getRecipient(){
    return recipient;
}

public String getMessage(){
        return message;
}
public String getFlag(){
    return flag;
}
 public String getMessageId(){
     return messageId;
     
 }
 public String getMessageHash(){
     return messageHash;
 }
    @Override
    public String toString() {
        return String.format("Recipient: %s\nMessage: %s\nFlag: %s\nID: %s\nHash: %s",
            recipient, message, flag, messageId, messageHash
        );
    }
}

