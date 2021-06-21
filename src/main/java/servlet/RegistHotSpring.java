package servlet;

//自分が格納されているフォルダの外にある必要なクラス
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import model.Sample;
import model.HotSpring;
import service.SampleService;

/** 
@author O.SATO
*/

@WebServlet("/RegistHotSpring")

// HttpServletを継承することで、このクラスはServletとして、働くことができる

public class RegistHotSpring extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/registHotSpring.jsp");
      dispatcher.forward(request, response);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");

      String name = request.getParameter("name");
      int star = Integer.parseInt(request.getParameter("star"));
      String comment = request.getParameter("comment");

      HotSpring hotSpring = new HotSpring();
      hotSpring.setName(name);
      hotSpring.setStar(star);
      hotSpring.setComment(comment);





      

      

    }

}
