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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class MessageManagerTest {
    private MessageManager1 manager;

    @BeforeEach
    public void setUp() {
        // Initialize a new MessageManager instance
        manager = new MessageManager1();
        
        // Adding some test messages before each test runs
        manager.addMessage(new Part3message("+27834557896", "Did you get the cake?", "Sent", "MSG001", "H001"));
        manager.addMessage(new Part3message("+27838884567", "Where are you?", "Stored", "MSG002", "H002"));
        manager.addMessage(new Part3message("+27834484567", "Yohoooo, I'm here!", "Disregard", "MSG003", "H003"));
        manager.addMessage(new Part3message("Admin", "Dinner time!", "Sent", "MSG004", "H004"));
    }

    @Test
    public void testAddMessage() {
        // Verify that messages can be added
        assertEquals(2, manager.generateSentMessageReport().size()); // Initially 2 sent messages
        manager.addMessage(new Part3message("+27812345678", "Hello!", "Sent", "MSG005", "H005"));
        assertEquals(3, manager.generateSentMessageReport().size()); // Now 3 sent messages
    }

    @Test
    public void testFindLongestSentMessage() {
        // Check that the longest sent message is correctly identified
        Part3message longestMessage = manager.findLongestSentMessage();
        assertNotNull(longestMessage);
        assertEquals("Did you get the cake?", longestMessage.getMessage());
    }

    @Test
    public void testFindMessageById() {
        // Test finding an existing message by ID
        Part3message foundMessage = manager.findMessageById("MSG001");
        assertNotNull(foundMessage);
        assertEquals("Did you get the cake?", foundMessage.getMessage());
        
        // Ensure that a non-existent ID returns null
        Part3message notFoundMessage = manager.findMessageById("MSG999");
        assertNull(notFoundMessage);
    }

    @Test
    public void testGetMessagesForRecipient() {
        // Validate that messages can be retrieved for a specific recipient
        List<Part3message> messages = manager.getMessagesForRecipient("+27834557896");
        assertEquals(1, messages.size());
        assertEquals("Did you get the cake?", messages.get(0).getMessage());
        
        // Check that no messages are returned for a non-existent recipient
        List<Part3message> noMessages = manager.getMessagesForRecipient("+27800000000");
        assertTrue(noMessages.isEmpty());
    }

    @Test
    public void testDeleteMessageByHash() {
        // Confirm that a message can be deleted by its hash
        boolean deleted = manager.deleteMessageByHash("H001");
        assertTrue(deleted);
        assertNull(manager.findMessageById("MSG001")); // Should not be found anymore
        
        // Check that trying to delete a non-existent message returns false
        boolean notDeleted = manager.deleteMessageByHash("H999");
        assertFalse(notDeleted);
    }

    @Test
    public void testGenerateSentMessageReport() {
        // Ensure that the report generation returns the correct number of messages
        List<String> report = manager.generateSentMessageReport();
        assertEquals(4, report.size()); // 2 messages * 2 lines each (message + separator)
        assertTrue(report.get(0).contains("Did you get the cake?"));
        assertTrue(report.get(1).contains("Dinner time!"));
    }
}
