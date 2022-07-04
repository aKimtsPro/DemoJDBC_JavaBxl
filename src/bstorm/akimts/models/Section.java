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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDelegateId() {
        return delegateId;
    }

    public void setDelegateId(Integer delegateId) {
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
