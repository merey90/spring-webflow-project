package ru.javabegin.training.springwebflow.objects;

import java.util.ArrayList;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.webflow.execution.RequestContext;

import ru.javabegin.training.springwebflow.exceptions.UserExistException;

@Component
public class UserService {

	private ArrayList<User> userList = new ArrayList<User>();

	public UserService() {
		userList.add(new User("user", "pass"));
	}

	public String registerUser(User user, RequestContext context) throws UserExistException {
		if(user.getName() == null || user.getName().isEmpty()){
			context.getMessageContext().addMessage(new MessageBuilder().error().code("e400n").build());
			return "400n";
		}
		if(user.getPassword() == null || user.getPassword().isEmpty()){
			context.getMessageContext().addMessage(new MessageBuilder().error().code("e400p").build());
			return "400p";
		}
		for(User u : userList){
			if(u.getName().equals(user.getName().trim())){
				context.getMessageContext().addMessage(new MessageBuilder().error().code("e403n").build());
				throw new UserExistException("User exist!");
			}
		}
		
		user.setName(user.getName().trim());
		user.setPassword(user.getPassword().trim());
		userList.add(user);
		
		context.getMessageContext().addMessage(new MessageBuilder().info().code("e200reg").build());
		context.getMessageContext().addMessage(new MessageBuilder().info().code("enter").build());
		
		return "success";
		
	}

	public boolean checkUser(User user, RequestContext context) {
		if(userList.contains(user)){
			return true;
		}
		else{
			context.getMessageContext().addMessage(new MessageBuilder().error().code("e400user").build());
			return false;
		}

	}
}
