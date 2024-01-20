package dev.qnix.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "`user`")
public class User {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "xid", length = 63, nullable = false, unique = true)
    private String xid;

    @Column(name = "date_last_activity_at", nullable = false)
    private Date dateLastActivityAt;

    @OneToMany(targetEntity = Story.class, mappedBy = "user", orphanRemoval = true)
    private List<Story> stories;

    public void addStory(Story story) {
        if (!this.stories.contains(story)) {
            this.stories.add(story);
            story.setUser(this);
        }
    }

    public void removeStory(Story story) {
        if (this.stories.remove(story)) {
            if (story.getUser() == this) {
                story.setUser(null);
            }
        }
    }
}