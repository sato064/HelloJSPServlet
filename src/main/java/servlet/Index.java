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
import service.SampleService;

@WebServlet("/index")
// HttpServletを継承することで、このクラスはServletとして、働くことができる
public class Index extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      SampleService sampleService = new SampleService();
      List<Sample> sampleList = sampleService.getSample();
      request.setAttribute("sampleList", sampleList);
      RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/sample/index.jsp");
      dispatcher.forward(request, response);
    }
}
