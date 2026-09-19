import java.util.Objects;

public class Member {
    final String name;
    final int memberNumber;

    public Member(String name, int memberNumber){
        this.name = name;
        this.memberNumber = memberNumber;

    }
    public int getMemberNumber(){
        return memberNumber;
    }
    @Override
    public boolean equals(Object otherObj) {
        if (otherObj == null || getClass() != otherObj.getClass()) return false;
        Member member = (Member) otherObj;
        return Objects.equals(getMemberNumber(), member.getMemberNumber());
    }
    public String toString() {
        return name + " (Lånernummber: " + memberNumber + ")";
  }
    }
