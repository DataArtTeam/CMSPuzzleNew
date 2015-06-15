package access.providers;


import hibernate.dao.FrontPageDao;
import hibernate.daoImpl.FrontPageDaoImpl;
import hibernate.tables.Content;
import hibernate.tables.FrontPage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FrontPageProvider {

    public String getContentInJson(){
        ArrayList<Content> contents = getFrontContent();
        String contentsInJSON = geJSONContent(contents);
        return contentsInJSON;
    }

    private ArrayList<Content> getFrontContent(){
        ArrayList<Content> contents = new ArrayList<>();
        FrontPageDao frontPageDao = new FrontPageDaoImpl();
        try {
            List<FrontPage> frontPageList = frontPageDao.getFrontPages();
            for (FrontPage frontPage: frontPageList){
                contents.add(frontPage.getContentId());
            }
        }
        catch (SQLException e){

        }

        return contents;
    }

    private String geJSONContent(ArrayList<Content> contents){

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        int arraySize = contents.size();
        int currentNumber = 1;
        for (Content content: contents){
            stringBuffer.append(content.getStringJSON(1));
            if(currentNumber < arraySize){
                stringBuffer.append(",");
                currentNumber++;
            }
        }

        stringBuffer.append("]");

        return stringBuffer.toString();
    }
}
