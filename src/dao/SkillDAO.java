package dao;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Skill;
import utility.ConnectionManager;

public class SkillDAO{
    ConnectionManager cm = new ConnectionManager();
    String insertSkills = "insert into skill11 values (?,?)";
    String selectSkills = "select * from skill11 order by name asc";
    
    public void insertSkills(Skill skill) throws ClassNotFoundException, SQLException, IOException {
	PreparedStatement ps = cm.getConnection().prepareStatement(insertSkills);
	ps.setLong(1, skill.getSkillId());
	ps.setString(2, skill.getSkillName());
	ps.executeUpdate();
    }
    
    /// declare list
    private List<Skill> skillList = new ArrayList<Skill>();
    
    public List<Skill> listAll_SKills() throws ClassNotFoundException, SQLException, IOException {
	Skill skill;
	PreparedStatement ps = cm.getConnection().prepareStatement(selectSkills);
	ResultSet rs = ps.executeQuery();
	while(rs.next()) {
	    long id = rs.getLong(1);
	    String name = rs.getString(2);
	    
	    skill = new Skill(id,name);
	    skill.setSkillId(id);
	    skill.setSkillName(name);
	    skillList.add(skill);
	}
	return skillList ;
    }
}
