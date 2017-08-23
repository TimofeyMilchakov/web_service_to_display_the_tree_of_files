package Models;

import javax.persistence.*;

/**
 * Created by ttt on 24.08.2017.
 */
@Entity
@Table(name = "folder", schema = "world", catalog = "")
public class FolderEntity {
    private int id;
    private String name;
    private String subfolder;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "subfolder")
    public String getSubfolder() {
        return subfolder;
    }

    public void setSubfolder(String subfolder) {
        this.subfolder = subfolder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FolderEntity that = (FolderEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (subfolder != null ? !subfolder.equals(that.subfolder) : that.subfolder != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (subfolder != null ? subfolder.hashCode() : 0);
        return result;
    }
}
