//package com.Innobyte.QuizManagementService.service;
//
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//
//import org.springframework.stereotype.Service;
//
//@Service
//public class WebSocketService {
//    private final SimpMessagingTemplate messagingTemplate;
//
//    public WebSocketService(SimpMessagingTemplate messagingTemplate) {
//        this.messagingTemplate = messagingTemplate;
//    }
//
//    public void sendFeedback(String attemptId, boolean isCorrect) {
//        messagingTemplate.convertAndSend("/topic/feedback/" + attemptId, isCorrect ? "Correct!" : "Incorrect!");
//    }
//}
