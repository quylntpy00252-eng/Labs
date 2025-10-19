package com.poly.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/lab3")
public class Lab3Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lấy tham số 'action' để xác định bài tập cần hiển thị
        String action = req.getParameter("action");
        String jspPage = "/index.jsp"; // Mặc định

        if ("core".equals(action)) {
            // Chuẩn bị dữ liệu cho Bài 1 & 2 (Đổ dữ liệu vào Select Box và Table)
            List<Country> list = List.of(
                new Country("VN", "Việt Nam"),
                new Country("US", "United States"),
                new Country("CN", "China")
            );
            req.setAttribute("countries", list);
            jspPage = "/jsp/lab3_core.jsp";
        } else if ("format".equals(action)) {
            // Chuẩn bị dữ liệu cho Bài 3 (Định dạng Thời gian và Số)
            Map<String, Object> map = new HashMap<>();
            map.put("name", "iPhone 2024");
            map.put("price", 12345.678);
            map.put("date", new Date());
            req.setAttribute("item", map);
            jspPage = "/jsp/lab3_format.jsp";
        } else if ("function".equals(action)) {
            // Chuẩn bị dữ liệu cho Bài 4 (Xử lý Chuỗi)
            Map<String, Object> map = new HashMap<>();
            map.put("title", "Tiêu đề bản tin");
            map.put("content", "Nội dung bản tin thường rất dài. Đây là một đoạn văn bản mẫu có độ dài vượt quá 100 ký tự để kiểm tra chức năng cắt chuỗi của JSTL function.");
            req.setAttribute("item", map);
            jspPage = "/jsp/lab3_function.jsp";
        } else {
             // Trang giới thiệu chung
             jspPage = "/jsp/lab3_menu.jsp";
        }

        req.getRequestDispatcher(jspPage).forward(req, resp);
    }
}


