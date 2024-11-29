package uz.pdp.ecommercejsp.servlet;

import uz.pdp.ecommercejsp.entity.Product;
import uz.pdp.ecommercejsp.repo.ProductRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@WebServlet("/file/*")
public class FileServlet extends HttpServlet {
    static String absolutPath = "C:/java/PDP java/7-modul-jsp/E-commerce-jsp/target/E-commerce-jsp-1.0-SNAPSHOT";
    static String absolutPathForGet = "C:/java/PDP java/7-modul-jsp/E-commerce-jsp/files/";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        String photoPath = pathInfo.split("/")[1];
        String url=absolutPathForGet+photoPath;
        resp.getOutputStream().write(Files.readAllBytes(Path.of(url)));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("ProductImage");
        Files.write(Path.of(absolutPath + "files/" + part.getSubmittedFileName() + ".jpg"), part.getInputStream().readAllBytes(), StandardOpenOption.CREATE_NEW);
    }
}
