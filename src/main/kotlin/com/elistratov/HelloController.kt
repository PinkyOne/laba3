package com.elistratov

import java.nio.file.Files
import java.nio.file.Paths
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "Hello", value = "/hello")
class HelloController : HttpServlet() {
    override fun doGet(req: HttpServletRequest, res: HttpServletResponse) {
        res.contentType = "text/html"
        var html = Files.readAllLines(
                Paths.get("C://Users//Alex//Desktop//servlet-web-applications//src//main//index.html"))
        for(line in html){
            res.writer.print(line)
        }
    }
}