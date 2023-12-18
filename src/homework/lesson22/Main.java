package homework.lesson22;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.ZoneId;

@WebServlet(urlPatterns = {"/minsk", "/washington", "/beijing", "/age"})

public class Main extends HttpServlet {
    private PrintWriter pw;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        pw = response.getWriter();
        String path = request.getServletPath();

        LocalTime lc = null;

        if(path.equals("/minsk")){
            try{
                pw.println(lc.now(ZoneId.of("Europe/Minsk")).toString());
            } finally {
                pw.close();
            }
        } else if (path.equals("/washington")){
            try{
                pw.println(lc.now(ZoneId.of("America/New_York")).toString());
            } finally {
                pw.close();
            }
        } else if (path.equals("/beijing")) {
            try {
                pw.println(lc.now(ZoneId.of("Asia/Shanghai")).toString());
            } finally {
                pw.close();
            }
        }else if(path.equals("/age")){
            int age;
                age = Integer.parseInt(request.getParameter("age"));
                System.out.println(age);
                if(age > 17){
                    pw.write("больше 18 лет");
                } else{
                    pw.write("меньше 18");
                }





        }

    }




}
