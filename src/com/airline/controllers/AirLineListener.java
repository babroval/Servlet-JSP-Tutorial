package com.airline.controllers;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.airline.models.Passenger;

/**
 * Application Lifecycle Listener implementation class ArilineListener
 *
 */
@WebListener
public class AirLineListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public AirLineListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent event)  { 
         
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
    	ServletContext sc = event.getServletContext();
        ArrayList<Passenger> passengers = (ArrayList<Passenger>) sc.getAttribute("passengers");
        
        if(passengers == null) {
       	 System.out.println("No passenger list created yet. Let's create the list here...");
       	 passengers = new ArrayList<>();
       	 sc.setAttribute("passengers", passengers);
        }
    }
	
}
