package servlets.images;


import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/imagine")
public class ImagineServlet extends HttpServlet {

    private String imageName;
    private String imagePass;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)  {
        response.setContentType("image/jpeg");
        getParametersFromRequest(request);
        getFullImagePath();
        uploadImage(response);
    }

    private void getFullImagePath(){
        StringBuffer imagePassBufer = new StringBuffer();
        imagePassBufer.append("D:\\CMS\\png\\");
        imagePassBufer.append(imageName);
        imagePass = imagePassBufer.toString();
    }

    private void getParametersFromRequest(HttpServletRequest request){
        imageName = request.getParameter("imageName");
    }

    private void uploadImage(HttpServletResponse response){
        try {

            ServletOutputStream out = response.getOutputStream();
            FileInputStream fin = new FileInputStream(imagePass.toString());

            BufferedInputStream bin = new BufferedInputStream(fin);
            BufferedOutputStream bout = new BufferedOutputStream(out);
            int ch = 0;
            while ((ch = bin.read()) != -1) {
                bout.write(ch);
            }
            fin.close();
            bin.close();
            bout.close();
            out.close();
        }
        catch (IOException e){

        }
    }
}
