package mobile.tiy.chatclientandroid;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Godfather on 5/11/2016.
 */
public class AndroidChatClientTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testSendMessage() throws Exception {
        AndroidChatClient chatClient = new AndroidChatClient();
        String messageToSend = "afkjasdjllkadsf;jl asdsfl jad";
        String expectedResponse = "echo::" + messageToSend;
        String serverResponse = chatClient.sendMessage(messageToSend);
//        assertNotNull(serverResponse);
        assertEquals(expectedResponse, serverResponse);
    }
}