package com.accenture.fers.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.fers.entity.Event;
import com.accenture.fers.exceptions.FERSGenericException;
import com.accenture.fers.service.EventFacade;

/**
 * Event controller will handle all event related activities for a new visitor
 *
 */

@Controller
public class EventController {

	private static Logger log = Logger.getLogger(EventController.class);

	/**
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 *             The method will display all the events available in the
	 *             catalog to the visitor
	 */

	@Autowired
	EventFacade eventServiceImpl;

	@RequestMapping("/catalog.htm")
	public ModelAndView getAvailableEvents(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		if (request == null || response == null) {
			log.info("request or response not valid in GETAVAILABLEEVENTS METHOD ");
			throw new FERSGenericException(
					"Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder",
					new NullPointerException());
		}

		List<Event> eventList = new ArrayList<Event>();

		eventList = eventServiceImpl.getAllEvents();

		log.info("All Events are listed :" + eventList);

		ModelAndView mv = new ModelAndView();
		mv.addObject("allEvents", eventList);
		mv.setViewName("/eventCatalog.jsp");
		return mv;
	}

}
