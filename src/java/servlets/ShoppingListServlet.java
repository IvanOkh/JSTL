/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 797462
 */
public class ShoppingListServlet extends HttpServlet 
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        
        String ex = request.getParameter("action");
        
        if(ex == null)
        {
            ex = "";
        }
        
        
        if (name == null)
        {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
        else 
        { 
            if(ex.equals("logout"))
            {
                session.invalidate();
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                
            }
            
                String dudeName = (String)session.getAttribute("name");
                request.setAttribute("currentlyLoged", dudeName);
                
                ArrayList lizt = (ArrayList) session.getAttribute("list");
                session.setAttribute("list", lizt);
                request.setAttribute("output", lizt);
            
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            //doGetEverything(request, response);
        }
        
    }
        
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        
        String ex = request.getParameter("action");
        //String hex = request.getParameter("ray");
        
        if (ex == null)
        {
            
        }
        
        else
        {
            if (ex.equals("register"))
            {
                //create an initial array
                ArrayList <String> list = new ArrayList();
                //read inout from inoutfield in register.jsp
                String dudeName = request.getParameter("inputOne");
                //set username and array list to session
                session.setAttribute ("name", dudeName);
                session.setAttribute ("list", list);
                //display username on shoppingList.jsp
                request.setAttribute("currentlyLoged", dudeName);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            }
            
            else if(ex.equals("add"))
            {
                String dudeName = (String)session.getAttribute("name");
                request.setAttribute("currentlyLoged", dudeName);
                
                ArrayList lizt = (ArrayList) session.getAttribute("list");
                String userText = request.getParameter("item");
                lizt.add(userText);
                session.setAttribute("list", lizt);
                request.setAttribute("output", lizt);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                
            }
            else if(ex.equals("delete"))
            {
                ArrayList lizt = (ArrayList)session.getAttribute("list");
                String str = (String)request.getParameter("btn");
                lizt.remove(str);
                session.setAttribute("list", lizt);
                request.setAttribute("output", lizt);
                
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            }
 
        }
      
    }
    
    
                 
   
    

}
