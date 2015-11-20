package com.accenture.fers.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.fers.entity.Event;
import com.accenture.fers.entity.Visitor;

@Component
public class VisitorDAO {

	private static Logger log = Logger.getLogger(VisitorDAO.class);

	@PersistenceContext
	private EntityManager entityManager;

	public VisitorDAO() {

	}
	@Transactional
	public boolean insertData(Visitor visitor) throws NoResultException,
			PersistenceException {

		return true;
	}

	public Visitor searchUser(String username, String password)
			throws NonUniqueResultException, PersistenceException {

		Visitor visitor = null;

		return visitor;
	}

	@Transactional
	public void registerVisitorToEvent(Visitor visitor, int eventid)
			throws NoResultException, NonUniqueResultException,
			PersistenceException {
		}

	public List<Object[]> registeredEvents(Visitor visitor)
	{
		return null;

	}

	@Transactional
	public int updateVisitor(Visitor visitor) throws PersistenceException {
		return 0;

	}

	@Transactional
	public int changePassword(Visitor visitor) throws PersistenceException {
		return 0;
	}

	private boolean matchWithOldPwd(Visitor visitor)
			throws NonUniqueResultException, PersistenceException {
		return true;

	}

	@Transactional
	public void unregisterEvent(Visitor visitor, int eventid)
			throws NonUniqueResultException, PersistenceException {

	}

	public boolean searchVisitor(String username) {
		return true;

	}

	}
