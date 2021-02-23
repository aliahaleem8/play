package guide.Chapter06.LiskovSubstitutionPrinciple.src.main.java.coding.challenge.bad;

public class PremiumMember extends Member {

    public PremiumMember(String name) {
        super(name);
    }
        
    @Override
    public void joinTournament() {
        System.out.println("Premium member joins tournament ...");
    }

    @Override
    public void organizeTournament() {
        System.out.println("Premium member organize tournament ...");
    }
}
