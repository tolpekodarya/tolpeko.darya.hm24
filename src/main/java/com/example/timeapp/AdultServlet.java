import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/age")
public class AgeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html; charset=UTF-8");

        String ageParameter = request.getParameter("age");

        if (ageParameter == null || ageParameter.isEmpty()) {
            response.getWriter().println("Укажите возраст: /age?age=18" );
            return;
        }

        try {
            int age = Integer.parseInt(ageParameter);

            if (age < 0) {
                response.getWriter().println("Возраст не может быть отрицательным.");
            } else if (age >= 18) {
                response.getWriter().println("Вы совершеннолетний.");
            } else {
                response.getWriter().println("Вы несовершеннолетний.");
            }
        }
        catch (NumberFormatException e) {
            response.getWriter().println("Возраст должен быть целым числом.");
        }
    }
}
