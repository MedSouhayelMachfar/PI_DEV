/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 *
 * @author Nawres
 */
public class sendSMS {
    public static final String ACCOUNT_SID = System.getenv("AC1aefcf79b6a7fe78f7b0a742908aa113");
    public static final String AUTH_TOKEN = System.getenv("d6c9ddcfbca66d42bf77d4146397b252");
   

    public static void sendSMS() {
        Twilio.init("AC1aefcf79b6a7fe78f7b0a742908aa113", "d6c9ddcfbca66d42bf77d4146397b252");
        Message message = Message.creator(new PhoneNumber("+21654111636"),
                new PhoneNumber("+19897188312"),
                "events valide").create();
        System.out.println(message.getSid());
       
    }
}
