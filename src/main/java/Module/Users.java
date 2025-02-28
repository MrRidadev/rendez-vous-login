package Module;

public class Users {
    int id;
    String nom;
    String email;
    String motdepass;
    String tele;
    String specialite;
    String role;


public Users(){}

public Users(int id, String nom, String email, String motdepass, String tele, String specialite,String role) {
    this.id = id;
    this.nom = nom;
    this.email = email;
    this.motdepass = motdepass;
    this.tele = tele;
    this.specialite = specialite;
    this.role = role;

}

    public Users( String nom, String email, String motdepass, String tele, String specialite,String role) {

        this.nom = nom;
        this.email = email;
        this.motdepass = motdepass;
        this.tele = tele;
        this.specialite = specialite;
        this.role = role;

    }

    public Users(int id, String email, String role) {
        this.id = id;
        this.email = email;
        this.role = role;
    }

    public String getRole() {
    return role;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getMotdepass() {
        return motdepass;
    }

    public void setMotdepass(String motdepass) {
        this.motdepass = motdepass;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", motdepass='" + motdepass + '\'' +
                ", tele='" + tele + '\'' +
                ", specialite='" + specialite + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
