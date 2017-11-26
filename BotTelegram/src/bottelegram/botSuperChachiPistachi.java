package bottelegram;
import com.vdurmont.emoji.EmojiParser; //https://emojipedia.org/
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.objects.PhotoSize;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
/**
 *
 * @author Fernando
 */

public class botSuperChachiPistachi extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables
            String user_first_name = update.getMessage().getChat().getFirstName();
            String user_last_name = update.getMessage().getChat().getLastName();
            long user_id = update.getMessage().getChat().getId();
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            String answer = EmojiParser.parseToUnicode("A palabras necias pollazo en la boca :eggplant: ");
            SendMessage message = new SendMessage() // Create a message object object
                    .setChatId(chat_id)
                    .setText(answer);
            log(user_first_name, user_last_name, Long.toString(user_id), message_text, answer);
            try {
                execute(message); // Sending our message object to user
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public String getBotUsername(){
        
        return "Doskoybot";   
    }
    
    @Override
    public String getBotToken(){
        //Todo
        return "458678466:AAF6m8fG5P3hLtLsENh8ZKKIw7lcnN5Myfk";
    }
    
    private void log(String first_name, String last_name, String user_id, String txt, String bot_answer) {
        System.out.println("\n ----------------------------");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        System.out.println("Message from " + first_name + " " + last_name + ". (id = " + user_id + ") \n Text - " + txt);
        System.out.println("Bot answer: \n Text - " + bot_answer);
    }
}





/*
public void onUpdateReceived(Update update) {

        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables
            String user_first_name = update.getMessage().getChat().getFirstName();
            String user_last_name = update.getMessage().getChat().getLastName();
            String user_username = update.getMessage().getChat().getUserName();
            long user_id = update.getMessage().getChat().getId();
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            String answer = message_text;
            SendMessage message = new SendMessage() // Create a message object object
                    .setChatId(chat_id)
                    .setText(answer);
            log(user_first_name, user_last_name, Long.toString(user_id), message_text, answer);
            try {
                execute(message); // Sending our message object to user
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
}
*/






























//Bot de photos y teclados con cosas
/*
public class botSuperChachiPistachi extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update){
        //The update has a message with text?
        if(update.hasMessage() && update.getMessage().hasText()){
            //if the message is correct we get the text and the chatId
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            if(message_text.equals("/start")){
                //User Sent /start
                SendMessage message = new SendMessage() //create the msg
                        .setChatId(chat_id)
                        .setText("Hola juapo!");
                try {
                    execute(message); 
                } catch (TelegramApiException e){
                    e.printStackTrace();
                }
            } else if (message_text.equals("/pic")) {
                SendPhoto msg = new SendPhoto()
                        .setChatId(chat_id)
                        .setPhoto("AgADBAADjqwxGwNz0FDMfg-mzd2563AvJhoABMHEo_tQebPB44YAAgI")
                        .setCaption("ñeñeñe");
                   try{
                        sendPhoto(msg);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
            } else if(message_text.equals("/markup")){
                SendMessage message = new SendMessage()
                        .setChatId(chat_id)
                        .setText("here is your keyboard");
                //replykeyboard object
                ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
                
                List<KeyboardRow> keyboard = new ArrayList<>();
                //KB row
                KeyboardRow row = new KeyboardRow();
                // Set each button
                
                row.add("Pene");
                row.add("pito");
                row.add("tranca");
                
                keyboard.add(row);
                
                row = new KeyboardRow();
                
                row.add("caca");
                row.add("troncho");
                row.add("Truño Morruño");
                
                keyboard.add(row);
                
                keyboardMarkup.setKeyboard(keyboard);
                message.setReplyMarkup(keyboardMarkup);
                
                try {
                    execute(message); 
                } catch (TelegramApiException e){
                    e.printStackTrace();
                }
            
            } else if (message_text.equals("Pene") || message_text.equals("pito")
                    || message_text.equals("caca") || message_text.equals("tranca")
                    || message_text.equals("troncho") || message_text.equals("Truño Morruño")) {
                SendMessage message = new SendMessage()
                        .setChatId(chat_id)
                        .setText("Wow! Soo rude man! ");
                try {
                    execute(message); 
                } catch (TelegramApiException e){
                    e.printStackTrace();
                }
            
            }else if(message_text.equals("/hide")) {
                SendMessage msg = new SendMessage()
                        .setChatId(chat_id)
                        .setText("keyboard hidden");
                ReplyKeyboardRemove keyboardMarkup = new ReplyKeyboardRemove();
                msg.setReplyMarkup(keyboardMarkup);
                try {
                    execute(msg); // Call method to send the photo
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                 }
            } else{
                //unknown command
                
                SendMessage message = new SendMessage()
                        .setChatId(chat_id)
                        .setText("Unknown command");
                try {
                    execute(message); 
                } catch (TelegramApiException e){
                    e.printStackTrace();
                }
            }

        } else if(update.hasMessage() && update.getMessage().hasPhoto()){
            long chat_id = update.getMessage().getChatId();
            
            // Array with photo objects with different sizes
            // We will get the biggest photo from that array
            List<PhotoSize> photos = update.getMessage().getPhoto();
            
            // Know file_id
            String f_id = photos.stream()
                    .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
                    .findFirst()
                    .orElse(null).getFileId();
            
            // Know photo height
            int f_height = photos.stream()
                    .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
                    .findFirst()
                    .orElse(null).getHeight();
            
            // Know photo width
            
            int f_width = photos.stream()
                    .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
                    .findFirst()
                    .orElse(null).getWidth();
            
            //Set photo caption
            String caption = "file_id: " + f_id + "\nwidth: " + Integer.toString(f_width) + "\nheight: " + Integer.toString(f_height);
            SendPhoto msg = new SendPhoto()
                    .setChatId(chat_id)
                    .setPhoto(f_id)
                    .setCaption(caption);
        
            try{
                sendPhoto(msg);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        
        }
    }
    
    @Override
    public String getBotUsername(){
        
        return "Doskoybot";   
    }
    
    @Override
    public String getBotToken(){
        //Todo
        return "458678466:AAF6m8fG5P3hLtLsENh8ZKKIw7lcnN5Myfk";
    }
}

*/











//Echo bot: devuelve lo mismo que le digas
/*
public class botSuperChachiPistachi extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update){
        //The update has a message with text?
        if(update.hasMessage() && update.getMessage().hasText()){
            //if the message is correct we get the text and the chatId
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            
            //Create a message
            SendMessage message = new SendMessage()
                    .setChatId(chat_id).setText(message_text);
            
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        
        }
            
    }
    
    @Override
    public String getBotUsername(){
        
        return "Doskoybot";   
    }
    
    @Override
    public String getBotToken(){
        //Todo
        return "458678466:AAF6m8fG5P3hLtLsENh8ZKKIw7lcnN5Myfk";
    }
}
*/