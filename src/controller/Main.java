package controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.SkillDAO;
import model.Skill;
public class Main{
    public static void main(String[] args) throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
	String skillname = null;
	long skillid = 0;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	System.out.println("Enter number of skills you want to add : ");
	int number = Integer.parseInt(br.readLine().trim());
	
	SkillDAO skilldao = new SkillDAO();
	
	for (int i=0;i<number;i++) {
	    System.out.println("Enter skill Id");
		skillid = Long.parseLong(br.readLine().trim());
		System.out.println("Enter skill name");
		skillname = br.readLine().trim();
		//setting into skill object 
		Skill skill = new Skill(skillid,skillname);
		skill.setSkillId(skillid);
		skill.setSkillName(skillname);
		// callingn skilldao class 
		skilldao.insertSkills(skill);
	}
	
	// declare list
	List<Skill> skillList = new ArrayList<Skill>();
	/// retrieve skills
	skillList = skilldao.listAll_SKills();
	
	if(skillList != null) {
	    System.out.println("id  \t\t name");
	    for(Skill skil : skillList) {
		System.out.println(skil.getSkillId()+"\t\t"+skil.getSkillName());
	    }
	}
    }
}
