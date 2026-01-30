package net.engineeringdigest.journalApp.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "journal_entries" )
@Data
@NoArgsConstructor
public class JournalEntry {   // @Document for mapping
    @Id
    private ObjectId id;   //@Id for primary key
    @NonNull
    private String title;

    private String content;

    private LocalDateTime date;




}
