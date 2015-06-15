package access.providers;

import context.ContentList;
import hibernate.dao.ContentDao;
import hibernate.daoImpl.ContentDaoImpl;
import hibernate.tables.Content;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContentListProvider {

    private static final int AMOUNT_ON_PAGE = 5;
    private static final int NUMBER_FIRST_PAGE = 1;

    public String getContentsByNumber(int pageNumber){
        ArrayList<Content> contents = fillContents(pageNumber);
        String contentsInString = getStringJSON(contents);
        return contentsInString;
    }


    private ArrayList<Content> fillContents(int pageNumber ){
        ArrayList<Content> contents = new ArrayList<>();
        ContentList contentList = new ContentList();
        if(pageNumber > 1 ){
            contents = contentList.getContents(AMOUNT_ON_PAGE, pageNumber);
        }
        else {
            contents = contentList.getContents(AMOUNT_ON_PAGE, NUMBER_FIRST_PAGE);
        }
        return contents;
    }


    private int getAmountOnPage(int amountPage, ContentList contentList){
        int residue = contentList.sizeList%AMOUNT_ON_PAGE;
        if(residue == 0){
            amountPage = contentList.sizeList/AMOUNT_ON_PAGE;
        }
        else {
            amountPage = contentList.sizeList/AMOUNT_ON_PAGE +1;
        }
        return amountPage;
    }

    private String getStringJSON(ArrayList<Content> contents){

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");

        int arraySize = contents.size();
        int currentNumber = 1;

        for (Content content: contents){
            stringBuffer.append(content.getStringJSON(1));
            if(currentNumber < arraySize){
                stringBuffer.append(",");
                currentNumber ++;
            }
        }

        stringBuffer.append("]");

        return stringBuffer.toString();

    }
}
