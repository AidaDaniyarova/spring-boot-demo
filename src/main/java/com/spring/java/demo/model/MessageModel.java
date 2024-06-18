package com.spring.java.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MESSAGE")
public class MessageModel {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "MESSAGE_TEXT")
    private String message;
    @Column(name = "TIME_SENT")
    private String time;
    @Column(name = "SENDER_ID")
    private String senderID;
    @Column(name = "RECEIVER_ID")
    private String receiverID;

    public MessageModel(String message, String time, String senderID, String receiverID) {
        this.message = message;
        this.time = time;
        this.senderID = senderID;
        this.receiverID = receiverID;
    }
}
