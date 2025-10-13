package com.inher.quest4;

import java.util.Arrays;

public class CommMain {

	/**
	 * Too lazy to use Scanner here, again!
	 */

	public static void main(String[] args) {
		Communication comm;
		
		comm = new MailCommunication();
		comm.sendMessage();
		MailCommunication mailComm = (MailCommunication) comm;
		System.out.println(Arrays.toString(mailComm.showTypes()));
		
		System.out.println();
		
		comm = new PhoneCommunication();
		comm.sendMessage();
		PhoneCommunication phoneComm = (PhoneCommunication) comm;
		phoneComm.callService();
		
		System.out.println();

		comm = new SMSCommunication();
		comm.sendMessage();
		SMSCommunication smsComm = (SMSCommunication) comm;
		smsComm.messageLength();
		
		System.out.println();
		
		comm = new WhatsappCommunication();
		comm.sendMessage();
		WhatsappCommunication whatsappComm = (WhatsappCommunication) comm;
		whatsappComm.otherFeatures();
	}
}
