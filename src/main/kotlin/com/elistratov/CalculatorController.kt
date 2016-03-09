package com.elistratov

import java.nio.file.Paths
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "calcKT", value = "/calc")
class CalculatorController : HttpServlet() {
    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
       servletContext
               .getRequestDispatcher("/calculator.jsp")
               .forward(req,resp)
        System.out.println(Paths.get("calculator.jsp").toAbsolutePath())
    }
}