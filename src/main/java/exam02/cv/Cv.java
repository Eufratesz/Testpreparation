package exam02.cv;

import java.util.ArrayList;
import java.util.List;

public class Cv {

    private String name;
    private List<Skill> skills = new ArrayList<>();


    public Cv(String name) {
        this.name = name;
    }

    //Fel kell darabolni a skill-t: a name a 0.indextől a (-ig tart, a level a ( és a ) között van. Stubstriggel kivágom őket, elnevezem
    public void addSkills(String... text) {
        for (String t : text) {
            String name = t.substring(0, t.indexOf("(") - 1);
            int level = Integer.parseInt(t.substring(t.indexOf("(") + 1, t.indexOf(")")));
//            System.out.println(name);
//            System.out.println(level);
            Skill skill = new Skill(name, level);
            skills.add(skill);
        }
    }

    public int findSkillLevelByName(String text) {
        for (Skill skill : skills) {
            if (skill.getName().equals(text)) {
                return skill.getLevel();
            }
        }
        throw new SkillNotFoundException("Cannot find skill");
    }


    public String getName() {
        return name;
    }

    public List<Skill> getSkills() {
        return skills;
    }


}
