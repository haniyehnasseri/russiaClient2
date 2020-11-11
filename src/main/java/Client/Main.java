/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.ws.BindingProvider;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import service.RU.*;

/**
 *
 * @author @AmirShk
 */

public class Main {


    public static void main(String[] args) throws IOException {


        /* GET MESSAGE LIST THREAD */
        ScheduledExecutorService thread = Executors.newSingleThreadScheduledExecutor();
        thread.scheduleAtFixedRate(new sendGetMessageListThread(), 0, 30, TimeUnit.SECONDS);
        /* GET MESSAGE LIST THREAD */

        System.out.println("Enter commands : ");
        while (true){
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            String command = myObj.nextLine();  // Read user input
            String[] commandDetails = command.split("\\s+");
            switch (commandDetails[0]){
                case "sendMessage":
                    String fXmlPath = "src/main/resources/" + commandDetails[1];
                    File fXmlFile = new File(fXmlPath);
                    String type = commandDetails[2];
                    boolean success1 = MessageHandler.getInstance().sendMessage(fXmlFile,fXmlPath,type);
                    System.out.println(success1);
                    break;
                // probably changed in future
                case "confirmEnvelope":
                    boolean success3 = MessageHandler.getInstance().confirmMessage(commandDetails[1]);
                    System.out.println(success3);
                    break;
                case "getMessageBody":
                    boolean success4 = MessageHandler.getInstance().getMessageBody(commandDetails[1]);
                    System.out.println(success4);
                    break;
                // probably changed in future
            }
        }
    }



}
