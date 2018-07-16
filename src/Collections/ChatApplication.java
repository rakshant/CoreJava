package Collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;


class User implements Comparable<User> {
	String uid;
	String password;
	String message;

	public String getMessage() {
		return message;
	}

	public User(String uid, String password) {
		super();
		this.uid = uid;
		this.password = password;
	}
	
	public User() {		
	}

	public User message(String uid,String message) {
		
		//User u = null;
		//u.uid=uid;
		//u.message=message;
		this.message = message;
		this.uid=uid;
		return this;		
	}

	
	public String getUid() {
		return uid;
	}

	public String getPassword() {
		return password;
	}


	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 1;
	}
	
	@Override
	public int compareTo(User o) {
		if(o.uid.equals(this.uid)){
			return 0;
		}
		return -1;	
	}

	@Override
	public boolean equals(Object obj) {
		User u=(User) obj;
		if(u.uid.equals(this.uid)){
			return true;
		}else{
			return false;
		}
	}
	
}




public class ChatApplication {

	public static void main(String[] args) {

		HashMap<String, TreeSet<User>> hm = new HashMap<String, TreeSet<User>>();
		HashMap<String, ArrayList<User>> hmlist = new HashMap<String, ArrayList<User>>();
		
		Scanner sc_1 = new Scanner(System.in);
		Scanner sc_2 = new Scanner(System.in);
		int option_1 = 0, option_2 = 0, option_3 = 0;

		do {
			System.out.println("Press 1 to create a chatroom");
			System.out.println("Press 2 to login to existing chatroom");
			System.out.println("Press 3 to delete a chatroom");
			option_1 = sc_1.nextInt();

			switch (option_1) {

			case 1:
				System.out.println("Enter chatroom name");
				String name = sc_2.nextLine();
				hm.put(name, new TreeSet<User>());

				do {
					System.out.println("Press 1 to add a user");
					System.out.println("Press 2 to delete a user");
					option_2 = sc_1.nextInt();

					switch (option_2) {

					case 1:
						System.out.println("Enter username");
						String uname = sc_2.nextLine();
						System.out.println("Enter password");
						String pwd = sc_2.nextLine();

						TreeSet<User> t = hm.get(name);
						System.out.println(t);
						
						if(!t.contains(new User(uname,pwd)))
						{
								t.add(new User(uname, pwd));
								hm.put(name, t);
		
								System.out.println("Welcome:" + uname);
		
								do {
									System.out.println("Press 1 to send message");
									System.out.println("Press 2 Display the messages from chatroom");
									System.out.println("Press 3 Display all users from chatroom");
									System.out.println("Press 4 to logout");
									option_3 = sc_1.nextInt();
									
									if (option_3 == 1) {
										
										System.out.println("Enter your message");
										String msg=sc_2.nextLine();
										hmlist.put(name, new ArrayList<User>());
										ArrayList<User> a = hmlist.get(name);								
										a.add(new User().message(uname, msg));
										hmlist.put(name, a);
										System.out.println("Message sent");
										
										
									}
									if (option_3 == 2) {
										System.out.println("All messages are!!!");
										if(hmlist.isEmpty()){
											System.out.println("No messages");
										}
										else{
											ArrayList<User> a = hmlist.get(name);
											Iterator<User> itr = a.iterator();
											while (itr.hasNext()) {
												User u = itr.next();
												String un = u.getUid();
												String message = u.getMessage();
												System.out.println(un+" says "+message);
											}	
										}
									}
									if (option_3 == 3) {
										System.out.println("All users are-");
										TreeSet<User> a = hm.get(name);
										Iterator<User> itr = a.iterator();
										int i=1;
										while (itr.hasNext()) {
											User u = itr.next();
											String un = u.getUid();
											System.out.println("User-"+i+" "+un);
											i++;
										}	
									}
									if (option_3 == 4) {
										System.out.println("you are logged out!!!");
										break;								
									}
								} while (option_3 <= 4);

						
						}
						else
						{
							System.out.println("Already exists");							
						}
						break;

					case 2:
						break;
					}
				} while (option_2 <= 2);

				break;

			case 2:
				System.out.println("Enter Chatroom name");
				String cname = sc_2.nextLine();
				System.out.println("Enter username");
				String uname = sc_2.nextLine();
				System.out.println("Enter password");
				String pwd = sc_2.nextLine();

				TreeSet<User> t = hm.get(cname);
				Iterator<User> itr = t.iterator();
				while (itr.hasNext()) {
					User u = itr.next();
					String un = u.getUid();
					String pw = u.getPassword();
					if (uname.equals(un) && pwd.equals(pw)) {
						System.out.println("Welcome:" + uname);

						do {
							System.out.println("Press 1 to send message");
							System.out.println("Press 2 Display the messages from chatroom");
							System.out.println("Press 3 to logout");
							option_3 = sc_1.nextInt();
							if (option_3 == 1) {
								System.out.println("Enter your message");
								String msg=sc_2.nextLine();
								hmlist.put(cname, new ArrayList<User>());
								ArrayList<User> a = hmlist.get(cname);								
								a.add(new User().message(uname, msg));
								hmlist.put(cname, a);
								System.out.println("Message sent");

							}
							if (option_3 == 2) {
								System.out.println("All messages are!!!");
								
								ArrayList<User> a = hmlist.get(cname);
								Iterator<User> itr1 = a.iterator();
								while (itr1.hasNext()) {
									User u1 = itr1.next();
									String un1 = u1.getUid();
									String message = u1.getMessage();
									System.out.println(un1+" says "+message);
								}														
							}
							if (option_3 == 3) {
								System.out.println("All users are-");
								TreeSet<User> a = hm.get(cname);
								Iterator<User> itr1 = a.iterator();
								int i=1;
								while (itr1.hasNext()) {
									User u1 = itr1.next();
									String un1 = u1.getUid();
									System.out.println("User-"+i+" "+un1);
									i++;
								}	
							}
							if (option_3 == 4) {
								System.out.println("you are logged out!!!");
								break;
							}
						} while (option_3 <= 4);
					}

					else {
						System.out.println("Wrong id or password");
					}

				}

				break;

			case 3:
				break;
			}

		} while (option_1 <= 3);
	}

}
