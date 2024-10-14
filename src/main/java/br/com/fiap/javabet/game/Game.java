package br.com.fiap.javabet.game;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String homeTeam;
    private String awayTeam;

    @Column(name = "match_date")
    private LocalDateTime matchDate;

    private int homeTeamScore;
    private int awayTeamScore;

    private String status;


}
