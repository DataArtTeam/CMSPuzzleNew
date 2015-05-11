package authorization;

import javax.mail.MessagingException;

public class TestSendMessage {
	public static void main(String[] args) {
		try {
			new SendMessage().sendMessage("Diesel31ks@mail.ru", "asd", "asdd");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
