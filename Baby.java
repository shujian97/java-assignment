import java.util.Date;
import java.text.*;
import java.util.ArrayList;

public class Baby {
	private String name;
	private Date birthday;
	private char gender;
	private ArrayList<Gift> gifts = new ArrayList<>();
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
	
	public Baby(){
		
	}
	public Baby(String birthday,String name,char gender){
		try{
		this.birthday=dateFormat.parse(birthday);
		this.name = name;
		this.gender = gender;
		}catch(ParseException e){
			System.out.println(e);
		}
	}
	public Baby(Date birthday,String name,char gender){
			this.birthday = birthday;
			this.name = name;
			this.gender = gender;
		}
	public String getName(){
		return this.name;
	}
	public Date getBirthday(){
		return this.birthday;
	}
	public char getGender(){
		return this.gender;
	}
	public void setName(String name){
			this.name = name;
	}
	public void setBirthday(Date birthday){
								this.birthday = birthday;
	}
	public void setBirthday(String birthday){
		try{
			this.birthday=dateFormat.parse(birthday);
		}catch(ParseException e){
			System.out.println(e);
		}
	}	
	public void setGender(char gender){
		this.gender = gender;
	}
		
		
	public boolean isOlder(Baby baby){
		if(this.birthday.compareTo(baby.getBirthday())<0)
			return true;
		else 
			return false;
	}
	public int howOld(){
		Date date = new Date();
		int age=0;
		if(this.birthday.getYear()<date.getYear()){
			age = date.getYear() - this.birthday.getYear();
		}
		if(this.birthday.getMonth()>date.getMonth()){
			age +=  1;
		}else if(this.birthday.getMonth()==date.getMonth()){
			if(this.birthday.getDay()>date.getDay()){
				age -= 1;
			}
		}
		return age;
	}
	public Gift addGift(Gift gift){
		gifts.add(gift);
		return gift;
	}
	public String showGifts(){
		String str="";
		for(Gift g : gifts){
			str+=g.toString()+"\n";
		}
		return str;
	}
	@Override
	public String toString(){
//		return "Name: "+name+" Birthday: "+dateFormat.format(birthday)+" gender: "+gender+"\n"
//		+"Gift list: \n"+showGifts();	
	return "Name: "+name+" Age:"+this.howOld()+" Birthday: "+dateFormat.format(birthday)+" gender: "+gender+"\n";
	}
	
}