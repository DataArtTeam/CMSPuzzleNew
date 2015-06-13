package hibernate.tables;

import context.ArticleStatus;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "content")
public class Content implements Serializable, hibernate.tables.Table {

    private static final long serialVersionUID = -5284963386489685478L;
    private static final String KEY_NAME            = "name";
    private static final String KEY_ID              = "id";
    private static final String KEY_DESCRIPTION     = "description";
    private static final String KEY_CREATED         = "created";
    private static final String KEY_URL             = "url";
    private static final String KEY_TAGS            = "tags";
    private static final String KEY_AUTHOR          = "author";
    private static final String KEY_TEXT            = "text";
    private static final String KEY_TITLE           = "title";
    private static final String KEY_DESCR           = "descr";
    private static final String KEY_REVIEW          = "review";
    private static final String KEY_IMG             = "img";
    private static final String KEY_KWDS            = "kwds";
    private static final String KEY_SIMILAR         = "similar";

    @Id
    @Column(name = "c_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "c_name")
    private String name;

    @Column(name = "title")
    private String title;

    @Column(name = "c_kwds")
    private String keywordsOfTags;

    @Column(name = "c_description_tags")
    private String descriptionOfTags;

    @Column(name = "c_img")
    private String image;

    @Column(name = "c_description_content")
    private String descriptionOfContent;

    @Column(name = "c_text")
    private String text;

    @Enumerated(EnumType.STRING)
    @Column (columnDefinition="enum('AUTHOR','CORRECTOR', 'EDITOR', 'DELETED', 'WEBSITE')", name="articleStatus")
    private ArticleStatus articleStatus;

    private Byte status;

    @Column(name = "c_created")
    private Timestamp created;

    @Column(name = "c_lastedit")
    private Timestamp lastEdit;

    @Column(name = "c_url")
    private String url;

    @ManyToOne								// (targetEntity = User.class)
    @JoinColumn(name = "c_author")			//field name in table
    private User author;

    @OneToMany(mappedBy = "content") 		// reference on field in object ContentTagLinker
    private Set<ContentTagLinker> contents;

    @OneToMany(mappedBy = "contentId")		// reference on field in object FrontPage
    private Set<FrontPage> frontPages;

    private ArrayList<Tag> tags;

    private String descr;

//	@OneToMany(mappedBy = "content") 		// reference on field in object ContentPosition
//	private Set<ContentTagLinker> contents;

    public Content(){

    }
    public Content(String name, String title, ArrayList<Tag> tags, String image, String descriptionOfContent,
                   String text, Timestamp created, String url, ArticleStatus articleStatus, User author){
        this.name = name;
        this.title = title;
        this.keywordsOfTags = keywordsOfTags;
        //this.descriptionOfTags = descriptionOfTags;
        this.descriptionOfContent = descriptionOfContent;
        this.image = image;
        this.text = text;
        //this.status = status;
        this.created = created;
        //this.lastEdit = lastEdit;
        this.url = url;
        this.articleStatus = articleStatus;
        this.author = author;
        this.tags = tags;
    }

    @Column(name = "c_review_count")
    private Integer reviewCount;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeywordsOfTags() {
        return keywordsOfTags;
    }

    public void setKeywordsOfTags(String keywordsOfTags) {
        this.keywordsOfTags = keywordsOfTags;
    }

    public String getDescriptionOfTags() {
        return descriptionOfTags;
    }

    public void setDescriptionOfTags(String descriptionOfTags) {
        this.descriptionOfTags = descriptionOfTags;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescriptionOfContent() {
        return descriptionOfContent;
    }

    public void setDescriptionOfContent(String descriptionOfContent) {
        this.descriptionOfContent = descriptionOfContent;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getLastEdit() {
        return lastEdit;
    }

    public void setLastEdit(Timestamp lastEdit) {
        this.lastEdit = lastEdit;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Set<ContentTagLinker> getContents() {
        return contents;
    }

    public Set<FrontPage> getFrontPages() {
        return frontPages;
    }

    public Integer getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }

    public ArticleStatus getArticleStatus(){
        return articleStatus;
    }

    public void setArticleStatus(ArticleStatus articleStatus){
        this.articleStatus = articleStatus;
    }
    @Override
    public String toString() {
        return new StringBuffer().append("Content [id=").append(id)
                .append(", name=").append(name)
                .append(", title=").append(title)
                .append(", keywordsOfTags=").append(keywordsOfTags)
                .append(", descriptionOfTags=").append(descriptionOfTags)
                .append(", image=").append(image)
                .append(", descriptionOfContent=").append(descriptionOfContent)
                .append(", text=").append(text)
                .append(", status=").append(status)
                .append(", created=").append(created)
                .append(", lastEdit=").append(lastEdit)
                .append(", url=").append(url)
                .append(", author=").append(author)
                .append(", reviewCount=").append(reviewCount)
                .append("]").toString();
    }

    public JSONObject createFullJSON() {

        try {
            JSONObject articleData = new JSONObject();
            articleData.put(KEY_ID,            id);
            articleData.put(KEY_NAME,          name);
            articleData.put(KEY_DESCRIPTION,   descriptionOfContent);
            articleData.put(KEY_CREATED,       created);
            articleData.put(KEY_URL,           url);
            articleData.put(KEY_IMG,           image);
            //articleData.put(KEY_REVIEW,        review);
            articleData.put(KEY_TAGS,          getTagsName());
            articleData.put(KEY_AUTHOR,        author.getFirstName());
            articleData.put(KEY_TEXT,          text);
            articleData.put(KEY_TITLE,         title);
            articleData.put(KEY_KWDS,          keywordsOfTags);
            articleData.put(KEY_DESCR,         descr);
            articleData.put(KEY_SIMILAR,       getSimilarContext());


            return articleData;
        }
        catch (JSONException e){
            return null;
        }

    }

    private ArrayList<JSONObject> getTagsName(){

        ArrayList<JSONObject> tagsName = new ArrayList<JSONObject>();

        for (Tag tag: tags){
            tagsName.add(tag.getTagInJSON());
        }

        return tagsName;
    }

    private ArrayList<Content> getSimilarContext(){
        return null;
    }

    public String getStringJSON(int mode) {
        JSONObject articleInJSON;

        if(mode == 0){
            articleInJSON = createFullJSON();
        }
        else {
            articleInJSON = createAbbreviatedJSON();
        }

        String articleInString = articleInJSON.toString();

        return articleInString;
    }

    public JSONObject createJSONObjectForSimilar(){

        try {

            JSONObject articleData = new JSONObject();
            articleData.put(KEY_ID,            id);
            articleData.put(KEY_NAME,          name);
            articleData.put(KEY_CREATED,       created);
            articleData.put(KEY_IMG,           image);
            articleData.put(KEY_URL,           url);

            return articleData;
        }
        catch (JSONException e){
            return null;
        }

    }

    public JSONObject createAbbreviatedJSON(){
        try {

            JSONObject articleData = new JSONObject();
            articleData.put(KEY_ID,            id);
            articleData.put(KEY_NAME,          name);
            articleData.put(KEY_DESCRIPTION,   descriptionOfContent);
            articleData.put(KEY_CREATED,       created);
            articleData.put(KEY_URL,           url);
            articleData.put(KEY_IMG,           image);
           // articleData.put(KEY_REVIEW,        review);
            articleData.put(KEY_TAGS,          getTagsName());
            articleData.put(KEY_AUTHOR,        author.createFullJSON());

            return articleData;
        }
        catch (JSONException e){
            return null;
        }
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        result = prime * result + ((created == null) ? 0 : created.hashCode());
        result = prime
                * result
                + ((descriptionOfContent == null) ? 0 : descriptionOfContent
                .hashCode());
        result = prime
                * result
                + ((descriptionOfTags == null) ? 0 : descriptionOfTags
                .hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((image == null) ? 0 : image.hashCode());
        result = prime * result
                + ((keywordsOfTags == null) ? 0 : keywordsOfTags.hashCode());
        result = prime * result
                + ((lastEdit == null) ? 0 : lastEdit.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result
                + ((reviewCount == null) ? 0 : reviewCount.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((text == null) ? 0 : text.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((url == null) ? 0 : url.hashCode());
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
        Content other = (Content) obj;
        if (author == null) {
            if (other.author != null)
                return false;
        } else if (!author.equals(other.author))
            return false;
        if (created == null) {
            if (other.created != null)
                return false;
        } else if (!created.equals(other.created))
            return false;
        if (descriptionOfContent == null) {
            if (other.descriptionOfContent != null)
                return false;
        } else if (!descriptionOfContent.equals(other.descriptionOfContent))
            return false;
        if (descriptionOfTags == null) {
            if (other.descriptionOfTags != null)
                return false;
        } else if (!descriptionOfTags.equals(other.descriptionOfTags))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (image == null) {
            if (other.image != null)
                return false;
        } else if (!image.equals(other.image))
            return false;
        if (keywordsOfTags == null) {
            if (other.keywordsOfTags != null)
                return false;
        } else if (!keywordsOfTags.equals(other.keywordsOfTags))
            return false;
        if (lastEdit == null) {
            if (other.lastEdit != null)
                return false;
        } else if (!lastEdit.equals(other.lastEdit))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (reviewCount == null) {
            if (other.reviewCount != null)
                return false;
        } else if (!reviewCount.equals(other.reviewCount))
            return false;
        if (status == null) {
            if (other.status != null)
                return false;
        } else if (!status.equals(other.status))
            return false;
        if (text == null) {
            if (other.text != null)
                return false;
        } else if (!text.equals(other.text))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (url == null) {
            if (other.url != null)
                return false;
        } else if (!url.equals(other.url))
            return false;
        return true;
    }

}
