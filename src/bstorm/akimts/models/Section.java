package bstorm.akimts.models;

public class Section {

    private int id;
    private String name;
    private Integer delegateId;

    public Section(int id, String name, Integer delegateId) {
        this.id = id;
        this.name = name;
        this.delegateId = delegateId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDelegateId() {
        return delegateId;
    }

    public void setDelegateId(int delegateId) {
        this.delegateId = delegateId;
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", delegateId=" + delegateId +
                '}';
    }
}
