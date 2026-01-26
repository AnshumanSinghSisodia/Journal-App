package net.engineeringdigest.journalApp.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "journal_entries" )
public class JournalEntry {   // @Document for mapping
    @Id
    private String id;   //@Id for primary key

    private String title;

    private String content;

    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
