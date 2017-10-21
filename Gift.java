import java.util.Date;
import java.text.*;
public class Gift {
	private String person;
	private String description;
	private Date date;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
	public Gift(){
		
	}
	public Gift(String person,String description,Date date){
		this.person = person;
		this.description = description;
		this.date = date;
	}
	public Gift(String person,String description,String date){
		try{
			this.person = person;
			this.description = description;
			this.date = dateFormat.parse(date);
			}catch(ParseException e){
				System.out.println(e);
			}
	}
	@Override
	public String toString(){
		return "[ Person: "+this.person+", Description: "+this.description+", Date: "+dateFormat.format(date)+" ]";
	}
}