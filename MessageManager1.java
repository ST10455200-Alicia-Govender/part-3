/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.part3message;

//Code Attribution
//OpenAI. (2025). ChatGPT (April 2025 version) [Large language model].
//https.//chat.openai.com/

/**
 *
 * @author lab_services_student
 */


import java.util.ArrayList;
import java.util.List;

/**
 * Manages the operations related to messages including storage, retrieval, and processing.
 */
public class MessageManager1 {
    private final List<Part3message> sentMessages = new ArrayList<>();
    private final List<Part3message> storedMessages = new ArrayList<>();
    private final List<Part3message> disregardedMessages = new ArrayList<>();

    /**
     * Adds a message to the appropriate list based on its flag.
     * @param message The message to add.
     */
    public void addMessage(Part3message message) {
        switch (message.getFlag()) {
            case "Sent" -> sentMessages.add(message);
            case "Stored" -> storedMessages.add(message);
            case "Disregard" -> disregardedMessages.add(message);
            default -> System.err.println("Unknown message flag: " + message.getFlag());
        }
    }

    /**
     * Finds the longest sent message by content length.
     * @return The longest message or null if no messages are sent.
     */
    public Part3message findLongestSentMessage() {
        if (sentMessages.isEmpty()) return null;

        Part3message longest = sentMessages.get(0);
        for (Part3message msg : sentMessages) {
            if (msg.getMessage().length() > longest.getMessage().length()) {
                longest = msg;
            }
        }
        return longest;
    }

    /**
     * Searches for a message by its ID.
     * @param messageId The ID to search for.
     * @return The found message or null if not found.
     */
    public Part3message findMessageById(String messageId) {
        for (Part3message msg : sentMessages) {
            if (msg.getMessageId().equals(messageId)) {
                return msg;
            }
        }
        for (Part3message msg : storedMessages) {
            if (msg.getMessageId().equals(messageId)) {
                return msg;
            }
        }
        return null; // Not found
    }

    /**
     * Gets all messages sent to a specific recipient.
     * @param recipient The recipient to search for.
     * @return List of messages sent to the recipient.
     */
    public List<Part3message> getMessagesForRecipient(String recipient) {
        List<Part3message> results = new ArrayList<>();
        for (Part3message msg : sentMessages) {
            if (msg.getRecipient().equals(recipient)) {
                results.add(msg);
            }
        }
        for (Part3message msg : storedMessages) {
            if (msg.getRecipient().equals(recipient)) {
                results.add(msg);
            }
        }
        return results;
    }

    /**
     * Deletes a message using its hash identifier.
     * @param messageHash The hash of the message to delete.
     * @return true if the message was found and deleted, false otherwise.
     */
    public boolean deleteMessageByHash(String messageHash) {
        // Try to remove from sent messages
        for (int i = 0; i < sentMessages.size(); i++) {
            if (sentMessages.get(i).getMessageHash().equals(messageHash)) {
                sentMessages.remove(i);
                return true;
            }
        }

        // Try to remove from stored messages
        for (int i = 0; i < storedMessages.size(); i++) {
            if (storedMessages.get(i).getMessageHash().equals(messageHash)) {
                storedMessages.remove(i);
                return true;
            }
        }

        return false; // Not found
    }

    /**
     * Generates a detailed report of all sent messages.
     * @return List of formatted message strings.
     */
    public List<String> generateSentMessageReport() {
        List<String> report = new ArrayList<>();
        for (Part3message msg : sentMessages) {
            report.add(msg.toString());
            report.add("----------"); // Separator for readability
        }
        return report;
    }
}
