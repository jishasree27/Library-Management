package com.pojo;

import com.twilio.Twilio;
import com.twilio.converter.Promoter;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.net.URI;
import java.math.BigDecimal;
public class twilio {
  // Find your Account Sid and Token at twilio.com/console
	 public static final String ACCOUNT_SID = "AC293281e16ad2126888a97c32d9660005"; 
	    public static final String AUTH_TOKEN = "[AuthToken]";   

	    public static void main(String[] args) {
	        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

	        Message message = Message.creator(
	                new PhoneNumber("+18777804236"),  
	                new PhoneNumber("+Your_Twilio_Number"), 
	                "Hello! This is a test message from Twilio.") 
	                .create();

	        System.out.println("Message SID: " + message.getSid());
  }
}

