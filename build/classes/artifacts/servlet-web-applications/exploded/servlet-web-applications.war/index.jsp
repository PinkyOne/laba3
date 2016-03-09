<%@ page import="helpers.SaverSingleton" %>
<?xml version="1.0" encoding="UTF-8" ?>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String action = request.getParameter("action");
    String firstS = request.getParameter("first") == null
            ? SaverSingleton.getInstance().getFirst()
            : request.getParameter("first");
    String secondS = request.getParameter("second") == null
            ? SaverSingleton.getInstance().getSecond()
            : request.getParameter("second");
    String result = "";

    try {
        double first = Double.parseDouble(firstS);
        double second = Double.parseDouble(secondS);

        switch (action) {
            case "add": {
                result = first + " + " + second + " = " + String.valueOf(first + second);
            }
            break;
            case "sub": {
                result = first + " - " + second + " = " + String.valueOf(first - second);
            }
            break;
            case "multiply": {
                result = first + " * " + second + " = " + String.valueOf(first * second);
            }
            break;
            case "divide": {
                result = first + " / " + second + " = " + String.valueOf(first / second);
            }
            break;
            default: {
            }
        }
        SaverSingleton.getInstance().setParameters(firstS, secondS);
    } catch (Exception e) {
        if (!firstS.isEmpty() || !secondS.isEmpty())
            pageContext.forward("/error");
    } finally {

    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Калькулятор</title>
</head>
<body>
<form action="" method="get">
    <div>
        <input type="text" name="first" value="<%= firstS %>"/>
        <input type="text" name="second" value="<%= secondS %>"/>
        =
        <input type="text" readonly="readonly" value="<%= result %>"/>
        <hr/>
        <button name="action" value="add">+</button>
        <button name="action" value="sub">-</button>
        <button name="action" value="multiply">*</button>
        <button name="action" value="divide">/</button>
    </div>
</form>
</body>
</html>