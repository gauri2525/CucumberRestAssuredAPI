package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {

	public AddPlace addPlacePayload() {
		
		AddPlace p=new AddPlace();
		Location I=new Location();
		 
	    p.setAccuracy(50);
	    p.setAddress("29,DL.VAIDYA ROAD");
	    p.setLanguage("French.IN");
	    p.setPhone_number("(+91)9870098700");
	    p.setWebsite("https://rahulshettyacademy.com");
	    p.setName("Frontline house");
	    List<String> mylist=new ArrayList<>();
	    mylist.add("shoepark");
	    mylist.add("shop");
	    p.setTypes(mylist);
	    I.setLang(-38.938475);
	    I.setLat(345.77);
	    p.setLocation(I);
	    return p;
	}
	
}
