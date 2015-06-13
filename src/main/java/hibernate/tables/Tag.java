package hibernate.tables;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;

@Entity
@Table(name = "tag")
public class Tag implements Serializable, hibernate.tables.Table{
	private static final long serialVersionUID = 1470698910064304556L;
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "t_id")
	private Integer id;
	
	@Column(name = "t_name")
	private String name;
	
	@Column(name = "t_priority")
	private Integer priority;
	
	@OneToMany(mappedBy="tag")		//reference on field in object ContentTagLinker
	private Set<ContentTagLinker>tags;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Set<ContentTagLinker> getTags() {
		return tags;
	}

    public String getStringJSON() {

        String tagInString = getTagInJSON().toString();
        return tagInString;

    }

    public JSONObject getTagInJSON(){
        try {
            JSONObject tagJSON = new JSONObject();
            tagJSON.put(KEY_ID, id);
            tagJSON.put(KEY_NAME, name);
            return tagJSON;
        }
        catch (JSONException e){
            return null;
        }
    }

	@Override
	public String toString() {
		return new StringBuffer().append("Tags [id=").append(id)
				.append(", name=").append(name)
				.append(", priority=").append(priority)
				.append("]").toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((priority == null) ? 0 : priority.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tag other = (Tag) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (priority == null) {
			if (other.priority != null)
				return false;
		} else if (!priority.equals(other.priority))
			return false;
		return true;
	}
}
