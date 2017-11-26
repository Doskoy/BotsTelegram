package bottelegram;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 *
 * @author Fernando
 */

public class BotTelegram {
    public static void main(String[] args) {
        //Initialize Api Context
        ApiContextInitializer.init();
        
        //Instantiate Telegram Bots API
        
        TelegramBotsApi botsApi = new TelegramBotsApi();
        
        //Register bot
        try{
            botsApi.registerBot(new botSuperChachiPistachi());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        System.out.println("Cacharro andando! :D ");
    }
    
}
