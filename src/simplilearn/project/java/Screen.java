package simplilearn.project.java;

public interface Screen {
	public final String path_main = System.getProperty("user.dir") + "/main/";

	public void showMenuOptions();

	public void menuTask();

	public String getUserInput();
}
