package edu.simpson.webdevelopment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@WebServlet(name = "NameListEdit")
public class NameListEdit extends HttpServlet {

    private Pattern firstnameValidationPattern;
    private Pattern lastnameValidationPattern;
    private Pattern emailValidationPattern;
    private Pattern phoneValidationPattern;
    private Pattern birthdayValidationPattern;

    public NameListEdit() {
        firstnameValidationPattern = Pattern.compile("^[A-Za-z' -]{1,20}$");
        lastnameValidationPattern = Pattern.compile("^[A-Za-z' -]{1,20}$");
        emailValidationPattern = Pattern.compile("^[A-Za-z0-9_.-]{1,20}@[a-zA-Z.]{1,20}\\.[a-zA-Z]{1,4}$");
        phoneValidationPattern = Pattern.compile("^[0-9]{10}$");
        birthdayValidationPattern = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        // Print that this is a post
        out.println("Post");

        // Grab the data we got via a parameter
        String id = request.getParameter("id");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String birthday = request.getParameter("birthday");

        // Just print the data out to confirm we got it.
        out.println("id = '"+id+"'");
        out.println("firstName = '"+firstName+"'");
        out.println("lastName = '"+lastName+"'");
        out.println("email = '"+email+"'");
        out.println("phone = '"+phone+"'");
        out.println("birthday = '"+birthday+"'");

        Matcher firstValidate = firstnameValidationPattern.matcher(firstName);
        Matcher lastValidate = lastnameValidationPattern.matcher(lastName);
        Matcher emailValidate = emailValidationPattern.matcher(email);
        Matcher phoneValidate = phoneValidationPattern.matcher(phone);
        Matcher birthdayValidate = birthdayValidationPattern.matcher(birthday);
        
        if (firstValidate.find( ) && lastValidate.find() && emailValidate.find() && phoneValidate.find() && birthdayValidate.find()) {
            out.println("Passed validation");
            
            Person person = new Person();
            person.setFirst(firstName);
            person.setLast(lastName);
            person.setEmail(email);
            person.setPhone(phone);
            person.setBirthday(birthday);
            PersonDAO.addPerson(person);
        }
        else {
            out.println("Did not pass validation");
        }
    }
}