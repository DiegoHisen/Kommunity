package mediator;

import java.util.ArrayList;

import Common.Petition;
import Common.Post;
import Common.User;

public interface SystemPersistence 
{
	public void initializeCitizenDbs(String url);
	public User createAccount(User user);
	public User accesAccount(User user);
	public Post createPost(Post post);
	public ArrayList<Post> getPostByCity(String city);
	public Petition createPetition(Petition petition);
	
}
