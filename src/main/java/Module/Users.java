package Module;

public class Users {
    int id;
    String nom;
    String email;
    String password;
    String motdepass;
    int tele;
    String specialite;


public Users(){}

public Users(int id, String nom, String email, String password, String motdepass, int tele, String specialite) {
    this.id = id;
    this.nom = nom;
    this.email = email;
    this.password = password;
    this.motdepass = motdepass;
    this.tele = tele;
    this.specialite = specialite;

}

    public Users( String nom, String email, String password, String motdepass, int tele, String specialite) {

        this.nom = nom;
        this.email = email;
        this.password = password;
        this.motdepass = motdepass;
        this.tele = tele;
        this.specialite = specialite;

    }

    public Users(int id, String nom, String email, String motPass, int numero, String specialisation) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMotdepass() {
        return motdepass;
    }

    public void setMotdepass(String motdepass) {
        this.motdepass = motdepass;
    }

    public int getTele() {
        return tele;
    }

    public void setTele(int tele) {
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
                ", password='" + password + '\'' +
                ", motdepass='" + motdepass + '\'' +
                ", tele=" + tele +
                ", specialite='" + specialite + '\'' +
                '}';
    }
}
