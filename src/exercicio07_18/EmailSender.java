package exercicio07_18;

public interface EmailSender {
	public boolean isOffline();

	public int sendEmail(String email, String title, String body);

}
