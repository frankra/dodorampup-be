package com.sap.csc.dodorampup.rest;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.sap.csc.dodorampup.controller.UserController;
import com.sap.csc.dodorampup.controller.UserQuery;
import com.sap.csc.dodorampup.model.User;
import com.sap.csc.dodorampup.model.View;

@RestController
@RequestMapping("/Users")
public class UserServlet extends AbstractBaseRestService<Long, User, UserController, UserQuery> {

	@Autowired
	public UserServlet(UserController controller, UserQuery query) {
		super(controller, query);
	}

	@Override
	public User create(@RequestBody User instance) {
		return new User();
	}

	@Override
	public List<User> findAll() {
		return this.getQuery().findAll();
	}

	@RequestMapping(value = "/current", method = RequestMethod.GET)
	public @ResponseBody User getCurrentUser(HttpServletRequest request) throws IOException {
		return (User) request.getSession().getAttribute("CurrentUser");
	}

}