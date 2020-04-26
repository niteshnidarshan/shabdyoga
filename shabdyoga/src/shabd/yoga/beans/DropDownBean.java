package shabd.yoga.beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class DropDownBean {
	
public List<String> getDropDownList(String string, Set<String> set){
	
		String copy=string;
		ArrayList <String> al = new ArrayList<String>();
		if(set!=null){
				for(String s:set){
						String l=s;
						if(l.startsWith(copy))
								{
									al.add(l);
								}
				}
				Collections.sort(al);
		}
		//reducing list size
		List lst=new ArrayList();
		if(al.size()>18){
			for(int x=0;x<17;x++){
				lst.add(al.get(x));
			}
			return lst;
		}
		else{
			return al;
		}
	} 

}
