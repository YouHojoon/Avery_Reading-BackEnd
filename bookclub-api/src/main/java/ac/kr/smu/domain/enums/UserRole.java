package ac.kr.smu.domain.enums;

public enum UserRole {
    MEMBER("MEMBER"), MANAGER("MANAGER"), USER("USER");

    private final String prefix="ROLE_";
    private String role;

    UserRole(String role){
        this.role = role;
    }
    public String getAuthoritie(){return prefix+role;}
    public String getRole(){return role;}
}
