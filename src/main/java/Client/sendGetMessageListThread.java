package Client;

public class sendGetMessageListThread implements Runnable {
    private int a = 0;
    @Override
    public void run() {

        boolean success = MessageHandler.getInstance().getNewMessageList();
        System.out.println(success);

    }
}
