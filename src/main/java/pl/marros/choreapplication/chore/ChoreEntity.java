package pl.marros.choreapplication.chore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="chore")
@AllArgsConstructor
@Setter @Getter
public class ChoreEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="chore_id")
    private Long id;
    @Column(name="chore_name")
    private String choreName;
    @Column(name="is_completed")
    private Boolean isCompleted;
    @Column(name="is_work_in_progress")
    private Boolean isWorkInProgress;
    @Column(name="started_on_date")
    private Date startedOn;
    @Column(name="completed_on_date")
    private Date completedOn;
}
