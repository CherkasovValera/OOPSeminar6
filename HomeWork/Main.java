public class Main{
	public static void main(String[] args){
		User user = new User("Bob");
		Report report=new Report();
		Persister persister = new Persister();
		report.report(user);
		persister.save(user);

	}
}