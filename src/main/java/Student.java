import java.util.List;

public class Student {
    private String id;
    private String name;
    private String email;
    private float bonus;
    private float report;
    private float app;
    private float lt;
    private float tongDiem;


    public String setId(String i) {
        return id;
    }

    public String setName(String name) {
        return name;
    }

    public String setEmail(String email) {
        return email;
    }

    public float setBonus(float bonus) {
        return bonus;
    }

    public float setReport(float report) {
        return report;
    }

    public float setApp(float app) {
        return app;
    }

    public float setLt(float lt) {
        return lt;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public float getBonus() {
        return bonus;
    }

    public float getReport() {
        return report;
    }

    public float getApp() {
        return app;
    }

    public float getLt() {
        return lt;
    }

    public float getTongDiem() {
        return tongDiem;
    }

    public String getGmail() {
        return;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", bonus=").append(bonus);
        sb.append(", report=").append(report);
        sb.append(", app=").append(app);
        sb.append(", lt=").append(lt);
        sb.append(", tongDiem=").append(tongDiem);
        sb.append('}');
        return sb.toString();
    }


}