package edu.simpson.webdevelopment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import com.google.gson.Gson;

@WebServlet(name = "name_list_get")
public class NameListGet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        List <Person> peopleList = PersonDAO.getPeople();
        out.print("[");
        boolean start = false;

        for (Person person : peopleList) {
            if (!start) {
                start = true;
                out.println();
            } else
                out.println(",");

            out.print("{\"id\":");
            out.print("\"");
            out.print(person.getId());
            out.print("\",");

            out.print("\"firstName\":");
            out.print("\"");
            out.print(person.getFirst());
            out.print("\",");

            out.print("\"lastName\":");
            out.print("\"");
            out.print(person.getLast());
            out.print("\",");

            out.print("\"email\":");
            out.print("\"");
            out.print(person.getEmail());
            out.print("\",");

            out.print("\"phone\":");
            out.print("\"");
            out.print(person.getPhone());
            out.print("\",");

            out.print("\"birthday\":");
            out.print("\"");
            out.print(person.getBirthday());
            out.print("\"");

            out.print("}");
        }
        out.println("\r\n]");
    }
}