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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        
        String ex = request.getParameter("action");
        

               
        if (name == null)
        {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
        else 
        { 
            if(ex == null)
            {
                ex = "";
            }
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
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        //hidden jsp elements are called "action". 
        //when one of the buttons is clicked ex will store string value from that button.
        //option are: register, add, delete.
        String ex = request.getParameter("action");
        //check if any button was used
        if (ex == null)
        {
            
        }
        //if not, go to one the options
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
                //display name
                String dudeName = (String)session.getAttribute("name");
                request.setAttribute("currentlyLoged", dudeName);
                //get array list from current session
                ArrayList lizt = (ArrayList) session.getAttribute("list");
                //read user input
                String userText = request.getParameter("item");
                //add user text to array list
                lizt.add(userText);
                //save the list to session
                session.setAttribute("list", lizt);
                //display updated list
                request.setAttribute("output", lizt);
                
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);    
            }
            
            else if(ex.equals("delete"))
            {   
                //display name
                String dudeName = (String)session.getAttribute("name");
                request.setAttribute("currentlyLoged", dudeName);
                //get array list from current session
                ArrayList lizt = (ArrayList)session.getAttribute("list");
                //value of radio button taken from value="${ivan}"
                String str = (String)request.getParameter("btn");
                //remove matching string from the list
                lizt.remove(str);
                //save new list
                session.setAttribute("list", lizt);
                //display updated list
                request.setAttribute("output", lizt);
                
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            } 
        }     
    }   
}
