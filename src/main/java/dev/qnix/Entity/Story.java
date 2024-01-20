package dev.qnix.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "story")
public class Story {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @ManyToOne(targetEntity = Ship.class)
    @JoinColumn(name = "id_ship_one", referencedColumnName = "id", nullable = false)
    private Ship shipOne;

    @Column(name = "ship_one_quantity", nullable = false)
    private Integer shipOneQuantity;

    @ManyToOne(targetEntity = Ship.class)
    @JoinColumn(name = "id_ship_two", referencedColumnName = "id", nullable = false)
    private Ship shipTwo;

    @Column(name = "ship_two_quantity", nullable = false)
    private Integer shipTwoQuantity;

    @ManyToOne(targetEntity = Ship.class)
    @JoinColumn(name = "id_winner_ship", referencedColumnName = "id")
    private Ship winnerShip = null;

    @Column(name = "ship_one_remainder_health")
    private Integer shipOneRemainderHealth;

    @Column(name = "ship_two_remainder_health")
    private Integer shipTwoRemainderHealth;

    @Column(name = "date_battle_at", nullable = false)
    private Date dateBattleAt;

    @PrePersist
    public void prePersist() {
        var dateNow = new Date();
        this.dateBattleAt = dateNow;
        this.user.setDateLastActivityAt(dateNow);
    }
}