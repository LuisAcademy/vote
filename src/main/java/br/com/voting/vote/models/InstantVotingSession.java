package br.com.voting.vote.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "instant_voting_session")
public class InstantVotingSession extends VotingSessionBase {

    @Override
    public LocalDateTime getEndSession() {

        return getStartSession();
    }
}
