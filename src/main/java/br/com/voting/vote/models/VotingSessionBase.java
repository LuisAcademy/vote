package br.com.voting.vote.models;

import br.com.voting.vote.enums.StatusVotingSession;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class VotingSessionBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_session")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime startSession;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusVotingSession status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getStartSession() { return startSession; }
    public void setStartSession(LocalDateTime startSession) { this.startSession = startSession; }

    public Topic getTopic() { return topic; }
    public void setTopic(Topic topic) { this.topic = topic; }

    public StatusVotingSession getStatus() { return status; }
    public void setStatus(StatusVotingSession status) { this.status = status; }


    public abstract LocalDateTime getEndSession();
}
